package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.SalaEntity;
import com.example.demo.service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping
    public String listarSalas(Model model) {
        List<SalaEntity> salas = salaService.listarSalas();
        model.addAttribute("salas", salas);
        return "salas/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearSala(Model model) {
        model.addAttribute("sala", new SalaEntity());
        return "salas/crear";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute("sala") SalaEntity sala) {
        salaService.crearSala(sala);
        return "redirect:/salas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarSala(@PathVariable Long id, Model model) {
        SalaEntity sala = salaService.obtenerSalaPorId(id).get();
        model.addAttribute("sala", sala);
        return "salas/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarSala(@PathVariable Long id, @ModelAttribute("sala") SalaEntity sala) {
        sala.setSalaId(id);
        salaService.actualizarSala(sala);
        return "redirect:/salas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSala(@PathVariable Long id) {
        salaService.eliminarSala(id);
        return "redirect:/salas";
    }
}
