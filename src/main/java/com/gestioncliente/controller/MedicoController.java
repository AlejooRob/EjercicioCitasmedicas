package com.gestioncliente.controller;

import com.gestioncliente.models.entities.Medico;
import com.gestioncliente.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public String home() {
        return "redirect:/medicos";
    }

    @GetMapping("/medicos")
    public String listarMedicos(Model model) {
        List<Medico> listarMedicos = medicoRepository.findAll();
        model.addAttribute("medico", listarMedicos);
        return "medicos";
    }

    @GetMapping("medico/nuevo")
    public String agregarMedico(Model model) {
        Medico medico = new Medico();
        model.addAttribute("medico", medico);
        model.addAttribute("pageTitle", "Ingresar Médico");
        return "medico_form";
    }

    @PostMapping("/medico/guardar")
    public String guardarMedico(@Valid @ModelAttribute Medico medico, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return "medico_form";
        }
        medicoRepository.save(medico);
        redirectAttributes.addFlashAttribute("message", "El Médico ha sido guardado con éxito");
        return "redirect:/medicos";
    }
}
