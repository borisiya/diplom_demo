package com.Project.diplom.experience.repository;

import com.Project.diplom.experience.entity.Experience;
import com.Project.diplom.users.entity.Persone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long>{
}
