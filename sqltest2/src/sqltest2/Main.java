//package edu.ucalgary.oop;
package sqltest2;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("EWR Volunteer Task Scheduler \n - - - - - - - - ");
        System.out.println("Accessing animal and task lists from Database");
    	SqlMan db = new SqlMan();
        db.readDataBase();
        TaskMan taskMan = new TaskMan(db.mergedList());
        
        System.out.println("Managing Tasks...");
        taskMan.makeSchedule();
        
    }
}
