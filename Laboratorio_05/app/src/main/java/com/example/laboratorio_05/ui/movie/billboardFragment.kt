package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton



class billboardFragment : Fragment() {

    private lateinit var action_button : FloatingActionButton
    private lateinit var cardView_star_wars : CardView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        cardView_star_wars.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
        action_button.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }


    }

    private fun bind(){
        action_button = view?.findViewById(R.id.action_button) as FloatingActionButton
        cardView_star_wars = view?.findViewById(R.id.cardView_StarWars) as CardView
    }

}