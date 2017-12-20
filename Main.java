import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Main{
	
	 private static boolean fileExists; // flag
	 private static Scanner scan = new Scanner(System.in);

	    
	 public static void MakeTextFile(String fileName) throws IOException {
	    	//TODO: check for preexisting file
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        
	        
	    
	      // writer.append(run.getDistance() + " " + run.getMin() + ":" + run.getSec());
	        	
	        
	        
	        writer.close();
	    }
	
   public static String getDateToday(){
	   DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	   Date dateToday = new Date();
	   return format.format(dateToday);
   }
	 /**
	 * This method creates a new run based on user input. 
	 * @return
	 */
	public static Run newRun(){
		 
		
		System.out.print("Minutes run: ");
		int mins = scan.nextInt();
		
		System.out.print("Seconds run: ");
		int secs = scan.nextInt();
		
		
		System.out.print("Distance run: ");
		double dist = scan.nextDouble();
		
		System.out.print("On a scale of 1-5, how tired are you? : ");
		int exhaust = scan.nextInt();
		
		System.out.print("On a scale of 1-5, with 1 being the worst and 5 being the best, "
				+ "how do you feel mentally today? : ");
		int mood = scan.nextInt();
		
		
		//Run(double dist, int mins, int secs, int mind, int tiredness)
		Run myRun = new Run(dist, mins, secs, mood, exhaust);
		
		return myRun;
	}

	public static void main(String[] args) throws IOException {
		//print today's date
		System.out.println(getDateToday());
		int year = 2017;
		
		//create new run
		newRun();
		
		//MakeTextFile("2017.txt");
		
		

		
	}
}

