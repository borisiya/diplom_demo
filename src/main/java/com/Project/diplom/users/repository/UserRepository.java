package com.Project.diplom.users.repository;

import com.Project.diplom.result.entity.Result;
import com.Project.diplom.users.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User deleteByLogin(String login);
    User getById(Long id);
    User findByLogin(String login);
}
