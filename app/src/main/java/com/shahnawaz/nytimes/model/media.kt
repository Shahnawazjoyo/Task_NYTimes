package com.shahnawaz.nytimes.model

import com.google.gson.annotations.SerializedName

class media(
    @SerializedName("media-metadata")
    val mediaMetadata: MutableList<MediaMetadata>
)