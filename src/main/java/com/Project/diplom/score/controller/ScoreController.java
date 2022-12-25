package com.Project.diplom.score.controller;

import com.Project.diplom.score.entity.Score;
import com.Project.diplom.score.service.ScoreService;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
@CrossOrigin("http://localhost:3000")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private PersoneService personeService;

    @PostMapping("/addScore/{id}")
    public boolean saveScore(@RequestBody Score score,@PathVariable Long id) {
        System.out.println(id);
        return scoreService.saveScoreLeader(score,id);

    }

    @PostMapping("/addScoreS/{id}")
    public boolean saveScoreS(@RequestBody Score score,@PathVariable Long id) {
        System.out.println(id);
        return scoreService.saveScoreStress(score,id);

    }

    @PostMapping("/addScoreC/{id}")
    public boolean saveScoreC(@RequestBody Score score,@PathVariable Long id) {
        System.out.println(id);
        return scoreService.saveScoreCommand(score,id);

    }

    @PostMapping("/addScoreCl/{id}")
    public boolean saveScoreCl(@RequestBody Score score,@PathVariable Long id) {
        System.out.println(id);
        return scoreService.saveScoreClient(score,id);

    }

    @PostMapping("/addInterCom/{id}")
    public boolean addInterCom(@RequestBody Score score,@PathVariable Long id) {
        System.out.println(id);
        return scoreService.saveScoreInterCom(score,id);

    }

    @PostMapping("/getScoreInfoAverage")
    public List<Score> getScoreInfoAverage(@RequestBody Score score) {
        System.out.println("OHOHOHOHOHOHOHO");
        return scoreService.getScoreInfoAverage(score);

    }

    @GetMapping("/getAll")
    public List<Score> getAllScores(){
        return scoreService.getAllScore();
    }

    @GetMapping("/getScoreInfoAnaliz/{personeId}")
    public List<Score> getInfoAnaliz(@PathVariable Long personeId) {
        return scoreService.getScoreID(personeId);
    }


}
