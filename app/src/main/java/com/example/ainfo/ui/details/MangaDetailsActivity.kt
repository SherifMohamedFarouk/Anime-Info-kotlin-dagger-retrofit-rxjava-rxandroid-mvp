package com.example.ainfo.ui.details

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.ainfo.R
import com.example.ainfo.model.anime.Top
import com.example.ainfo.model.manga.TopM
import kotlinx.android.synthetic.main.activity_manga_details.*

class MangaDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_details)
        var manga = intent.extras!!.getParcelable<TopM>("value1")
        Log.d("menda",manga.title)
        if(manga.title!=null){
        manganame.text = manga.title
            }else{

        }

        Glide.with(this)
            .load(manga.image_url)
            .into(topAnimeImage)

        imageviewdetails.setOnClickListener(View.OnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(manga.url)))
        })
        ratingbar1.rating = (manga.score / 2.0).toFloat()
        ratingbar1.isEnabled = false




    }
    }

