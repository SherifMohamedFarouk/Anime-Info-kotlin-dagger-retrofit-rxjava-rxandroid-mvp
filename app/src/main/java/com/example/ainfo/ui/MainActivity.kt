package com.example.ainfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ainfo.R
import com.example.ainfo.model.Top
import com.example.ainfo.presenter.TopAnimePresImpl
import com.example.ainfo.presenter.TopAnimeView
import com.veirn.animest.di.DaggerMainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(),TopAnimeView {
     @Inject
     lateinit var topAnimePresImpl : TopAnimePresImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var component = DaggerMainComponent.create()
        component.inject(this)
        topAnimePresImpl.topAnimeView = this
        topAnimePresImpl.getTopAnime()

    }

    override fun getanime(top: List<Top>) {
    Log.d("animee",top.toString())
    }


}
