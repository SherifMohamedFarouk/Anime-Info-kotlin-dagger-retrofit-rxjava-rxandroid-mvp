package com.example.ainfo.utils
import com.example.ainfo.model.TopModel
import com.example.ainfo.model.manga.TopManga
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface AnimeApiClient {

        /* Get list of articles */
        @GET("top/anime/{page}")
        fun getTopAnime(@Path(value = "page") page: Int): Observable<TopModel>
        @GET("top/manga/{page}")
        fun getTopmanga(@Path(value = "page") page: Int): Observable<TopManga>
//        /* Get one article by it's id */
//        @GET("posts/{id}")anime/{page}
//        fun getArticle(@Path("id") id: Int): Observable<Article>


//    @GET("v3/top/anime/{page}")
//    abstract fun gettopanime(@Path(value = "page") page: String): Call<TopAnime>
//
//    @GET("v3/top/manga/{page}")
//    abstract fun gettopmanga(@Path(value = "page") page: String): Call<TopAnime>
//
//    @GET("v3/search/anime/")
//    abstract fun getSanime(@Query("q") animeName: String): Call<SearchAnime>
//    // @GET ("v3/search/anime/?q=deathnote")
//    //Call<SearchAnime> getSanime();

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
