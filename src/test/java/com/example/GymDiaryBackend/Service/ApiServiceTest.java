package com.example.GymDiaryBackend.Service;
import com.example.GymDiaryBackend.model.Exercise;
import com.example.GymDiaryBackend.model.GymMember;
import com.example.GymDiaryBackend.repositories.ExerciseRepository;
import com.example.GymDiaryBackend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ApiServiceTest {

    @Autowired
    ApiService apiService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    ExerciseRepository exerciseRepository;
    GymMember gymMember;
    GymMember gymMember1;
    List<GymMember> gymMemberList;
    Exercise exercise;
    Exercise exercise1;
    List<Exercise> exerciseList;

    @BeforeEach
    void setUp(){
        gymMember = new GymMember();
        gymMember1 = new GymMember();
        gymMemberList = new ArrayList<>();
        gymMemberList.add(gymMember);
        gymMemberList.add(gymMember1);

        exercise = new Exercise();
        exercise1 = new Exercise();
        exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        exerciseList.add(exercise1);
    }

    //Users Test
    @Test
    void findAllUsers(){
        Mockito.when(userRepository.findAll()).thenReturn(gymMemberList);
        assertThat(apiService.findAllUsers()).isEqualTo(gymMemberList);
        Mockito.verify(userRepository).findAll();
    }
    @Test
    void findUserByEmail(){
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(gymMember);
        assertThat(apiService.findUserByEmail(Mockito.anyString())).isEqualTo(gymMember);
        Mockito.verify(userRepository).findByEmail(Mockito.anyString());
    }
    @Test
    void insertOneUser(){
        Mockito.when(userRepository.save(Mockito.any(GymMember.class))).thenReturn(gymMember);
        assertThat(apiService.insertOneUser(gymMember1)).isEqualTo(gymMember);
        Mockito.verify(userRepository).save(Mockito.any(GymMember.class));
    }
    @Test
    void updateOneUser(){
        Mockito.when(userRepository.save(Mockito.any(GymMember.class))).thenReturn(gymMember);
        assertThat(apiService.updateOneUser(gymMember1)).isEqualTo(gymMember);
        Mockito.verify(userRepository).save(Mockito.any(GymMember.class));
    }
    @Test
    void deleteOneUser(){
        Mockito.doNothing().when(userRepository).deleteById(Mockito.anyInt());
        apiService.deleteOneUser(1);
        Mockito.verify(userRepository).deleteById(Mockito.anyInt());
    }


    //Exercises Test
    @Test
    void findAllExercises(){
        Mockito.when(exerciseRepository.findByUserId(Mockito.anyInt())).thenReturn(exerciseList);
        assertThat(apiService.findAllExercises(Mockito.anyInt())).isEqualTo(exerciseList);
        Mockito.verify(exerciseRepository).findByUserId(Mockito.anyInt());
    }
    @Test
    void findExerciseByDate(){
        Mockito.when(exerciseRepository.findByUserIdAndDate(Mockito.anyInt(),Mockito.anyString())).thenReturn(exerciseList);
        assertThat(apiService.findExerciseByDate(Mockito.anyInt(),Mockito.anyString())).isEqualTo(exerciseList);
        Mockito.verify(exerciseRepository).findByUserIdAndDate(Mockito.anyInt(),Mockito.anyString());
    }
    @Test
    void findExerciseByUserIdAndName(){
        Mockito.when(exerciseRepository.findByUserIdAndName(Mockito.anyInt(),Mockito.anyString())).thenReturn(exerciseList);
        assertThat(apiService.findExerciseByUserIdAndName(Mockito.anyInt(),Mockito.anyString())).isEqualTo(exerciseList);
        Mockito.verify(exerciseRepository).findByUserIdAndName(Mockito.anyInt(),Mockito.anyString());
    }
    @Test
    void insertOneExercise(){
        Mockito.when(exerciseRepository.save(Mockito.any(Exercise.class))).thenReturn(exercise);
        assertThat(apiService.insertOneExercise(Mockito.anyInt(),exercise1)).isEqualTo(exercise);
        Mockito.verify(exerciseRepository).save(Mockito.any(Exercise.class));
    }
    @Test
    void updateOneExercise(){
        Mockito.when(exerciseRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.ofNullable(exercise));
        Mockito.when(exerciseRepository.save(Mockito.any(Exercise.class))).thenReturn(exercise);
        assertThat(apiService.updateOneExercise(Mockito.anyInt(),exercise1)).isEqualTo(exercise);
        Mockito.verify(exerciseRepository).save(Mockito.any(Exercise.class));
    }
    @Test
    void deleteOneExercise(){
        Mockito.doNothing().when(exerciseRepository).deleteById(Mockito.anyInt());
        apiService.deleteOneExercise(1);
        Mockito.verify(exerciseRepository).deleteById(Mockito.anyInt());
    }

}
