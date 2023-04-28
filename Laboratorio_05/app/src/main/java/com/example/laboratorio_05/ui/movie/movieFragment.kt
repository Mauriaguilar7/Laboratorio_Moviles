package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel

class movieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    private lateinit var nameEditText : EditText
    private lateinit var categoryEditText : EditText
    private lateinit var descriptionText : EditText
    private lateinit var qualificationEditText : EditText
    private lateinit var summitButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        summitButton.setOnClickListener {
            addMovie()
        }

    }





    private fun bind (){
        nameEditText = view?.findViewById(R.id.nameEditText) !!
        categoryEditText = view?.findViewById(R.id.categoryEditText) !!
        descriptionText = view?.findViewById(R.id.descriptionEditText) !!
        qualificationEditText = view?.findViewById(R.id.qualificationEditText) !!
        summitButton = view?.findViewById(R.id.simon_button) !!
    }

    private fun addMovie(){
        val name = nameEditText.text.toString()
        val category = categoryEditText.text.toString()
        val description = descriptionText.text.toString()
        val qualification = qualificationEditText.text.toString()

        val movie = MovieModel(name, category, description, qualification)

        movieViewModel.addMovies(movie)


        Log.d("NewMovieFragment", movieViewModel.getMovies().toString())

        findNavController().popBackStack()

    }
}