/**
 @author Md Ishrak Mashroor <a href="mailto:mdishrak.mashroor@ucalgary.ca">mdishrak.mashroor@ucalgary.ca</a>
 
 Group 10 - other members:  Zeerak Shafique, Yousef Mohamed, Mariana Hidalgo Diaz

 @version       1.0
 @since         1.0
 */
package edu.ucalgary.oop;

public class Treatments {
	public String treatID; // treatmentID
	public String aniID; // animalID
	public String taskID; // task ID
	public String startTime; // treatment start hour

	public String animalName;
	public String taskName;
	public int taskDuration;

	public Treatments(String trID, String anID, String tasID, String startTym) {
		// Assign values to the instance variables
		this.treatID = trID;
		this.aniID = anID;
		this.taskID = tasID;
		this.startTime = startTym;

	}

	public Treatments(String trID, String a, String t, String startTym, int d) {
		// Assign values to the instance variables
		this.treatID = trID;
		this.animalName = a;
		this.taskDuration = d;
		this.taskName = t;
		this.startTime = startTym;

	}
	
	// Override the toString() method to return a formatted string with the instance variables
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return "id:"+treatID+", "+taskDuration+"m @ "+startTime+"hr - "+taskName+" for "+animalName;
		return startTime + ":00 hour \n         " + taskName+" for "+animalName + " - " + taskDuration ;

	
	
	}
}
