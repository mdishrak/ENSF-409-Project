package sqltest2;

public class Tasks {
	public String taskID ;
	public String taskDesc;
	public int taskDur;
	public String taskTime;
	
	public Tasks (String id, String desc, int dur, String time) {
		
		this.taskID = id ;
		this.taskDesc = desc;
		this.taskDur = dur;
		this.taskTime = time;
		
		
	}

	@Override
	public String toString() {
		return "id:"+taskID+", "+taskDesc+", "+taskDur+"mins @ "+taskTime;

	}

}
