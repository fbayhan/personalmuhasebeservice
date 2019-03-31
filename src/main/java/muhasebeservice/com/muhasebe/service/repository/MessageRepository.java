package muhasebeservice.com.muhasebe.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import muhasebeservice.com.muhasebe.service.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
