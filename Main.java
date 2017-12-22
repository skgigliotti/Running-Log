import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Main{
	
	 private static boolean fileExists; // flag
	 private static Scanner scan = new Scanner(System.in);

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
	        		run.getMin() + ":" + run.getSec() + "    " + run.getPace()+ "    "+ run.getExhaustion() + "    " + run.getMood());
	       
	      
	        
	        writer.close();
	    }
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
		String year = "2017";
		
		//create new run
		Run run = newRun();
		
		addRunToFile(year + ".txt", run);
		
		

		
	}
}

