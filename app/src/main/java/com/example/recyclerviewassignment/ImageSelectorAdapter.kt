package com.example.recyclerviewassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
    var onItemClick : ((ImageSelect)->Unit)? = null
    inner class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image : ImageView
        val txtTitle : TextView
       // val btnSave : Button

        init {
            image = view.findViewById(R.id.img1)
            txtTitle = view.findViewById(R.id.txtTitle)
            //btnSave = view.findViewById(R.id.btnSave)
            itemView.setOnClickListener {
                Toast.makeText(it.context,"My action:${position} is clicked",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_main2,null)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imagelist = imageList[position]
        holder.image.setImageResource(imagelist.image)
        holder.txtTitle.text = imagelist.title

    }
}