package org.teliang.android.mywiktionary

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myWebView: WebView = findViewById(R.id.main_webview)
        myWebView.loadUrl("https://www.wiktionary.org/")
        myWebView.webViewClient = WebViewClient()
    }
}