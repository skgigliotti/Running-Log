import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

class Main{
	
	 private static boolean fileExists; // flag
	 private static Scanner scan = new Scanner(System.in);
	 private static double totalPace = 0;
	 private static double totalDist = 0;
	 private static double totalMood = 0;
	 private static double totalExhaust = 0;
	 private static double totalTime = 0;
	 private static int numRuns;

	
/**
 * This method gets today's current date
 * @return String today's date
 */
   public static String getDateToday(){
	   DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	   Date dateToday = new Date();
	   return format.format(dateToday);
   }
	 /**
	 * This method creates a new run based on user input. 
	 * @return new Run with parameters filled
	 */
	public static Run newRun(){
		 //TODO: catching input errors
		
		System.out.print("Minutes run: ");
		int mins = scan.nextInt();
		
		System.out.print("Seconds run: ");
		int secs = scan.nextInt();
		
		
		System.out.print("Distance run (mi): ");
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
	
	/**
	 * This method creates a file (if it does not exist yet) and adds the new run as a line
	 * with the date, distance run, time, pace, tiredness, and mood
	 *  (yyyy/mm/dd    dist    min:sec    pace    exhaustion    mood)    
	 *  
	 * @param fileName
	 * @param run
	 * @throws IOException
	 */
	 public static void addRunToFile(String fileName, Run run) throws IOException {
	    	//TODO: format seconds
	   
	        PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
	        writer.println(getDateToday() + "    " + run.getDistance() + "    " +
	        		run.getComboTime() + "    " + run.getPace()+ "    "+ run.getExhaustion() + "    " + run.getMood());
	       
	      
	        
	        writer.close();
	    }

	/**
	 * Reads data from the file containing the runs and adds up totals for each category.
	 * @param file String of file name containing the runs
	 * @throws FileNotFoundException
	 */
	public static void readData(String file) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(file));
		for (int i = 0; scanner.hasNextLine(); i++){
			  
			  scanner.next();
			  
			  totalDist+=Double.parseDouble(scanner.next());
			  totalTime+=Double.parseDouble(scanner.next());
			  totalPace+=Double.parseDouble(scanner.next());
			  totalExhaust+=Double.parseDouble(scanner.next());
			  totalMood+=Double.parseDouble(scanner.next());
			  
		      numRuns++;
			  scanner.nextLine();  
		      
		      
		      
		}
		
		
		scanner.close();
		
	}
	
	/**
	 * This method is used to average different categories of data (distance, time, etc)
	 * @param total
	 * @param numNums
	 * @return the average based on the number of runs
	 */
	public static double getAvg(double total, int numNums){
		
		return (total / numNums);
		
	}
	/**
	 * This method averages each category of data and prints out the results for the user.
	 * @param year
	 */
	public static void processData(String year){
		//TODO: formatting
		System.out.println("Averges for the Year " + year);
		System.out.println("Pace:" + getAvg(totalPace,numRuns));
		System.out.println("Distance:" + getAvg(totalDist,numRuns));
		System.out.println("Time Run:" + getAvg(totalTime,numRuns));
		System.out.println("Mood:" + getAvg(totalMood, numRuns));
		System.out.println("Tiredness:" + getAvg(totalExhaust, numRuns));
	}
	
	
	public static void main(String[] args) throws IOException {
		//print today's date
		System.out.println(getDateToday());
		String year = "2017";
		
		//create new run
		Run run = newRun();
		
		addRunToFile(year + ".txt", run);
		readData(year + ".txt");
		processData(year);
		

		
	}
}

