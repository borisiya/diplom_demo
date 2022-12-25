package com.Project.diplom;

import static org.assertj.core.api.Assertions.assertThat;


import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.repository.PersoneRepository;
import com.Project.diplom.users.repository.UserRepository;
import com.Project.diplom.users.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestOperation {
    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersService service;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testsaveUser() {
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        user.setRole("user");
        Assertions.assertNotNull(service.saveUser(user));
    }

    @Test
    public void testdeleteRole() {
        User user = userRepository.findByLogin("test");
        Assertions.assertNull(service.deleteUserId(user.getId()));
    }

    @Test
    public void testfindAllWhenUserExists() {
        List<User> users = service.getAllUser();
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    public void testfindAllWhenUserNotExists() {
        List<User> users = service.getAllUser();
        Assertions.assertTrue(users.isEmpty());
    }

}
