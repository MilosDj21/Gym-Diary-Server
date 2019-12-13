package com.example.GymDiaryBackend.controllers;

import com.example.GymDiaryBackend.Service.ApiService;
import com.example.GymDiaryBackend.model.GymMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private ApiService service;

    @GetMapping("/users")
    public List<GymMember> findAll(){
        return service.findAllUsers();
    }
    @GetMapping("/users/{email}")
    public GymMember findByEmail(@PathVariable String email){
        return service.findUserByEmail(email);
    }
    @PostMapping("/users")
    public GymMember insertOne(@RequestBody GymMember user){
        return service.insertOneUser(user);
    }
    @PutMapping("/users")
    public GymMember updateOne(@RequestBody GymMember user){
        return service.updateOneUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable int id){
        service.deleteOneUser(id);
    }
}
