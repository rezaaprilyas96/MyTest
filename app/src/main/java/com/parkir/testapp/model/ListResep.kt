package com.parkir.testapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ListResep(

    @Expose
    @field:SerializedName("idCategory")
    var idCategory:String ?= null,

    @Expose
    @field:SerializedName("strCategory")
    var strCategory:String ?= null,

    @Expose
    @field:SerializedName("strCategoryThumb")
    var strCategoryThumb:String ?= null,

    @Expose
    @field:SerializedName("strCategoryDescription")
    var strCategoryDescription:String ?= null
):Serializable, Parcelable