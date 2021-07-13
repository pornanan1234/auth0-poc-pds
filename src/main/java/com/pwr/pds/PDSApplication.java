package com.pwr.pds;

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
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class PDSApplication {

	@Autowired
	private PDSservice pDSservice;

	public static void main(String[] args) {
		SpringApplication.run(PDSApplication.class, args);
	}


	@RestController
	public class RequestCotroller {

		@PreAuthorize("hasAuthority('SCOPE_pwrscope')")
		@GetMapping("/Price")
		public List<PDS> Catalog(Principal principal, @RequestParam String customerGroup) {

			List<PDS> PDSs = pDSservice.getAllPDSs();

			List<PDS> resultPDSs = new ArrayList<PDS>();

			for (PDS  pds : PDSs) {
				if (pds.getCustomergroup().equals(customerGroup)){

					resultPDSs.add(pds);
				}

			}

			return resultPDSs;
		}



	}

}
