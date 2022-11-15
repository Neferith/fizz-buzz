package com.fizzbuzz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fizzbuzz.R
import com.fizzbuzz.ui.result.ResultFragment

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    ResultFragment.newInstance(intent.getParcelableExtra("entity"))
                )
                .commitNow()
        }
    }
}