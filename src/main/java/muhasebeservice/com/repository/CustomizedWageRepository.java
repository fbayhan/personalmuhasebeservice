package muhasebeservice.com.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;

@Repository
public class CustomizedWageRepository {
	@PersistenceContext
	EntityManager entityManager;

	public List<Wage> getRandomWage() {

		List<Wage> wageList = new ArrayList<>();
		Query query = entityManager.createQuery("From Wage");
		return query.getResultList();

	}

	public Wage getUsersWageProperties(Long userId) {
		Wage wage = new Wage();
		Query query = entityManager.createQuery("From User where id=:userid").setParameter("userid", userId);
		User user = (User) query.getResultList().get(0);
		System.out.println("Get user çalışıyor");

		System.out.println(user.getName());
		return wage;

	}

}
