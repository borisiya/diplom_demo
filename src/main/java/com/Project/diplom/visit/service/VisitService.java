package com.Project.diplom.visit.service;

import com.Project.diplom.visit.entity.Visit;

import java.util.List;


public interface VisitService {
    public boolean saveVisit(Visit visit, Long userId);
    public List<Visit> getAllVisit(int offset, int limit);
    public int getVisitsCount();
}
