package com.example.ainfo.NavFragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.ainfo.R
import com.example.ainfo.adapters.MangaAdapter
import com.example.ainfo.model.manga.TopM
import com.example.ainfo.presenter.TopAnimePresImpl
import com.example.ainfo.presenter.TopMangaVIew
import com.example.ainfo.utils.PaginationScrollListener
import com.veirn.animest.di.DaggerMainComponent
import kotlinx.android.synthetic.main.fragment_top_manga.*
import javax.inject.Inject

class TopMangaFragment : Fragment(),TopMangaVIew {
    @Inject
 lateinit var TopAnimePres : TopAnimePresImpl
    lateinit var mangaAdapter:MangaAdapter
    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var page : Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_manga, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var component = DaggerMainComponent.create()
        component.inject(this)
        mangaAdapter = MangaAdapter(activity, ArrayList())
        MangaRecycle.adapter = mangaAdapter
        MangaRecycle.layoutManager = GridLayoutManager(activity , 2)
        MangaRecycle.setHasFixedSize(false)
        TopAnimePres.topMangaVIew = this
        TopAnimePres.getTopManga(page++)
        mangaAdapter.notifyDataSetChanged()

        MangaRecycle.addOnScrollListener(object : PaginationScrollListener(MangaRecycle.layoutManager as GridLayoutManager){
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
        TopAnimePres.getTopManga(page++)
        isLoading = false
        mangaAdapter.notifyDataSetChanged()

    }
    override fun getmanga(top: List<TopM>) {
      Log.d("mangaa",top.toString())
        mangaAdapter.updatelist(top)
        mangaprogress.visibility = INVISIBLE
    }

}
