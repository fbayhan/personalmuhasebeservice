package muhasebeservice.com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import muhasebeservice.com.model.User;
import muhasebeservice.com.model.Wage;

@Repository
public class CustomizedWageRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	WageRepository wageRepository;

	@Autowired
	UserRepository userRepository;

	public List<Wage> getRandomWage() {

		List<Wage> wageList = new ArrayList<>();
		Query query = entityManager.createQuery("From Wage");
		return query.getResultList();

	}

	public Wage updateUserWageDay(Long userId, int day) {

		int isRecordExist = entityManager
				.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
				.setParameter("userid", userId).getResultList().size();
		if (isRecordExist > 0) {
			System.out.println("Var");
			Query wageQuery = entityManager
					.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
					.setParameter("userid", userId).setMaxResults(1);

			Wage wage = (Wage) wageQuery.getResultList().get(0);
			wage.setWageDay(day);
			System.out.println("Wage Son çalışıyor");
			System.out.println(wage.toString());
			wageRepository.save(wage);
			return wage;
		} else {
			System.out.println("yokmuş burası çalışıyor");
			Wage wage = new Wage();
			wage.setIsAktive(true);
			wage.setWageDay(day);
			Optional<User> user = userRepository.findById(userId);

			user.ifPresent(currentUser -> {
				wage.setUser(currentUser);
				wageRepository.save(wage);
			});
			return wage;
		}
	}

	public Wage updateUserSalary(Long userId, int salary) {

		int isRecordExist = entityManager
				.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
				.setParameter("userid", userId).getResultList().size();
		if (isRecordExist > 0) {
			System.out.println("Var");
			Query wageQuery = entityManager
					.createQuery("From Wage where userid=:userid and isAktive=true order by updateDateTime desc")
					.setParameter("userid", userId).setMaxResults(1);

			Wage wage = (Wage) wageQuery.getResultList().get(0);
			wage.setSalary(salary);
			System.out.println("Wage Son çalışıyor");
			System.out.println(wage.toString());
			wageRepository.save(wage);
			return wage;
		} else {
			System.out.println("yokmuş burası çalışıyor");
			Wage wage = new Wage();
			wage.setIsAktive(true);
			wage.setSalary(salary);
			Optional<User> user = userRepository.findById(userId);

			user.ifPresent(currentUser -> {
				wage.setUser(currentUser);
				wageRepository.save(wage);
			});
			return wage;
		}

	}

}
