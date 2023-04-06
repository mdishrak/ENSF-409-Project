package sqltest2;

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
				boolean b = taskHour.AddTasktoHour(t);
				if (!b)
					leftoutTasksList.add(t);
				hourslist.put(t.startTime, taskHour);
			} else {
				TaskHour tHour = new TaskHour(Integer.parseInt(t.startTime));
				hourslist.put(t.startTime, tHour);
			}
		}
		for (int i = 0; i < 24; i++) {
			boolean hasHour = hourslist.containsKey(String.valueOf(i));
			TaskHour doesHourHaveTasks = hourslist.get(String.valueOf(i));
			if (hasHour ) {
				TaskHour h = hourslist.get(String.valueOf(i));
				h.PrintHourSchedule();
			}
		}
	}
}
