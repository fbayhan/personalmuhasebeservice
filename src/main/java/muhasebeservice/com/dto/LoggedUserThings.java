package muhasebeservice.com.dto;

public class LoggedUserThings {

	private Long id;
	private int dayOfWage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDayOfWage() {
		return dayOfWage;
	}

	public void setDayOfWage(int dayOfWage) {
		this.dayOfWage = dayOfWage;
	}

	@Override
	public String toString() {
		return "LoggedUserThings [id=" + id + ", dayOfWage=" + dayOfWage + "]";
	}

}
