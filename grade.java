
class grade {

int stid,
	cnum,
	yr;
String semester;
char grade;
long recordnum;
	
	public grade(int id, int coursenum, int year, String semet, char gr) 
	
	{
	stid = id;
	cnum = coursenum;
	yr = year;
	semester = semet;
	grade = gr;

	}
	
	public grade(int id, int coursenum, int year, String semet, char gr, long record) 
	
	{
	stid = id;
	cnum = coursenum;
	yr = year;
	semester = semet;
	grade = gr;
	recordnum = record;

	}
	
	public void  setid(int id)
	{
		stid = id;
	}
	
	public int getid()
	{
		return stid;
	}
	
	public void setcnum(int coursenum)
	{
		cnum = coursenum;
	}
	
	public int getcnum()
	{
		return cnum;
	}

	public void setyear(int year)
	{
		yr = year;
	}
	
	public int getyear()
	{
		return yr;
	}
	
	public void setsemester(String semest)
	{
		semester = semest;
	}
	
	public String getsemester()
	{
		return semester;
	}
	
	public void setgrade(char gr)
	{
		grade = gr;
	}
	
	public char getgrade()
	{
		return grade;
	}
	
	public void gradeDisplay()
	{
		System.out.println("Course Number: ");
		System.out.println(cnum);
		System.out.println("Semester: ");
		System.out.println(semester);
		System.out.println("Year: ");
		System.out.println(yr);
		System.out.println("Grade: ");
		System.out.println(grade);
	}
	
	public void setRecord(long record)
	{
		recordnum = record;
	}
	
	public long getRecord()
	{
		return recordnum;
	}
}