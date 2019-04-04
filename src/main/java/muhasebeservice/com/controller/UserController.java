package muhasebeservice.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.model.User;
import muhasebeservice.com.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	UserRepository userRepository;

 

	@GetMapping(path = "/", produces = "application/json")
	public String greeting() {
		return "Spring Security In-memory Authentication Example";
	}

	@PostMapping("/saveuser")
	public User insertUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

}
