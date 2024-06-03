package com.example.spring_cinema.models;


//Basically, a POJO is a Java object which we use purely as a data type
//A POJO must have a default constructor (one with no parameters)
//It must have private properties, and public getters & setters for all of them

import jakarta.persistence.*;

@Entity
@Table(name = "cinema")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private String rating;

    @Column(name = "duration")
    private int duration;


    public Movie(String title, String rating, int duration) {
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }


    public Movie() {

    }


//    Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
