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

import com.example.demo.entity.PagoEntity;
import com.example.demo.service.PagoService;

@Controller
@RequestMapping("/pagos")
public class PagoController {
	
	@Autowired
    private PagoService pagoService;

    @GetMapping
    public String listarPagos(Model model) {
        List<PagoEntity> pagos = pagoService.listarPagos();
        model.addAttribute("pagos", pagos);
        return "pagos/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearPago(Model model) {
        model.addAttribute("pago", new PagoEntity());
        return "pagos/crear";
    }

    @PostMapping("/guardar")
    public String guardarPago(@ModelAttribute("pago") PagoEntity pago) {
        pagoService.crearPago(pago);
        return "redirect:/pagos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPago(@PathVariable Long id, Model model) {
        PagoEntity pago = pagoService.obtenerPagoPorId(id);
        model.addAttribute("pago", pago);
        return "pagos/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPago(@PathVariable Long id, @ModelAttribute("pago") PagoEntity pago) {
        pago.setPagoId(id);
        pagoService.actualizarPago(pago);
        return "redirect:/pagos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return "redirect:/pagos";
    }
}
