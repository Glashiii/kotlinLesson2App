package ru.glashiii.kotlinlessonapp2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.receivedText).text =
            intent.getStringExtra(Intent.EXTRA_TEXT).orEmpty()

        findViewById<TextView>(R.id.intentLabel).setText(
            if (intent.action == ACTION_SHOW_TEXT) {
                R.string.implicit_intent
            } else {
                R.string.explicit_intent
            }
        )
    }

    companion object {
        const val ACTION_SHOW_TEXT = "ru.glashiii.kotlinlessonapp2.action.SHOW_TEXT"
    }
}
