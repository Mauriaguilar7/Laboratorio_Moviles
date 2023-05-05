package com.example.laboratorio_05.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_05.MovieReviewerApplication
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository) : ViewModel() {


    var name = MutableLiveData("")
    var category = MutableLiveData ("")
    var description = MutableLiveData ("")
    var qualification = MutableLiveData ("")
    var status = MutableLiveData ("")



    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)


    fun createMovie(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrBlank() -> return false
            category.value.isNullOrBlank() -> return false
            description.value.isNullOrBlank() -> return false
            qualification.value.isNullOrBlank() -> return false
        }
        return true
    }

    private fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}