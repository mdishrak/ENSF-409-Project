/**
 @author Md Ishrak Mashroor <a href="mailto:mdishrak.mashroor@ucalgary.ca">mdishrak.mashroor@ucalgary.ca</a>
 
 Group 10 - other members:  Zeerak Shafique, Yousef Mohamed, Mariana Hidalgo Diaz

 @version       1.0
 @since         1.0
 */

package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class TaskHour {
	int hour;
	ArrayList<Treatments> tasksArrayList;
	int timeRemaining = 60;

	// Constructor for the TaskHour class
	public TaskHour(int h) {
		// TODO Auto-generated constructor stub
		this.hour = h;  	// Initializing the hour variable to h
		tasksArrayList = new ArrayList<Treatments>();  	// Initializing the tasksArrayList variable as an ArrayList of type Treatments
	}

	// Method to check if there are any tasks in the ArrayList
	public boolean isTasksEmpty() {
		// If the ArrayList is null, return true
		if (tasksArrayList == null)
			return true;
		else if (tasksArrayList.isEmpty())
			return true;
		return false;
	}
	
	// Method to add a task to the ArrayList
	public boolean AddTasktoHour(Treatments t) {
		// Check if there is enough time remaining in the hour to add the task
		if ((timeRemaining - t.taskDuration) >= 0) {
			tasksArrayList.add(t);
			timeRemaining = timeRemaining - t.taskDuration;
			return true;
		} else {
			System.out.println("Not enough time in hour left for " + t.taskName + " for " + t.animalName);
			// TODO prompt for volunteer
			// Create a new Scanner object to get user input
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nCall for backup voluneteer. \nPress 'y' to confirm, or 'n' to quit system. ");
			String userInput = scanner.nextLine().toLowerCase();

			// userInput.equals("y")

			if (userInput.equals("y")) {
				// Print a message indicating that a backup volunteer has been called
				System.out.println("backup volunteer has been called");
 
				                                                                          // print treatment lists 
				SqlMan sqlMan = new SqlMan();
				try {
		            sqlMan.readDataBase();
		            ArrayList<Treatments> tmpArrayList = sqlMan.mergedList();
		                                                                         //System.out.println(tmpArrayList);
		            for (int i = 0; i < tmpArrayList.size(); i++) {
		                System.out.println(tmpArrayList.get(i));
		            }
		            sqlMan.AddExtraTasks(11);
		            for (Tasks task : sqlMan.taskList) {
		                System.out.println(task);
		            }                                        // call the AddExtraTasks method with the last ID as 10
		            
		        }catch (Exception e) {
		            e.printStackTrace();
		        }
				
				
			} else if (userInput.equals("n")) {
				// Print a message indicating that a backup volunteer has NOT been called.
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
			// Print each task in the ArrayList
			System.out.println("\t" + t.taskName + " for " + t.animalName + " - " + t.taskDuration + " mins");
		}
	}
}
