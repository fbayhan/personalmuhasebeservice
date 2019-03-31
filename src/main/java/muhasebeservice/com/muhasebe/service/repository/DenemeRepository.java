package muhasebeservice.com.muhasebe.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import muhasebeservice.com.muhasebe.service.model.Deneme;

 
@Repository
public interface DenemeRepository extends JpaRepository<Deneme, Long> {

}
