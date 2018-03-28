package io.github.stefjohns.funfacts

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import java.util.*

class FunFactsActivity : AppCompatActivity() {
    private val TAG = FunFactsActivity::class.java.simpleName
    private val factBook = FactBook()
    private val colorBook = ColorBook()
    // Declare Our View Variables
    private var factTextView: TextView? = null
    private var showFactButton: Button? = null
    private var relativeLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_facts)

        // Assign The Views From The Layout File To The Corresponding Variables
        factTextView = findViewById(R.id.factTextView)
        showFactButton = findViewById(R.id.showFactButton)
        relativeLayout = findViewById(R.id.relativeLayout)
        showFactButton!!.setOnClickListener {
            val fact = factBook.getFact()
            val color = colorBook.getColor()

            // Update The Screen With Our New Fact
            factTextView!!.text = fact
            relativeLayout!!.setBackgroundColor(color)
            showFactButton!!.setTextColor(color)
        }

        // Toast.makeText(this, "Yay! The Activity was created!", Toast.LENGTH_LONG).show()
        Log.d(TAG, "We're logging from the onCreate() method!")
    }
}
