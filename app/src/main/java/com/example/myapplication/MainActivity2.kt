package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.databinding.ActivityAdapterUserBinding
import com.example.myapplication.moodle.User

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityAdapterUserBinding
    private lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdapterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = arrayOf(
            User("abdallah", 1, "sabera"),
            User("suliman", 1, "zaiton"),
            User("osama", 1, "remal"),
            User("salama", 1, "tal al hawa")
        )

        recycleView = findViewById(R.id.listView)

        var adapter = ArrayAdapter(this, android.R.layout.activity_list_item, data)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = UserAdapter(this, data)


    }

}
