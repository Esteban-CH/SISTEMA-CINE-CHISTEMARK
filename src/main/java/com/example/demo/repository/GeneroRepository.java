package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GeneroEntity;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long>{

}
