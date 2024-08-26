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

import com.example.demo.entity.HorarioEntity;
import com.example.demo.service.HorarioService;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

	@Autowired
    private HorarioService horarioService;

    @GetMapping
    public String listarHorarios(Model model) {
        List<HorarioEntity> horarios = horarioService.listarHorarios();
        model.addAttribute("horarios", horarios);
        return "horarios/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearHorario(Model model) {
        model.addAttribute("horario", new HorarioEntity());
        return "horarios/crear";
    }

    @PostMapping("/guardar")
    public String guardarHorario(@ModelAttribute("horario") HorarioEntity horario) {
        horarioService.crearHorario(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarHorario(@PathVariable Long id, Model model) {
        HorarioEntity horario = horarioService.obtenerHorarioPorId(id);
        model.addAttribute("horario", horario);
        return "horarios/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarHorario(@PathVariable Long id, @ModelAttribute("horario") HorarioEntity horario) {
        horario.setHorarioId(id);
        horarioService.actualizarHorario(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHorario(@PathVariable Long id) {
        horarioService.eliminarHorario(id);
        return "redirect:/horarios";
    }
}
