package com.example.ainfo.model

import android.os.Parcel
import android.os.Parcelable

data class TopModel(
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val top: List<Top>
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        1 == source.readInt(),
        source.readString(),
        source.createTypedArrayList(Top.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(request_cache_expiry)
        writeInt((if (request_cached) 1 else 0))
        writeString(request_hash)
        writeTypedList(top)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TopModel> = object : Parcelable.Creator<TopModel> {
            override fun createFromParcel(source: Parcel): TopModel = TopModel(source)
            override fun newArray(size: Int): Array<TopModel?> = arrayOfNulls(size)
        }
    }
}