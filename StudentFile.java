import java.util.*;
import java.io.*;

class StudentFile {
	private final int RECORD_SIZE = 244;
	
	RandomAccessFile studentfile;  
	
	public StudentFile(String filename) throws IOException
	
	{
		
		studentfile = new RandomAccessFile(filename, "rw");
		
	}
	
	
	public void writeStudent(Student stud) throws IOException
	{
		String name = stud.getName();
		String address = stud.getAddress();
		String city = stud.getCity();
		String state = stud.getState();
		int stid = stud.getID();
		
		
		if (name.length() > 40)
			
		{
		
		for (int x = 0; x < 40; x++ ) 
		{
			studentfile.writeChar(name.charAt(x)); 
			
		}
		
		}
		
		else if (name.length() == 40)
		{
			studentfile.writeChars(name);
		}
		
		
		else 
			
		{
			studentfile.writeChars(name);
			for (int i = 0; i < (40 - name.length()); i++)
			{
				studentfile.writeChar(' ');
			}
			
		}
		// end of name 
		

		if (address.length() > 40)
			
		{
		
		for (int x = 0; x < 40; x++ ) 
		{
			studentfile.writeChar(address.charAt(x)); 
			
		}
		
		}
		
		else if (address.length() == 40)
		{
			studentfile.writeChars(address);
		}
		
		
		else 
			
		{
			studentfile.writeChars(address);
			for (int i = 0; i < (40 - address.length()); i++)
			{
				studentfile.writeChar(' ');
			}
			
		}
		
// city
		if (city.length() > 20)
			
		{
		
		for (int x = 0; x < 20; x++ ) 
		{
			studentfile.writeChar(city.charAt(x)); 
			
		}
		
		}
		
		else if (city.length() == 20)
		{
			studentfile.writeChars(city);
		}
		
		
		else 
			
		{
			studentfile.writeChars(city);
			for (int i = 0; i < (20 - city.length()); i++)
			{
				studentfile.writeChar(' ');
			}
			
		}
		
	// state 	
		

		if (state.length() > 20)
			
		{
		
		for (int x = 0; x < 20; x++ ) 
		{
			studentfile.writeChar(state.charAt(x)); 
			
		}
		
		}
		
		else if (state.length() == 20)
		{
			studentfile.writeChars(state);
		}
		
		
		else 
			
		{
			studentfile.writeChars(state);
			for (int i = 0; i < (20 - state.length()); i++)
			{
				studentfile.writeChar(' ');
			}
			
		}
		
		// end of state
	
		
		studentfile.writeInt(stid);
		
			// end of writestudent 
	}
	

	public Student readStudent() throws IOException 
	{
		char [] namearray = new char[40];
		char [] addressarray = new char[40];
		char [] cityarray = new char[20];
		char [] statearray = new char[20];
		int id;
		
		for (int x = 0; x < 40; x++)
		{

			
			namearray[x] = studentfile.readChar();
		}
		
		for (int x = 0; x < 40; x++)
		{
			addressarray[x] = studentfile.readChar();
		}
		
		for (int x = 0; x < 20; x++)
		{
			cityarray[x] = studentfile.readChar();
		}
		for (int x = 0; x < 20; x++)
		{
			statearray[x] = studentfile.readChar();
		}
		
		id = studentfile.readInt();
		
		String nm = new String(namearray);
		nm = nm.trim();		
		String adr = new String(addressarray);
		adr = adr.trim();
		String ct = new String(cityarray);
		ct = ct.trim();
		String st = new String(statearray);
		st = st.trim();
		
		return new Student(nm, adr, ct, st, id);
		
		// end of read student
	}
			 
	// end of read student
	
	private long getByteNum (long recordNum)
	{

		return RECORD_SIZE * recordNum;
	}
	 
	public void moveFilePointer(long recordNum) throws IOException
	{
		studentfile.seek(getByteNum(recordNum));
	}
	
	
	public long getRecords() throws IOException 
	{
		return studentfile.length() / RECORD_SIZE;
	}
	
	public void close() throws IOException
	{
		studentfile.close();
	}
	
	public boolean checkID(int id) throws IOException 
	{
		boolean match = false;
		for (int x = 240; x < studentfile.length(); x += 240)
		{
			int stid = studentfile.readInt();
			System.out.println(stid);
			if (stid == id) 
			{
				System.out.println("They are equal!");
				match = true;
			}
		}
		return match;
		
	}
	
	public ArrayList findMatches(long numrecords, int studentid) throws Exception
	{
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (long r = 0; r < numrecords; r++)
		{
			char [] namearray = new char[40];
			char [] addressarray = new char[40];
			char [] cityarray = new char[20];
			char [] statearray = new char[20];
			int id;
			
			for (int x = 0; x < 40; x++)
			{

				
				namearray[x] = studentfile.readChar();
			}
			
			for (int x = 0; x < 40; x++)
			{
				addressarray[x] = studentfile.readChar();
			}
			
			for (int x = 0; x < 20; x++)
			{
				cityarray[x] = studentfile.readChar();
			}
			for (int x = 0; x < 20; x++)
			{
				statearray[x] = studentfile.readChar();
			}
			
			id = studentfile.readInt();
			
			String nm = new String(namearray);
			nm = nm.trim();		
			String adr = new String(addressarray);
			adr = adr.trim();
			String ct = new String(cityarray);
			ct = ct.trim();
			String st = new String(statearray);
			st = st.trim();
			
			if (studentid == id)
			{
			long recordnum = r + 1;
			Student student = new Student(nm, adr, ct, st, id, recordnum);
			students.add(student);
			}
		}
		
		if (students.isEmpty())
		{
			throw new Exception("STUDENT ID DOES NOT EXIST");
		}
		
		
		return new ArrayList<Student>(students);
	}
	
	
	public ArrayList noMatches(long numrecords, int studentid) throws Exception
	{
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (long r = 0; r < numrecords; r++)
		{
			char [] namearray = new char[40];
			char [] addressarray = new char[40];
			char [] cityarray = new char[20];
			char [] statearray = new char[20];
			int id;
			
			for (int x = 0; x < 40; x++)
			{

				
				namearray[x] = studentfile.readChar();
			}
			
			for (int x = 0; x < 40; x++)
			{
				addressarray[x] = studentfile.readChar();
			}
			
			for (int x = 0; x < 20; x++)
			{
				cityarray[x] = studentfile.readChar();
			}
			for (int x = 0; x < 20; x++)
			{
				statearray[x] = studentfile.readChar();
			}
			
			id = studentfile.readInt();
			
			String nm = new String(namearray);
			nm = nm.trim();		
			String adr = new String(addressarray);
			adr = adr.trim();
			String ct = new String(cityarray);
			ct = ct.trim();
			String st = new String(statearray);
			st = st.trim();
			
			if (studentid == id)
			{
			long recordnum = r + 1;
			Student student = new Student(nm, adr, ct, st, id, recordnum);
			students.add(student);
			}
		}
		
		
		return new ArrayList<Student>(students);
	}
	
	
// end of class
}