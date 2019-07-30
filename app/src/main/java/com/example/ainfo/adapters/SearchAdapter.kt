package com.example.ainfo.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ainfo.R
import com.example.ainfo.model.anime.Top
import com.example.ainfo.model.manga.TopM
import com.example.ainfo.model.searchanime.Result
import com.example.ainfo.ui.details.MangaDetailsActivity
import com.example.ainfo.ui.details.SearchDetailsActivity

class SearchAdapter (private var context: FragmentActivity?, private var dataList:ArrayList<Result>):
    RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return dataList.size;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.manga_list, parent, false))
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
//            holder.textView.text=dataList[position].title
        Glide.with(holder.itemView.context)
            .load(dataList[position].image_url)
            .into(  holder.imageview)
        if(dataList[position]!= null){
            holder.imageview.setOnClickListener(View.OnClickListener {
                holder.itemView.context.startActivity(
                    Intent(holder.itemView.context, SearchDetailsActivity::class.java)
                        .putExtra("value2",dataList[position])
                )

            })
        }
    }

    fun updatelist(list: List<Result>){
        dataList.addAll(list)
        notifyDataSetChanged()

    }
    fun restlist(){
        dataList.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView =itemView.findViewById(R.id.image2)
    }
}