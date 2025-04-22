package com.example.lab2

import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    private var onTextEntered: ((String) -> Unit)? = null

    fun setOnTextEnteredListener(listener: (String) -> Unit) {
        onTextEntered = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.input_fragment, container, false)

        val editText = view.findViewById<EditText>(R.id.editText)
        val button = view.findViewById<Button>(R.id.buttonOk)
        val showPassword = view.findViewById<RadioButton>(R.id.showPassword)
        val hidePassword = view.findViewById<RadioButton>(R.id.hidePassword)

        button.setOnClickListener {
            val text = editText.text.toString()
            onTextEntered?.invoke(text)
        }

        showPassword.setOnClickListener {
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            editText.setSelection(editText.text.length)
        }

        hidePassword.setOnClickListener {
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            editText.setSelection(editText.text.length)
        }

        return view
    }
}
