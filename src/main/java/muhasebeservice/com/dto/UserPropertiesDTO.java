package muhasebeservice.com.dto;

/**
 * @author fatih
 *
 */
public class UserPropertiesDTO {

	private Long userId;
	private int nextWageDay;
	private int dayToWage;
	private int wage;
	private int moneyPerDay;
	private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getNextWageDay() {
		return nextWageDay;
	}

	public void setNextWageDay(int nextWageDay) {
		this.nextWageDay = nextWageDay;
	}

	public int getDayToWage() {
		return dayToWage;
	}

	public void setDayToWage(int dayToWage) {
		this.dayToWage = dayToWage;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getMoneyPerDay() {
		return moneyPerDay;
	}

	public void setMoneyPerDay(int moneyPerDay) {
		this.moneyPerDay = moneyPerDay;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserProperties [userId=" + userId + ", nextWageDay=" + nextWageDay + ", dayToWage=" + dayToWage
				+ ", wage=" + wage + ", moneyPerDay=" + moneyPerDay + ", userName=" + userName + "]";
	}

}
