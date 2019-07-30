package com.example.ainfo.NavFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_search.*
import android.widget.VideoView

import android.net.Uri
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ainfo.adapters.SearchAdapter
import com.example.ainfo.model.searchanime.Result
import com.example.ainfo.presenter.SearchInterface
import com.example.ainfo.presenter.TopAnimePresImpl
import com.github.rtoshiro.view.video.FullscreenVideoLayout
import com.veirn.animest.di.DaggerMainComponent

import java.io.IOException
import javax.inject.Inject


class SearchFragment : Fragment(),SearchInterface, SearchView.OnQueryTextListener {

    @Inject
    lateinit var topAnimePresImpl: TopAnimePresImpl
    lateinit var searchAdapter : SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.ainfo.R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchview.setOnQueryTextListener(this)
        var component = DaggerMainComponent.create()
        component.inject(this)
       searchAdapter = SearchAdapter(activity , ArrayList())
        searchRecycle.adapter = searchAdapter
        searchRecycle.layoutManager = LinearLayoutManager(activity)
        searchRecycle.setHasFixedSize(false)
        topAnimePresImpl.searchInterface = this



       }

    override fun searchAnime(search: List<Result>) {
        Log.d("anmser",search.toString())
        searchAdapter.updatelist(search)
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        topAnimePresImpl.getSearchanime(query)
        searchAdapter.restlist()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }



}
