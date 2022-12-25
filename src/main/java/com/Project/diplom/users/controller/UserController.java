package com.Project.diplom.users.controller;

import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UsersService usersService;



    @PostMapping("/addUser")
    public Object add(@RequestBody User user){
        return usersService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return usersService.getAllUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        System.out.println("Hohohohoho");
        usersService.deleteUser(id);
        return "User deleted";
    }
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        return usersService.login(user);
    }

    @PostMapping("/editRole/{id}")
    public boolean editRole(@RequestBody User user,@PathVariable Long id){
        System.out.println("Hohohohoho");
        return usersService.editRole(user,id);
    }

}
