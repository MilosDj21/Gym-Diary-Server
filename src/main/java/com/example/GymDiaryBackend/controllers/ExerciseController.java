package com.example.GymDiaryBackend.controllers;

import com.example.GymDiaryBackend.Service.ApiService;
import com.example.GymDiaryBackend.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExerciseController {

    @Autowired
    private ApiService service;

    @GetMapping("/users/{userId}/exercises")
    public List<Exercise> findAllExercises(@PathVariable Integer userId){
        return service.findAllExercises(userId);
    }
    @GetMapping("/users/{userId}/exercises/date/{date}")
    public List<Exercise> findByDate(@PathVariable Integer userId, @PathVariable String date){
        return service.findExerciseByDate(userId, date);
    }
    @GetMapping("/users/{userId}/exercises/{exerciseName}")
    public List<Exercise> findExerciseByUserIdAndName(@PathVariable int userId, @PathVariable String exerciseName){
        return service.findExerciseByUserIdAndName(userId, exerciseName);
    }
    @PostMapping("/users/{userId}/exercises")
    public Exercise insertOneExercise(@PathVariable Integer userId, @RequestBody Exercise exercise){
        return service.insertOneExercise(userId, exercise);
    }
    @PutMapping("/users/{userId}/exercises")
    public Exercise updateOneExercise(@PathVariable Integer userId, @RequestBody Exercise exercise){
        return service.updateOneExercise(userId, exercise);
    }
    @DeleteMapping("/users/exercises/{exerciseId}")
    public void deleteOneExercise(@PathVariable Integer exerciseId){
        service.deleteOneExercise(exerciseId);
    }
}
