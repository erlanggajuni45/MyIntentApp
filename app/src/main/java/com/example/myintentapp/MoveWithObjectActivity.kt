package com.example.myintentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject : TextView = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name: ${person.name.toString()},\nEmail: ${person.email},\nAge: ${person.age},\nCity: ${person.city}"
            tvObject.text = text
        }
    }
}