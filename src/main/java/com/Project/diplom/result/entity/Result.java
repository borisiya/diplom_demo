package com.Project.diplom.result.entity;

import com.Project.diplom.score.entity.Score;
import com.Project.diplom.users.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Table(name = "result")
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;


    @OneToOne(mappedBy="result")
    @JsonBackReference(value="score-res")
    private Score scores;


    public Result() {
    }

    public Result(Long id, String comment, User user) {
        this.id = id;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String status) {
        this.comment = status;
    }


}
