package com.example.recyclerviewassignment

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var menuPlus : Menu
    private lateinit var imageSelectorAdapter: ImageSelectorAdapter
    private lateinit var itemSelect: ItemSelect

    val imageList = ArrayList<ImageSelect>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerPost)

        imageSelectorAdapter = ImageSelectorAdapter(imageList)
        recyclerView.adapter = imageSelectorAdapter

        recyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity, menu)
        val itemMenu = menu?.findItem(R.id.itemMenu)
        return super.onCreateOptionsMenu(menu)
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val Intent = Intent(this,ItemSelect::class.java)
            startActivity(Intent)

        return super.onOptionsItemSelected(item)
    }
    }
