package com.Project.diplom.result.repository;

import com.Project.diplom.result.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultReporitory extends JpaRepository<Result,Long>{
}
