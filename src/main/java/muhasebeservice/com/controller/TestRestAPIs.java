package muhasebeservice.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import muhasebeservice.com.calculator.Calculator;
import muhasebeservice.com.dto.UserPropertiesDTO;
import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;
import muhasebeservice.com.repository.CustomizedWageRepository;
import muhasebeservice.com.repository.UserRepository;
import muhasebeservice.com.repository.WageRepository;

@RestController
public class TestRestAPIs {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CustomizedWageRepository customizedWageRepository;

	@Autowired
	WageRepository wageRepository;

	MoneyTalks moneyTalks = new MoneyTalks();

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
			// user.getWages();
		});

		randomUser.ifPresent(user -> {
			System.out.println("Çalışıyor sanırım");
			userRepository.save(user);
		});
		return userRepository.findById(3L);
	}

	@GetMapping("/api/everyone/wages")
	public List<Wage> wages() {
		Long userId = 4L;
		UserPropertiesDTO userPropertiesDTO = customizedWageRepository.calculateUserDetails(userId);
		Optional<User> user = userRepository.findById(userId);

		user.ifPresent(currentUser -> {

		});

		System.out.println("bakalım ne gelecek" + userPropertiesDTO.toString());

		Calculator calculator = new Calculator();
		int daysToWage = calculator.daysToWage(userPropertiesDTO.getNextWageDay());
		System.out.println("Days to wage çıktısı :" + daysToWage);
		userPropertiesDTO.setDayToWage(daysToWage);

		int moneyPerDay = userPropertiesDTO.getWage() / userPropertiesDTO.getDayToWage();
		userPropertiesDTO.setMoneyPerDay(moneyPerDay);
		System.out.println(userPropertiesDTO.toString());
		return customizedWageRepository.getRandomWage();
	}

}
