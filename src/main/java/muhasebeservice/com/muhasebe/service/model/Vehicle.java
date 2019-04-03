package muhasebeservice.com.muhasebe.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

public class Vehicle extends AbstractAuditableEntity<User, Long> implements Serializable {
	@Column
	private String name;
}
