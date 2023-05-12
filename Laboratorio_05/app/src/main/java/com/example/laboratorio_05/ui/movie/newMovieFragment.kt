package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.databinding.FragmentMovieBinding
import com.example.laboratorio_05.databinding.FragmentNewMovieBinding
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel


class newMovieFragment : Fragment() {


    private lateinit var binding: FragmentNewMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewMovieBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = movieViewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }
}