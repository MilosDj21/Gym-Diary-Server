package com.example.GymDiaryBackend.controllers;

import com.example.GymDiaryBackend.model.Exercise;
import com.example.GymDiaryBackend.Service.ApiService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ExerciseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ApiService apiService;

    @Test
    void findAllExercises() throws Exception {
        List<Exercise> list = new ArrayList<>();
        list.add(new Exercise());
        Mockito.when(apiService.findAllExercises(anyInt())).thenReturn(list);
        MvcResult result = mockMvc.perform(get("/users/1/exercises").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).findAllExercises(anyInt());
    }
    @Test
    void findExerciseByUserIdAndDate() throws Exception {
        List<Exercise> list = new ArrayList<>();
        list.add(new Exercise());
        Mockito.when(apiService.findExerciseByDate(anyInt(), anyString())).thenReturn(list);
        MvcResult result = mockMvc.perform(get("/users/1/exercises/date/date").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).findExerciseByDate(anyInt(), anyString());
    }
    @Test
    void findExerciseByUserIdAndName() throws Exception {
        List<Exercise> list = new ArrayList<>();
        list.add(new Exercise());
        Mockito.when(apiService.findExerciseByUserIdAndName(anyInt(),anyString())).thenReturn(list);
        MvcResult result = mockMvc.perform(get("/users/1/exercises/exerciseName").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).findExerciseByUserIdAndName(anyInt(), anyString());
    }
    @Test
    void insertOneExercise() throws Exception {
        Exercise exercise = new Exercise(1,"name",2,2.2,"date",3);
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"name1\",\n" +
                "  \"reps\": 2,\n" +
                "  \"weight\": 2.2,\n" +
                "  \"date\": \"date\",\n" +
                "  \"userId\": 3\n" +
                "}";
        Mockito.when(apiService.insertOneExercise(anyInt(),Mockito.any(Exercise.class))).thenReturn(exercise);
        MvcResult result = mockMvc.perform(post("/users/1/exercises").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("name")))
                .andExpect(jsonPath("$.reps", Matchers.is(2)))
                .andExpect(jsonPath("$.weight", Matchers.is(2.2)))
                .andExpect(jsonPath("$.date", Matchers.is("date")))
                .andExpect(jsonPath("$.userId", Matchers.is(3)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).insertOneExercise(anyInt(),Mockito.any(Exercise.class));
    }
    @Test
    void updateOneExercise() throws Exception {
        Exercise exercise = new Exercise(1,"name",2,2.2,"date",3);
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"name1\",\n" +
                "  \"reps\": 2,\n" +
                "  \"weight\": 2.2,\n" +
                "  \"date\": \"date\",\n" +
                "  \"userId\": 3\n" +
                "}";
        Mockito.when(apiService.updateOneExercise(anyInt(),Mockito.any(Exercise.class))).thenReturn(exercise);
        MvcResult result = mockMvc.perform(put("/users/1/exercises").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("name")))
                .andExpect(jsonPath("$.reps", Matchers.is(2)))
                .andExpect(jsonPath("$.weight", Matchers.is(2.2)))
                .andExpect(jsonPath("$.date", Matchers.is("date")))
                .andExpect(jsonPath("$.userId", Matchers.is(3)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).updateOneExercise(anyInt(),Mockito.any(Exercise.class));
    }
    @Test
    void deleteOneExercise() throws Exception {
        Mockito.doNothing().when(apiService).deleteOneExercise(anyInt());
        MvcResult result = mockMvc.perform(delete("/users/exercises/1"))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).deleteOneExercise(anyInt());
    }
}
