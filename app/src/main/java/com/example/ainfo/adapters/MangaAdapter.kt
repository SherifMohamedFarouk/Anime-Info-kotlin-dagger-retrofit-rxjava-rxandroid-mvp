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
import com.example.ainfo.ui.details.MangaDetailsActivity

class MangaAdapter (private var context: FragmentActivity?, private var dataList:ArrayList<TopM>):
    RecyclerView.Adapter<MangaAdapter.ViewHolder>(){
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
                Intent(holder.itemView.context, MangaDetailsActivity::class.java)
                    .putExtra("value1",dataList[position])
                    )

        })
        }
    }

    fun updatelist(list: List<TopM>){
        dataList.addAll(list)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView =itemView.findViewById(R.id.image2)
    }
}