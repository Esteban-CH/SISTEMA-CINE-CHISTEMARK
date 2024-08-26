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

import com.example.demo.entity.AsientoEntity;
import com.example.demo.service.AsientoService;

@Controller
@RequestMapping("/asientos")
public class AsientoController {
	
	@Autowired
    private AsientoService asientoService;

    @GetMapping
    public String listarAsientos(Model model) {
        List<AsientoEntity> asientos = asientoService.listarAsientos();
        model.addAttribute("asientos", asientos);
        return "asientos/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearAsiento(Model model) {
        model.addAttribute("asiento", new AsientoEntity());
        return "asientos/crear";
    }

    @PostMapping("/guardar")
    public String guardarAsiento(@ModelAttribute("asiento") AsientoEntity asiento) {
        asientoService.crearAsiento(asiento);
        return "redirect:/asientos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarAsiento(@PathVariable Long id, Model model) {
        AsientoEntity asiento = asientoService.obtenerAsientoPorId(id);
        model.addAttribute("asiento", asiento);
        return "asientos/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarAsiento(@PathVariable Long id, @ModelAttribute("asiento") AsientoEntity asiento) {
        asiento.setAsientoId(id);
        asientoService.actualizarAsiento(asiento);
        return "redirect:/asientos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsiento(@PathVariable Long id) {
        asientoService.eliminarAsiento(id);
        return "redirect:/asientos";
    }
}
