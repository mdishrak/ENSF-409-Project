package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class TaskMan {

	ArrayList<Treatments> requiredTasksList; // ArrayList to store all required tasks
	ArrayList<Treatments> leftoutTasksList; // ArrayList to store tasks that could not be scheduled

	public TaskMan() {
		// TODO Auto-generated constructor stub
	}

	public TaskMan(ArrayList<Treatments> t) {
		this.requiredTasksList = t;
		leftoutTasksList = new ArrayList<Treatments>();
	}

	public void makeSchedule() {
		TreeMap<String, TaskHour> hourslist = new TreeMap<String, TaskHour>();

		for (Treatments t : requiredTasksList) {
			// if the hour already exists in the TreeMap get the TaskHour object associated with the hour attempt to allocate task to hour
			if (hourslist.containsKey(t.startTime)) {
				TaskHour taskHour = hourslist.get(t.startTime);
				boolean isTaskAllocated = taskHour.AddTasktoHour(t);
				if (!isTaskAllocated)
					leftoutTasksList.add(t);
				hourslist.put(t.startTime, taskHour);
			} else {
				TaskHour tHour = new TaskHour(Integer.parseInt(t.startTime));
				hourslist.put(t.startTime, tHour);
			}
		}
		for (int i = 0; i < 24; i++) {
			boolean hasHour = hourslist.containsKey(String.valueOf(i));
//			boolean doesHourHaveTasks = ;
			if (hasHour && !hourslist.get(String.valueOf(i)).isTasksEmpty()) {
				TaskHour h = hourslist.get(String.valueOf(i));
				h.PrintHourSchedule();
				
//				System.out.println(h.PrintHourSchedule());
			}
		}
	}
}
