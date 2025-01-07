package com.example.proje.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.proje.Entity.Arac;
import com.example.proje.Repoistory.AracRepository;

@Controller
public class AracController {

    @Autowired
    private AracRepository aracRepository;

    @GetMapping("/")
    public String listAraclar(Model model) {
        model.addAttribute("araclar", aracRepository.findAll());
        return "index";
    }

    @GetMapping("/arac/new")
    public String showForm(Model model) {
        model.addAttribute("arac", new Arac());
        return "form";
    }

    @PostMapping("/arac/save")
    public String saveArac(@ModelAttribute Arac arac) {
        aracRepository.save(arac);
        return "redirect:/";
    }

    @GetMapping("/arac/edit/{id}")
    public String editArac(@PathVariable("id") Long id, Model model) {
        model.addAttribute("arac", aracRepository.findById(id).orElse(null));
        return "form";
    }

    @GetMapping("/arac/delete/{id}")
    public String deleteArac(@PathVariable("id") Long id) {
        aracRepository.deleteById(id);
        return "redirect:/";
    }
}

