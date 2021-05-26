package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Cat;
import com.crud.entity.User;

public interface CatRepository extends JpaRepository<Cat,Integer> {
}

