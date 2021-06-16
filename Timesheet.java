package timesheetapp;

import java.util.Scanner;

public class Timesheet 
{
	private DayHours[] day = new DayHours[5];
	private final String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thurs", "Fri"};
	private boolean valid;
	private double totalHours;
	
	public Timesheet() {
		System.out.println("Timesheet created");
		Scanner in = new Scanner(System.in);
		for (int d = 0; d < dayOfWeek.length; d++) {
			day[d] = new DayHours();
			valid = false;
			while(!valid) {
				day[d].setStartTime(dayOfWeek[d], in);
				day[d].setEndTime(dayOfWeek[d], in);
				day[d].setLunchTime(dayOfWeek[d], in);
				valid = day[d].hoursCheck(in);
			}
		}
		in.close();
		System.out.println("Hours done " + WeeklyHours());
	}
		
	public double WeeklyHours() {
		for (int d = 0; d < dayOfWeek.length; d++) {
			totalHours += day[d].hoursDone();
		}
		return totalHours;
	}
	
}

