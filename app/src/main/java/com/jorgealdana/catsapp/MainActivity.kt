package com.jorgealdana.catsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jorgealdana.catsapp.databinding.ActivityMainBinding
import com.jorgealdana.catsapp.views.viewcats.ViewCatsFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.containerMain.id, ViewCatsFragment.newInstance())
                .commitNow()
        }
    }
}