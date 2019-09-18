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
 * This program will encrypt data in the form of four-digit integers by replacing each digit with the result of adding 7 to the digit
 * and getting the remainder after dividing the new value by 10. It then swaps the first digit with the third, and the second digit with
 * the fourth. 
 */

package menown_p1;

import java.util.Scanner;

public class encrypt {

	public static void main(String[] args) {
		//Declaring variables
		Scanner in = new Scanner(System.in);
		String temporaryString; //stores integer to be converted to array
		int unencryptedInt[]= new int[4]; //array to store unencrypted digits
		int enteredNumber; //stores originally entered integer
		int storedInt; //stores number while digits are swapped
		int i; //counter

		//Taking user input
		System.out.println("Enter the unencrypted four-digit integer:");
		enteredNumber = in.nextInt();
		in.close(); //closing scanner
		temporaryString = Integer.toString(enteredNumber); //converting integer to string temporarily
		
		for (i = 0; i < 4; i++) { //assigning entered digits to array
			unencryptedInt[i] = Character.getNumericValue(temporaryString.charAt(i)); 
		}
		
		//Encrypting input
		for (i = 0; i < 4; i++) { //adding 7 and getting remainder after dividing by 10
			unencryptedInt[i] = (unencryptedInt[i] + 7) % 10; 
		}
		
		for (i = 0; i < 2; i++) { //swapping the positions of 1 & 3, and 2 & 4
			storedInt = unencryptedInt[i + 2];
			unencryptedInt[i + 2] = unencryptedInt[i];
			unencryptedInt[i] = storedInt;
		}
		
		for (i = 0; i < 4; i++) { //printing encrypted value
			System.out.print(unencryptedInt[i]);
		}

	}

}
