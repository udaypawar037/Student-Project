package com;

import java.util.Scanner;

public class Registration 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 

		StudentManagementSystem sms = new StudentManagementSystemImpl();
		
		System.out.println("Welcome to Student Database Management System");
		System.out.println("---------------------------------------------");

		while(true)
		{
			System.out.println("1:Add Student\n2:Update Student");
			System.out.println("3:Delete Student\n4:Delete All Students");
			System.out.println("5:Display Student\n6:Display All Students");
			System.out.println("7:Sort Students\n8:Exit");

			System.out.println("Enter your Choice:");
			int choice = scan.nextInt();

			switch(choice)
			{
			case 1 : 
				System.out.println("Adding Student");
				sms.addStudent();
				break;

			case 2 : 
				System.out.println("Update Student");
				sms.updateStudent();
				break;

			case 3 : 
				System.out.println("Delete Student");
				sms.deleteStudent();
				break;

			case 4 : 
				System.out.println("Delete All Students");
				sms.deleteAllStudents();
				break;

			case 5 : 
				System.out.println("Display Student");
				sms.displayStudent();
				break;

			case 6 : 
				System.out.println("Display All Students");
				sms.displayAllStudents();
				break;

			case 7 : 
				System.out.println("Sort Students");
				sms.sortStudent();
				break;
				
			case 8 : 
				System.out.println("THANK YOU!!!!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("---------------------------------------------");
		}
	}
}
