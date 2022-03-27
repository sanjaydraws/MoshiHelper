package com.sanjayprajapat.moshihelper.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User (
    @Json(name = "user_name")
    val name:String,
    @Json(name = "user_email")
    val email:String,
    @Json(name = "user_number")
    val numbers:List<String>
)