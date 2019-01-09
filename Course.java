import java.io.*;

class Course {
	
	String cid,
	cname,
	prof,
	dpt;
int cnum;
long recordnum;


// constructor
	
	public Course(String courseid, String coursename, String teacher, String department, int coursenum )
	{
		cid = courseid;
		cname = coursename;
		prof = teacher;
		dpt = department;
		cnum = coursenum;

	}	
	
	public Course(String courseid, String coursename, String teacher, String department, int coursenum, long record )
	{
		cid = courseid;
		cname = coursename;
		prof = teacher;
		dpt = department;
		cnum = coursenum;
		recordnum = record;
	}	
	
// constructor 
	
	public void setcid (String courseid)
	{
		cid = courseid;
	}
	
	public String getcid ()
	{
		return cid;
	}
	
	public void setcname (String coursename)
	{
		cname = coursename;
	}
	
	public String getcname ()
	{
		return cname;
	}
	
	public void setprof(String teacher)
	{
		prof = teacher;
	}
	
	public String getprof()
	{
		return prof;
	}
	
	public void setdpt(String department)
	{
		dpt = department;
	}
	
	public String getdpt()
	{
		return dpt;
	}
	
	public void setcnum(int coursenum)
	{
		cnum = coursenum;
	}
	
	public int getcnum()
	{
		return cnum;
	}
	
	public void courseDisplay() 
	{
		System.out.println("Course ID: ");
		System.out.println(cid);
		System.out.println("Course Name: ");
		System.out.println(cname);
		System.out.println("Professor: ");
		System.out.println(prof);
		System.out.println("Department: ");
		System.out.println(dpt);
		System.out.println("Course Number: ");
		System.out.println(cnum);
		
	}
	
	public void setRecord(long record)
	{
		recordnum = record;
	}
	
	public long getRecord() 
	{
		return recordnum;
	}
	
	// end of class
}
