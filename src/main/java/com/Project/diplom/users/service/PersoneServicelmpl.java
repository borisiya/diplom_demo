package com.Project.diplom.users.service;


import com.Project.diplom.experience.entity.Experience;
import com.Project.diplom.users.entity.Persone;
import com.Project.diplom.users.entity.User;
import com.Project.diplom.users.repository.PersoneRepository;
import com.Project.diplom.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoneServicelmpl implements PersoneService{

    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean savePersone(Persone persone, Long userId) {
        List<Persone> persones = personeRepository.findAll();
        System.out.println("2132");
        List<User> users = userRepository.findAll();
        System.out.println(persone.getExperience().getOldWork());
        Experience experience = new Experience();
        experience.setExp(persone.getExperience().getExp());
        experience.setOldWork(persone.getExperience().getOldWork());
        if(experience.getExp() == 0 || experience.getExp()<0){
            experience.setExp(0);
            experience.setOldWork("-");
            persone.setExperience(experience);
        }
        persone.setExperience(experience);
        for(int i=0;i < users.size();i++){
            if(users.get(i).getId().equals(userId)){
                System.out.println("Соупало");
                persone.setUser(users.get(i));
                for(int j=0;j < persones.size();j++){
                    if(persone.getEmail().equals(persones.get(j).getEmail()) || persone.getEmail()=="" ){
                        persone.setEmail("-");
                    }
                    if(persone.getPhone().equals(persones.get(j).getPhone()) || persone.getPhone()==""){
                        persone.setPhone("-");
                    }
                }

                personeRepository.save(persone);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Persone> getAllPersone() {
        return personeRepository.findAll();
    }

    @Override
    public List<Persone> getPersoneId(Long userId) {
        return  personeRepository.findAllByUserId(userId);
    }

    @Override
    public Persone editInfo(Long id, Persone persone) {
        System.out.println("kUKUKUKUKU");
        List<Persone> persones = personeRepository.findAll();
        Persone pers = personeRepository.findByUserId(id);
        System.out.println(persone.getExperience().getOldWork());

        for(int j=0;j < persones.size();j++){
            if(persone.getEmail().equals(persones.get(j).getEmail()) || persone.getEmail().equals("") ){
                persone.setEmail("-");
            }
            if(persone.getPhone().equals(persones.get(j).getPhone()) || persone.getPhone().equals("")){
                persone.setPhone("-");
            }
        }
        persone.setExperience(pers.getExperience());
        persone.setId(pers.getId());
        persone.setUser(pers.getUser());

        return personeRepository.save(persone);
    }
}
