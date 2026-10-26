package ru.glashiii.kotlinlessonapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textInput = findViewById<EditText>(R.id.textInput)

        findViewById<Button>(R.id.explicitIntentButton).setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, textInput.text.toString())
            startActivity(intent)
        }

        findViewById<Button>(R.id.implicitIntentButton).setOnClickListener {

            val intent = Intent(SecondActivity.ACTION_SHOW_TEXT)
            intent.putExtra(Intent.EXTRA_TEXT, textInput.text.toString())
            startActivity(intent)
        }
    }
}
