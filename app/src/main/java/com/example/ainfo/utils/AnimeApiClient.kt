package com.example.ainfo.utils
import com.example.ainfo.model.TopModel
import com.example.ainfo.model.manga.TopManga
import com.example.ainfo.model.searchanime.SearchAnime
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface AnimeApiClient {

        /* Get list of animes */
        @GET("top/anime/{page}")
        fun getTopAnime(@Path(value = "page") page: Int): Observable<TopModel>
        @GET("top/manga/{page}")
        fun getTopmanga(@Path(value = "page") page: Int): Observable<TopManga>
        @GET("search/anime/")
        fun getSanime(@Query("q") animeName: String): Observable<SearchAnime>


        companion object {

            fun create(): AnimeApiClient {

                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("$base_url/")
                    .build()

                return retrofit.create(AnimeApiClient::class.java)

            }
        }

    }
