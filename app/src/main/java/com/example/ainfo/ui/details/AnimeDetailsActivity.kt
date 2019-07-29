package com.example.ainfo.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.ainfo.model.Top
import kotlinx.android.synthetic.main.activity_anime_details.*
import android.content.Intent
import android.R
import android.net.Uri


class AnimeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.ainfo.R.layout.activity_anime_details)
        var anime = intent.extras!!.getParcelable<Top>("value")
        animename.text = anime.title

        Glide.with(this)
            .load(anime.image_url)
            .into(topAnimeImage)

        imageviewdetails.setOnClickListener(View.OnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(anime.url)))
        })
        ratingbar1.rating = (anime.score / 2.0).toFloat()
        ratingbar1.isEnabled = false




    }
}
