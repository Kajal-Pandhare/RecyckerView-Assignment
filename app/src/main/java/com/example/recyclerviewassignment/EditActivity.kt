package com.example.recyclerviewassignment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditActivity:AppCompatActivity() {

    private lateinit var userName : String
    private lateinit var Address : String

    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3  : ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    private lateinit var image6 : ImageView
    private lateinit var edtuserName : EditText
    private lateinit var edtAddress  : EditText
    private lateinit var btnSave  : Button

    private lateinit var saveUsername : String
    private lateinit var saveAddress : String
    private var selectedImage : Int = 0
    private var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_activity)

        initData()
        initListener()

        userName = intent.getStringExtra("userName").toString()
        Address = intent.getStringExtra("Address").toString()

        edtuserName.setText(userName)
        edtAddress.setText(Address)

        btnSave.setOnClickListener {
            saveUsername = edtuserName.text.toString()
            saveAddress = edtAddress.text.toString()

            val intent = Intent()
            intent.putExtra("position",position)
            intent.putExtra("userName",saveUsername)
            intent.putExtra("Address",saveAddress)
            intent.putExtra("selectedImage",selectedImage)

            setResult(3,intent)
            finish()
        }
    }
    private fun initData(){
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        edtuserName = findViewById(R.id.editUserName)
        edtAddress = findViewById(R.id.editAddress)
        btnSave = findViewById(R.id.buttonSave)

    }
    private fun initListener(){
        image1.setOnClickListener {
            image1.setBackgroundColor(Color.parseColor("#4CAF50"))
            selectedImage = R.drawable.image1
        }
        image2.setOnClickListener{
            selectedImage = R.drawable.image2
            image2.setBackgroundColor(Color.parseColor("#FF5722"))
        }
        image3.setOnClickListener{
            selectedImage = R.drawable.image3
            image3.setBackgroundColor(Color.parseColor("#009688"))
        }
        image4.setOnClickListener{
            selectedImage = R.drawable.image4
            image2.setBackgroundColor(Color.parseColor("#FF9800"))
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
