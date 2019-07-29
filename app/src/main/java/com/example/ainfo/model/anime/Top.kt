package com.example.ainfo.model.anime

import android.os.Parcel
import android.os.Parcelable

data class Top(
    val end_date: String,
    val episodes: Int,
    val image_url: String,
    val mal_id: Int,
    val members: Int,
    val rank: Int,
    val score: Double,
    val start_date: String,
    val title: String,
    val type: String,
    val url: String,
    val volumes: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readDouble(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(end_date)
        writeInt(episodes)
        writeString(image_url)
        writeInt(mal_id)
        writeInt(members)
        writeInt(rank)
        writeDouble(score)
        writeString(start_date)
        writeString(title)
        writeString(type)
        writeString(url)
        writeInt(volumes)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Top> = object : Parcelable.Creator<Top> {
            override fun createFromParcel(source: Parcel): Top = Top(source)
            override fun newArray(size: Int): Array<Top?> = arrayOfNulls(size)
        }
    }
}