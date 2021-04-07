@file:Suppress("DEPRECATION")

package com.example.mobile_21545_ca3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_row.*

class MainActivity : AppCompatActivity() {

    var myList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save.setOnClickListener {
            var insertedText = addList.text.toString()
            var sharedPreferences = getSharedPreferences("SHARED_TITLE", MODE_PRIVATE)
            var editor: SharedPreferences.Editor = sharedPreferences.edit()


            editor.apply {
                putString("SHARED_TITLE", insertedText)

            }.apply()

            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            while(insertedText!= null) {
                recyclerView.adapter = MainAdapter(initList(insertedText))
            }

        }

    }

    private fun initList(insertedText: String): ArrayList<ItemObject> {

        val arrayList = ArrayList<ItemObject>()

        arrayList.add(ItemObject(insertedText))

        return arrayList
    }


    }
