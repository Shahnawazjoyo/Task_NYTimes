package com.shahnawaz.nytimes.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.shahnawaz.nytimes.R
import kotlinx.android.synthetic.main.mostview_detail_screen.*

class MovtViewDetailScreen : AppCompatActivity(){




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostview_detail_screen)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }


        intent.getStringExtra("url")?.let { webView.loadUrl(it) }
    }
}