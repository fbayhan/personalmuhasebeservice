package muhasebeservice.com.dto;

public class LoggedUserThingsDTO {

	private Long id;
	private int dayOfWage;
	private int salary;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

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
		return "LoggedUserThingsDTO [id=" + id + ", dayOfWage=" + dayOfWage + ", salary=" + salary + ", userName="
				+ userName + "]";
	}

}
