package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementSystem
{
	Scanner scan = new Scanner(System.in);

	HashMap<String, Student> db = new HashMap<String, Student>();

	@Override
	public void addStudent() 
	{
		// logic for adding student record into DB

		System.out.println("Enter Id, Name, Age, Marks");
		String id = scan.next();
		String name = scan.next();
		int age = scan.nextInt();
		int marks = scan.nextInt();

		Student std = new Student(id, name, age, marks);
		db.put(std.getId(), std);
		//db.put(std.getId(), new Student(id, name, age, marks));
		//db.put(std.getId(), new Student(scan.next(), scan.next(), 
		//scan.nextInt(), scan.nextInt()));

		System.out.println("STUDENT RECORD ADDED SUCCESSFULLY");
	}

	@Override
	public void updateStudent() 
	{
		// logic for updating student record from DB
		System.out.println("Enter Student Id");
		String id = scan.next();

		if(db.containsKey(id))
		{
			Student std = db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter Name");
				String name = scan.next();
				std.setName(name);
				break;

			case 2:
				System.out.println("Enter Age");
				int age = scan.nextInt();
				std.setAge(age);
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks = scan.nextInt();
				std.setMarks(marks);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
		else
		{
			System.out.println("Id is Invalid");
		}

	}

	@Override
	public void deleteStudent() 
	{
		// logic for deleting student record from DB		

		System.out.println("Enter Student id");
		String id = scan.next();

		if(db.containsKey(id))
		{
			System.out.println("Student record Present");
			db.remove(id);
			System.out.println("Student Record Deleted");
		}
		else
		{
			System.out.println("Student record not Present");
		}
	}

	@Override
	public void deleteAllStudents() 
	{
		// logic for deleting all the student records from DB	
		db.clear();
		System.out.println("All Student Record Deleted");
	}

	@Override
	public void displayStudent() {
		// logic for displaying one student record from DB			

		System.out.println("Enter Student id");
		String id = scan.next();

		if(db.containsKey(id))
		{
			System.out.println("Student Record Available");

			Student std = db.get(id);

			System.out.println("Student Details");
			System.out.println("Id : "+std.getId()); 
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("------------------------------");
		}
		else {
			System.out.println("Student Record Not Available");
		}
	}

	@Override
	public void displayAllStudents() 
	{
		Set<String> s = db.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext())
		{
			String id = i.next();
			Student std = db.get(id);
			System.out.println("Student Details");
			System.out.println("Id : "+std.getId()); 
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("------------------------------");
		}
	}

	@Override
	public void sortStudent()
	{
		// logic for sorting all the student records from DB	
		ArrayList<Student> l = new ArrayList<Student>();
		Set<String> s = db.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext())
		{
			String id = i.next();
			Student std = db.get(id);
			l.add(std);
		}

		System.out.println("Sort Student");
		System.out.println("1:By Id\n2:By Name\n3:By Age\n4:By Marks");
		System.out.println("Enter Choice");
		int choice = scan.nextInt();

		switch(choice)
		{
		case 1:
			System.out.println("Sorting based on ID");
			Collections.sort(l, new SortStudentById());
			for(Student s1 : l)
			{
				System.out.println(s1);
			}
			break;

		case 2:
			System.out.println("Sorting based on NAME");
			Collections.sort(l, new SortStudentByName());
			for(Student s1 : l)
			{
				System.out.println(s1);
			}
			break;

		case 3:
			System.out.println("Sorting based on AGE");
			Collections.sort(l, new SortStudentByAge());
			for(Student s1 : l)
			{
				System.out.println(s1);
			}
			break;

		case 4:
			System.out.println("Sorting based on MARKS");
			Collections.sort(l, new SortStudentByMarks());
			for(Student s1 : l)
			{
				System.out.println(s1);
			}
			break;

		default:
			System.out.println("Invalid Choice");
		}
	}
}












