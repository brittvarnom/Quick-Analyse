package britt.com.quickanalyse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onButtonsClicked()
    }

    fun onButtonsClicked() {
        onButtonClicked(analyser_text_button, TextInputActivity().javaClass)
        onButtonClicked(analyser_file_button, FIleInputActivity().javaClass)
    }

    fun onButtonClicked(button: Button, destination: Class<Activity>) {
        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, destination))
        }
    }
}