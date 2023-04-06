package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class TaskMan {

	ArrayList<Treatments> requiredTasksList;
	ArrayList<Treatments> leftoutTasksList;

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
			}
		}
	}
}
