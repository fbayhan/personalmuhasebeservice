package muhasebeservice.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import muhasebeservice.com.model.Wage;

@Repository
public interface WageRepository extends JpaRepository<Wage, Long> {

	
	
}
