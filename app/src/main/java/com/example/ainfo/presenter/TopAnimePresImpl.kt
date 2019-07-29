package com.example.ainfo.presenter

import com.example.ainfo.model.anime.Top
import com.example.ainfo.model.manga.TopM
import com.example.ainfo.repo.TopAnimeRepo
import javax.inject.Inject

class TopAnimePresImpl@Inject constructor(var topAnimeRepo: TopAnimeRepo ) : TopAnimePres {

    lateinit var topAnimeView: TopAnimeView
    lateinit var topMangaVIew: TopMangaVIew
    override fun mangafetech(top: List<TopM>) {
     topMangaVIew.getmanga(top)
    }

    override fun animefetech(top: List<Top>) {
        topAnimeView.getanime(top)

    }

    init {
 topAnimeRepo.topAnimePresImpl = this
    }


    fun getTopAnime(page : Int){
     topAnimeRepo.gettopanime(page)
    }

    fun getTopManga(page : Int){
        topAnimeRepo.gettopmanga(page)
    }
}