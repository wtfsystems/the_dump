/*
  Filename:  EmployeePaymentTest.java
  By:  Matthew Evans
  
  Test class to test the functionality of the EmployeePayment class
*/

import java.io.*;
import java.text.*;

public class EmployeePaymentTest {
	// Main function
	public static void main(String args[]) throws IOException {
		int workerType = 0;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String InputString;
		
		EmployeePayment employeeSalaries = new EmployeePayment();
		
		NumberFormat NumFormat = NumberFormat.getNumberInstance();
	    NumFormat.setMinimumFractionDigits(2);
		NumFormat.setMaximumFractionDigits(2);
		
		// The infinate for loop strikes again!
		for(;;) {
			System.out.println("1 - Manager\t\t2 - Hourly Worker");
			System.out.println("3 - Commission Worker\t4 - Piece Worker");
			System.out.print("Enter paycode (-1 to end):  ");
			InputString = input.readLine();
			workerType = Integer.parseInt(InputString);
			
			switch(workerType) {
				case 1: {
					// Manager was selected
					employeeSalaries.incManagers();
					System.out.println();
					System.out.println("Manager selected");
					System.out.println("Manager's pay is:  $" + NumFormat.format(employeeSalaries.calcManagerPay()));
					System.out.println();
					break;
				}
				case 2: {
					// Hourly Worker was selected
					int hours = 0;
					double pay = 0.0;
					
					employeeSalaries.incHourlyWorkers();
					System.out.println();
					System.out.println("Hourly worker selected");
					
					// Get the hourly salary
					System.out.print("Enter the hourly salary:  $");
					InputString = input.readLine();
					pay = Double.parseDouble(InputString);
					
					// Get the number of hours worked
					System.out.print("Enter the number of hours worked:  ");
					InputString = input.readLine();
					hours = Integer.parseInt(InputString);
					
					System.out.println("Hourly worker's pay is:  $" + NumFormat.format(employeeSalaries.calcHourlyWorkerPay(pay, hours)));
					System.out.println();
					break;
				}
				case 3: {
					// Commission worker was selected
					double sales = 0.0;
					
					employeeSalaries.incCommWorkers();
					System.out.println();
					System.out.println("Commission worker selected");
					
					// Get the weekly sales
					System.out.print("Enter gross weekly sales:  $");
					InputString = input.readLine();
					sales = Double.parseDouble(InputString);
					
					System.out.println("Commission worker's pay is:  $" + NumFormat.format(employeeSalaries.calcCommWorkerPay(sales)));
					System.out.println();
					break;
				}
				case 4: {
					// Piece worker was selected
					int pieces = 0;
					double wage = 0.0;
					
					employeeSalaries.incPieceWorkers();
					System.out.println();
					System.out.println("Piece worker selected");
					
					// Enter the number of pieces made
					System.out.print("Enter the number of pieces:  ");
					InputString = input.readLine();
					pieces = Integer.parseInt(InputString);
					
					// Enter the wage per piece
					System.out.print("Enter the wage per piece:  $");
					InputString = input.readLine();
					wage = Double.parseDouble(InputString);
					
					System.out.println("Piece worker's pay is:  $" + NumFormat.format(employeeSalaries.calcPieceWorkerPay(wage, pieces)));
					System.out.println();
					break;
				}
				case -1: {
					// Exits the program
					System.out.println();	System.out.println();
					System.out.println("Total number of managers paid:  " + employeeSalaries.getManagers());
					System.out.println("Total number of hourly workers paid:  " + employeeSalaries.getHourlyWorkers());
					System.out.println("Total number of commission workers paid:  " + employeeSalaries.getCommWorkers());
					System.out.println("Total number of piece workers paid:  " + employeeSalaries.getPieceWorkers());
					System.out.println();
					return;
				}
				default: {
					// Incase the user enters an invalid number
					System.out.println();	System.out.println();
					// It was either this or "The system is down" but this is more descriptive
					System.out.println("Gomen asi, but enter a valid number, onegai!");
					System.out.println();	System.out.println();
				}
			} // End switch
		} // End for loop
	}
}
