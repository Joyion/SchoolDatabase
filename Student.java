import java.util.*;


class Student {
	
	String  name,
	address,
	city,
	state;
int stid;
long recordnum = 0;

public Student () 

{
	name = " ";
	address = " ";
	city = " ";
	state = " ";
	stid = 0;
	
	
}

public Student (String nm, String adr, String town, String st, int id)
{
	name = nm;

	address = adr;

	city = town;

	state = st;

	stid = id;

// end of constructor	
}	

public Student (String nm, String adr, String town, String st, int id, long record)
{
	name = nm;

	address = adr;

	city = town;

	state = st;

	stid = id;
	
	recordnum = record;

// end of constructor	
}	
	

public void setName (String nm)
{
	
	name = nm;
}

public String getName ()
{
	
	return name;
}

public void setAddress (String addr)
{
	
	address = addr;
	
}

public String getAddress()
{
	return address;
}

public void setCity(String town)
{
	
	city = town;
}

public String getCity()
{
	return city;
}

public void setState (String st)
{
	
	state = st;
}
	
public String getState()
{
	return state;
}

public void setID (int id)
{
	
	stid = id;
}
	
public int getID ()
{
	return stid;
}

public void setRecordnum (long record)
{
	recordnum = record;
}

public long getRecordnum ()
{
	return recordnum;
}

public void studentDisplay()
{
	System.out.println("Student ID: ");
	System.out.println(stid);
	System.out.println("Student Name: ");
	System.out.println(name);
	System.out.println("Address: ");
	System.out.println(address);
	System.out.println("City: ");
	System.out.println(city);
	System.out.println("State: ");
	System.out.println(state);
	
}
	
	
	
	
	
	
// end of class
}
