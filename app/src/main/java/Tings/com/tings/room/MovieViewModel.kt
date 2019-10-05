package Tings.com.tings.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Class extends AndroidViewModel and requires application as a parameter.
class MovieViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: MovieRepository
    // LiveData gives us updated movies when they change.
    val allMovies: LiveData<List<Movie>>
    val viewModelScope=GlobalScope

    init {
        // Gets reference to MovieDao from MovieRoomDatabase to construct
        // the correct MovieRepository. 
        val moviesDao = MovieRoomDatabase.getDatabase(application,viewModelScope).movieDao()
        repository = MovieRepository(moviesDao)
        allMovies = repository.allMovies
    }

    // The implementation of insert() is completely hidden from the UI.
    // We don't want insert to block the main thread, so we're launching a new
    // coroutine. ViewModels have a coroutine scope based on their lifecycle called
    // viewModelScope which we can use here.
    fun insert(movie: Movie) = viewModelScope.launch {//
        repository.insert(movie)
    }
}