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

import muhasebeservice.com.dto.LoggedUserThings;
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
	public ResponseEntity<String> addWageDay(@Valid @RequestBody LoggedUserThings loggedUserThings) {
		System.out.println("Add Wage Day Çalışıyor " + loggedUserThings.toString());

		Optional<User> user = userRepository.findById(loggedUserThings.getId());
		user.ifPresent(currentUser -> {
			Wage usersWageProperties;
		});

		return ResponseEntity.ok().body("Wage has been added!");
	}

}
