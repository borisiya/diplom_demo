package com.Project.diplom.experience.entity;


import com.Project.diplom.result.entity.Result;
import com.Project.diplom.score.entity.Score;
import com.Project.diplom.users.entity.Persone;
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
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldWork;

    private  int exp;

    public Experience(Long id, String oldWork, int exp) {
        this.id = id;
        this.oldWork = oldWork;
        this.exp = exp;
    }

    @OneToOne(mappedBy = "experience")
    @JsonBackReference
    private Persone persone;

    public Experience() {

    }
}
