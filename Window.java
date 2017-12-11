import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * This class creates a window to display info for the run method
 * @author skgigliotti
 *
 */
public class Window extends JFrame{
	
	JPanel panel1 = new JPanel();
	JLabel jMins = new JLabel();
	JButton submit = new JButton("submit");
	BufferedWriter writer;
	
	
	public Window(BufferedWriter writ){
		 super("Run");
		 setLayout(new FlowLayout());
		 
		 
		 JLabel date = new JLabel(getDate());
		 writer = writ;
	
		 add(date);
		 textFields();
		 add(panel1);
		 add(jMins);
		 panel1.add(submit);
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
	
	
	
	/**
	 * This method creates text fields for the minutes and seconds
	 */
	private void textFields(){
		JTextField mins = new JTextField(" minutes ");
		JTextField sec = new JTextField(" seconds ");
		JLabel colon = new JLabel(":");
		panel1.add(mins);
		panel1.add(colon);
		panel1.add(sec);
		mins.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = mins.getText();
				jMins.setText(input);
			}
		});
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					writer.append(jMins +"*");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	
}
