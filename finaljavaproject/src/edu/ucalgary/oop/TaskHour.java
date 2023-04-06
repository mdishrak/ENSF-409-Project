package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class TaskHour {
	int hour;
	ArrayList<Treatments> tasksArrayList;
	int timeRemaining = 60;

	public TaskHour(int h) {
		// TODO Auto-generated constructor stub
		this.hour = h;
		tasksArrayList = new ArrayList<Treatments>();
	}

	public boolean isTasksEmpty() {
		if (tasksArrayList == null)
			return true;
		else if (tasksArrayList.isEmpty())
			return true;
		return false;
	}

	public boolean AddTasktoHour(Treatments t) {
		if ((timeRemaining - t.taskDuration) >= 0) {
			tasksArrayList.add(t);
			timeRemaining = timeRemaining - t.taskDuration;
			return true;
		} else {
			System.out.println("Not enough time in hour left for " + t.taskName + " for " + t.animalName);
			// TODO prompt for volunteer
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nCall for backup voluneteer. \nPress 'y' to confirm, or 'n' to quit system. ");
			String userInput = scanner.nextLine().toLowerCase();

			// userInput.equals("y")

			if (userInput.equals("y")) {
				System.out.println("backup volunteer has been called");
			} else if (userInput.equals("n")) {
				System.out.println("no pressed.shcedule generation dismissed. System quit.");
				System.exit(0);
			}

			else {
				System.out.println("invalid input. Schedule genertion dismissed. System quit.");

				System.exit(0);
			}

		}

		return false;
	}

	public void PrintHourSchedule() {
		System.out.println(hour + ":00 hour");
		for (Treatments t : tasksArrayList) {
			System.out.println("\t" + t.taskName + " for " + t.animalName + " - " + t.taskDuration + " mins");
		}
	}
}
