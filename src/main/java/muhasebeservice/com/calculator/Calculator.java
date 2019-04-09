package muhasebeservice.com.calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calculator {

	public int daysToWage(int WageDay) {

		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);

		int todaysDay = cal.get(Calendar.DATE);
		int todaysMonth = cal.get(Calendar.MONTH) + 1;
		int todayYear = cal.get(Calendar.YEAR);
		int nextMonth = todaysMonth;
		int nextYear = todayYear;
		System.out.println(
				" Yıl " + todayYear + " Gün : " + todaysDay + " Ay : " + todaysMonth + " Maaş Günü : " + WageDay);

		if (WageDay > todaysDay) {
			return WageDay - todaysDay;
		}

		else {

			nextMonth = (todaysMonth + 1) % 12;
			if (nextMonth == 0) {
				nextYear = nextYear + 1;
			}
			Date nextWageDate = this.valiteDate(nextYear, nextMonth, WageDay);
			return (int) ((nextWageDate.getTime() - nowDate.getTime()) / (1000 * 60 * 60 * 24));
		}

	}

	public int moneyPerDay(int daysToWage, int sallary) {
		return 6;
	}

	public Date valiteDate(int year, int month, int wageDay) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		sdf.setLenient(false);

		Date date = null;
		Boolean isDateValid = false;

		while (isDateValid == false) {
			try {
				String newDate = wageDay + "-" + month + "-" + year;
				String dateInString = newDate + " 09:00:00";
				date = sdf.parse(dateInString);
				isDateValid = true;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				wageDay = wageDay - 1;

			}

		}

		return date;

	}

	// Burada tüm hesaplamaları yapacağım, giderler de buraya girilecek

}
