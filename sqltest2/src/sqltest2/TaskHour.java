package sqltest2;

import java.util.ArrayList;

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
		if(tasksArrayList == null)
			return true;
		else if(tasksArrayList.isEmpty())
			return true;
		return true;
	} 

	public boolean AddTasktoHour(Treatments t) {
		if ((timeRemaining - t.taskDuration) >= 0) {
			tasksArrayList.add(t);
			timeRemaining = timeRemaining - t.taskDuration;
			System.out.println("asdasf");
			return true;
		} else {
			System.out.println("Not enough time in hour left for " + t.taskName + " for " + t.animalName);
			return false;
		}
	}
	
	public void PrintHourSchedule() {
		System.out.println(hour + ":00 hour");
		for (Treatments t : tasksArrayList) {
			System.out.println("\t"+t.taskName+" for "+t.animalName+" - "+t.taskDuration);
		}
	}
}
