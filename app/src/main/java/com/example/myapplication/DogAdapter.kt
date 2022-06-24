package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogAdapter : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    var dogList: List<Dog> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context))
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = dogList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dogList.size

    class DogViewHolder(
        private val binding: ItemDogBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog) {
            val picasso = Picasso.Builder(binding.root.context).build()
            picasso.load(dog.imageUrl).into(binding.imgDog)
        }
    }
}