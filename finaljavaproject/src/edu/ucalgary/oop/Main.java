/**
 @author Md Ishrak Mashroor <a href="mailto:mdishrak.mashroor@ucalgary.ca">mdishrak.mashroor@ucalgary.ca</a>
 
 Group 10 - other members:  Zeerak Shafique, Yousef Mohamed, Mariana Hidalgo Diaz

 @version       1.0
 @since         1.0
 */

package edu.ucalgary.oop;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("EWR Volunteer Task Scheduler \n - - - - - - - - ");  // Prints out a message indicating that the animal and task lists are being accessed from the database.
        System.out.println("Accessing animal and task lists from Database");
    	SqlMan db = new SqlMan(); // Creates a new instance of the SqlMan class.
        db.readDataBase();    // Calls the "readDataBase()" method of the SqlMan class to read the data from the database.
        TaskMan taskMan = new TaskMan(db.mergedList());  // Creates a new instance of the TaskMan class and passes the merged list of animals and tasks from the database to its constructor.     
        System.out.println("Managing Tasks...");
        taskMan.makeSchedule();
        
    }
}


