package com.Project.diplom.users.entity;


import com.Project.diplom.experience.entity.Experience;
import com.Project.diplom.result.entity.Result;
import com.Project.diplom.score.entity.Score;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "persone")
public class Persone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String secondName;
    private String firstName;
    private String fatherName;
    private String phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonManagedReference
    private User user;

    @OneToOne(mappedBy = "persone")
    @JsonBackReference
    private Score score;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expId", referencedColumnName = "id")
    @JsonManagedReference
    private Experience experience;

    public Persone(Long id, String email, String secondName, String firstName, String fatherName, String phone) {
        this.id = id;
        this.email = email;
        this.secondName = secondName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.phone = phone;

    }



    public Persone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }




}
