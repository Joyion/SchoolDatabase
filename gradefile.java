import java.util.*;
import java.io.*;

class gradefile {
	private final int RECORD_SIZE = 94;
	RandomAccessFile grdfile;
	
	
	public gradefile (String filename) throws Exception
	
	{
	
	grdfile = new RandomAccessFile(filename, "rw");

	}
	
	public void writeGrade(grade grades) throws Exception 
	{
		int stid = grades.getid();
		int cnum = grades.getcnum();
		int yr = grades.getyear();
	String semester = grades.getsemester();
	char grade = grades.getgrade();
	
	grdfile.writeInt(stid);
	grdfile.writeInt(cnum);
	grdfile.writeInt(yr);
	
	if (semester.length() > 40)
	{
	
		for (int x = 0; x < 40; x++)
		{
		grdfile.writeChar(semester.charAt(x));
		}
	}	

	else if (semester.length() == 40)
	{
		grdfile.writeChars(semester);
	}
	
	else 
	{
		grdfile.writeChars(semester);
		for (int i = 0; i < (40 - semester.length()); i++)
		{
			grdfile.writeChar(' ');
		}
	}
	
	grdfile.writeChar(grade);
	

	// end of write method	
	}
	
	public grade readgrade() throws Exception
	{
		int stid = grdfile.readInt();
		int cnum = grdfile.readInt();
		int yr = grdfile.readInt();
		char [] semesterarray = new char [40];
		for (int x = 0; x < 40; x++)
		{
			semesterarray[x] = grdfile.readChar();
		}
		
		String semester = new String(semesterarray);
		semester = semester.trim();
		
		char grade = grdfile.readChar();
		
		return new grade(stid, cnum, yr, semester, grade);
	}
	
	private long getByteNum (long recordNum)
	{

		return RECORD_SIZE * recordNum;
	}
	
	public void moveFilePointer(long recordNum) throws IOException
	{
		grdfile.seek(getByteNum(recordNum));
	}
	
	
	public long getRecords() throws IOException 
	{
		return grdfile.length() / RECORD_SIZE;
	}
	
	public void close() throws IOException
	{
		grdfile.close();
	}
	
	public ArrayList findMatches(long recordnums, int id, int coursenum, int year, String semet) throws Exception
	{
		ArrayList<grade> grades = new ArrayList<grade>();
		
		for (long r = 0; r < recordnums; r++)
		{
			int stid = grdfile.readInt();
			int cnum = grdfile.readInt();
			int yr = grdfile.readInt();
			char [] semesterarray = new char [40];
			long record;
			
			for (int x = 0; x < 40; x++)
			{
				semesterarray[x] = grdfile.readChar();
			}
			
			String semester = new String(semesterarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			char grade = grdfile.readChar();
			record = r+1;
			
			if(stid == id && coursenum == cnum && yr == year && semester.equals(semet))
			{
			grade newgrade = new grade(stid, cnum, yr, semester, grade, record);
			grades.add(newgrade);
			}

			
		}
		
		if (grades.isEmpty())
		{
			throw new Exception ("A grade for this enrollment doesn't exist");
		}
		
		
		return new ArrayList<grade>(grades);
	}
	
	
	
	public ArrayList nodMatches(long recordnums, int id, int coursenum, int year, String semet) throws Exception
	{
		ArrayList<grade> grades = new ArrayList<grade>();
		
		for (long r = 0; r < recordnums; r++)
		{
			int stid = grdfile.readInt();
			int cnum = grdfile.readInt();
			int yr = grdfile.readInt();
			char [] semesterarray = new char [40];
			long record;
			
			for (int x = 0; x < 40; x++)
			{
				semesterarray[x] = grdfile.readChar();
			}
			
			String semester = new String(semesterarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			char grade = grdfile.readChar();
			record = r+1;
			
			if(stid == id && coursenum == cnum && yr == year && semester.equals(semet))
			{
			grade newgrade = new grade(stid, cnum, yr, semester, grade, record);
			grades.add(newgrade);
			}

			
		}
		
		return new ArrayList<grade>(grades);
	}
	
	
	public ArrayList findMatches(long recordnums, int coursenum, int year) throws Exception
	{
		ArrayList<grade> grades = new ArrayList<grade>();
		
		for (long r = 0; r < recordnums; r++)
		{
			int stid = grdfile.readInt();
			int cnum = grdfile.readInt();
			int yr = grdfile.readInt();
			char [] semesterarray = new char [40];
			long record;
			
			for (int x = 0; x < 40; x++)
			{
				semesterarray[x] = grdfile.readChar();
			}
			
			String semester = new String(semesterarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			char grade = grdfile.readChar();
			record = r+1;
			
			if(coursenum == cnum && yr == year)
			{
			grade newgrade = new grade(stid, cnum, yr, semester, grade, record);
			grades.add(newgrade);
			}

			
		}
		
		if (grades.isEmpty())
		{
			throw new Exception ("A grade for this enrollment doesn't exist");
		}
		
		
		return new ArrayList<grade>(grades);
	}

	
	// end of class
}

