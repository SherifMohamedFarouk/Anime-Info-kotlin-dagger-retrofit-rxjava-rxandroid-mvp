package com.example.ainfo.model.searchanime

import android.os.Parcel
import android.os.Parcelable

data class SearchAnime(
    val last_page: Int,
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val results: List<Result>
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readInt(),
        1 == source.readInt(),
        source.readString(),
        ArrayList<Result>().apply { source.readList(this, Result::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(last_page)
        writeInt(request_cache_expiry)
        writeInt((if (request_cached) 1 else 0))
        writeString(request_hash)
        writeList(results)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SearchAnime> = object : Parcelable.Creator<SearchAnime> {
            override fun createFromParcel(source: Parcel): SearchAnime = SearchAnime(source)
            override fun newArray(size: Int): Array<SearchAnime?> = arrayOfNulls(size)
        }
    }
}