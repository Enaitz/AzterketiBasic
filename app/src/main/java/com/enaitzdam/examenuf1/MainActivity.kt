package com.enaitzdam.examenuf1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels

class MainActivity : AppCompatActivity() {
    private val sharedViewModel: SharedViewModel by viewModels<SharedViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val nomAdmin: TextView = findViewById(R.id.editTextAdmin)
//
//        sharedViewModel.asignarAdmin(nomAdmin.text.toString())
        // get reference to button
        val btn_click_me = findViewById(R.id.buttonEntrar) as Button
// set on-click listener
        btn_click_me.setOnClickListener {
            val nomAdmin: TextView = findViewById(R.id.editTextAdmin)
            sharedViewModel.asignarAdmin(nomAdmin.text.toString())
            val prova = sharedViewModel.admin
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}