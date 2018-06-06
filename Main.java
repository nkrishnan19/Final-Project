import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
/**
 * Final Project
 * @author Nandhini Krishnan
 *Main Frame
 */
public class Main extends JFrame
{
	
	public Main()
	{
		add(new DataInput());
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		
		new Main();
		
		
	}
}