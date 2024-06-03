package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @Service is a 'bean', we don't need to instantiate it
@Service
public class MovieService {


//    Connecting service layer to data layer
    @Autowired
    MovieRepository movieRepository;


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    public Movie createMovie(Movie newMovie) {
//        .save() returns the added object + ID
        return movieRepository.save(newMovie);
    }


    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }


    public Movie updateMovie(long id, Movie movie) {

        // Getting the ID of the movie to update, we've already checked it exists
        Movie existingMovie = movieRepository.getById(id);

        // check if the given field is empty, if it's present then update it
        if (movie.getTitle() != null) {
            existingMovie.setTitle(movie.getTitle());
        }

        if (movie.getRating() != null) {
            existingMovie.setRating(movie.getRating());
        }

        if (!(movie.getDuration() == 0)) {
            existingMovie.setDuration(movie.getDuration());
        }

        // Updates the movie
        return movieRepository.save(existingMovie);
    }


    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }


}

