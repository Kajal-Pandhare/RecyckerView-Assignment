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

class ImageSelectorAdapter(private var imageList : ArrayList<ImageSelect>):
RecyclerView.Adapter<ImageSelectorAdapter.ImageViewHolder>(){

    interface OnImageClickListener{
       fun onImageListener(position: Int,imageSelect: ImageSelect,view: View)
    }
    var onImageClickListener : OnImageClickListener? = null

    inner class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val selectedImage:ImageView
       val userName : TextView
       val Address : TextView

        init {
            selectedImage = view.findViewById(R.id.imageView)
            userName = view.findViewById(R.id.txtUsername)
            Address = view.findViewById(R.id.txtAddress)

            itemView.setOnClickListener{
                if (onImageClickListener!=null){
                    onImageClickListener!!.onImageListener(
                        adapterPosition,
                        imageList[adapterPosition],
                        it
                    )
                }

            }
        }
    }

    override fun getItemCount() = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.view_image,null)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.selectedImage.setImageResource(imageList[position].image)
        holder.userName.text = imageList[position].userName
        holder.Address.text = imageList[position].address

    }
}