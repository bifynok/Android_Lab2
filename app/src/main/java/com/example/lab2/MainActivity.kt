package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var outputFragment: OutputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputFragment = supportFragmentManager.findFragmentById(R.id.outputFragment) as OutputFragment

        val inputFragment = supportFragmentManager.findFragmentById(R.id.inputFragment) as InputFragment
        inputFragment.setOnTextEnteredListener { text ->
            outputFragment.updateText(text)
        }
    }
}
