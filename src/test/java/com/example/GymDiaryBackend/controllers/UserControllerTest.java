package com.example.GymDiaryBackend.controllers;

import com.example.GymDiaryBackend.model.GymMember;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ApiService apiService;

    @Test
    void findAllUsers() throws Exception {
        List<GymMember> list = new ArrayList<>();
        list.add(new GymMember());
        Mockito.when(apiService.findAllUsers()).thenReturn(list);
        MvcResult result = mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).findAllUsers();
    }
    @Test
    void findUserByEmail() throws Exception {
        Mockito.when(apiService.findUserByEmail("email")).thenReturn(new GymMember(1,"name1","email1","password1"));
        MvcResult result = mockMvc.perform(get("/users/email").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("name1")))
                .andExpect(jsonPath("$.email", Matchers.is("email1")))
                .andExpect(jsonPath("$.password", Matchers.is("password1")))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).findUserByEmail("email");
    }
    @Test
    void insertOneUser() throws Exception {
        GymMember user = new GymMember(1,"name1","email1","password1");
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"name1\",\n" +
                "  \"email\": \"email1\",\n" +
                "  \"password\": \"password1\"\n" +
                "}";
        Mockito.when(apiService.insertOneUser(Mockito.any(GymMember.class))).thenReturn(user);
        MvcResult result = mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("name1")))
                .andExpect(jsonPath("$.email", Matchers.is("email1")))
                .andExpect(jsonPath("$.password", Matchers.is("password1")))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).insertOneUser(Mockito.any(GymMember.class));
    }
    @Test
    void updateOneUser() throws Exception {
        GymMember user = new GymMember(1,"name1","email1","password1");
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"name1\",\n" +
                "  \"email\": \"email1\",\n" +
                "  \"password\": \"password1\"\n" +
                "}";
        Mockito.when(apiService.updateOneUser(Mockito.any(GymMember.class))).thenReturn(user);
        MvcResult result = mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("name1")))
                .andExpect(jsonPath("$.email", Matchers.is("email1")))
                .andExpect(jsonPath("$.password", Matchers.is("password1")))
                .andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).updateOneUser(Mockito.any(GymMember.class));
    }
    @Test
    void deleteOneUser() throws Exception {
        Mockito.doNothing().when(apiService).deleteOneUser(Mockito.anyInt());
        MvcResult result = mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse());
        Mockito.verify(apiService).deleteOneUser(Mockito.anyInt());
    }
}
