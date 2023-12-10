package com.example.recyclerviewassignment

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailActivity:AppCompatActivity() {
    private lateinit var image : ImageView
    private lateinit var edtuserName : TextView
    private lateinit var edtAddress  : TextView

    private var detailImage : Int = 0
    private var position  :Int=0

    private lateinit var userName : String
    private lateinit var Address  : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_details)

        initViews()
        initIntent()
    }
    private fun initViews(){
        image = findViewById(R.id.img)
        edtuserName = findViewById(R.id.textUserName)
        edtAddress = findViewById(R.id.textAddress)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        val itemMenu = menu?.findItem(R.id.itemMenu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.editItem -> {
                val intent = Intent(this@DetailActivity,EditActivity::class.java)
                intent.putExtra("position",position)
                intent.putExtra("userName",userName)
                intent.putExtra("Address",Address)
                intent.putExtra("selectedImage",detailImage)

                startActivityForResult(intent,3)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 3 && resultCode == 4) {
            position = data?.getIntExtra("position", -1)!!
            if (position != -1) {
                userName = data?.getStringExtra("userName").toString()
                Address = data?.getStringExtra("Address").toString()
                detailImage = data?.getIntExtra("detailImage", 0).toString().toInt()

                edtuserName.setText(userName)
                edtAddress.setText(Address)
                image.setImageResource(detailImage)

                val intent = Intent()
               intent.putExtra("position",position)
                intent.putExtra("userName",userName)
                intent.putExtra("Address",Address)
                intent.putExtra("detailImage",detailImage)

                setResult(3,intent)
                finish()
            }
        }
    }
    private fun initIntent(){
        val position = intent.getIntExtra("position",-1)

        if (position != -1){
            userName = intent.getStringExtra("userName").toString()
            Address = intent.getStringExtra("Address").toString()
            detailImage = intent.getIntExtra("selectedImage",0).toString().toInt()

            edtuserName.setText(userName)
            edtAddress.setText(Address)
            image.setImageResource(detailImage)
        }
        else{
            Toast.makeText(this,"position not found",Toast.LENGTH_SHORT).show()
        }
    }
}