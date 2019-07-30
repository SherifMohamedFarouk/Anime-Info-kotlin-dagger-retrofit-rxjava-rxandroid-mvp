package com.example.ainfo.ui.details

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.ainfo.R
import com.example.ainfo.model.manga.TopM
import com.example.ainfo.model.searchanime.Result
import kotlinx.android.synthetic.main.activity_manga_details.*
import kotlinx.android.synthetic.main.activity_search_details.*
import kotlinx.android.synthetic.main.activity_search_details.ratingbar1

class SearchDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_details)
        var search = intent.extras!!.getParcelable<Result>("value2")
        Searchname.text = search.title
        Glide.with(this)
            .load(search.image_url)
            .into(SearchAnimeImage)

        ratingbar1.rating = (search.score / 2.0).toFloat()
        ratingbar1.isEnabled = false

        searchviewdetails.setOnClickListener(View.OnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(search.url)))
        })
    }
}
