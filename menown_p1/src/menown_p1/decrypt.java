/* Shelby Menown
 * September 21, 2019
 * COP3330 - Object Oriented Programming
 * 
 * PROBLEM:
 * A company that wants to send data over the Internet has asked you to write a program that will encrypt it 
 * so that it may be transmitted more securely. All the data is transmitted as four-digit integers. Your application 
 * should read a four-digit integer entered by the user and encrypt it as follows: Replace each digit with the 
 * result of adding 7 to the digit and getting the remainder after dividing the new value by 10. Then swap the first 
 * digit with the third, and swap the second digit with the fourth. Then print the encrypted integer. Write a separate 
 * application that inputs an encrypted four-digit integer and decrypts it (by reversing the encryption scheme) to 
 * form the original number.
 * 
 * This program will decrypt data in the form of four-digit integers that has been encrypted by replacing each digit with the result of adding 7 to the digit
 * and getting the remainder after dividing the new value by 10. It then swaps the first digit with the third, and the second digit with
 * the fourth. 
 */

package menown_p1;

import java.util.Scanner;

public class decrypt {

	public static void main(String[] args) {
		//Declaring variables
		Scanner in = new Scanner(System.in);
		String temporaryString; //stores integer to be converted to array
		int encryptedInt[]= new int[4]; //array to store encrypted digits
		int enteredNumber; //stores originally entered integer
		int storedInt; //stores number while digits are swapped
		int i; //counter
		
		//Taking user input
		System.out.println("Enter the encrypted four-digit integer:");
		enteredNumber = in.nextInt();
		in.close(); //closing scanner
		temporaryString = Integer.toString(enteredNumber); //converting integer to string temporarily
		
		for (i = 0; i < 4; i++) { //assigning entered digits to array
			encryptedInt[i] = Character.getNumericValue(temporaryString.charAt(i)); 
		}
		
		//Decrypting input
		for (i = 0; i < 2; i++) { //swapping the positions of 1 & 3, and 2 & 4
			storedInt = encryptedInt[i + 2];
			encryptedInt[i + 2] = encryptedInt[i];
			encryptedInt[i] = storedInt;
		}
		
		for (i = 0; i < 4; i++) { //getting remainder after dividing by 10, then subtracting 7
			encryptedInt[i] = (encryptedInt[i] % 10) - 7; 
		}
		
		for (i = 0; i < 4; i++) { //printing decrypted value
			System.out.print(encryptedInt[i]);
		}

	}

}
