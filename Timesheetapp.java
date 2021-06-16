package timesheetapp;

import java.util.Calendar;
import java.util.Scanner;

public class Timesheetapp 
{
	public static void main(String[] args) 
	{
		Calendar c1 = Calendar.getInstance();
		System.out.println("Timesheet Week " + c1.get(Calendar.WEEK_OF_YEAR) + "\n");
		
		// Create a new time sheet object for each week
		System.out.println( "1. Create new timesheet" + "\n" +
							"2. Close" + "\n"
								);
		Scanner in = new Scanner(System.in);
		System.out.print("Enter option: ");
		int selection = in.nextInt();			
		switch (selection) {
			case 1: new Timesheet(); break;
			case 2: break;
			default: System.out.println("Invalid");
		}
		in.close();
	}
}