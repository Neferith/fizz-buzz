package com.fizzbuzz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fizzbuzz.R
import com.fizzbuzz.ui.main.FormMainFragment

class FormMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FormMainFragment.newInstance())
                .commitNow()
        }
    }
}