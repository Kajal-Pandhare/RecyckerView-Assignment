package com.example.recyclerviewassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonSave : Button
    private lateinit var imageSelectorAdapter: ImageSelectorAdapter
    val imageList = ArrayList<ImageSelect>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initViews()

        recyclerView = findViewById(R.id.recyclerPost)
       // buttonSave = findViewById(R.id.btnSave)

        imageSelectorAdapter = ImageSelectorAdapter(imageList)
        recyclerView.adapter = imageSelectorAdapter

        recyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        imageSelectorAdapter.onItemClick={
            val intent = Intent(this,MainActivity::class.java)

        }
    }

    private fun initViews(){
        imageList.add(ImageSelect(
            R.drawable.image1,
            "Pasta"
        ))
        imageList.add(ImageSelect(
            R.drawable.image2,
            "Pizza"
        ))
        imageList.add(ImageSelect(
            R.drawable.image3,
            "Noodels"
        ))
        imageList.add(ImageSelect(
            R.drawable.image4,
            "Chiken Biriyani"
        ))
        imageList.add(ImageSelect(
            R.drawable.image5,
            "Momos"
        ))
        imageList.add(ImageSelect(
            R.drawable.image6,
            "Manchurian"
        ))

    }
}