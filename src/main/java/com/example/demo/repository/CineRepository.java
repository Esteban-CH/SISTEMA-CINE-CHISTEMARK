package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CineEntity;

@Repository
public interface CineRepository extends JpaRepository<CineEntity, Long>{

}
