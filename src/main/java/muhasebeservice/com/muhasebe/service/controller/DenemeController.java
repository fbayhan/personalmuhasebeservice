package muhasebeservice.com.muhasebe.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import muhasebeservice.com.muhasebe.service.model.Deneme;
import muhasebeservice.com.muhasebe.service.repository.DenemeRepository;

@RestController
@RequestMapping("/service")
public class DenemeController {

	@Autowired
	DenemeRepository denemeRepository;

	@GetMapping("/denemes")
	public List<Deneme> getAllDenemes() {
		return denemeRepository.findAll();
	}

	@PostMapping("/notes")
	public Deneme createDeneme(@Valid @RequestBody Deneme deneme) {
		return denemeRepository.save(deneme);
	}
} 
