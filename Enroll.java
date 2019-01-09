
class Enroll {
	
	int stid,
		coursenum,
		year;
	String semester;
	long recordnum;
	
	
	public Enroll (int sid, int cnum, int yr, String semet) 
	{
		
		stid = sid;
		coursenum = cnum;
		year = yr;
		semester = semet;
		
	}
	
	public Enroll (int sid, int cnum, int yr, String semet, long record) 
	{
		
		stid = sid;
		coursenum = cnum;
		year = yr;
		semester = semet;
		recordnum = record;
	}
	
	public void setstid(int id)
	{
		stid = id;
	}
	
	public int getstid()
	{
		return stid;
	}
	
	public void setcnum(int cnum)
	{
		coursenum = cnum;
	}
	
	public int getcnum ()
	{
		return coursenum;
	}
	
	public void setyear(int yr)
	{
		year = yr;
	}
	
	public int getyear()
	{
		return year;
	}
	
	public void setsemester(String semet)
	{
		semester = semet;
	}
	
	public String getsemester()
	{
		return semester;
	}

	public void displayEnrollment()
	{
		System.out.println("Student ID: ");
		System.out.println(stid);
		System.out.println("Course Number: ");
		System.out.println(coursenum);
		System.out.println("Semester: ");
		System.out.println(semester);
		System.out.println("Year: ");
		System.out.println(year);
	}
	
	public void setRecord(long record) {
		
		recordnum = record;
	}
	
	public long getRecord()
	{
		return recordnum;
	}
	
}