package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PeliculaEntity;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long>{
	
	List<PeliculaEntity> findByTituloContaining(String titulo);
    
    List<PeliculaEntity> findByDirector(String director);
    
    List<PeliculaEntity> findByGeneroId(Long generoId);
}
