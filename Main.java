import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Main{
	
	 private static boolean fileExists; // flag

	    public static void MakeTextFile(String fileName) throws IOException {
	    	//TODO: get input from user
	    	
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        
	        
	    
	      // writer.append(run.getDistance() + " " + run.getMin() + ":" + run.getSec());
	        	
	        
	        
	        writer.close();
	    }

	public static void main(String[] args) throws IOException {
		
		int year = 2017;
		MakeTextFile("2017.txt");
		

		
	}
}

