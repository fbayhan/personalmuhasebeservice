package muhasebeservice.com.muhasebe.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import muhasebeservice.com.muhasebe.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	@Query(" from User where id = 1")
	User findByUserNameHQL(String userName);

}
