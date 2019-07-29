package com.veirn.animest.di


import com.example.ainfo.NavFragment.TopAnimeFragment
import com.example.ainfo.NavFragment.TopMangaFragment
import com.example.ainfo.ui.MainActivity
import dagger.Component

@Component(modules = arrayOf(ComponentModule::class) )
interface MainComponent {


      fun inject(mainActivity: TopAnimeFragment)
      fun inject(mainActivity: TopMangaFragment)
//    fun inject(mainActivity: SearchFragment)
//    fun inject(mainActivity: AnimeDetails)
//    fun inject(mainActivity: MainActivity)
}