package com.Project.diplom.users.service;


import com.Project.diplom.score.entity.Score;
import com.Project.diplom.score.repository.ScoreRepository;
import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.repository.UserRepository;
import com.Project.diplom.users.repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicelmpl implements UsersService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Object saveUser(User user) {
        List<User> users = userRepository.findAll();
        for(int i=0;i < users.size();i++){
            if(user.getLogin().equals(users.get(i).getLogin()) || user.getLogin()=="" || user.getPassword()==""){
                return false;
            }
        }
        System.out.println(user.getLogin());
        user.setRole("user");
        userRepository.save(user);
        return user;
    }

    @Override
    public Object login(User user) {
        List<User> found = userRepository.findAll();
        for (int i = 0; i < found.size(); i++) {
            if (found.get(i).getLogin().equals(user.getLogin()) && found.get(i).getPassword().equals(user.getPassword())) {
                User new_user = new User();
                new_user.setId(found.get(i).getId());
                new_user.setLogin(found.get(i).getLogin());
                new_user.setRole(found.get(i).getRole());
                new_user.setPassword(found.get(i).getPassword());
                return new_user;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {

        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("Hahahahaha");
        Persone persone = personeRepository.findByUserId(id);
        User us = userRepository.getById(id);

        if(us.getRole().equals("user")  || us.getRole().equals("expert")){
            System.out.println("Hehehehehe");
            try{
                Score score = scoreRepository.findByPersoneId(persone.getId());
                System.out.println(score.getId());
                scoreRepository.delete(score);
            }catch ( Exception e){
                System.out.println("У вас няма оценок");
            }
            finally {
                personeRepository.delete(persone);
                userRepository.deleteById(id);
            }
        }

    }

    @Override
    public Object deleteUserId(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public boolean editRole(User user, Long id) {
        User us = userRepository.getById(id);
        System.out.println("Hihihihihi");
        if(us.getRole().equals("admin")){
            return false;
        }
        if(user.getRole().equals("expert") || user.getRole().equals("user")){
            user.setId(us.getId());
            user.setLogin(us.getLogin());
            user.setPassword(us.getPassword());
            user.setPerson(us.getPerson());
            userRepository.save(user);
            return true;
        }
        return false;
    }


}
