import java.util.*;
import java.io.*;

class CourseFile {

	private final int RECORD_SIZE = 324;
	
	RandomAccessFile coursefile;
	
	// make file constructor 
	
	public CourseFile(String filename) throws Exception
	{
		coursefile = new RandomAccessFile(filename, "rw");
	}

	public void writeCourse(Course cours) throws Exception
	{
		String cid = cours.getcid();
		String cname = cours.getcname();
		String prof = cours.getprof();
		String dpt = cours.getdpt();
		int cnum = cours.getcnum();
		
		if (cid.length() > 40)
		{
			for (int x = 0; x < 40; x++)
			{
				coursefile.writeChar(cid.charAt(x));
			}
		}
		
		else if (cid.length() == 40)
		{
			coursefile.writeChars(cid);
		}
		
		else 
		{
			coursefile.writeChars(cid);
			for (int i = 0; i < (40 - cid.length()); i++)
			{
				coursefile.writeChar(' ');
			}
		}
		// end of cid 
		
		if (cname.length() > 40)
		{
			for (int x = 0; x < 40; x++)
			{
				coursefile.writeChar(cname.charAt(x));
			}
		}
		
		else if (cname.length() == 40)
		{
			coursefile.writeChars(cname);
		}
		
		else 
		{
			coursefile.writeChars(cname);
			for (int i = 0; i < (40 - cname.length()); i++)
			{
				coursefile.writeChar(' ');
			}
		}
		// end of cname write
		
		if (prof.length() > 40)
		{
			for (int x = 0; x < 40; x++)
			{
				coursefile.writeChar(prof.charAt(x));
			}
		}
		
		else if (prof.length() == 40)
		{
			coursefile.writeChars(prof);
		}
		
		else 
		{
			coursefile.writeChars(prof);
			for (int i = 0; i < (40 - prof.length()); i++)
			{
				coursefile.writeChar(' ');
			}
		}
		
		// end of prof 
		
		if (dpt.length() > 40)
		{
			for (int x = 0; x < 40; x++)
			{
				coursefile.writeChar(dpt.charAt(x));
			}
		}
		
		else if (dpt.length() == 40)
		{
			coursefile.writeChars(dpt);
		}
		
		else 
		{
			coursefile.writeChars(dpt);
			for (int i = 0; i < (40 - dpt.length()); i++)
			{
				coursefile.writeChar(' ');
			}
		}
		
		// end of dpt write
		
		coursefile.writeInt(cnum);
		
		
	// end of write course file
	}
	
	public Course readCourse() throws Exception
	{
		char [] cidarray = new char[40];
		char [] cnamearray = new char[40];
		char [] profarray = new char [40];
		char [] dptarray = new char [40];
		int cnum;
		
		for (int x = 0; x < 40; x++)
		{
			cidarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			cnamearray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			profarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			dptarray[x] = coursefile.readChar();
		}
		
		cnum = coursefile.read();
		
		String cid = new String(cidarray);
		cid = cid.trim();
		String cname = new String(cnamearray);
		cname = cname.trim();
		String prof = new String(profarray);
		prof = prof.trim();
		String dpt = new String(dptarray);
		dpt = dpt.trim();
		
		
		return new Course(cid, cname, prof, dpt, cnum);
		// read course 
	}

	private long getByteNum(long recordNum)
	{
		return RECORD_SIZE * recordNum;
	}
	
	public void moveFilePointer(long recordNum) throws Exception
	{
		coursefile.seek(getByteNum(recordNum));
	}
	
	public long getRecords() throws Exception
	{
		return coursefile.length() / RECORD_SIZE;
	}
	
	public void close() throws Exception
	{
		coursefile.close();
	}
	
	public ArrayList findMatches(long numrecords, int coursenumber) throws Exception
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		
		for (long r = 0; r < numrecords; r++)
		{
		char [] cidarray = new char[40];
		char [] cnamearray = new char[40];
		char [] profarray = new char [40];
		char [] dptarray = new char [40];
		int cnum;
		long recordnum;
		
		for (int x = 0; x < 40; x++)
		{
			cidarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			cnamearray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			profarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			dptarray[x] = coursefile.readChar();
		}
		
		cnum = coursefile.readInt();
		
		String cid = new String(cidarray);
		cid = cid.trim();
		String cname = new String(cnamearray);
		cname = cname.trim();
		String prof = new String(profarray);
		prof = prof.trim();
		String dpt = new String(dptarray);
		dpt = dpt.trim();
		recordnum = r+1;
	//	System.out.println("Cnum: " + cnum);
		
		if (coursenumber == cnum)
		{
		
		Course course = new Course(cid, cname, prof, dpt, cnum, recordnum);
		courses.add(course);
		}
		
		}
		
		if (courses.isEmpty())
		{
			throw new Exception("Course Number does not exist");
		}
		
		
		return new ArrayList<Course>(courses);
	}
	
	
	public ArrayList noMatches(long numrecords, int coursenumber) throws Exception
	{
	ArrayList<Course> courses = new ArrayList<Course>();
		
		for (long r = 0; r < numrecords; r++)
		{
		char [] cidarray = new char[40];
		char [] cnamearray = new char[40];
		char [] profarray = new char [40];
		char [] dptarray = new char [40];
		int cnum;
		long recordnum;
		
		for (int x = 0; x < 40; x++)
		{
			cidarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			cnamearray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			profarray[x] = coursefile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			dptarray[x] = coursefile.readChar();
		}
		
		cnum = coursefile.readInt();
		
		String cid = new String(cidarray);
		cid = cid.trim();
		String cname = new String(cnamearray);
		cname = cname.trim();
		String prof = new String(profarray);
		prof = prof.trim();
		String dpt = new String(dptarray);
		dpt = dpt.trim();
		recordnum = r+1;
		
		if (coursenumber == cnum)
		{
		
		Course course = new Course(cid, cname, prof, dpt, cnum, recordnum);
		courses.add(course);
		}
		
		}
		
		
		return new ArrayList<Course>(courses);
		
		
		
	}
	
}