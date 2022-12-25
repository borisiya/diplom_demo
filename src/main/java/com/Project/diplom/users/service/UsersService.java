package com.Project.diplom.users.service;


import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;

import java.util.List;

public interface UsersService {
    public Object saveUser(User user);
    public Object login(User user);
    public List<User> getAllUser();
    public void deleteUser(Long id);
    public Object deleteUserId(Long id);
    public boolean editRole(User user, Long id);


    /*
    public User editUser(User user, Long userId, Long personid);
    */
}
