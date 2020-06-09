package com.antarticstudio.lottietestcrash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_content)

        val fragment = MainFragment.newInstance()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContent, fragment, "MainPage")
            .commitAllowingStateLoss()
    }
}
