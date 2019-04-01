package muhasebeservice.com.muhasebe.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.muhasebe.service.model.User;
import muhasebeservice.com.muhasebe.service.repository.UserRepository;

@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private InMemoryUserDetailsManager userManager;

	@GetMapping(path = "/", produces = "application/json")
	public String greeting() {
		return "Spring Security In-memory Authentication Example";
	}

	@PostMapping("/saveuser")
	public User insertUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/userdenemesi")
	public User findByUserName()
	{
		System.out.println("Test test");
		return userRepository.findByUserNameHQL("test");
	}

}
