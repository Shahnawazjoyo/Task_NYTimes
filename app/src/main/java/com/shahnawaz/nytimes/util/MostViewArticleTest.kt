package com.shahnawaz.nytimes.util

import com.shahnawaz.nytimes.model.MediaMetadata
import com.shahnawaz.nytimes.model.Results
import com.shahnawaz.nytimes.model.media


object MostViewArticleTest {

    const val FAKE_NETWORK_DELAY = 1000L

    val resultList = arrayOf(

        Results(
            "In the Covid-19 Economy, You Can Have a Kid or a Job. You Can’t Have Both.",
            "https://static01.nyt.com/images/2020/07/05/business/02Schoolparent-illo/02Schoolparent-illo-thumbStandard.jpg",
            "Our struggle is not an emotional concern. We are not burned out. We are being crushed by an economy that has bafflingly declared working parents inessential.",
            "2020-07-02",
            arrayListOf(media(arrayListOf(MediaMetadata("https://static01.nyt.com/images/2020/07/05/business/02Schoolparent-illo/02Schoolparent-illo-thumbStandard.jpg"))))
        )
    )
}