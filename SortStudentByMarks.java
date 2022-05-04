package com;
import java.util.Comparator;
public class SortStudentByMarks implements Comparator<Student>
{
	@Override
	public int compare(Student x, Student y)
	{
		return x.getMarks() - y.getMarks();
	}
}
