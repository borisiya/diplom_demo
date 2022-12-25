package com.Project.diplom.users.service;

import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;

import java.util.List;

public interface PersoneService {
    public boolean savePersone(Persone persone, Long userId);
    public List<Persone> getAllPersone();

    public List<Persone> getPersoneId(Long userId);

    Persone editInfo(Long id, Persone persone);
}
