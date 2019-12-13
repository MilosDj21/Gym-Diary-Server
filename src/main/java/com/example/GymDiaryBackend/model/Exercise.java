package com.example.GymDiaryBackend.model;

import javax.persistence.*;

@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer reps;
    private Double weight;
    private String date;
    private Integer userId;

    public Exercise() {
    }

    public Exercise(Integer id, String name, Integer reps, Double weight, String date, Integer userId) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}


