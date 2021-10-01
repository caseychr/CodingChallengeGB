package com.gb.codingchalleng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gb.codingchalleng.R.id.fragmentContainer

class GuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(BuildConfig.FLAVOR)

        supportFragmentManager.beginTransaction()
            .add(fragmentContainer, GuideFragment.newInstance()).commit()
    }
}