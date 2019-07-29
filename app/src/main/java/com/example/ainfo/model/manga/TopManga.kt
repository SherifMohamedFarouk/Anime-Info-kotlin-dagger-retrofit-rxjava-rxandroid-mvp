package com.example.ainfo.model.manga

import android.os.Parcel
import android.os.Parcelable

data class TopManga(
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val top: List<TopM>
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        1 == source.readInt(),
        source.readString(),
        ArrayList<TopM>().apply { source.readList(this, TopM::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(request_cache_expiry)
        writeInt((if (request_cached) 1 else 0))
        writeString(request_hash)
        writeList(top)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TopManga> = object : Parcelable.Creator<TopManga> {
            override fun createFromParcel(source: Parcel): TopManga = TopManga(source)
            override fun newArray(size: Int): Array<TopManga?> = arrayOfNulls(size)
        }
    }
}