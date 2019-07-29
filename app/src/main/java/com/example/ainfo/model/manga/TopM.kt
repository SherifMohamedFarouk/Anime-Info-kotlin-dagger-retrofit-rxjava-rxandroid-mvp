package com.example.ainfo.model.manga

import android.os.Parcel
import android.os.Parcelable

data class TopM(
    val end_date: String?,
    val image_url: String?,
    val mal_id: Int,
    val members: Int,
    val rank: Int,
    val score: Double,
    val start_date: String?,
    val title: String?,
    val type: String?,
    val url: String?,
    val volumes: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readInt(),
        source.readDouble(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(end_date)
        writeString(image_url)
        writeInt(mal_id)
        writeInt(members)
        writeInt(rank)
        writeDouble(score)
        writeString(start_date)
        writeString(title)
        writeString(type)
        writeString(url)
        writeString(volumes)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TopM> = object : Parcelable.Creator<TopM> {
            override fun createFromParcel(source: Parcel): TopM = TopM(source)
            override fun newArray(size: Int): Array<TopM?> = arrayOfNulls(size)
        }
    }
}