package ru.webanimal.test46podlodkacrewlinttest

import android.os.Bundle
import android.util.Log
import moxy.MvpAppCompatActivity

class MainActivity: MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(this::class.java.simpleName, "TEST::onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.d(this::class.java.simpleName, "TEST::onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(this::class.java.simpleName, "TEST::onResume")
        super.onResume()

        routeToFirstScreen()
    }

    override fun onStop() {
        super.onStop()
        Log.d(this::class.java.simpleName, "TEST::onStop")
    }

    private fun routeToFirstScreen() {
        val tag = FirstScreenFragment::class.java.simpleName
        val fragment = supportFragmentManager.findFragmentByTag(tag) ?: FirstScreenFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, FirstScreenFragment::class.java.simpleName)
            .commit()
    }
}