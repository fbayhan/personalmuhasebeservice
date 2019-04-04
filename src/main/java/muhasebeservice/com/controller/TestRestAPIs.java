package muhasebeservice.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.model.User;
import muhasebeservice.com.repository.UserRepository;

@RestController
public class TestRestAPIs {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}

	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}

	@GetMapping("/api/deneme")
	public List<User> tumUserlar() {
		return userRepository.findAll();

	}

	@GetMapping("/api/everyone/tumkullanicilar")
	public List<User> tumKullanicilar()
	{
		System.out.println("Fatih bayhan");
		return userRepository.tumKullanicilar();
	}
}
