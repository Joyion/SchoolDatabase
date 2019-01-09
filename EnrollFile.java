import java.util.*;
import java.io.*;

class EnrollFile {
	private final int RECORD_SIZE = 92;
	
	RandomAccessFile enrollfile;
	
	public EnrollFile(String filename) throws Exception
	{
		enrollfile = new RandomAccessFile(filename, "rw");
	}
	
	public void writeEnroll(Enroll course) throws Exception
	{
		int stid = course.getstid();
		int cnum = course.getcnum();
		int yr = course.getyear();
		String semester = course.getsemester();
		
		enrollfile.writeInt(stid);
		enrollfile.writeInt(cnum);
		enrollfile.writeInt(yr);
		
	if (semester.length() > 40)
			
		{
		
		for (int x = 0; x < 40; x++ ) 
		{
			enrollfile.writeChar(semester.charAt(x)); 
			
		}
		
		}
		
		else if (semester.length() == 40)
		{
			enrollfile.writeChars(semester);
		}
		
		
		else 
			
		{
			enrollfile.writeChars(semester);
			for (int i = 0; i < (40 - semester.length()); i++)
			{
				enrollfile.writeChar(' ');
			}
			
		// end of write method
			
		}
	}
	
	
	public Enroll readEnroll() throws Exception 
	{
		int stid,
		cnum,
		yr;
		String semester;
		
		stid = enrollfile.readInt();
		cnum = enrollfile.readInt();
		yr = enrollfile.readInt();
		char [] semetarray = new char [40];
		
		for (int x = 0; x < 40; x++)
		{
			semetarray[x] = enrollfile.readChar();
		}
		
		semester = new String(semetarray);
		semester = semester.trim();
		
		
		return new Enroll(stid, cnum, yr, semester);
		// end of read method
	}
	
	private long getByteNum (long recordnum)
	{
		return RECORD_SIZE * recordnum;
	}

	public void moveFilePointer(long recordnum) throws Exception
	{
		enrollfile.seek(getByteNum(recordnum));
	}
	
	public long getRecords() throws Exception
	{
		return enrollfile.length() / RECORD_SIZE;
	}
		
	public void close() throws Exception
	{
		enrollfile.close();
	}
	
	public ArrayList findMatches(long recordnums, int id, int coursenum, int year, String semet) throws Exception 
	{
		ArrayList <Enroll> enrolls = new ArrayList <Enroll>();
		
		for(int r = 0; r < recordnums; r++)
		{
			int stid,
			cnum,
			yr;
			String semester;
			long record;
			
			stid = enrollfile.readInt();
			cnum = enrollfile.readInt();
			yr = enrollfile.readInt();
			char [] semetarray = new char [40];
			
			for (int x = 0; x < 40; x++)
			{
				semetarray[x] = enrollfile.readChar();
			}
			
			semester = new String(semetarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			record = r+1;
			
			if (stid == id && cnum == coursenum && year == yr && semester.equals(semet))
			{
			Enroll enrollee =  new Enroll(stid, cnum, yr, semester, record);
			
			enrolls.add(enrollee);
			}
		
		}
		
		if (enrolls.isEmpty())
		{
			throw new Exception("Enrollment doesn't exist. Please try again");
		}
		
		return new ArrayList<Enroll>(enrolls);
		
	}
	
	public ArrayList noMatches(long recordnums, int id, int coursenum, int year, String semet) throws Exception
	{
		ArrayList <Enroll> enrolls = new ArrayList <Enroll>();
		
		for(long r = 0; r < recordnums; r++)
		{
			int stid,
			cnum,
			yr;
			String semester;
			long record;
			
			stid = enrollfile.readInt();
			cnum = enrollfile.readInt();
			yr = enrollfile.readInt();
			char [] semetarray = new char [40];
			
			for (int x = 0; x < 40; x++)
			{
				semetarray[x] = enrollfile.readChar();
			}
			
			semester = new String(semetarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			record = r+1;
			
			if (stid == id && cnum == coursenum && year == yr && semester.equals(semet))
			{
			Enroll enrollee =  new Enroll(stid, cnum, yr, semester, record);
			
			enrolls.add(enrollee);
			}
		
		}
		
		return new ArrayList<Enroll>(enrolls);
		
	}
	
	public ArrayList findMatches(long recordnums, int id, int coursenumber) throws Exception 
	{
		ArrayList <Enroll> enrolls = new ArrayList <Enroll>();
		
		for(int r = 0; r < recordnums; r++)
		{
			int stid,
			cnum,
			yr;
			String semester;
			long record;
			
			stid = enrollfile.readInt();
			cnum = enrollfile.readInt();
			yr = enrollfile.readInt();
			char [] semetarray = new char [40];
			
			for (int x = 0; x < 40; x++)
			{
				semetarray[x] = enrollfile.readChar();
			}
			
			semester = new String(semetarray);
			semester = semester.trim();
			semester = semester.toUpperCase();
			
			record = r+1;
			
			if (stid == id && cnum == coursenumber)
			{
			Enroll enrollee =  new Enroll(stid, cnum, yr, semester, record);
			
			enrolls.add(enrollee);
			}
		
		}
		
		if (enrolls.isEmpty())
		{
			throw new Exception("Enrollment doesn't exist. Please try again");
		}
		
		return new ArrayList<Enroll>(enrolls);
		
	}
	
	
		
		
		// end of class
	

}