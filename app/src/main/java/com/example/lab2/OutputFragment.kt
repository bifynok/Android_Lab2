package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class OutputFragment : Fragment(R.layout.output_fragment) {
    private lateinit var outputText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        outputText = view.findViewById(R.id.outputText)
    }

    fun updateText(text: String) {
        outputText.text = text
    }
}
