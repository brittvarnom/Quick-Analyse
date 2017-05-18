package britt.com.quickanalyse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onButtonsClicked()
    }

    fun onButtonsClicked() {
        onButtonClicked(analyser_text_button, TextInputActivity().javaClass)
        onButtonClicked(analyser_file_button, FIleInputActivity().javaClass)
        onButtonClicked(analyser_demo_button, DemoInputActivity().javaClass)
    }

    fun onButtonClicked(analyser_button: Button, destination: Class<Activity>) {
        analyser_button.setOnClickListener {
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, destination))
        }
    }
}



