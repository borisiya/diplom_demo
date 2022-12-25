package com.Project.diplom.score.service;

import com.Project.diplom.score.entity.Score;
import com.Project.diplom.result.entity.Result;
import com.Project.diplom.result.repository.ResultReporitory;
import com.Project.diplom.score.repository.ScoreRepository;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.repository.PersoneRepository;
import com.Project.diplom.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServicelmpl implements ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResultReporitory resultRepository;

    @Override
    public boolean saveScoreLeader(Score score, Long userId) {
        Persone pers = personeRepository.findByUserId(userId); //персоне с id
        List<Score> found = scoreRepository.findAll();
        for(int i=0;i<found.size();i++){
            if(found.get(i).getPersone().getId().equals(pers.getId())){
                score.setId(found.get(i).getId());
                score.setMarkstress(found.get(i).getMarkstress());
                score.setMarkcommand(found.get(i).getMarkcommand());
                score.setMarkclient(found.get(i).getMarkclient());
                score.setMarklint1(found.get(i).getMarklint1());
                score.setMarklint2(found.get(i).getMarklint2());
                score.setResult(found.get(i).getResult());
            }
        }
        if(score.getResult() == null){
            Result res = new Result();
            res.setComment("-");
            score.setResult(res);
        }
        int sum = score.getMarkcommand()+score.getMarkclient()+score.getMarkleader()+score.getMarkstress();
        int avgSum = sum/4;
        int avgSkill = (avgSum+score.getMarklint2())/2; //психолог
        int result = Math.round ((avgSkill+score.getMarklint1())/2);
        score.setAverage(result);
        score.setPersone(pers);
        scoreRepository.save(score);
        return true;
    }

    public boolean saveScoreStress(Score score, Long userId) {
        Persone pers = personeRepository.findByUserId(userId); //персоне с id
        List<Score> found = scoreRepository.findAll();
        for(int i=0;i<found.size();i++){
            if(found.get(i).getPersone().getId().equals(pers.getId())){
                score.setId(found.get(i).getId());
                score.setMarkleader(found.get(i).getMarkleader());
                score.setMarkcommand(found.get(i).getMarkcommand());
                score.setMarkclient(found.get(i).getMarkclient());
                score.setMarklint1(found.get(i).getMarklint1());
                score.setMarklint2(found.get(i).getMarklint2());
                score.setResult(found.get(i).getResult());
            }
        }
        if(score.getResult() == null){
            Result res = new Result();
            res.setComment("-");
            score.setResult(res);
        }
        int sum = score.getMarkcommand()+score.getMarkclient()+score.getMarkleader()+score.getMarkstress();
        int avgSum = sum/4;
        int avgSkill = (avgSum+score.getMarklint2())/2; //психолог
        int result = Math.round ((avgSkill+score.getMarklint1())/2);
        score.setAverage(result);
        score.setPersone(pers);
        score.setPersone(pers);
        scoreRepository.save(score);
        return true;
    }

    @Override
    public boolean saveScoreClient(Score score, Long userId) {
        Persone pers = personeRepository.findByUserId(userId); //персоне с id
        List<Score> found = scoreRepository.findAll();
        for(int i=0;i<found.size();i++){
            if(found.get(i).getPersone().getId().equals(pers.getId())){
                score.setId(found.get(i).getId());
                score.setMarkleader(found.get(i).getMarkleader());
                score.setMarkcommand(found.get(i).getMarkcommand());
                score.setMarkstress(found.get(i).getMarkstress());
                score.setMarklint1(found.get(i).getMarklint1());
                score.setMarklint2(found.get(i).getMarklint2());
                score.setResult(found.get(i).getResult());
            }
        }
        if(score.getResult() == null){
            Result res = new Result();
            res.setComment("-");
            score.setResult(res);
        }
        int sum = score.getMarkcommand()+score.getMarkclient()+score.getMarkleader()+score.getMarkstress();
        int avgSum = sum/4;
        int avgSkill = (avgSum+score.getMarklint2())/2; //психолог
        int result = Math.round ((avgSkill+score.getMarklint1())/2);
        score.setAverage(result);
        score.setPersone(pers);
        score.setPersone(pers);
        scoreRepository.save(score);
        return true;
    }

    @Override
    public boolean saveScoreCommand(Score score, Long userId) {
        Persone pers = personeRepository.findByUserId(userId); //персоне с id
        List<Score> found = scoreRepository.findAll();
        for(int i=0;i<found.size();i++){
            if(found.get(i).getPersone().getId().equals(pers.getId())){
                score.setId(found.get(i).getId());
                score.setMarkleader(found.get(i).getMarkleader());
                score.setMarkstress(found.get(i).getMarkstress());
                score.setMarkclient(found.get(i).getMarkclient());
                score.setMarklint1(found.get(i).getMarklint1());
                score.setMarklint2(found.get(i).getMarklint2());
                score.setResult(found.get(i).getResult());
            }
        }
        if(score.getResult() == null){
            Result res = new Result();
            res.setComment("-");
            score.setResult(res);
        }
        int sum = score.getMarkcommand()+score.getMarkclient()+score.getMarkleader()+score.getMarkstress();
        int avgSum = sum/4;
        int avgSkill = (avgSum+score.getMarklint2())/2; //психолог
        int result = Math.round ((avgSkill+score.getMarklint1())/2);
        score.setAverage(result);
        score.setPersone(pers);
        score.setPersone(pers);
        scoreRepository.save(score);
        return true;
    }

    @Override
    public boolean saveScoreInterCom(Score score, Long id) {
        Persone pers = personeRepository.findAllById(id);
        List<Score> found = scoreRepository.findAll();
        Result res = new Result();
        if(score.getMarklint1()<=5||score.getMarklint2()<=5){
            for(int i=0;i<found.size();i++){
                if(found.get(i).getPersone().getId().equals(pers.getId())){
                    score.setId(found.get(i).getId());
                    score.setMarkleader(found.get(i).getMarkleader());
                    score.setMarkstress(found.get(i).getMarkstress());
                    score.setMarkclient(found.get(i).getMarkclient());
                    score.setMarkcommand(found.get(i).getMarkcommand());
                    res.setId(found.get(i).getResult().getId());
                }
            }
            if(score.getResult().getComment() == "" || score.getResult().getComment() == null){
                res.setComment("-");
            }else{
                res.setComment(score.getResult().getComment());
            }
            int sum = score.getMarkcommand()+score.getMarkclient()+score.getMarkleader()+score.getMarkstress();
            int avgSum = sum/4;
            int avgSkill = (avgSum+score.getMarklint2())/2; //психолог
            int result = Math.round ((avgSkill+score.getMarklint1())/2);
            score.setAverage(result);
            score.setPersone(pers);
            score.setPersone(pers);
            score.setResult(res);
            scoreRepository.save(score);
            return true;
        }
        return false;

        // res.setComment(score.getResult().getComment());
        //resultRepository.save(res);
       // score.setResult(res);

    }

    @Override
    public List<Score> getScoreInfoAverage(Score score) {
        System.out.println("AGAGAGAGAGAGAGAGGA");
        try{
            return  scoreRepository.findAllByAverage(score.getAverage());
        }catch (Exception e){
            System.out.println("Ня получилось");
        }
        return null;
    }

    @Override
    public List<Score> getScoreID(Long personeId) {
        return scoreRepository.findAllByPersoneId(personeId);
    }

    @Override
    public List<Score> getAllScore() {
        return scoreRepository.findAll();
    }
}
