package com.Project.diplom.visit.service;

import com.Project.diplom.users.repository.UserRepository;
import com.Project.diplom.visit.entity.Visit;

import com.Project.diplom.visit.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServicelmpl implements VisitService{
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveVisit(Visit visit, Long userId) {
        visit.setUser(userRepository.getById(userId));

        visitRepository.save(visit);
        return true;
    }

    @Override
    public List<Visit> getAllVisit(int offset, int limit) {
        List<Visit> result = new ArrayList<>();
        Page<Visit> res = visitRepository.findAll(PageRequest.of(offset, limit));
        result.addAll(res.getContent());
        return result;
    }

    @Override
    public int getVisitsCount() {
        return (int) visitRepository.count();
    }
}
