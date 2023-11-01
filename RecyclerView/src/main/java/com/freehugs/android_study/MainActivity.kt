package com.freehugs.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freehugs.android_study.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //데이터 넣기
        val items = mutableListOf<String>()

        items.add("a")
        items.add("b")
        items.add("c")

        val rv1 = findViewById<RecyclerView>(R.id.rv_1)

        //RecyclerView에 집어넣을 Adapter 만들기
        val rv1Adapter = RV1Adapter(items)

        rv1.adapter = rv1Adapter
        rv1.layoutManager = LinearLayoutManager(this)

        rv1Adapter.itemClick = object : RV1Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}
