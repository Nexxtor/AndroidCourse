package com.deushdezt.estructurabasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var mDisplayText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDisplayText = findViewById(R.id.tv_display_text)

        mDisplayText.text = "Texto agregado desde codigo"
    }
}
