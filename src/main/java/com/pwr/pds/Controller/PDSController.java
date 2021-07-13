package com.pwr.pds.Controller;

import com.pwr.pds.Model.PDS;
import com.pwr.pds.services.PDSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PDSController {

    @Autowired
    PDSservice pdsService;

    @GetMapping("/pds")
    private List getAllMovies() {
        return pdsService.getAllPDSs();
    }

    @GetMapping("/pdss/{id}")
    private PDS getPds(@PathVariable("id") int id) {
        return pdsService.getPDSById(id);
    }

    @DeleteMapping("/pdss/{id}")
    private void deletePDS(@PathVariable("id") int id) {
        pdsService.delete(id);
    }

    @PostMapping("/pdss")
    private int saveCpc (@RequestBody PDS pds) {
        pdsService.saveOrUpdate(pds);
        return pds.getId();
    }
}

