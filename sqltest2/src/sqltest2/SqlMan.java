package sqltest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class SqlMan {

	    private Connection connect = null;
	    private Statement statement = null;
	    private PreparedStatement preparedStatement = null;
	    private ResultSet resultSet = null;
	    
	    ArrayList<Animals> animalList = new ArrayList<Animals>();
	    ArrayList<Tasks> taskList = new ArrayList<Tasks>();
	    ArrayList<Treatments> treatmentList = new ArrayList<Treatments>();

	    public void readDataBase() throws Exception {
	        try {
	            // This will load the MySQL driver, each DB has its own driver
	            Class.forName("com.mysql.jdbc.Driver");
	            // Setup the connection with the DB
	            connect = DriverManager
	                    .getConnection("jdbc:mysql://localhost/ewr?"
	                            + "user=root&password=Rakish,1202");

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            resultSet = statement
	                    .executeQuery("select * from ewr.animals");
	            
	            
	            while(resultSet.next()) {
	            	String aid = resultSet.getString(1);
	            	String aname = resultSet.getString(2);
	            	String aSpec = resultSet.getString(3);
	            	System.out.println("ID:"+aid+"  ||   NAME:"+aname + "  ||   Species:  "+ aSpec);
	            	
	            	Animals tempAnimal = new Animals(aid, aname, aSpec);
	            	animalList.add(tempAnimal);
	            }
	            
	            
	            
	            System.out.println("  ");
	            
	            resultSet = statement
	                    .executeQuery("select * from ewr.tasks");
	            while(resultSet.next()) {
	            	String tid = resultSet.getString(1);
	            	String tDesc = resultSet.getString(2);
	            	String tDur = resultSet.getString(3);
	            	String  aMax = resultSet.getString(4); 
	            	System.out.println(" Task ID :"+tid+"  ||  T Desc: "+tDesc + "  ||   T Dur : "+ tDur + "  ||   MaxWindow: "+ aMax );
	            	
	            	Tasks tempTask = new Tasks(tid, tDesc, tDur, aMax);
	            	taskList.add(tempTask);
	            }
	            
	            System.out.println("  ");
	            
	            resultSet = statement
	                    .executeQuery("select * from ewr.treatments");
	            while(resultSet.next()) {
	            	String trId = resultSet.getString(1);
	            	String aid = resultSet.getString(2);
	            	String tid = resultSet.getString(3);
	            	String  startHour = resultSet.getString(4); 
	            	System.out.println( " Treatment ID: "+ trId+ "  ||   Animal ID :"+aid+"  ||  Task Id: "+tid + "  || Start Hour : "+ startHour  );
	            	
	            	Treatments tempTreatment = new Treatments(trId, aid, tid, startHour);
	            	treatmentList.add(tempTreatment);
	            }
	            
	            

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }

	    }

	    // You need to close the resultSet
	    private void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {

	        } 
	    } 

	}


