/**
 @author Md Ishrak Mashroor <a href="mailto:mdishrak.mashroor@ucalgary.ca">mdishrak.mashroor@ucalgary.ca</a>
 
 Group 10 - other members:  Zeerak Shafique, Yousef Mohamed, Mariana Hidalgo Diaz

 @version       1.0
 @since         1.0
 */
package edu.ucalgary.oop;

public class Tasks {
	public String taskID ;
	public String taskDesc;
	public int taskDur;
	public String taskTime;
	
	public Tasks (String id, String desc, int dur, String time) {
		// task constructor created.
		
		this.taskID = id ;
		this.taskDesc = desc;
		this.taskDur = dur;
		this.taskTime = time;
		
		
	}

	@Override
	public String toString() {
		return "id:"+taskID+", "+taskDesc+", "+taskDur+"mins @ "+taskTime;
		
		//return taskTime + ":00 hour \n            " + taskDesc + " - " + taskDur;

	}

}
