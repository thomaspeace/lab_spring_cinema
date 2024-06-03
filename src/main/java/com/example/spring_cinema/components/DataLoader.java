package com.example.spring_cinema.components;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;


//    Data loader starts the database with some entries


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Movie movie1 = new Movie("Shrek", "12A", 120);
        Movie movie2 = new Movie("Pulp Fiction", "18", 115);
        Movie movie3 = new Movie("Kiki's Delivery Service", "E", 110);

        movieService.createMovie(movie1);
        movieService.createMovie(movie2);
        movieService.createMovie(movie3);



    }
}
