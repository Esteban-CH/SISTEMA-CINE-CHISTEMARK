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

import com.example.demo.entity.FuncionEntity;
import com.example.demo.service.FuncionService;
import com.example.demo.service.HorarioService;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.SalaService;

@Controller
@RequestMapping("/funciones")
public class FuncionController {
	
	@Autowired
    private FuncionService funcionService;
	
	@Autowired
    private HorarioService horarioService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private SalaService salaService;

    @GetMapping
    public String listarFunciones(Model model) {
        List<FuncionEntity> funciones = funcionService.listarFunciones();
        model.addAttribute("funciones", funciones);
        return "funciones/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearFuncion(Model model) {
        model.addAttribute("funcion", new FuncionEntity());
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        model.addAttribute("salas", salaService.listarSalas());
        model.addAttribute("horarios", horarioService.listarHorarios());
        return "funciones/crear";
    }

    @PostMapping("/guardar")
    public String guardarFuncion(@ModelAttribute("funcion") FuncionEntity funcion) {
        funcionService.crearFuncion(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarFuncion(@PathVariable Long id, Model model) {
        FuncionEntity funcion = funcionService.obtenerFuncionPorId(id);
        model.addAttribute("funcion", funcion);
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        model.addAttribute("salas", salaService.listarSalas());
        model.addAttribute("horarios", horarioService.listarHorarios());
        return "funciones/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarFuncion(@PathVariable Long id, @ModelAttribute("funcion") FuncionEntity funcion) {
        funcion.setFuncionId(id);
        funcionService.actualizarFuncion(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFuncion(@PathVariable Long id) {
        funcionService.eliminarFuncion(id);
        return "redirect:/funciones";
    }
}
