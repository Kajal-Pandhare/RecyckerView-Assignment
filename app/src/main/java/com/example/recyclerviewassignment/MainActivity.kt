package com.example.recyclerviewassignment

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var menuPlus: Menu
    private lateinit var imageSelectorAdapter: ImageSelectorAdapter
    private lateinit var itemSelect: ItemSelect

    val imageList = ArrayList<ImageSelect>()
    private lateinit var username: String
    private lateinit var address: String
    private var selectedImage: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerPost)

        imageSelectorAdapter = ImageSelectorAdapter(imageList)
        recyclerView.adapter = imageSelectorAdapter



        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        initListener()
    }

    fun initListener() {
        imageSelectorAdapter.onImageClickListener = MyOnItemClickListener()
    }

    private inner class MyOnItemClickListener : ImageSelectorAdapter.OnImageClickListener {

        override fun onImageListener(position: Int, imageSelect: ImageSelect, view: View) {
           // Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show()
            // val intent = Intent(this@MainActivity,DetailActivity::class.java)
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("userName", imageList[position].userName)
            intent.putExtra("Address", imageList[position].address)
            intent.putExtra("selectedImage", imageList[position].image)


            startActivityForResult(intent, 2)
            Toast.makeText(this@MainActivity, "listener", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity, menu)
        val itemMenu = menu?.findItem(R.id.itemMenu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val intent = Intent(this, ItemSelect::class.java)
        startActivityForResult(intent, 1)

        return super.onOptionsItemSelected(item)
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == 1) {
            username = data?.getStringExtra("userName").toString()
            address = data?.getStringExtra("address").toString()
            selectedImage = data?.getIntExtra("selectedImage", 0)!!.toInt()

            imageList.add(
                ImageSelect(
                    selectedImage,
                    username,
                    address
                )
            )
            imageSelectorAdapter.notifyDataSetChanged()
        }

        if (requestCode == 2 && resultCode == 3) {

            val position = data?.getIntExtra("position", -1)

            if (position != -1) {
                username = data?.getStringExtra("userName").toString()
                address = data?.getStringExtra("Address").toString()
                selectedImage = data?.getIntExtra("detailImage", 0).toString().toInt()

                if (position != null) {
                   imageList[position] = ImageSelect(selectedImage,username,address)
                    imageSelectorAdapter.notifyItemChanged(position)
                }
            }
        }
        if (requestCode == 2 && resultCode == 4){
            val position = data?.getIntExtra("position",-1)

            if (position != -1){
                if (position != null){
                    imageList.removeAt(position)
                }
                if (position != null){
                    imageSelectorAdapter.notifyItemRemoved(position)
                }
            }
        }
    }

}
