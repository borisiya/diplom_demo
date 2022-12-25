package com.Project.diplom.users.entity;

import com.Project.diplom.result.entity.Result;
import com.Project.diplom.score.entity.Score;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter

@Table(name = "user")
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Persone person;


    public User(Long id, String login, String password, String role, Persone person) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    public User(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.person = user.getPerson();
    }

    public User() {
    }
}
