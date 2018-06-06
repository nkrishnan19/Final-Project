import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Final Project
 * @author Nandhini Krishnan
 * Data Input
 */
public class DataInput extends JPanel
{
	private String age;
	private String  race;
	private String histology;
	private String gradeL;
	private String erStatus;
	private String prStatus;
	private String posLymNodes;
	private String tumorSize;
	private String radiationF;
	private  ArrayList <String> total;
	private ArrayList<String> list;
	public DataInput()
	{
		setPreferredSize(new Dimension(500, 500));
	setLayout( new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	
	total = new ArrayList ();
	JFrame myFrame = new JFrame();
	
	JLabel data = new JLabel("Enter your data below: ");
	gbc.gridx = 0;
	gbc.gridy = 0;	
	gbc.gridx++;	
	gbc.gridx = 0;
	gbc.gridy++;
	add(data, gbc);
	gbc.gridy++;
	JLabel lbl1 = new JLabel("Age");
	add(lbl1, gbc);
	gbc.gridx++;
	JTextField agetxt = new JTextField();
	agetxt.setPreferredSize(new Dimension(180, 30)); 
	add(agetxt, gbc);
	gbc.gridx = 0;
	JLabel lbl2 = new JLabel("Race");
	gbc.gridy++;
	gbc.gridy++;
	gbc.gridy++;
	add(lbl2, gbc);
	gbc.gridy--;
	gbc.gridx++;
	gbc.gridy++;
	String raceChoice [] = {"Caucasian" , "Asain/Pacific Islander", "African American", "Native American", "Other"};
	JList <String> raceC  = new JList<String> (raceChoice);
	add(raceC, gbc);	
	JLabel lbl20 = new JLabel("Histology");
	gbc.gridx = 0;
	gbc.gridy++;
	add(lbl20, gbc);
	
	
	String h [] = {"IDC", "ILC"};
	JList<String> histList = new JList<String>(h);
	gbc.gridx++;
	add(histList, gbc);
	gbc.gridx = 0;
	JLabel grade = new JLabel("Grade ");
	gbc.gridy++;
	add(grade, gbc);
	String grad [] =  {"I", "II", "III"};
	gbc.gridx++;
	JList <String> gradList = new JList <String> (grad);
	add(gradList, gbc);
	gbc.gridx = 0;
	gbc.gridy++;
	JLabel erStat = new JLabel("ER Status");
	add(erStat, gbc);
	String estat [] = {"Positive" , "Negative"};
	JList <String> stat  = new JList<String> (estat);
	gbc.gridx++;
	add(stat, gbc);
	gbc.gridx=0;
	gbc.gridy++;
	gbc.gridy++;
	JLabel prStat = new JLabel("PR Status");
	add(prStat, gbc);
	String pstat [] = {"Positive" , "Negative"};
	JList <String> pstatus  = new JList<String> (pstat);
	gbc.gridx++;
	gbc.gridy++;
	add(pstatus, gbc);

	gbc.gridx = 0;
	gbc.gridy++;
	JLabel lymphlbl = new JLabel ("Positive Lymph Nodes");
	add(lymphlbl, gbc);
	JTextField lymptxt = new JTextField();
	gbc.gridx++;
	lymptxt.setPreferredSize(new Dimension(180, 30));
	add(lymptxt, gbc);
	gbc.gridx = 0;
	gbc.gridy++;
	JLabel tumorlbl = new JLabel ("Tumor Size");
	add(tumorlbl, gbc);
	JTextField tumortxt = new JTextField();
	gbc.gridx++;
	tumortxt.setPreferredSize(new Dimension(180, 30));
	add(tumortxt, gbc);
	gbc.gridx = 0;
	JLabel radiationlbl = new JLabel ("Radiation");
	gbc.gridy++;
	add(radiationlbl, gbc);
	String [] radiation = {"Yes", "No"};
	JList <String> radiationChoice = new JList<String>(radiation);
	gbc.gridx++;
	add(radiationChoice, gbc);
	
	JButton submit  = new JButton("Calculate Nomogram");
	gbc.gridy++;
	add(submit, gbc);
	
	gbc.gridy++;
	JLabel results = new JLabel("");
	add(results, gbc);

	submit.addActionListener(new ActionListener()
			{
		boolean tempAge = true; 
		boolean tempRace = true;
		boolean tempHis = true;
		boolean tempGrade = true;
		boolean tempER = true;
		boolean tempPR = true;
		boolean tempPos = true;
		boolean tempTumor = true;
		boolean tempRad = true;
		boolean condition = true;
				@Override
				public void actionPerformed(ActionEvent e) 
				{ 							
						try 
						{
							checkAge(agetxt.getText());
							age = agetxt.getText();
							tempAge = true;
						}
						catch( IllegalArgumentException e3)
						{
							
							JOptionPane.showMessageDialog(myFrame,  "Your input for age was invalid.");
							agetxt.setText("");
							tempAge = false;
							
						}
						try
						{
							checkTumor(tumortxt.getText());
							tumorSize = tumortxt.getText();
							tempTumor = true;
						}
						catch(IllegalArgumentException e3)
						{
							JOptionPane.showMessageDialog(tumortxt, "Your input for tumor size was invalid. Please enter the tumor size between 0 and 3.");
							tumortxt.setText("");
							tempTumor = false;
						}
						try
						{
							checkLymph(lymptxt.getText());
							posLymNodes = lymptxt.getText();
							tempPos = true;
						}
						catch(IllegalArgumentException e4)
						{
							JOptionPane.showMessageDialog(lymptxt, "Your input for positive lymph nodes size was invalid. Please enter size between 2 and 5.");
							lymptxt.setText("");
							tempPos = false;
						}
						try
						{ 
							checkRace(raceC.isSelectionEmpty());
							if(raceC.getSelectedValue().equals("Caucasian"))
							{
								race = "Caucasian";
								tempRace = true;
							
							}
							else if(raceC.getSelectedValue().equals("Asian/Pacific Islander"))
							{
								race = "Asain/Pacific_Islander";
								tempRace = true;
								
							}
							else if(raceC.getSelectedValue().equals("African American"))
							{
								race = "African_American";
								tempRace = true;
								
							}
							else if (raceC.getSelectedValue().equals("Native American"))
							{
								race = "Native_American";
								tempRace = true;
							}
							
							else
							{
								race = "Other";
								tempRace = true;
							}
						}
						catch(IllegalArgumentException e5)
						{
								JOptionPane.showMessageDialog(myFrame, "Please Select Your Race.");
								tempRace = false;	
						}
						
						try
						{
							checkER(gradList.isSelectionEmpty());
							if(gradList.getSelectedValue().equals("I"))
							{
								gradeL = "I";
								tempGrade = true;
							}
							else if(gradList.getSelectedValue().equals("II"))
							{
								gradeL = "II";
								tempGrade = true;
							}
							else if(gradList.getSelectedValue().equals("III"))
							{
								gradeL = "III";
								tempGrade = true;
							}
						}
						catch(IllegalArgumentException e6)
						{
							JOptionPane.showMessageDialog(myFrame, "Please Select Your Grade level");
							tempGrade = false;
						}
						try
						{
							checkHistology(histList.isSelectionEmpty());
							if(histList.getSelectedValue().equals("ILC"))
							{
								histology = "ILC";
								tempHis = true;
							}
							else if(histList.getSelectedValue().equals(("IDC")))
							{
								histology = "IDC";
								tempHis = true;
							}
						}
						catch(IllegalArgumentException e7)
						{
							JOptionPane.showMessageDialog(myFrame, "Please Select your Histology");
							tempHis = false;
						}
						try
						{
							checkER(stat.isSelectionEmpty());
							if(stat.getSelectedValue().equals("Positive"))
							{
								erStatus = "Positive";
								tempER = true;
							}
							else if(stat.getSelectedValue().equals("Negative"))
							{
								erStatus = "Negative";
								tempER = true;
							}
							
						}
						catch(IllegalArgumentException e8)
						{
							JOptionPane.showMessageDialog(myFrame, "Please select your ER Status");
							tempER = false;
						}
						try
						{
							checkER(pstatus.isSelectionEmpty());
							if(pstatus.getSelectedValue().equals("Positive"))
							{
								prStatus = "Positive";
								tempPR = true;
							}
							else if(pstatus.getSelectedValue().equals("Negative"))
							{
								prStatus = "Negative";
								tempPR = true;
							}
						}
						catch(IllegalArgumentException e9)
						{
							JOptionPane.showMessageDialog(myFrame, "Please select your P Status");
							tempPR = false;
						}
						try
						{
							checkER(radiationChoice.isSelectionEmpty());
							if(radiationChoice.getSelectedValue().equals("Yes"))
							{
								radiationF = "Yes"; 
								tempRad = true;
							}
							else if(radiationChoice.getSelectedValue().equals("No"))
							{
								radiationF = "No";
								tempRad = true;
							}
						}
						catch(IllegalArgumentException e10)
						{
							JOptionPane.showMessageDialog(myFrame, "Please select your radiation");
							tempRad = false;
						}									
					if(tempAge && tempRace && tempHis && tempGrade && tempER && tempPR && tempPos && tempTumor && tempRad)
					{
						condition = false;
						try {
							
							total.add(age + " ");
							total.add(race + " ");
							total.add(histology + " ");
							total.add(gradeL + " ");
							total.add(erStatus + " ");
							total.add(prStatus + " ");
							total.add(posLymNodes + " ");
							total.add(radiationF + " ");
							total.add(tumorSize + " ");
							FileWriter writer = new FileWriter("Breast Cancer File");
							
							for(int i =0; i < total.size(); i++)
							{
								writer.write(total.get(i));
							}
							writer.close();						
						}						
						catch(IOException ex)
						{
							ex.printStackTrace();
						}				
						try 
						{
							Scanner s = new Scanner(new File("Breast Cancer File"));
							 list = new ArrayList<String>();
							while (s.hasNext())
							{
							    list.add(s.next());
							}
							s.close();
						}
						catch(IOException e2)
						{
							e2.printStackTrace();
						}
						Calculations calc = new Calculations();
						calc.checkage(list.get(0));
						calc.checkrace(list.get(1));
						calc.checkhistology(list.get(2));
						calc.checkGrade(list.get(3));
						calc.checkER(list.get(4));
						calc.checkPR(list.get(5));
						calc.checkPos(list.get(6));
						calc.checkRadiation(list.get(7));
						calc.checkTumor(list.get(8));
						results.setText(calc.getResults());
						JOptionPane.showMessageDialog(myFrame, "Go Blue!!! :)");
					}	
				}
			});	
	}
/**
 * Checks to see if user input is a number	
 * @param str
 * @return true if user entered a number and false otherwise
 */
	public boolean isNumeric(String str)
	{
	try
	{
		Double.parseDouble(str);
		return true;
	}
	catch(IllegalArgumentException e)
	{
	return false;
	}

	}
	/**
	 * Checks to see if age is a number
	 * @param str
	 * @return true if age is a number
	 */
	public boolean checkAge(String str)
	{
		boolean age = false;
		String s = str;
		if(isNumeric(s) && Double.parseDouble(s) > 0 && Double.parseDouble(s) < 105)
		{
			age = true;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		return age;
	}
	/**
	 * Checks to see if user input is a number within range
	 * @param str
	 * @return true if user input is a number within range
	 */
	public boolean checkLymph(String str)
	{
		boolean lymph = false;
		String s = str;
		if(isNumeric(s) && Double.parseDouble(s) >= 2 && Double.parseDouble(s) <= 5)
		{
			lymph = true;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		return lymph;
	}
	/**
	 * Checks to see if user input is a number within range
	 * @param str
	 * @return true if user input is a number within range
	 */
	public boolean checkTumor(String str)
	{
		boolean tumor = false;
		String s = str;
		if(isNumeric(s) && Double.parseDouble(s) >= 0 && Double.parseDouble(s) <= 3)
		{
			tumor = true;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		return tumor;
	}
	/**
	 * Check to see if race selected
	 * @param abc
	 * @return true if race is selected
	 */
	public boolean checkRace(boolean abc)
	{
		boolean temp = false;
		if(!abc)
		{
			temp = true;
		}
		else
		{	
			throw new IllegalArgumentException();
		}
		
		return temp;
	}
	/**
	 * Check to see if Histology Selected
	 * @param abc
	 * @return true if histology selected
	 */
	public boolean checkHistology(boolean abc)
	{
		boolean temp = false;
		if(!abc)
		{
			temp = true;
		}
		else
		{	
			throw new IllegalArgumentException();
		}
		
		return temp;
	}
	/**
	 * check to see if ER Status selected
	 * @param abc
	 * @return true if ER Status selected
	 */
	public boolean checkER(boolean abc)
	{
		boolean temp = false;
		if(!abc)
		{
			temp = true;
		}
		else
		{	
			throw new IllegalArgumentException();
		}
		
		return temp;
	}
	
}