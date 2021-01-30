package com.parkir.testapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class categori(

    @Expose
    @field:SerializedName("categories")
    val categori: List<ListResep> ?= null
) : Parcelable