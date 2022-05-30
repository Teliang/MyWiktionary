package org.teliang.android.mywiktionary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class ArticleActivity : AppCompatActivity() {
    private val TAG = "ArticleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val myWebView: WebView = findViewById(R.id.article_webview)
        myWebView.webViewClient = WebViewClient()

        var language = "en"
        val word = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)
        Log.d(TAG, word.toString())
        myWebView.loadUrl("https://$language.m.wiktionary.org/wiki/$word")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        val myWebView: WebView = findViewById(R.id.article_webview)
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

}