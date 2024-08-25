package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GeneroEntity;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	public List<GeneroEntity> listarGeneros() {
		return generoRepository.findAll();
	}

}
