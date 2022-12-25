package com.Project.diplom.visit.entity;


import com.Project.diplom.users.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String time;

    @ManyToOne()
    User user;

    public Visit(Visit visit) {
        this.setId(visit.getId());
        this.login = visit.getLogin();
        this.time = visit.getTime();
        this.user = visit.getUser();
    }

    public Visit(String login, String time, User user) {
        this.login = login;
        this.time = time;
        this.user = user;
    }

    public Visit() {

    }
}
