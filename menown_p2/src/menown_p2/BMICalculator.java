/* Shelby Menown
 * September 21, 2019
 * COP3330 - Object Oriented Programming
 * 
 * PROBLEM:
 * Create a BMI calculator that reads the user’s weight and height (providing an option for the user to select which formula to use), 
 * and then calculates and displays the user’s body mass index. Also, display the BMI categories and their values from the National 
 * Heart Lung and Blood Institute: http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm (Links to an external site.) 
 * so the user can evaluate his/her BMI.
 * 
 * This program will calculate and display the user's BMI given their weight and height. Users may choose to calculate their BMI with imperial or
 * metric values. The program will also display the BMI categories and their values from the National 
 * Heart Lung and Blood Institute so the user can evaluate his/her BMI.
 */

package menown_p2;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		//Declaring variables
		Scanner in = new Scanner(System.in);
		int systemType; //stores user-chosen measurement system choice
		double height; //stores user-inputed height
		double weight; //stores user-inputed weight
		double bmi; //stores calculated BMI
		
		//Taking user input
		System.out.println("Enter the number corresponding to your preferred system of measurement:\n" 
					+ "1 --- Standard System (Pounds, Inches)\n"
					+ "2 --- Metric System (Kilograms, Meters)");
		systemType = in.nextInt();
		
		switch (systemType) {
			case 1:
				System.out.println("Enter your height (inches):");
				height = in.nextDouble();
				System.out.println("Enter your weight (pounds):");
				weight = in.nextDouble();
				break;
			case 2:
				System.out.println("Enter your height (meters):");
				height = in.nextDouble();
				System.out.println("Enter your weight (kilograms):");
				weight = in.nextDouble();
				break;
			default:
				System.out.println("Not a valid entry.");
				in.close(); //closing scanner
				return;
		}
		in.close(); //closing scanner
		
		//Calculating results
		if (systemType == 1) {
			bmi = (703 * weight) / Math.pow(height, 2);
		}
		else {
			bmi = (weight) / Math.pow(height, 2);
		}
		
		//Printing results
		System.out.printf("\nYour BMI (Body Mass Index) is: %.2f\n\n", bmi);
		
		//Printing BMI information
		System.out.println("BMI Categories:\n"
				+ "Underweight ------- 16 through 18\n"
				+ "Normal ------------ 19 through 24\n"
				+ "Overweight -------- 25 through 29\n"
				+ "Obese ------------- 30 through 39\n"
				+ "Extreme Obesity --- 40 through 54");
		
	}

}
