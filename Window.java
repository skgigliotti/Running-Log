import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	private JLabel item1;
	
	public Window(){
		 super("Run");
		 setLayout(new FlowLayout());
		 
		 
		 item1 = new JLabel(getDate());
		 
		 item1.setToolTipText("hover"); 
		
		 add(item1);
	}
	
	
	/**
	 * This method gets the current day's date and formats it as a String yyyy/MM/dd
	 * @return today's date
	 */
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		 String theDate = (dateFormat.format(date));
		 return theDate;
	}
	
	
}
