package com;
import java.util.Comparator;
public class SortStudentByAge implements Comparator<Student>{
	@Override
	public int compare(Student x, Student y)
	{
		return x.getAge() - y.getAge();
	}
}
