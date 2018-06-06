/**
 * Final Project
 * @author Nandhini Krishnan
 *Calculations
 */
public class Calculations 
{
	private int points;
	
	public Calculations()
	{
		points = 0;
	}
	/**
	 *assigns points to age entered
	 * @param str
	 */
	public void checkage(String str)
	{
		int age = Integer.parseInt(str);
		
		if(age >= 50 && age <= 59)
		{
			points += 1;
		}
		else if(age < 40)
		{
			points += 2;
		}
		else if(age >= 60 && age <= 69)
		{
			points += 3;
		}
		else if(age >=70)
		{
			points +=5;
		}
		
	}
	/**
	 * Assigns values to race selected
	 * @param str
	 */
	public void checkrace(String str)
	{
		if(str.equals("Caucasian"))
		{
			points += 1;
		}
		else if(str.equals("African_American"))
		{
			points += 2;
		}
	}
	/**
	 * Assigns values to histology selected
	 * @param str
	 */
	public void checkhistology(String str)
	{
		if(str.equals("IDC"))
		{
			points += 1;
		}
	}	
	/**
	 * Assigns values to Grade Selected
	 * @param str
	 */
	public void checkGrade(String str)
	{
		if(str.equals("II"))	
		{
			points += 3;
		}
		else if(str.equals("III"))
		{
			points += 6;
		}
	}
	/**
	 * Assigns values to ER Status Selected
	 * @param str
	 */
	public void checkER(String str)
	{
		if(str.equals("Negative"))
		{
			points +=3;
		}
	}
	/**
	 * Assigns values to PR Status Selected
	 * @param str
	 */
	public void checkPR(String str)
	{
		if(str.equals("Negative"))
		{
			points +=2;
		}
	}
	/**
	 * Assigns Values to the Positive Lymph Node
	 * @param str
	 */
	public void checkPos(String str)
	{
		int pos = Integer.parseInt(str);
		if(pos > 2 && pos < 5)
		{
			points += 3;
		}
		else if(pos >= 5)
		{
			points += 6;
		}
	}
	/**
	 * Assigns Values to the Tumor Size
	 * @param str
	 */
	public void checkTumor(String str)
	{
		int tum = Integer.parseInt(str);
		if(tum > 2 && tum < 5)
		{
			points += 3;
		}
		else if(tum >= 5)
		{
			points += 6;
		}
	}
	/**
	 * Assigns Values to Radiation
	 * @param str
	 */
	public void checkRadiation(String str)
	{
		if(str.equals("No"))
		{
			points += 1;
		}
	}
	/**
	 * Calculates the 5 Year and 10 year BCSS based on points calculated
	 * @return 5 and 10 year BCSS
	 */
	public String getResults()
	{
		String fiveYear = "";
		String tenYear = "";
		if(points <= 15 && points>= 10)
		{
			fiveYear = "0.95";
			tenYear = "0.9";
		}
		else if(points > 15 && points <= 20)
		{
			fiveYear = "0.9";
			tenYear = "0.8";
		}
		else if(points > 20 && points <=25)
		{
			fiveYear = "0.8";
			tenYear = "0.6";
		}
		else if(points > 25)
		{
			fiveYear = "0.4";
			tenYear = "0.3";
		}
		else
		{
			fiveYear = "0";
			tenYear = "0";		
		}		
		return "5-Year BCSS: "+ fiveYear + "\n" + " " + "10-Year BCSS: " + tenYear;			
	}	
}