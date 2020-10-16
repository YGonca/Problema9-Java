package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter department's name: ");
		String depName = sc.nextLine();
		System.out.println("\nEnter worker's data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(depName));
		
		System.out.print("How many contracts to this worker? ");
		int numCont = sc.nextInt();
		for(int i=1; i <= numCont; i++) {
			System.out.println("\nEnter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			worker.addContract(new HourContract(date, valuePerHour, hours));
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String yearAndMonth = sc.next();
		int year = Integer.parseInt(yearAndMonth.substring(3));
		int month = Integer.parseInt(yearAndMonth.substring(1, 2));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + yearAndMonth + ": " + worker.income(year, month));
		
		sc.close();
	}
}
