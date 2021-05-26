package com.crud.service;

import com.crud.entity.Cat;
import com.crud.entity.User;
import com.crud.repository.CatRepository;
import com.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;

    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    public List<Cat> saveCats(List<Cat> cats) {
        return catRepository.saveAll(cats);
    }

    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    public Cat getCatById(int catid) {
        return catRepository.findById(catid).orElse(null);
    }

    public String deleteCat(int catid) {
    	catRepository.deleteById(catid);
        return "cat removed !! " + catid;
    }

}
