package com.shahnawaz.nytimes.model

data class MostViewed(
    val status: String?, val copyright: String?,
    val results: ArrayList<Results>?
)