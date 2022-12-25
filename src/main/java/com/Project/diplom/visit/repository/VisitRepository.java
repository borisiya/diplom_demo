package com.Project.diplom.visit.repository;
import com.Project.diplom.visit.entity.Visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>{

}
