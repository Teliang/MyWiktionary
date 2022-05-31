package org.teliang.android.mywiktionary

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : WebBaseActivity() {

    val LOG_TAG = "MainActivity"

    override lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myWebView = findViewById(R.id.main_webview)
        myWebView.loadUrl("https://www.wiktionary.org/")
        myWebView.webViewClient = WebViewClient()

        val mySwipeRefreshLayout: SwipeRefreshLayout = findViewById(R.id.main_swiperefresh)

        webSwipeReload(mySwipeRefreshLayout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings) {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            return true
        } else if (id == R.id.action_about) {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}