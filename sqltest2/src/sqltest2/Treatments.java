package sqltest2;

public class Treatments {
	public String treatID; // treatmentID
	public String aniID; // animalID
	public String taskID; // task ID
	public String startTime; // treatment start hour

	public String animalName;
	public String taskName;
	public int taskDuration;

	public Treatments(String trID, String anID, String tasID, String startTym) {

		this.treatID = trID;
		this.aniID = anID;
		this.taskID = tasID;
		this.startTime = startTym;

	}

	public Treatments(String trID, String a, String t, String startTym, int d) {

		this.treatID = trID;
		this.animalName = a;
		this.taskDuration = d;
		this.taskName = t;
		this.startTime = startTym;

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+treatID+", "+taskDuration+"m @ "+startTime+"hr - "+taskName+" for "+animalName;
	}
}
