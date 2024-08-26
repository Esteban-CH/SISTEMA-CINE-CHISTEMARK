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

import com.example.demo.entity.BoletoEntity;
import com.example.demo.service.BoletoService;

@Controller
@RequestMapping("/boletos")
public class BoletoController {
	
	@Autowired
    private BoletoService boletoService;

    @GetMapping
    public String listarBoletos(Model model) {
        List<BoletoEntity> boletos = boletoService.listarBoletos();
        model.addAttribute("boletos", boletos);
        return "boletos/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearBoleto(Model model) {
        model.addAttribute("boleto", new BoletoEntity());
        return "boletos/crear";
    }

    @PostMapping("/guardar")
    public String guardarBoleto(@ModelAttribute("boleto") BoletoEntity boleto) {
        boletoService.crearBoleto(boleto);
        return "redirect:/boletos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarBoleto(@PathVariable Long id, Model model) {
        BoletoEntity boleto = boletoService.obtenerBoletoPorId(id);
        model.addAttribute("boleto", boleto);
        return "boletos/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarBoleto(@PathVariable Long id, @ModelAttribute("boleto") BoletoEntity boleto) {
        boleto.setBoletoId(id);
        boletoService.actualizarBoleto(boleto);
        return "redirect:/boletos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarBoleto(@PathVariable Long id) {
        boletoService.eliminarBoleto(id);
        return "redirect:/boletos";
    }
}
