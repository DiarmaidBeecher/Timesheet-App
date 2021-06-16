package timesheetapp;

import java.util.Scanner;

public class DayHours {
	private String start;
	private String end; 	// if end time less than 8 ask "are you sure"
	private String lunchTime;
	
	private final int minToHour = 60;
	
	private double startHour;
	private double startMin;
	private double startTime;
	
	private double endHour;
	private double endMin;
	private double endTime;
	
	private double timeAtLunch;
	
	private double hoursDiff;
	
	public DayHours() {
		System.out.println("Day Hours object created");
	}

	public double setStartTime(String dayOfWeek, Scanner in) {
		System.out.print("Start time on " + dayOfWeek + " (HH:MM): ");
		this.start = in.next();
		if (start.equals("#")) {
			start = "08:00";
		}
		//in.close();
		startHour = Double.parseDouble(start.substring(0,2));
		startMin = Double.parseDouble(start.substring(3,5));
		return startTime = startHour + (startMin/minToHour);
	}
	
	public double setEndTime(String dayOfWeek, Scanner in) {
		System.out.print("End time on " + dayOfWeek + " (HH:MM): ");
		this.end = in.next();
		if (end.equals("#")) {
			end = "16:30";
		}
		endHour = Double.parseDouble(end.substring(0,2));
		endMin = Double.parseDouble(end.substring(3,5));
		return endTime = endHour + (endMin/minToHour);
	}
	
	public double setLunchTime(String dayOfWeek, Scanner in) {
		System.out.print("Time at lunch on " + dayOfWeek + " (mins): ");
		this.lunchTime = in.next();
		if (lunchTime.equals("#")) {
			lunchTime = "30";
		}
		return timeAtLunch = (Double.parseDouble(lunchTime)/minToHour);
	}
	
	public boolean hoursCheck(Scanner in) {
		hoursDiff = endTime - (startTime + timeAtLunch);
		System.out.println("End time: " + endTime + "\n" +
				"Start time: " + startTime + "\n" +
				"Time at lunch: " + timeAtLunch);
		System.out.println(hoursDiff);
		if (hoursDiff < 8) {
			System.out.println("Correct? (Y/N): ");
			String check = in.next();
			if (check == "Y") {
				return true;
			}
			else if (check == "N") {
				return false;
			}
			else {
				System.out.println("Invalid");
				return false;
			}
		}
		return true;
	}
	
	public double hoursDone() {
		return hoursDiff;
	}
	
	
	
	// Include option for holidays
}
