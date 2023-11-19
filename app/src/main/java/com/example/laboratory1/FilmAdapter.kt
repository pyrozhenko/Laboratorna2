package com.example.laboratory1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratory1.databinding.ItemAnimalBinding

class FilmAdapter(private val onItemClick: (Film, Int) -> Unit) : RecyclerView.Adapter<FilmAdapter.AnimalViewHolder>() {
    private var filmList: List<Film> = emptyList()

    inner class AnimalViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film, position: Int) {
            binding.apply {
                iv.setImageResource(film.imageResId)
                animalName.text = film.name
                shortDescription.text = film.description
                btn.setOnClickListener { onItemClick(film, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val film = filmList[position]
        holder.bind(film, position)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun setList(filmList: List<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
    }
}