import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Main{
	
	 
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
	   DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
	
	
	
	/**
	 * This class connects to the local host w/o SSL
	 * @return Connection the connection to the local host
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Scanner scan = new Scanner(System.in);
		//create interface here?
		try{
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/myData?autoReconnect=true&useSSL=false";
			String username = "root";
			System.out.println("Please enter your password to acess the database.");
			String password = scan.next();
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected");
			
			
			return con;
			
		}
		
		catch(Exception e){
			System.out.println(e);
			
		}
		
		return null;
	}
	
	/**
	 * This method creates a new log for the database if one is not already created.
	 * @param con Database to connect to
	 * @throws Exception
	 */
	public static void createLog(Connection con) throws Exception{
		try{
			
			
			String createLog = "CREATE TABLE IF NOT EXISTS log(id int NOT NULL AUTO_INCREMENT, date varchar(10),distance varChar(5), time varChar(5), pace varChar(5), tiredness char(1), mood char(1), PRIMARY KEY(id))";
			PreparedStatement create = con.prepareStatement(createLog);
			create.executeUpdate();
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		finally{
			System.out.println("Log created");
		}
	}
	
	/**
	 * This method adds an individual run to the log.
	 * @param con Database to connect to
	 * @param run Run to log
	 * @throws Exception
	 */
	public static void addRun(Connection con, Run run) throws Exception{
		

		
		final String distance = Double.toString(run.getDistance());
		final String time = run.getComboTime();
		final String pace = run.getPace();
		final String tiredness = Integer.toString(run.getExhaustion());
		final String mood = Integer.toString(run.getMood());
				
		try{
		   
		   String insert = "INSERT INTO log (date, distance, time, pace, tiredness, mood) VALUES(" + "CURDATE()"  + "," + distance + "," + time + "," + pace + "," + tiredness + "," + mood + ")";
		   PreparedStatement posted = con.prepareStatement(insert);
		   posted.executeUpdate();
		}
		
		catch (Exception e){
			System.out.println(e);
			
		}
		
		finally{
			System.out.println("Run logged");
		}
	}
	
public static void analyzeData(Connection con) throws Exception{
	getMonthInfo(con);
	
	}
	
	public static ArrayList<String> getMonthInfo(Connection con) throws Exception{
		try{
			 PreparedStatement statementMonth = con.prepareStatement("SELECT avg(pace) FROM log WHERE date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)");
			 ResultSet resultMonth = statementMonth.executeQuery();
			 ArrayList<String> array = new ArrayList<String>();
			 resultMonth.next();
			System.out.println("Avg Pace for the month: " + 
			 (((int)(Double.parseDouble(resultMonth.getString("avg(pace)"))*100))/100.0) +
					" min/mi"			);
			 
			 
			 return array;
		}
		
		catch(Exception e){
		   System.out.println(e);
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		//print today's date
		System.out.println(getDateToday());

	
//		//create new run
		//Run run = newRun();

		Connection con = getConnection();
		//createLog(con);
		//addRun(con, run);
		//analyzeData(con);
		getMonthInfo(con);

		
	}
}

