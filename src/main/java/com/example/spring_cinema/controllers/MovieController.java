package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

//  Returns all movies in database
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

//  Returns movie by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if (movieOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Movie movie = movieOptional.get();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }

//  Add a movie to the database
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        // We expect something returned here as .save() returns the object added to the database
        Movie savedMovie = movieService.createMovie(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }




}
