package org.teliang.android.mywiktionary

import android.view.KeyEvent
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

abstract class WebBaseActivity : AppCompatActivity() {

    abstract val webViewId: Int

    abstract val swipeRefreshId: Int

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val myWebView: WebView = findViewById(webViewId)
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

    protected fun setWebSwipeReload() {
        val mySwipeRefreshLayout: SwipeRefreshLayout = findViewById(swipeRefreshId)
        val myWebView: WebView = findViewById(webViewId)
        mySwipeRefreshLayout.setOnRefreshListener {
            myWebView.reload()
            //should add to web finish callback
            mySwipeRefreshLayout.isRefreshing = false
        }
    }
}