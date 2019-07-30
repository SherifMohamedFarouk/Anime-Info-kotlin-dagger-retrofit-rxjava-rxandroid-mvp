package com.example.ainfo.presenter

import com.example.ainfo.model.anime.Top
import com.example.ainfo.model.manga.TopM
import com.example.ainfo.model.searchanime.Result

interface TopAnimePres {
    fun animefetech(top: List<Top>);
    fun mangafetech(top: List<TopM>);
    fun searchfetech(search : List<Result>)

}