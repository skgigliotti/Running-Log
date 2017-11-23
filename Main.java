import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;



class Main{
	
	 private static boolean fileExists; // flag
	 
	 
	 
	 
	   private static void createUserRun(){
	    	JFrame.setDefaultLookAndFeelDecorated(true);
	    	Window frame = new Window();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         

	     

	        // set the size of the frame 300 x 200
	        frame.setBounds(50, 50, 700, 400);
	        frame.setVisible(true);
	    }

	    public static void MakeTextFile(String fileName) throws IOException {
	    	//TODO: get input from user
	    	Run run = new Run(3.55, 34, 12);
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        
	        createUserRun();
	    
	       writer.append(run.getDistance() + " " + run.getMin() + ":" + run.getSec());
	        	
	        
	        
	        writer.close();
	    }

	public static void main(String[] args) throws IOException {
		Run run = new Run(3, 27, 22);
		int year = 2017;
		MakeTextFile("2017.txt");
		

		
	}
}

