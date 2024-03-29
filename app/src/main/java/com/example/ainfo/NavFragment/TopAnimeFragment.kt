package com.example.ainfo.NavFragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.ainfo.R
import com.example.ainfo.adapters.RecyclerViewAdapter
import com.example.ainfo.model.anime.Top
import com.example.ainfo.presenter.TopAnimePresImpl
import com.example.ainfo.presenter.TopAnimeView
import com.example.ainfo.utils.PaginationScrollListener
import com.veirn.animest.di.DaggerMainComponent
import kotlinx.android.synthetic.main.fragment_top_anime.*
import javax.inject.Inject

class TopAnimeFragment : Fragment(), TopAnimeView {
    @Inject
    lateinit var topAnimePresImpl : TopAnimePresImpl
    lateinit var animeAdapter:RecyclerViewAdapter
    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var page : Int = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_anime, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var component = DaggerMainComponent.create()
        component.inject(this)
        animeAdapter = RecyclerViewAdapter(activity,ArrayList())
        AnimeRecycle.adapter = animeAdapter
        AnimeRecycle.layoutManager = GridLayoutManager(activity,2)
        AnimeRecycle.setHasFixedSize(false)

        topAnimePresImpl.topAnimeView = this
        topAnimePresImpl.getTopAnime(page++)
        animeAdapter.notifyDataSetChanged()

        AnimeRecycle.addOnScrollListener(object : PaginationScrollListener(AnimeRecycle.layoutManager as GridLayoutManager){
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
            override fun loadMoreItems() {
            isLoading = true
                moreitems()


            }

        }
        )
    }
    fun moreitems(){
        topAnimePresImpl.getTopAnime(page++)
        isLoading = false
        animeAdapter.notifyDataSetChanged()

    }

    override fun getanime(top: List<Top>) {
        Log.d("animee",top.toString())
        animeAdapter.updatelist(top)
        animeprogress.visibility = View.INVISIBLE

    }



}
