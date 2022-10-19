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
            // Intialize fragment with fizzbuzz meta.
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    ResultFragment.newInstance(intent.getParcelableExtra("meta")))
                .commitNow()
        }
    }
}