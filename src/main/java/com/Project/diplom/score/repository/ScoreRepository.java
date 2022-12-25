package com.Project.diplom.score.repository;

import com.Project.diplom.result.entity.Result;
import com.Project.diplom.score.entity.Score;
import com.Project.diplom.users.entity.Persone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {

    List<Score> findAllByAverage(int Average);
    List<Score> findAllByPersone(Persone persone);
    List<Score> findAllByPersoneId(Long personeId);
    Score findByPersoneId(Long PersoneId);
}
