package com.example.ainfo.presenter

import com.example.ainfo.model.searchanime.Result
import com.example.ainfo.model.searchanime.SearchAnime

interface SearchInterface {
    fun searchAnime(search : List<Result>)
}