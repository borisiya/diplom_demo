package com.Project.diplom.score.service;

import com.Project.diplom.score.entity.Score;

import java.util.List;


public interface ScoreService {

    public List<Score> getAllScore();
    public boolean saveScoreLeader(Score score, Long userId);
    public boolean saveScoreStress(Score score, Long userId);
    public boolean saveScoreClient(Score score, Long userId);
    public boolean saveScoreCommand(Score score, Long userId);

    public boolean saveScoreInterCom(Score score, Long id);
    public List<Score> getScoreInfoAverage(Score score);

    public List<Score> getScoreID(Long personeId);
}
