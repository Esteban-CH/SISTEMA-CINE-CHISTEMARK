package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AsientoEntity;

@Repository
public interface AsientoRepository extends JpaRepository<AsientoEntity, Long>{

}
