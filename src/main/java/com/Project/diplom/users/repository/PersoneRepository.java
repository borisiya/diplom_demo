package com.Project.diplom.users.repository;

import com.Project.diplom.result.entity.Result;
import com.Project.diplom.users.entity.Persone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersoneRepository extends JpaRepository<Persone,Long>{
    Persone findByUserId(Long userId);
    
    List<Persone> findAllByUserId(Long userId);

    Persone findAllById(Long id);
}
