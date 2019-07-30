package com.example.ainfo.model.searchanime

import android.os.Parcel
import android.os.Parcelable

data class Result(
    val airing: Boolean,
    val end_date: String?,
    val episodes: Int,
    val image_url: String?,
    val mal_id: Int,
    val members: Int,
    val rated: String?,
    val score: Double,
    val start_date: String?,
    val synopsis: String?,
    val title: String?,
    val type: String?,
    val url: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        1 == source.readInt(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readString(),
        source.readDouble(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt((if (airing) 1 else 0))
        writeString(end_date)
        writeInt(episodes)
        writeString(image_url)
        writeInt(mal_id)
        writeInt(members)
        writeString(rated)
        writeDouble(score)
        writeString(start_date)
        writeString(synopsis)
        writeString(title)
        writeString(type)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Result> = object : Parcelable.Creator<Result> {
            override fun createFromParcel(source: Parcel): Result = Result(source)
            override fun newArray(size: Int): Array<Result?> = arrayOfNulls(size)
        }
    }
}