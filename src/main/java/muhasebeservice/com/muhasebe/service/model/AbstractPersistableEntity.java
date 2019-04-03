package muhasebeservice.com.muhasebe.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

public abstract class AbstractPersistableEntity<ID> implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;

	@Version
	private Long version;
}
