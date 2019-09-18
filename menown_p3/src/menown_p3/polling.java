/* Shelby Menown
 * September 21, 2019
 * COP3330 - Object Oriented Programming
 * 
 * PROBLEM:
 * Write a simple polling program that allows users to rate five topics from 1 (least important) to 10 (most important). 
 * Pick five topics that are important to you (e.g., political issues, global environmental issues, food, video games). 
 * Use a one-dimensional array topics (of type String) to store the five issues. To summarize the survey responses, use 
 * a 5-row, 10-column two-dimensional array responses (of type int), each row corresponding to an element in the topics 
 * array. When the program runs, it should ask the user to rate each issue. Multiple people should be able to respond to 
 * the survey while the program is running. Once all responses have been logged, have the program display a summary of 
 * the results, including:
 *
 *  1. A tabular report with the five topics down the left side and the 10 ratings across the top, listing in each column 
 *     the number of ratings received for each topic.
 *
 *  2. To the right of each row, show the average of the ratings for that issue.
 *
 *  3. Which issue received the highest point total? Display both the issue and the point total.
 *
 *  4. Which issue received the lowest point total? Display both the issue and the point total.
 */


package menown_p3;

import java.util.Scanner;

public class polling {

	public static void main(String[] args) {
		//Declaring variables
		Scanner in = new Scanner(System.in);
		String topics[] = new String[]{"TASTE", "TOUCH", "SIGHT", "SMELL", "SOUND"}; //stores five different topics
		int points[] = new int[5]; //stores total point values for each topic
		int responses[][] = new int[5][10]; //stores rating amounts for each topic
		int rating; //stores last inputed rating
		int numSurveys = 0; //stores number of times survey has been taken
		int yesOrNo; //stores user choice to repeat survey or not
		double average = 0; //stores average of all ratings for one topic
		int highestPoints = 0; //stores highest point total
		int highestPointsLocation = 0; //stores highest point total array location
		int lowestPoints = 0; //stores lowest point total
		int lowestPointsLocation = 0; //stores lowest point total array location
		int i, j; //counter

		
		//Taking user input
		do {
			System.out.println("Rate the following topics from 1 (least important) to 10 (most important).\n"
					+ "Ability to: (1) Taste, (2) Touch, (3) See, (4) Smell, (5) Hear\n\n");
			
			System.out.print("Rate TASTE: ");
			rating = in.nextInt() - 1;
			responses[0][rating] = responses[0][rating] + 1;
			
			System.out.print("Rate TOUCH: ");
			rating = in.nextInt() - 1;
			responses[1][rating] = responses[1][rating] + 1;
			
			System.out.print("Rate SIGHT: ");
			rating = in.nextInt() - 1;
			responses[2][rating] = responses[2][rating] + 1;
			
			System.out.print("Rate SMELL: ");
			rating = in.nextInt() - 1;
			responses[3][rating] = responses[3][rating] + 1;
			
			System.out.print("Rate SOUND: ");
			rating = in.nextInt() - 1;
			responses[4][rating] = responses[4][rating] + 1;
			
			System.out.println("\nTake survey again? Enter the number corresponding to your answer.\n"
					+ "1 --- Yes\n"
					+ "2 --- No");
			yesOrNo = in.nextInt();
			numSurveys++;
			
		} while (yesOrNo == 1);
		in.close(); //closing scanner
		
		//Printing out table of survey results
		System.out.println("\n	1	2	3	4	5	6	7 	8	9	10	Average");
		for (i = 0; i < 5; i++) {
			System.out.print(topics[i] + "\t");
			for (j = 0; j < 10; j++) {
				System.out.printf("%d	", responses[i][j]);
 				average += (j + 1) * responses[i][j];
			}
			
 			System.out.printf("%.2f", average / numSurveys);
 			points[i] = (int)average;
 			
 			average = 0;
 			System.out.print("\n");
		}
		
		//Calculating highest and lowest point totals
		highestPoints = points[0];
		lowestPoints = points[0];
		for (i = 1; i < 5; i++) {
			if (points[i] > highestPoints) {
				highestPoints = points[i];
				highestPointsLocation = i;
			}
			if (points[i] < lowestPoints) {
				lowestPoints = points[i];
				lowestPointsLocation = i;
			}
		}
		
		//Printing out highest and lowest point totals
		System.out.printf("\nHighest Point Total: %s with %d points\n", topics[highestPointsLocation], highestPoints);
		System.out.printf("Lowest Point Total: %s with %d points\n", topics[lowestPointsLocation], lowestPoints);

	}

}
