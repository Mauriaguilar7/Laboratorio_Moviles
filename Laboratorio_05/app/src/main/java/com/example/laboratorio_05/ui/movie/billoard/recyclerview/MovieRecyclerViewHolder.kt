package com.example.laboratorio_05.ui.movie.billoard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind (movie: MovieModel, clickListener: (MovieModel)->Unit)  {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}