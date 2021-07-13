package com.pwr.pds.Controller;


import javax.validation.Valid;
import  com.pwr.pds.services.PDSservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pwr.pds.Model.PDS;
import com.pwr.pds.Model.PDSrepository;

@Controller
public class PDSPageController {

    private final PDSrepository pdsRepository;

    @Autowired
    private PDSservice pdsservice;

    @Autowired
    public PDSPageController( PDSrepository pdsRepository) {
        this.pdsRepository = pdsRepository;
    }


    @GetMapping("/")
    public String login() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showPDSList(Model model) {
        model.addAttribute("pdss",   pdsservice.getAllPDSs());
        return "index";
    }

    @GetMapping("/signup")
    public String showPDSForm(PDS pds) {
        return "add-pds";
    }

    @PostMapping("/addpds")
    public String addPds(@Valid PDS pds, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-pds";
        }

        pdsRepository.save(pds);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        PDS pds = pdsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid PDS Id:" + id));
        model.addAttribute("pds", pds);

        return "update-pds";
    }

    @PostMapping("/update/{id}")
    public String updatePDS(@PathVariable("id") int id, @Valid PDS pds, BindingResult result, Model model) {
        if (result.hasErrors()) {
            pds.setId(id);
            return "update-pds";
        }

        pdsRepository.save(pds);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deletePDS(@PathVariable("id") int id, Model model) {
        PDS pds = pdsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pds Id:" + id));
        pdsRepository.delete(pds);

        return "redirect:/index";
    }
}