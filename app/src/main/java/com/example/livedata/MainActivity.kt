package com.example.livedata

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val factsTextView:TextView
        get() = findViewById(R.id.tvFacts)
    private val factsButton:Button
        get() = findViewById(R.id.btnFacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this, Observer {
            factsTextView.text = it
        })

        factsButton.setOnClickListener{
            mainViewModel.updateLiveData()
        }
    }
}