package com.example.GymDiaryBackend.Service;

import com.example.GymDiaryBackend.model.Exercise;
import com.example.GymDiaryBackend.model.GymMember;
import com.example.GymDiaryBackend.repositories.ExerciseRepository;
import com.example.GymDiaryBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private UserRepository userRepository;

    //Users
    public List<GymMember> findAllUsers(){
        return userRepository.findAll();
    }
    public GymMember findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public GymMember insertOneUser(GymMember user){
        return userRepository.save(user);
    }
    public GymMember updateOneUser(GymMember user){
        return userRepository.save(user);
    }
    public void deleteOneUser(Integer id){
        userRepository.deleteById(id);
    }


    //Exercises
    public List<Exercise> findAllExercises(Integer userId){
        return exerciseRepository.findByUserId(userId);
    }

    public List<Exercise> findExerciseByDate(Integer userId, String date){
        return exerciseRepository.findByUserIdAndDate(userId, date);
    }
    public List<Exercise> findExerciseByUserIdAndName(Integer userId, String name){
        return exerciseRepository.findByUserIdAndName(userId, name);
    }
    public Exercise insertOneExercise(Integer userId, Exercise exercise){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        exercise.setDate(df.format(date));
        exercise.setUserId(userId);
        return exerciseRepository.save(exercise);
    }
    public Exercise updateOneExercise(Integer userId, Exercise exercise){
        Optional<Exercise> exercise1 = exerciseRepository.findById(exercise.getId());
        exercise1.ifPresent(exercise3 -> exercise.setDate(exercise3.getDate()));
        exercise.setUserId(userId);
        return exerciseRepository.save(exercise);
    }
    public void deleteOneExercise(Integer id){
        exerciseRepository.deleteById(id);
    }


}
