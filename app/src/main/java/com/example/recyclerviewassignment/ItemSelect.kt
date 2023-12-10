package com.example.recyclerviewassignment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ItemSelect : AppCompatActivity() {

    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3  :ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    private lateinit var image6 : ImageView
    private lateinit var edtuserName : EditText
    private lateinit var edtAddress  : EditText
    private lateinit var btnSave  :Button
    private var selectedImage : Int = 0

    private lateinit var userName : String
    private lateinit var address : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        imageClickOnListener()

        btnSave.setOnClickListener {
            userName = edtuserName.text.toString()
            address = edtAddress.text.toString()

            val intent = Intent()

            intent.putExtra("userName", userName)
            intent.putExtra("address", address)
            intent.putExtra("selectedImage",selectedImage)

            setResult(1, intent)
            finish()
        }

    }
    private fun initViews(){
        setContentView(R.layout.activity_item_select)
        image1 = findViewById(R.id.img1)
        image2 = findViewById(R.id.img2)
        image3 = findViewById(R.id.img3)
        image4 = findViewById(R.id.img4)
        image5 = findViewById(R.id.img5)
        image6 = findViewById(R.id.img6)
        edtuserName = findViewById(R.id.edtUserName)
        edtAddress = findViewById(R.id.edtAddress)
        btnSave = findViewById(R.id.btnSave)

    }
    private fun imageClickOnListener(){

            image1.setOnClickListener {
                 selectedImage = R.drawable.image1
                    image1.setBackgroundColor(Color.parseColor("#4CAF50"))

                Toast.makeText(this, "Image1 clicked", Toast.LENGTH_SHORT).show()
            }
            image2.setOnClickListener{
                 selectedImage = R.drawable.image2
                image2.setBackgroundColor(Color.parseColor("#FF5722"))
                Toast.makeText(this,"Image2 is clicked",Toast.LENGTH_SHORT).show()
            }
            image3.setOnClickListener{
                image3.setBackgroundColor(Color.parseColor("#009688"))
                selectedImage = R.drawable.image3
            }
            image4.setOnClickListener{
                image4.setBackgroundColor(Color.parseColor("#FF9800"))
            selectedImage = R.drawable.image4
        }
            image5.setOnClickListener{

                selectedImage = R.drawable.image5
                image5.setBackgroundColor(Color.parseColor("#2196F3"))
            }
            image6.setOnClickListener{
                selectedImage = R.drawable.image6
                image6.setBackgroundColor(Color.parseColor("#673AB"))
            }
    }

}