package muhasebeservice.com.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.dto.LoggedUserThingsDTO;
import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;
import muhasebeservice.com.repository.CustomizedWageRepository;
import muhasebeservice.com.repository.UserRepository;
import muhasebeservice.com.repository.WageRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/everyone")
public class PostRestAPI {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WageRepository wageRespository;

	@Autowired
	CustomizedWageRepository customizedWageRepository;

	@PostMapping("/addWageDay")
	public ResponseEntity<String> addWageDay(@Valid @RequestBody LoggedUserThingsDTO loggedUserThings) {
		System.out.println("Add Wage Day Çalışıyor " + loggedUserThings.toString());
		Wage wage = customizedWageRepository.updateUserWageDay(loggedUserThings.getId(),
				loggedUserThings.getDayOfWage());

		System.out.println(wage.toString());

		return ResponseEntity.ok().body("Wage has been added!");
	}

	@PostMapping("/addsalary")
	public ResponseEntity<String> addSalary(@Valid @RequestBody LoggedUserThingsDTO loggedUserThings) {
		System.out.println("Add Wage Day Çalışıyor " + loggedUserThings.toString());
		Wage wage = customizedWageRepository.updateUserSalary(loggedUserThings.getId(), loggedUserThings.getSalary());

		System.out.println(wage.toString());

		return ResponseEntity.ok().body("Wage has been added!");
	}

}
