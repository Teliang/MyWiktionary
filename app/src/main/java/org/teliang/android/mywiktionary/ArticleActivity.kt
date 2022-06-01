package org.teliang.android.mywiktionary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class ArticleActivity : WebBaseActivity() {
    private val LOG_TAG = "ArticleActivity"

    override lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        myWebView = findViewById(R.id.article_webview)
        myWebView.webViewClient = WebViewClient()

        val mySwipeRefreshLayout: SwipeRefreshLayout = findViewById(R.id.article_swiperefresh)

        webSwipeReload(mySwipeRefreshLayout)

        this.supportActionBar
            ?.setHomeAsUpIndicator(com.google.android.material.R.drawable.ic_m3_chip_close)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true);

//      user configure
        var language = "en"
        val word = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
        Log.d(LOG_TAG, word.toString())
        myWebView.loadUrl("https://$language.m.wiktionary.org/wiki/$word")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // close this activity as oppose to navigating up
        return false
    }

}