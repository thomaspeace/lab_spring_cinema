package com.example.spring_cinema.repositories;

import com.example.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
