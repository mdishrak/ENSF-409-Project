package sqltest2;

public class Treatments {
	public String treatID ; //treatmentID
	public String aniID; // animalID
	public String taskID; // task ID
	public String startTime; //treatment start hour
	
	public Treatments (String trID, String anID, String tasID, String startTym) {
		
		this.treatID = trID ;
		this.aniID = anID;
		this.taskID = tasID;
		this.startTime = startTym;
		
	}
	

}
