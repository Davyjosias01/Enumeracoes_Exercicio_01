package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		System.out.print("Enter department's name: ");
			Department dep = new Department(sc.next());
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
			String name = sc.next();
		System.out.print("Level: ");
			String aux = sc.next();
			WorkerLevel level = WorkerLevel.valueOf(aux);  
		System.out.print("Base salary: ");
			Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, level, baseSalary, dep);
		
		
		System.out.print("How many contracts to this worker? ");
			int cont = sc.nextInt();
		
		for (int i=1; i<=cont; i++) {
			System.out.println("Enter contract #" + i +" data: ");
			
			System.out.print("Date (DD/MM/YYYY): ");
				Date contDate = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
				Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
				Integer duration = sc.nextInt();
				
			HourContract contract = new HourContract(contDate, valuePerHour, duration);
				worker.addContract(contract);	
		}
		
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = sc.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
			
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDep().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
		
}
