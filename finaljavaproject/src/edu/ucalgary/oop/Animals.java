/**
 @author Md Ishrak Mashroor <a href="mailto:mdishrak.mashroor@ucalgary.ca">mdishrak.mashroor@ucalgary.ca</a>

 @version       1.0
 @since         1.0
 */
package edu.ucalgary.oop;


public class Animals {
	
	public String animalName ;
	public String animalID;
	public String animalSpecies;
	
	public Animals() {}
	
	
	// This is a constructor with three parameters to initialize the instance variables

	public Animals (String id, String name, String spec) {
		
		this.animalID = id ;
		this.animalName = name;
		this.animalSpecies = spec;
		
	}	
	
}
