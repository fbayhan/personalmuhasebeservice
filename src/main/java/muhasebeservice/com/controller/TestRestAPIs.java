package muhasebeservice.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;
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
	public List<User> tumKullanicilar() {
		System.out.println("Fatih bayhan");
		return userRepository.tumKullanicilar();
	}

	@GetMapping("/api/everyone/randomusers")
	public Optional<User> randomUser() {
		Wage wage = new Wage();
		wage.setSalary(6000);
		wage.setTip("AYLIK");
		wage.setWageDay(7);
		Optional<User> randomUser = userRepository.findById(3L);
		randomUser.ifPresent(user -> {
			user.getWages().add(wage);

		});

		randomUser.ifPresent(user -> {
			System.out.println("Çalışıyor sanırım");
			userRepository.save(user);			
		});
		return userRepository.findById(3L);
	}

}
