package com.example.recyclerviewassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ImageSelectorAdapter(private val imageList : ArrayList<ImageSelect>):
RecyclerView.Adapter<ImageSelectorAdapter.ImageViewHolder>(){

    interface OnImageClickListener{
       fun onImageListener(position: Int,imageSelect: ImageSelect,view: View)
    }
    var onImageClickListener : OnImageClickListener? = null

    inner class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
       val image : ImageView
       val edtUserName : TextView
       val edtAddress : TextView
        init {
            image = view.findViewById(R.id.img1)
            edtUserName = view.findViewById(R.id.edtUserName)
            edtAddress = view.findViewById(R.id.edtAddress)
        }
    }

    override fun getItemCount() = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_item_select,null)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.image.setImageResource(imageList[position].image)
        holder.edtUserName.text = imageList[position].userName
        holder.edtAddress.text = imageList[position].address

    }
}