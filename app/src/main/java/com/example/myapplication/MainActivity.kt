package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var txt_name = findViewById<TextView>(R.id.txt_name).text
        var  txt_number= findViewById<TextView>(R.id.txt_number).text
        var txt_address = findViewById<TextView>(R.id.txt_address).text


        val person = hashMapOf(
            "name" to txt_name.toString(),
            "number" to txt_number.toString(),
            "address" to txt_address.toString()
        )
        findViewById<Button>(R.id.btn_show).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)


        }
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            if (txt_name.isEmpty() && txt_number.isEmpty() && txt_address.isEmpty()) {
                Toast.makeText(this, "enter all inputs", Toast.LENGTH_LONG).show()
            } else {
                db.collection("persones").add(person)
                    .addOnSuccessListener { person ->
                        Toast.makeText(this, person.id, LENGTH_SHORT).show()
                        txt_number=""
                        txt_address =""
                        txt_name=""
                    }.addOnFailureListener { e ->
                        Toast.makeText(this, e.toString(), LENGTH_SHORT).show()
                    }

            }

        }
    }


}