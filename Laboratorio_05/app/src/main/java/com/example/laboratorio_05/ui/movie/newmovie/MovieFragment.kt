package com.example.laboratorio_05.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.laboratorio_05.databinding.FragmentMovieBinding
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel

class movieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observerStatus()

    }

    private fun observerStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG ,status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


    private  fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    companion object{
        const val APP_TAG = "APP_TAG"
    }
}