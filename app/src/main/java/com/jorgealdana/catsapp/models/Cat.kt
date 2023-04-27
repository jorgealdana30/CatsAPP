package com.jorgealdana.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cat(
    @Expose
    @SerializedName("name")
    val breedName: String,
    @Expose
    @SerializedName("origin")
    val origin: String,
    @Expose
    @SerializedName("affection_level")
    val affectionLevel: Int,
    @Expose
    @SerializedName("intelligence")
    val intelligence: Int,
    @Expose
    @SerializedName("reference_image_id")
    val imageUrl: String
)