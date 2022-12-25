package com.Project.diplom.score.entity;

import com.Project.diplom.result.entity.Result;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter

@Table(name = "score")
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personeId", referencedColumnName = "id")
    @JsonManagedReference
    private Persone persone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resultId", referencedColumnName = "id")
    @JsonManagedReference(value="score-res")
    private Result result;

    private int markleader;
    private int markclient;
    private int markcommand;
    private int markstress;
    private int marklint1;
    private int marklint2;

    private int average;

    public Score() {
    }

    public Score(Long id, Persone persone, Result result, int markleader, int markclient, int markcommand, int markstress, int marklint1, int marklint2, int average) {
        this.id = id;
        this.persone = persone;
        this.result = result;
        this.markleader = markleader;
        this.markclient = markclient;
        this.markcommand = markcommand;
        this.markstress = markstress;
        this.marklint1 = marklint1;
        this.marklint2 = marklint2;
        this.average = average;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
