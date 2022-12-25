package com.Project.diplom.visit.controller;

import com.Project.diplom.visit.service.VisitService;
import com.Project.diplom.visit.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping("/add/{userId}")
    public boolean add(@RequestBody Visit visit, @PathVariable Long userId){
        System.out.println("111153233");
        return visitService.saveVisit(visit, userId);
    }


    @GetMapping("/count")
    public int getVisitsCount() {
        return visitService.getVisitsCount();
    }

    @GetMapping("/getAll")
    public List<Visit> getAll(@RequestParam int offset, @RequestParam int limit){
        return visitService.getAllVisit(offset, limit);
    }

}
