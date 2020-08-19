/*
  Filename:  EmployeePayment.java
  By:  Matthew Evans
  
  The new and improved EmployeePayment class v2.0
  ok, so it's not that improved... it's the same thing
  minus the main class
*/

public class EmployeePayment {
	// Stores the amount of each type of worker
	private int numManager;
	private int numHourlyWorker;
	private int numCommWorker;
	private int numPieceWorker;
	
	// Stores the weekly pay of a manager
	private double weeklyManagerPay;
	
	public EmployeePayment() {
		setManagerPay(625.00);
		
		numManager = 0;
		numHourlyWorker = 0;
		numCommWorker = 0;
		numPieceWorker = 0;
	}
	
	// Method to increase the number of paid managers
	public void incManagers() {
		++numManager;
	}
	
	// Method to increase the number of paid hourly workers
	public void incHourlyWorkers() {
		++numHourlyWorker;
	}
	
	// Method to increase the number of commission workers
	public void incCommWorkers() {
		++numCommWorker;
	}
	
	// Method to increase the number of piece workers
	public void incPieceWorkers() {
		++numPieceWorker;
	}
	
	//  Method to return the number of managers
	public int getManagers() {
		return numManager;
	}
	
	// Method to return the number of hourly workers
	public int getHourlyWorkers() {
		return numHourlyWorker;
	}
	
	// Method to return the number of commission workers
	public int getCommWorkers() {
		return numCommWorker;
	}
	
	// Method to return the number of piece workers
	public int getPieceWorkers() {
		return numPieceWorker;
	}

	// Method to return the manager's pay
	public double getManagerPay() {
		return weeklyManagerPay;
	}
	
	// Method to set the manager's pay
	public void setManagerPay(double pay) {
		weeklyManagerPay = pay;
	}
	
	// Method to calculate the manager's pay
	public double calcManagerPay() {
		return weeklyManagerPay;
	}
	
	// Method to calculate the hourly worker pay
	public double calcHourlyWorkerPay(double salary, int hrsWorked) {
		if(hrsWorked <= 40)
			return (salary * hrsWorked);
		return (((salary * 1.5) * (hrsWorked - 40)) + (salary * 40));
	}
	
	// Method to calculate the commission worker pay
	public double calcCommWorkerPay(double grossSales) {
		return ((grossSales * .057) + 250.00);
	}
	
	// Method to calculate the piece worker pay
	public double calcPieceWorkerPay(double wage, int pieces) {
		return (wage * pieces);
	}
}
