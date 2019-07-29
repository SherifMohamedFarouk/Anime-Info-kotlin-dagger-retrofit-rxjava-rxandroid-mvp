package com.example.ainfo.repo

import android.util.Log
import com.example.ainfo.presenter.TopAnimePresImpl
import com.example.ainfo.utils.AnimeApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopAnimeRepo @Inject constructor() {
 lateinit var topAnimePresImpl: TopAnimePresImpl
    val client by lazy {
        AnimeApiClient.create()
    }

    var disposable: Disposable? = null


     fun gettopanime(page :Int ) {

        disposable = client.getTopAnime(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Log.v("anime", "" + result)
                topAnimePresImpl.animefetech(result.top)
                },
                { error -> Log.e("ERROR", error.message) }
            )

    }
    fun gettopmanga(page :Int ) {

        disposable = client.getTopmanga(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Log.v("anime", "" + result)
                    topAnimePresImpl.mangafetech(result.top)
                },
                { error -> Log.e("ERROR", error.message) }
            )

    }
}