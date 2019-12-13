package com.example.GymDiaryBackend.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class GymMember {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String name;
    @Email
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;

    public GymMember() {
    }

    public GymMember(Integer id, @NotNull String name, @Email @NotNull String email, @NotNull String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
