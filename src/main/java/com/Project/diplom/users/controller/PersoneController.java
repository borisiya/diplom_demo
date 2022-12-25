package com.Project.diplom.users.controller;

import com.Project.diplom.score.entity.Score;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persone")
public class PersoneController {
    @Autowired
    private PersoneService personeService;

    @PostMapping("/addPersone/{userId}")
    public boolean addPersone(@RequestBody Persone persone,@PathVariable Long userId) {
        return personeService.savePersone(persone, userId);
    }

    @GetMapping("/getAll")
    public List<Persone> getAllPersones(){
        return personeService.getAllPersone();
    }

    @GetMapping("/getPersone/{userId}")
    public List<Persone> getPersone(@PathVariable Long userId) {
        return personeService.getPersoneId(userId);
    }

    @PostMapping("/editPersone/{id}")
    public Persone edinInfo(@RequestBody Persone persone,@PathVariable Long id){
        System.out.println("SASASASA");
        return personeService.editInfo(id, persone);
    }


}