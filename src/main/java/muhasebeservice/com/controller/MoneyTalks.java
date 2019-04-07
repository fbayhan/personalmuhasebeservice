package muhasebeservice.com.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import muhasebeservice.com.dto.UserPropertiesDTO;
import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;
import muhasebeservice.com.repository.UserRepository;
import muhasebeservice.com.repository.WageRepository;

@Service
@Transactional
public class MoneyTalks {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	WageRepository wageRepository;

	@Autowired
	UserRepository userRepository;

	public UserPropertiesDTO calculateUserDetails(Long userId) {

		UserPropertiesDTO userPropertiesDTO = new UserPropertiesDTO();
		Optional<User> user = userRepository.findById(userId);

		user.ifPresent(currentUser -> {
			userPropertiesDTO.setUserId(userId);
			userPropertiesDTO.setUserName(currentUser.getUsername());

		});

		int isRecordExist = entityManager
				.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
				.setParameter("userid", userId).getResultList().size();
		if (isRecordExist > 0) {
			System.out.println("Var");
			Query wageQuery = entityManager
					.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
					.setParameter("userid", userId).setMaxResults(1);

			Wage wage = (Wage) wageQuery.getResultList().get(0);
			userPropertiesDTO.setNextWageDay(wage.getWageDay());
			userPropertiesDTO.setWage(wage.getSalary());

		}

		System.out.println("user properties dto çalışıyor, veeee ");
		System.out.println(userPropertiesDTO.toString());
		return userPropertiesDTO;
	}
}
