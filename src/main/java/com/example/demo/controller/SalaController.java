package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/listar")
    public String listarSalas(Model model) {
        model.addAttribute("salas", salaService.listarSalas());
        return "salas/listar";
	}
}
