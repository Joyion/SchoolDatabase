import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.event.*;
import java.util.*;
import java.io.*;



public class MainWindow extends JFrame {
	
	private final int WIDTH = 500;
	private final int HEIGHT = 350;
	
	private JMenuBar menuBar;
	
	private JMenu studmenu;
	private JMenu searchStud;
	private JMenu courses;
	private JMenu enrolls;
	private JMenu grades;
	private JMenu reports;
	private JRadioButtonMenuItem studsearchbutton;
	private JRadioButtonMenuItem studaddbutton;
	private JRadioButtonMenuItem courssearch;
	private JRadioButtonMenuItem coursadd;
	private JRadioButtonMenuItem enrollsearch;
	private JRadioButtonMenuItem enrolladd;
	private JRadioButtonMenuItem gradesearch;
	private JRadioButtonMenuItem gradeadd;
	private JRadioButtonMenuItem reportdisplay;
	
	ArrayList enrollobj;
	ArrayList enrollobj2;
	String[] enrollarray;
	ArrayList courseobj;
	ArrayList studobj;
	String[] studarray;
	
	ArrayList gradeobj;
	ArrayList gradeobj2;
	String[] gradearray;
	
	String[] reportarray;
	
	int index;
	int index1;
	
// studentpanel 1 data 	
	private JPanel studentPN;
	private JPanel student2PN;
	private JLabel studmsg1;
	private JButton studsearch;
	private JTextField studentid;
	private JLabel studmsg2;
	private JTextField studentid2;
	private JButton editstud;

	
	private JPanel studaddpnl;
	private JPanel studentPanelin;
	private JPanel studaddpnl2;
	private JPanel studbottompanel;
	
// data for studentpanel2 for add student 
	
	private JLabel studname;
	private JTextField name;
	private JLabel studaddress;
	private JTextField address;
	private JLabel studcity;
	private JTextField city;
	private JLabel studstate;
	private JTextField state;
	private JButton addstud;
	private JButton cancelstud;
	
	
// data for course panels 
	private JPanel coursemainpanel;
	private JPanel coursemainpanel2;
	private JPanel coursesearchpanel;
	private JPanel courseaddpanel;
	private JPanel coursebottompanel;
	
	private JLabel coursesearchlabel;
	private JTextField courseid1;
	private JButton coursesearchbt;
	
	
	private JLabel idcourse;
	private JTextField cid;
	private JLabel namecourse;
	private JTextField coursename;
	private JLabel profcourse;
	private JTextField proffesor;
	private JLabel numcourse;
	private JTextField cnum;
	private JLabel department;
	private JTextField departmentfield;
	
	private JButton addcourse;
	private JButton cancelcourse;
	private JButton addnewcourse;
	
	// enroll panel data
	
	private JPanel enrollmainpanel;
	private JPanel enrollmainpanel2;
	private JPanel enrolleditmainpanel;
	private JPanel enrollsearchpanel;
	private JPanel enrolladdpanel;
	private JPanel enrollbottompanel;
	private JPanel enrollfieldpanel;
	private JPanel innerenrollpanel;
	
	private JLabel stidenroll1;
	private JLabel cidenroll1;
	private JTextField studentidenroll;
	private JTextField courseidenroll;
	
	private JLabel stidenroll;
	private JTextField stidenrollfield;
	private JLabel cidenroll;
	private JTextField cidenrollfield;
	private JLabel yearenroll;
	private JTextField yrenrollfield;
	private JLabel semesterenroll;
	private JTextField semestenrollfield;
	private JList enrollist;
	
	private JButton addenroll;
	private JButton cancelenroll;
	private JButton searchenroll;
	private JButton editenroll;
	private JButton saveenroll;
	
	

	
	private JPanel grademainpanel1;
	private JPanel grademainpanel2;
	private JPanel gradesearchpanel;
	private JPanel gradeaddpanel;
	private JPanel gradebottompanel;
	private JPanel gradefieldpanel;
	private JPanel innergradepanel;
	
	private JLabel stidgrade1;
	private JLabel cidgrade1;
	private JLabel yrgrade1;
	private JLabel smgrade1;
	private JLabel grgrade1;
	private JTextField stidgradefield1;
	private JTextField cidgradefield1;
	private JTextField yrgradefield1;
	private JTextField smgradefield1;
	private JTextField gradefield1;
	
	
	private JLabel stidgrade2;
	private JLabel cidgrade2;
	private JLabel yrgrade2;
	private JLabel smgrade2;
	private JLabel grdgrade2;
	private JTextField stidgradefield2;
	private JTextField cidgradefield2;
	private JTextField yrgradefield2;
	private JTextField smgradefield2;
	private JTextField grdgradefield2;
	private JList gradelist;
	
	
	private JButton searchgrade;
	private JButton addgrade;
	private JButton cancelgrade;
	private JButton savegradebt;
	private JButton editgradebt;
	
	// report file data
	
	private JPanel reportmainpanel1;
	private JPanel reportmainpanel2;
	private JPanel reportsearchpanel;
	private JPanel reportlistpanel;
	
	private JLabel stidreport;
	private JTextField stidreportfield;
	private JLabel yrreport;
	private JTextField yrreportfield;
	private JList reportlist;
	
	
	private JButton searchreport;
	
	private JScrollPane scrollpane;
	

	public MainWindow()
	{
		setTitle("Lufkin High School Database");
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildMenuBar();
		studsearchbutton.doClick();
		setVisible(true);
		
	}
	
	public void buildStudentPN()
	{	
		studmsg1 = new JLabel("Student ID: ");
		studentid = new JTextField(10);
		studsearch = new JButton("Search");
		studsearch.addActionListener(new ButtonListen());
		
		studentPanelin = new JPanel();
		studentPanelin.add(studmsg1);
		studentPanelin.add(studentid);
		studentPanelin.add(studsearch);
		studentPN = new JPanel();
		
		studmsg2 = new JLabel("Student ID");
		studmsg2.setHorizontalAlignment(JLabel.CENTER);
		studentid2 = new JTextField(10);
		studentid2.setEditable(false);
		student2PN = new JPanel();
		studname = new JLabel("Name");
		studname.setHorizontalAlignment(JLabel.CENTER);
		name = new JTextField(40);
		name.setEditable(false);
		studaddress = new JLabel ("Address");
		studaddress.setHorizontalAlignment(JLabel.CENTER);
		address = new JTextField(40);
		address.setEditable(false);
		studcity = new JLabel ("City");
		studcity.setHorizontalAlignment(JLabel.CENTER);
		city = new JTextField(20);
		city.setEditable(false);
		studstate = new JLabel ("State");
		studstate.setHorizontalAlignment(JLabel.CENTER);
		state = new JTextField(20);
		state.setEditable(false);
		
		editstud = new JButton("Edit");
		cancelstud = new JButton("Cancel");
		editstud.addActionListener(new ButtonListen());
		cancelstud.addActionListener(new ButtonListen());
		
		 
			studaddpnl = new JPanel();
			studaddpnl.setLayout(new GridLayout(5,2));
			studbottompanel = new JPanel();
			studbottompanel.setLayout(new GridLayout(1,2));
			
			
			studaddpnl.add(studmsg2);
			studaddpnl.add(studentid2);
			studaddpnl.add(studname);
			studaddpnl.add(name);
			studaddpnl.add(studaddress);
			studaddpnl.add(address);
			studaddpnl.add(studcity);
			studaddpnl.add(city);
			studaddpnl.add(studstate);
			studaddpnl.add(state);
			
			studbottompanel.add(editstud);
			studbottompanel.add(cancelstud);
			
			studaddpnl.setVisible(false);
			studbottompanel.setVisible(false);
		
		studentPN.setLayout(new BorderLayout());
		studentPN.add(studentPanelin, BorderLayout.NORTH);
		studentPN.add(studaddpnl, BorderLayout.CENTER);
		studentPN.add(studbottompanel, BorderLayout.SOUTH);
		setContentPane(studentPN);
		validate();
			
	}
	
	public void buildStudent2PN()
	{
		studmsg2 = new JLabel("Student ID");
		studmsg2.setHorizontalAlignment(JLabel.CENTER);
		studentid2 = new JTextField(10);
		student2PN = new JPanel();
		studname = new JLabel("Name");
		studname.setHorizontalAlignment(JLabel.CENTER);
		name = new JTextField(40);
		 studaddress = new JLabel ("Address");
		 studaddress.setHorizontalAlignment(JLabel.CENTER);
		 address = new JTextField(40);
		 studcity = new JLabel ("City");
		 studcity.setHorizontalAlignment(JLabel.CENTER);
		 city = new JTextField(20);
		 studstate = new JLabel ("State");
		 studstate.setHorizontalAlignment(JLabel.CENTER);
		 state = new JTextField(20);
		 
		 addstud = new JButton("Add New Student");
		 addstud.addActionListener(new ButtonListen());
		 cancelstud = new JButton("Cancel");
		 cancelstud.addActionListener(new ButtonListen());
		
		studaddpnl = new JPanel();
		studaddpnl.setLayout(new GridLayout(5,2));
		studaddpnl2 = new JPanel();
		studaddpnl2.setLayout(new GridLayout(1,2));
		
		
		studaddpnl.add(studmsg2);
		studaddpnl.add(studentid2);
		studaddpnl.add(studname);
		studaddpnl.add(name);
		studaddpnl.add(studaddress);
		studaddpnl.add(address);
		studaddpnl.add(studcity);
		studaddpnl.add(city);
		studaddpnl.add(studstate);
		studaddpnl.add(state);
		
		studaddpnl2.add(addstud);
		studaddpnl2.add(cancelstud);
		
		student2PN.setLayout(new BorderLayout());
		
		
		student2PN.add(studaddpnl, BorderLayout.CENTER);
		student2PN.add(studaddpnl2, BorderLayout.SOUTH);
		setContentPane(student2PN);
		validate();
	}
	// course panels 1
	
	
	private void buildcoursepanel()
	{
		coursemainpanel = new JPanel();
		coursemainpanel.setLayout(new BorderLayout());
		
		coursesearchlabel = new JLabel("Course ID");
		courseid1 = new JTextField(10);
		coursesearchbt = new JButton("Search");
		coursesearchbt.addActionListener(new ButtonListen());
		
		idcourse = new JLabel("Course ID");
		idcourse.setHorizontalAlignment(JLabel.CENTER);
		cid = new JTextField(40);
		cid.setEditable(false);
		namecourse = new JLabel("Course Name");
		coursename = new JTextField(40);
		namecourse.setHorizontalAlignment(JLabel.CENTER);
		coursename.setEditable(false);
		profcourse =  new JLabel("Professor");
		proffesor = new JTextField(40);
		profcourse.setHorizontalAlignment(JLabel.CENTER);
		proffesor.setEditable(false);
		numcourse =  new JLabel("Course Number");
		cnum = new JTextField(40);
		numcourse.setHorizontalAlignment(JLabel.CENTER);
		cnum.setEditable(false);
		department = new JLabel("Department");
		department.setHorizontalAlignment(JLabel.CENTER);
		departmentfield = new JTextField(40);
		
		departmentfield.setEditable(false);
		
		addcourse = new JButton("Edit");
		cancelcourse = new JButton("Cancel");
		addcourse.addActionListener(new ButtonListen());
		cancelcourse.addActionListener(new ButtonListen());
		
		coursesearchpanel = new JPanel();
		courseaddpanel = new JPanel();
		courseaddpanel.setLayout(new GridLayout(5,2));
		coursebottompanel = new JPanel();
		coursebottompanel.setLayout(new GridLayout(1,2));
		
		coursesearchpanel.add(coursesearchlabel);
		coursesearchpanel.add(courseid1);
		coursesearchpanel.add(coursesearchbt);
	
		courseaddpanel.add(idcourse);
		courseaddpanel.add(cid);
		courseaddpanel.add(namecourse);
		courseaddpanel.add(coursename);
		courseaddpanel.add(profcourse);
		courseaddpanel.add(proffesor);
		courseaddpanel.add(numcourse);
		courseaddpanel.add(cnum);
		courseaddpanel.add(department);
		courseaddpanel.add(departmentfield);
		courseaddpanel.setVisible(false);
		
		coursebottompanel.add(addcourse);
		coursebottompanel.add(cancelcourse);
		coursebottompanel.setVisible(false);
		
		coursemainpanel.add(coursesearchpanel, BorderLayout.NORTH);
		coursemainpanel.add(courseaddpanel, BorderLayout.CENTER);
		coursemainpanel.add(coursebottompanel, BorderLayout.SOUTH);
		setContentPane(coursemainpanel);
		validate();
		
	}
	
	
	private void buildcoursepanel2()
	{
		coursemainpanel2 = new JPanel();
		coursemainpanel2.setLayout(new BorderLayout());
		
		
		idcourse = new JLabel("Course ID");
		idcourse.setHorizontalAlignment(JLabel.CENTER);
		cid = new JTextField(40);
		cid.setEditable(true);
		namecourse = new JLabel("Course Name");
		coursename = new JTextField(40);
		namecourse.setHorizontalAlignment(JLabel.CENTER);
		coursename.setEditable(true);
		profcourse =  new JLabel("Professor");
		proffesor = new JTextField(40);
		profcourse.setHorizontalAlignment(JLabel.CENTER);
		proffesor.setEditable(true);
		numcourse =  new JLabel("Course Number");
		cnum = new JTextField(40);
		numcourse.setHorizontalAlignment(JLabel.CENTER);
		cnum.setEditable(true);
		department = new JLabel("Department");
		department.setHorizontalAlignment(JLabel.CENTER);
		departmentfield = new JTextField(40);
		departmentfield.setEditable(true);
		
		addnewcourse = new JButton("Add Course");
		cancelcourse = new JButton("Cancel");
		addnewcourse.addActionListener(new ButtonListen());
		cancelcourse.addActionListener(new ButtonListen());
		
		courseaddpanel = new JPanel();
		courseaddpanel.setLayout(new GridLayout(5,2));
		coursebottompanel = new JPanel();
		coursebottompanel.setLayout(new GridLayout(1,2));
		
	
		courseaddpanel.add(idcourse);
		courseaddpanel.add(cid);
		courseaddpanel.add(namecourse);
		courseaddpanel.add(coursename);
		courseaddpanel.add(profcourse);
		courseaddpanel.add(proffesor);
		courseaddpanel.add(numcourse);
		courseaddpanel.add(cnum);
		courseaddpanel.add(department);
		courseaddpanel.add(departmentfield);
		courseaddpanel.setVisible(true);
		
		coursebottompanel.add(addnewcourse);
		coursebottompanel.add(cancelcourse);
		coursebottompanel.setVisible(true);
		
		coursemainpanel2.add(courseaddpanel, BorderLayout.CENTER);
		coursemainpanel2.add(coursebottompanel, BorderLayout.SOUTH);
		setContentPane(coursemainpanel2);
		validate();
		
		// end course panel 2
	}
	
	private void buildenrollpanel1()
	{
		enrollmainpanel = new JPanel();
		enrollmainpanel.setLayout(new BorderLayout());
		
		enrollsearchpanel = new JPanel();
		

	
		enrolladdpanel = new JPanel();
		enrollbottompanel = new JPanel();
		
		stidenroll1 = new JLabel("Student ID");
		stidenroll1.setHorizontalAlignment(JLabel.CENTER);
		cidenroll1 = new JLabel("Course ID");
		cidenroll1.setHorizontalAlignment(JLabel.CENTER);
		innerenrollpanel = new JPanel(new GridLayout(2,2));
		
		
		studentidenroll = new JTextField(10);
		courseidenroll = new JTextField(10);
		
		
		innerenrollpanel.add(stidenroll1);
		innerenrollpanel.add(studentidenroll);
		innerenrollpanel.add(cidenroll1);
		innerenrollpanel.add(courseidenroll);
		
		
		searchenroll = new JButton("Search");
		searchenroll.setHorizontalAlignment(JButton.CENTER);
		searchenroll.addActionListener(new ButtonListen2());
		
		editenroll = new JButton("Edit");
		editenroll.addActionListener(new ButtonListen2());
		enrolladdpanel = new JPanel();
		
		enrollbottompanel.add(editenroll);
		
		enrollsearchpanel.add(innerenrollpanel);
		enrollsearchpanel.add(searchenroll);
		
		
		enrollmainpanel.add(enrollsearchpanel, BorderLayout.NORTH);
	
		
		enrollist = new JList();
		enrollist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		enrollist.setVisibleRowCount(6);
		enrollist.setVisible(true);
		enrollist.addListSelectionListener(new ListListen());
		
//		enrollfieldpanel = new JPanel();
//		enrollfieldpanel.add(enrollist);
		
		scrollpane = new JScrollPane(enrollist);
		
	//	enrolladdpanel.add(scrollpane);
		
		
		enrollmainpanel.add(scrollpane, BorderLayout.CENTER);
		enrollmainpanel.add(enrollbottompanel, BorderLayout.SOUTH);
		
		setContentPane(enrollmainpanel);
		validate();
		
		
		
	
	// end of build enroll panel 1
	}
	
	private void buildenrolleditpanel()
	{
		enrolleditmainpanel = new JPanel();
		enrolleditmainpanel.setLayout(new GridLayout(4,2));
		
		stidenroll = new JLabel("Student ID");
		stidenroll.setHorizontalAlignment(JLabel.CENTER);
		stidenrollfield = new JTextField(40);
		cidenroll = new JLabel("Course ID");
		cidenroll.setHorizontalAlignment(JLabel.CENTER);
		cidenrollfield = new JTextField(40);
		yearenroll = new JLabel("Year");
		yearenroll.setHorizontalAlignment(JLabel.CENTER);
		yrenrollfield = new JTextField(4);
		semesterenroll = new JLabel("Semester");
		semesterenroll.setHorizontalAlignment(JLabel.CENTER);
		semestenrollfield = new JTextField(20);
		
		saveenroll = new JButton("Save");
		saveenroll.addActionListener(new ButtonListen2());
		cancelenroll = new JButton("Cancel");
		cancelenroll.addActionListener(new ButtonListen2());
		
		enrolleditmainpanel.add(stidenroll);
		enrolleditmainpanel.add(stidenrollfield);
		enrolleditmainpanel.add(cidenroll);
		enrolleditmainpanel.add(cidenrollfield);
		enrolleditmainpanel.add(yearenroll);
		enrolleditmainpanel.add(yrenrollfield);
		enrolleditmainpanel.add(semesterenroll);
		enrolleditmainpanel.add(semestenrollfield);
		
		enrollbottompanel = new JPanel();
		enrollbottompanel.setLayout(new GridLayout(1,2));
		enrollbottompanel.add(saveenroll);
		enrollbottompanel.add(cancelenroll);
		
		enrollmainpanel2 = new JPanel();
		enrollmainpanel2.setLayout(new BorderLayout());
		enrollmainpanel2.add(enrolleditmainpanel, BorderLayout.CENTER);
		enrollmainpanel2.add(enrollbottompanel, BorderLayout.SOUTH);
		setContentPane(enrollmainpanel2);
		validate();
		
		
	}
	
	private void buildenrollpanel2()
	{
		enrolleditmainpanel = new JPanel();
		enrolleditmainpanel.setLayout(new GridLayout(4,2));
		
		stidenroll = new JLabel("Student ID");
		stidenroll.setHorizontalAlignment(JLabel.CENTER);
		stidenrollfield = new JTextField(40);
		cidenroll = new JLabel("Course ID");
		cidenroll.setHorizontalAlignment(JLabel.CENTER);
		cidenrollfield = new JTextField(40);
		yearenroll = new JLabel("Year");
		yearenroll.setHorizontalAlignment(JLabel.CENTER);
		yrenrollfield = new JTextField(4);
		semesterenroll = new JLabel("Semester");
		semesterenroll.setHorizontalAlignment(JLabel.CENTER);
		semestenrollfield = new JTextField(20);
		
		addenroll = new JButton("Add Enrollment");
		addenroll.addActionListener(new ButtonListen2());
		cancelenroll = new JButton("Cancel");
		cancelenroll.addActionListener(new ButtonListen2());
		
		enrolleditmainpanel.add(stidenroll);
		enrolleditmainpanel.add(stidenrollfield);
		enrolleditmainpanel.add(cidenroll);
		enrolleditmainpanel.add(cidenrollfield);
		enrolleditmainpanel.add(yearenroll);
		enrolleditmainpanel.add(yrenrollfield);
		enrolleditmainpanel.add(semesterenroll);
		enrolleditmainpanel.add(semestenrollfield);
		
		enrollbottompanel = new JPanel();
		enrollbottompanel.setLayout(new GridLayout(1,2));
		enrollbottompanel.add(addenroll);
		enrollbottompanel.add(cancelenroll);
		
		enrollmainpanel2 = new JPanel();
		enrollmainpanel2.setLayout(new BorderLayout());
		enrollmainpanel2.add(enrolleditmainpanel, BorderLayout.CENTER);
		enrollmainpanel2.add(enrollbottompanel, BorderLayout.SOUTH);
		setContentPane(enrollmainpanel2);
		validate();
	// end of enroll panel 2
	}
	
	private void buildgradepanel1()
	{
		grademainpanel1 = new JPanel();
		grademainpanel1.setLayout(new BorderLayout());
		
		gradesearchpanel = new JPanel();
	
		gradebottompanel = new JPanel();
		
		stidgrade1 = new JLabel("Student ID");
		stidgrade1.setHorizontalAlignment(JLabel.CENTER);
		cidgrade1 = new JLabel("Course ID");
		cidgrade1.setHorizontalAlignment(JLabel.CENTER);
		yrgrade1 = new JLabel("Year");
		yrgrade1.setHorizontalAlignment(JLabel.CENTER);
		smgrade1 = new JLabel("Semester");
		smgrade1.setHorizontalAlignment(JLabel.CENTER);
		
		
		innergradepanel = new JPanel(new GridLayout(4,4));
		
		
		stidgradefield1 = new JTextField(10);
		cidgradefield1 = new JTextField(10);
		yrgradefield1 = new JTextField(4);
		smgradefield1 = new JTextField(1);
		
		
		innergradepanel.add(stidgrade1);
		innergradepanel.add(stidgradefield1);
		innergradepanel.add(cidgrade1);
		innergradepanel.add(cidgradefield1);
		innergradepanel.add(yrgrade1);
		innergradepanel.add(yrgradefield1);
		innergradepanel.add(smgrade1);
		innergradepanel.add(smgradefield1);
		
		
		searchgrade = new JButton("Search");
		searchgrade.setHorizontalAlignment(JButton.CENTER);
		searchgrade.addActionListener(new ButtonListen2());
		
		editgradebt = new JButton("Edit");
		editgradebt.addActionListener(new ButtonListen2());
		gradebottompanel.add(editgradebt);
		
		gradesearchpanel.add(innergradepanel);
		gradesearchpanel.add(searchgrade);
		
		
		grademainpanel1.add(gradesearchpanel, BorderLayout.NORTH);
	
		
		gradelist = new JList();
		gradelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gradelist.setVisibleRowCount(6);
		gradelist.setVisible(true);
		gradelist.addListSelectionListener(new ListListen());
		
		scrollpane = new JScrollPane(gradelist);
		
	//	gradeaddpanel = new JPanel();
	//	gradeaddpanel.add(scrollpane);
		
		grademainpanel1.add(scrollpane, BorderLayout.CENTER);
		grademainpanel1.add(gradebottompanel, BorderLayout.SOUTH);
		
		setContentPane(grademainpanel1);
		validate();
		
	}
	
	private void buildgradeedit()
	{
		grademainpanel1 = new JPanel();
		grademainpanel1.setLayout(new GridLayout(5,2));
	
		stidgrade2 = new JLabel("Student ID");
		stidgrade2.setHorizontalAlignment(JLabel.CENTER);
		cidgrade2 = new JLabel("Course ID");
		cidgrade2.setHorizontalAlignment(JLabel.CENTER);
		yrgrade2 = new JLabel("Year");
		yrgrade2.setHorizontalAlignment(JLabel.CENTER);
		smgrade2 = new JLabel("Semester");
		smgrade2.setHorizontalAlignment(JLabel.CENTER);
		grdgrade2 = new JLabel("Grade");
		grdgrade2.setHorizontalAlignment(JLabel.CENTER);
		
		stidgradefield2 = new JTextField(10);
		stidgradefield2.setHorizontalAlignment(JTextField.CENTER);
		cidgradefield2 = new JTextField(10);
		cidgradefield2.setHorizontalAlignment(JTextField.CENTER);
		yrgradefield2 = new JTextField(10);
		yrgradefield2.setHorizontalAlignment(JTextField.CENTER);
		smgradefield2 = new JTextField(10);
		smgradefield2.setHorizontalAlignment(JTextField.CENTER);
		grdgradefield2 = new JTextField(1);
		grdgradefield2.setHorizontalAlignment(JTextField.CENTER);
		
		
		savegradebt = new JButton("Save Grade");
		savegradebt.addActionListener(new ButtonListen2());
		cancelgrade = new JButton("Cancel");
		cancelgrade.addActionListener(new ButtonListen2());
		
		
		grademainpanel1.add(stidgrade2);
		grademainpanel1.add(stidgradefield2);
		grademainpanel1.add(cidgrade2);
		grademainpanel1.add(cidgradefield2);
		grademainpanel1.add(yrgrade2);
		grademainpanel1.add(yrgradefield2);
		grademainpanel1.add(smgrade2);
		grademainpanel1.add(smgradefield2);
		grademainpanel1.add(grdgrade2);
		grademainpanel1.add(grdgradefield2);
		
		
	
		
		gradebottompanel = new JPanel();
		gradebottompanel.setLayout(new GridLayout(1,2));
		gradebottompanel.add(savegradebt);
		gradebottompanel.add(cancelgrade);
		
		grademainpanel2 = new JPanel();
		grademainpanel2.setLayout(new BorderLayout());
		grademainpanel2.add(grademainpanel1, BorderLayout.CENTER);
		grademainpanel2.add(gradebottompanel, BorderLayout.SOUTH);
		setContentPane(grademainpanel2);
		validate();
		
	}
	
	private void buildgradepanel2()
	{
		grademainpanel1 = new JPanel();
		grademainpanel1.setLayout(new GridLayout(5,2));
		
		stidgrade2 = new JLabel("Student ID");
		stidgrade2.setHorizontalAlignment(JLabel.CENTER);
		cidgrade2 = new JLabel("Course ID");
		cidgrade2.setHorizontalAlignment(JLabel.CENTER);
		yrgrade2 = new JLabel("Year");
		yrgrade2.setHorizontalAlignment(JLabel.CENTER);
		smgrade2 = new JLabel("Semester");
		smgrade2.setHorizontalAlignment(JLabel.CENTER);
		grdgrade2 = new JLabel("Grade");
		grdgrade2.setHorizontalAlignment(JLabel.CENTER);
		
		stidgradefield2 = new JTextField(10);
		stidgradefield2.setHorizontalAlignment(JTextField.CENTER);
		cidgradefield2 = new JTextField(10);
		cidgradefield2.setHorizontalAlignment(JTextField.CENTER);
		yrgradefield2 = new JTextField(10);
		yrgradefield2.setHorizontalAlignment(JTextField.CENTER);
		smgradefield2 = new JTextField(10);
		smgradefield2.setHorizontalAlignment(JTextField.CENTER);
		grdgradefield2 = new JTextField(1);
		grdgradefield2.setHorizontalAlignment(JTextField.CENTER);
		
		addgrade = new JButton("Add Grade");
		addgrade.addActionListener(new ButtonListen2());
		cancelgrade = new JButton("Cancel");
		cancelgrade.addActionListener(new ButtonListen2());
		
		
		grademainpanel1.add(stidgrade2);
		grademainpanel1.add(stidgradefield2);
		grademainpanel1.add(cidgrade2);
		grademainpanel1.add(cidgradefield2);
		grademainpanel1.add(yrgrade2);
		grademainpanel1.add(yrgradefield2);
		grademainpanel1.add(smgrade2);
		grademainpanel1.add(smgradefield2);
		grademainpanel1.add(grdgrade2);
		grademainpanel1.add(grdgradefield2);
		
		gradebottompanel = new JPanel();
		gradebottompanel.setLayout(new GridLayout(1,2));
		gradebottompanel.add(addgrade);
		gradebottompanel.add(cancelgrade);
		
		grademainpanel2 = new JPanel();
		grademainpanel2.setLayout(new BorderLayout());
		grademainpanel2.add(grademainpanel1, BorderLayout.CENTER);
		grademainpanel2.add(gradebottompanel, BorderLayout.SOUTH);
		setContentPane(grademainpanel2);
		validate();
		
	}
	
	private void buildreportpanel1()
	{
		reportsearchpanel = new JPanel();
		reportsearchpanel.setLayout(new GridLayout(2,2));
		
		reportmainpanel1 = new JPanel();
		
		reportmainpanel2 = new JPanel(new BorderLayout());
		
		stidreport = new JLabel("Course ID");
		stidreport.setHorizontalAlignment(JLabel.CENTER);
		yrreport = new JLabel("Year");
		yrreport.setHorizontalAlignment(JLabel.CENTER);
		
		stidreportfield = new JTextField(10);
		stidreportfield.setHorizontalAlignment(JTextField.CENTER);
		yrreportfield = new JTextField(10);
		yrreportfield.setHorizontalAlignment(JTextField.CENTER);
		
		
		searchreport = new JButton("Create Report");
		searchreport.addActionListener(new ButtonListen2());
		
		
		reportsearchpanel.add(stidreport);
		reportsearchpanel.add(stidreportfield);
		reportsearchpanel.add(yrreport);
		reportsearchpanel.add(yrreportfield);
		
		
		searchreport = new JButton("Search");
		searchreport.setHorizontalAlignment(JButton.CENTER);
		searchreport.addActionListener(new ButtonListen2());
		
		reportmainpanel1.add(reportsearchpanel);
		reportmainpanel1.add(searchreport);
		
		
		reportmainpanel2.add(reportmainpanel1, BorderLayout.NORTH);
	
/*		String[] months = new String[3];
		months[0] = "Cats";
		months[1] = "Cats";
		months[2] = "Cats";
*/		
		
		reportlist = new JList();
		reportlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reportlist.setVisibleRowCount(6);
		reportlist.setVisible(true);
		reportlist.addListSelectionListener(new ListListen());
		
		scrollpane = new JScrollPane(reportlist);
		
	//	reportlistpanel = new JPanel();
	//	reportlistpanel.add(reportlist);
		
		reportmainpanel2.add(scrollpane, BorderLayout.CENTER);
		
		setContentPane(reportmainpanel2);
		validate();
		
	}
	
	
	
	//
	private void buildMenuBar()
	{
		menuBar = new JMenuBar();
		
		buildStudentMenu();
		
		menuBar.add(studmenu);
		menuBar.add(courses);
		menuBar.add(enrolls);
		menuBar.add(grades);
		menuBar.add(reports);
		setJMenuBar(menuBar);
	}
	
	private void buildStudentMenu()
	{
		studsearchbutton = new JRadioButtonMenuItem("Search");
		studsearchbutton.addActionListener(new MenuListen());
		studaddbutton = new JRadioButtonMenuItem("Add");
		studaddbutton.addActionListener(new MenuListen());
		
		courssearch = new JRadioButtonMenuItem("Search");
		coursadd = new JRadioButtonMenuItem("Add");
		courssearch.addActionListener(new MenuListen());
		coursadd.addActionListener(new MenuListen());
		
		enrollsearch = new JRadioButtonMenuItem("Search");
		enrolladd = new JRadioButtonMenuItem("Add");
		enrollsearch.addActionListener(new MenuListen());
		enrolladd.addActionListener(new MenuListen());
		
		gradesearch = new JRadioButtonMenuItem("Search");
		gradeadd = new JRadioButtonMenuItem("Add");
		gradesearch.addActionListener(new MenuListen());
		gradeadd.addActionListener(new MenuListen());
		
		reportdisplay = new JRadioButtonMenuItem("Report");
		reportdisplay.addActionListener(new MenuListen());
		
		
		ButtonGroup studgroup = new ButtonGroup();
		ButtonGroup coursegroup = new ButtonGroup();
		ButtonGroup enrollgroup = new ButtonGroup();
		ButtonGroup gradegroup = new ButtonGroup();
		ButtonGroup reportgroup = new ButtonGroup();
		
		studgroup.add(studsearchbutton);
		studgroup.add(studaddbutton);
		
		coursegroup.add(courssearch);
		coursegroup.add(coursadd);
		
		enrollgroup.add(enrollsearch);
		enrollgroup.add(enrolladd);
		
		gradegroup.add(gradesearch);
		gradegroup.add(gradeadd);
		
		reportgroup.add(reportdisplay);
		
		
		studmenu = new JMenu("Student");
		studmenu.add(studsearchbutton);
		studmenu.add(studaddbutton);
		
		courses = new JMenu("Course");
		courses.add(courssearch);
		courses.add(coursadd);
		
		enrolls = new JMenu("Enrollment");
		enrolls.add(enrollsearch);
		enrolls.add(enrolladd);
		
		grades = new JMenu("Grades");
		grades.add(gradesearch);
		grades.add(gradeadd);
		
		reports = new JMenu("Report");
		reports.add(reportdisplay);
		
	}
	
	
	
// end of Build Menu
	
	
	private class MenuListen implements ActionListener
	{
		public void actionPerformed(ActionEvent E)
		{
			if(E.getSource() == studsearchbutton)
			{
				buildStudentPN();
				
			}
			
			else if (E.getSource() == studaddbutton)
			{
				buildStudent2PN();
				
			}
			
			else if (E.getSource() == courssearch)
			{
				buildcoursepanel();
			}
			
			else if (E.getSource() == coursadd)
			{
				buildcoursepanel2();
			}
			
			else if (E.getSource() == enrollsearch)
			{
				buildenrollpanel1();
			}
			
			else if (E.getSource() == enrolladd)
			{
				buildenrollpanel2();
			}
			
				else if (E.getSource() == gradesearch)
			{
				buildgradepanel1();
			}
			
				else if (E.getSource() == gradeadd)
			{
				buildgradepanel2();
				
			}
			
				else if (E.getSource() == reportdisplay)
			{
				buildreportpanel1();
			}
			
			
		
			
		}
	}
// end of inner class for Menu Listen 
	
	
	private class ButtonListen implements ActionListener
	{
		// studentdata
		String parse;
		String nm, addr, cty, st;
		int id;
		Student boy;
		StudentFile studentfile;
		ArrayList students;
		long numrecords;
		
		//coursedata
		Course course;
		ArrayList courses;
		int coursenumber;
		String courseid, prof, dpt, cname;
		CourseFile coursefile;
		long courserecordnum;
		Course course1;
	
		
		public void actionPerformed(ActionEvent e)
		{
		String parse;
		String nm, addr, cty, st;
		int id;
		
		
		
			if (e.getSource() == addstud)
			{
				
				try {
					parse = studentid2.getText();
					id = Integer.parseInt(parse);
					nm = name.getText();
					addr = address.getText();
					cty = city.getText();
					st = state.getText();
					
					boy = new Student(nm, addr, cty, st, id);
					
					studentfile = new StudentFile("Student.dat");
					
					long numrecords = studentfile.getRecords();

					
							
					if (numrecords == 0) {
						
						studentfile.moveFilePointer(0);
						studentfile.writeStudent(boy);
						studentfile.close();
					}
					else {
						students = studentfile.noMatches(numrecords, id);
						
						if (students.isEmpty())
						{
						studentfile.moveFilePointer(numrecords);
						studentfile.writeStudent(boy);
						studentfile.close();
						}
						
						else {
							
							throw new Exception("STUDENT ID ALREADY EXISTS. PLEASE TRY AGAIN");
						}
						
						studentfile.close();
						
						buildStudentPN();
									
					}
					
					
				}
				
				catch (Exception d) {
					
					if (d.getMessage() == "STUDENT ID ALREADY EXISTS. PLEASE TRY AGAIN")
					{
						JOptionPane.showMessageDialog(null, "Student ID Already Exists. Please Try Again");
					}
					
					else {
					
					JOptionPane.showMessageDialog(null, "Student ID must consist of numbers only");
					}
				}
				
		// end of addstud button		
			}
			
		else if (e.getSource() == cancelstud)
			{
				buildStudentPN();
				
				// end of cancelstud button
			}
			
		else if (e.getSource() == studsearch)
		{
			try {
				parse = studentid.getText();
				id = Integer.parseInt(parse);
				studentfile = new StudentFile("Student.dat");
				numrecords = studentfile.getRecords();
				
				if (numrecords == 0)
				{
					throw new Exception("STUDENT ID DOES NOT EXIST");
				}
				
				else if (numrecords > 0)
				{
					students = studentfile.findMatches(numrecords, id);
					int listlength = students.size();
					for (int a = 0; a < listlength; a++)
					{
					boy = (Student) students.get(a);
					nm = boy.getName();
					addr = boy.getAddress();
					cty = boy.getCity();
					st = boy.getState();
					
					studentid2.setText(parse);
					name.setText(nm);
					address.setText(addr);
					city.setText(cty);
					state.setText(st);
					
					studentPanelin.setVisible(false);
					studaddpnl.setVisible(true);
					studbottompanel.setVisible(true);
					
					validate();	
						
					}
					
					studentfile.close();
					
				}
					
			}
			
			catch (Exception studsearch)
			{
				String emessage = studsearch.getMessage();
				JOptionPane.showMessageDialog(null, emessage);
				
			}
		
			// end of search button
			}
			
	else if (e.getSource() == editstud)
			{
				if(editstud.getText() == "Edit")
				{
				editstud.setText("Save");
				name.setEditable(true);
				address.setEditable(true);
				city.setEditable(true);
				state.setEditable(true);
				
		
				
				}
			
			
				else if (editstud.getText() == "Save")
				{
					editstud.setText("Edit");
					
					parse = studentid2.getText();
					id = Integer.parseInt(parse);
					nm = name.getText();
					addr = address.getText();
					cty = city.getText();
					st = state.getText();
				
					try {
					studentfile = new StudentFile("Student.dat");
					numrecords = studentfile.getRecords();
					
					
						
						
						ArrayList students = studentfile.findMatches(numrecords, id);
						int listlength = students.size();
						for (int a = 0; a < listlength; a++)
						{
						boy = (Student) students.get(a);
						boy.studentDisplay();
				
						
							studentfile.moveFilePointer((boy.getRecordnum() - 1));
							
							boy.setName(nm);
							boy.setAddress(addr);
							boy.setCity(cty);
							boy.setState(st);
							studentfile.writeStudent(boy);
						}
					studentfile.close();
					JOptionPane.showMessageDialog(null, "STUDENT RECORD SAVED.");
					}
					
					catch (Exception b)
					{
						String emessage = b.getMessage();
						JOptionPane.showMessageDialog(null, emessage);
					}
						
					
					
					// end of edit stud button
					
				}
				
			}	
				// beginingg of search 
				
		else if (e.getSource() == coursesearchbt)
				{
				
				try {
					parse = courseid1.getText();
					coursenumber = Integer.parseInt(parse);
					
					coursefile = new CourseFile("Course.dat");
					numrecords = coursefile.getRecords();
					ArrayList jlist = new ArrayList();
					
					if (numrecords == 0)
					{
						throw new Exception("Record doesn't exist");
					}
					
					ArrayList courses = coursefile.findMatches(numrecords, coursenumber);
					int listlength = courses.size();
					for (int a = 0; a < listlength; a++)
					{
					
					course = (Course) courses.get(a);
					courseid = course.getcid();
					cname = course.getcname();
					prof = course.getprof();
					dpt = course.getdpt();
					
					cid.setText(parse);
					coursename.setText(cname);
					proffesor.setText(prof);
					cnum.setText(courseid);
					departmentfield.setText(dpt);
					
					
					
					coursesearchpanel.setVisible(false);
					courseaddpanel.setVisible(true);
					coursebottompanel.setVisible(true);
					
					}
					
					
					coursefile.close();
					
					}
					
				// end of try

				
				catch (Exception coursea)
				{
					String courseamessage = coursea.getMessage();
					JOptionPane.showMessageDialog(null, courseamessage);
					
				// end of catch
				}
					// end of edit student button
				}
		
		else if (e.getSource() == addcourse)
				
		{
		try {
			if (addcourse.getText() == "Edit")
			{
				addcourse.setText("Save");
				coursename.setEditable(true);
				proffesor.setEditable(true);
				cnum.setEditable(true);
				departmentfield.setEditable(true);
				
			}
			
			
			
			else if (addcourse.getText() == "Save")
			{
				parse = cid.getText();
				coursenumber = Integer.parseInt(parse);
				courseid = cnum.getText();
				cname = coursename.getText();
				prof = proffesor.getText();
				dpt = departmentfield.getText();
				
				coursefile = new CourseFile("Course.dat");
				numrecords = coursefile.getRecords();
				
				courses = coursefile.findMatches(numrecords, coursenumber);
				int listlength = courses.size();
				for (int a = 0; a < listlength; a++)
				{
				course1 = (Course) courses.get(a);
				coursefile.moveFilePointer(course1.getRecord() - 1);
				course1.setcid(courseid);
				course1.setcname(cname);
				course1.setprof(prof);
				course1.setdpt(dpt);
				course1.setcnum(coursenumber);
				coursefile.writeCourse(course1);
				}
				
				JOptionPane.showMessageDialog(null, "Course record was saved.");
				cid.setEditable(false);
				coursename.setEditable(false);
				proffesor.setEditable(false);
				cnum.setEditable(false);
				departmentfield.setEditable(false);
				addcourse.setText("Edit");
				
				coursefile.close();
			}
			
			
		}
		
		catch (Exception courseb)
		{
			String coursebmessage = courseb.getMessage();
			JOptionPane.showMessageDialog(null, coursebmessage);
			
		}
			
			// end of add course button
		}
				
		
		else if (e.getSource() == cancelcourse)
		{
			buildcoursepanel();
	
		}
			
		else if (e.getSource() == addnewcourse)
		{
			try {

			parse = cid.getText();
			coursenumber = Integer.parseInt(parse);
			courseid = cnum.getText();
			cname = coursename.getText();
			prof = proffesor.getText();
			dpt = departmentfield.getText();
			
			course1 = new Course(courseid, cname, prof, dpt, coursenumber);
			
			coursefile = new CourseFile("Course.dat");
			numrecords = coursefile.getRecords();
			if (numrecords == 0)
			{
				coursefile.writeCourse(course1);
				JOptionPane.showMessageDialog(null, "Course record was added");
			}
			
			else {
				courses = coursefile.noMatches(numrecords, coursenumber);
				if (courses.isEmpty())
				{
				coursefile.moveFilePointer(numrecords);
				coursefile.writeCourse(course1);
				coursefile.close();
				JOptionPane.showMessageDialog(null, "Course record was added");
				cid.setText(null);
				cnum.setText(null);
				coursename.setText(null);
				proffesor.setText(null);
				departmentfield.setText(null);
				}
				else {
					coursefile.close();
					throw new Exception("Course Number Already Exists");
				}
			}
			
			}
			
			catch (Exception courseaddbutton)
			{
				String courseaddbtmsg = courseaddbutton.getMessage();
				JOptionPane.showMessageDialog(null, courseaddbtmsg);
			}
			
			}
		}
		
	
		// end of ButtonListen Class	
		}
	
	
	
	private class ListListen implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent list)
		{
			if (list.getSource() == enrollist)
			{
				index1 = enrollist.getSelectedIndex();
				
				
			}
			
			else if (list.getSource() == gradelist)
			{
				index = gradelist.getSelectedIndex();
				
				
			}
			
		}
	}
	
	
	
	private class ButtonListen2 implements ActionListener
	{
		int stid, cnum, yr;
		String semester;
		char grade;
		long recordnum;
		
		StudentFile studentfile;
		Student boy;
		long studentrecords;
		
		Course course;
		CourseFile coursefile;
		long courserecords;
		
		Enroll enroll;
		EnrollFile enrollfile;
		long enrollments;
		long enrollrecords;
		
		grade agrade;
		gradefile Gradefile;
		long graderecords;
		
		
		
		
		
		public void actionPerformed(ActionEvent button2)
		{
	// enrollment BUTTONS 
			if (button2.getSource() == searchenroll)
			{
			try {
				enrollobj = new ArrayList <Enroll>();
				enrollobj2 = new ArrayList <Enroll>();
				enrollfile = new EnrollFile("Enroll.dat");
				long numrecords = enrollfile.getRecords();
				if (numrecords == 0)
				{
					throw new Exception("Records doesn't exist");
				}
				
				
				cnum = Integer.parseInt(courseidenroll.getText());
				stid = Integer.parseInt(studentidenroll.getText());
					
				
					
					enrollobj = enrollfile.findMatches(numrecords, stid, cnum);
					int listlength = enrollobj.size();
					
				if (listlength > 0)
				{
					enrollarray = new String[listlength];
					for (int a = 0; a < listlength; a++)
					{
					enroll = (Enroll) enrollobj.get(a);
					enrollobj2.add(enroll);
					String enrollrecordlist = "Student ID: " +  enroll.getstid() + "       " +
							" Course ID: " + enroll.getcnum() + "       " +
							"Semester: " + enroll.getsemester();
					enrollarray[a] = enrollrecordlist;
					}
					
					
					enrollist.setListData(enrollarray);
					// end of if 
				}
				
				else {
					throw new Exception("No Record Exists");
				}
				
				
			
				// end of try 	
				}
			
					
					
				catch (Exception e)
					{
					String	emessage = e.getMessage();
						JOptionPane.showMessageDialog(null, emessage);
						enrollsearch.doClick();
					}
				
					
			}
			
			else if (button2.getSource() == addenroll)
		{
			try {
				cnum = Integer.parseInt(cidenrollfield.getText());
				stid = Integer.parseInt(stidenrollfield.getText());
				yr = Integer.parseInt(yrenrollfield.getText());
				semester = semestenrollfield.getText();
				semester = semester.trim();
				semester = semester.toUpperCase();
				
				Enroll enroll = new Enroll(stid, cnum, yr, semester);
				


				enrollfile = new EnrollFile("Enroll.dat");
				studentfile = new StudentFile("Student.dat");
				coursefile = new CourseFile("Course.dat");
				studentrecords = studentfile.getRecords();
				courserecords = coursefile.getRecords();

				if (studentrecords == 0 || courserecords == 0)
				{
					throw new Exception ("No Records exist for Student and Courses. Create Students and/or Courses first");
				}
				studobj = studentfile.noMatches(studentrecords, stid);
				courseobj  = coursefile.noMatches(courserecords, cnum);


				if(studobj.isEmpty() && courseobj.isEmpty())
				{
					throw new Exception ("Student ID and Course Number doesn't exist in the database. Please try again");
				}

				else if (studobj.isEmpty())
				{
					throw new Exception("Student ID doesn't exist in the database. Please try again");
				}

				else if (courseobj.isEmpty())
				{
					throw new Exception("Course Number doesn't exist in the database. Please try again");
				}

				else {
					
				long numrecords = enrollfile.getRecords();
				// System.out.println(numrecords);
				ArrayList enrolls = enrollfile.noMatches(numrecords, stid, cnum, yr, semester);
				if (!enrolls.isEmpty())
				{
					throw new Exception("Student is already enrolled");
				}
				if (numrecords == 0) {
					
					
					
					enrollfile.writeEnroll(enroll);
					enrollfile.close();

				}
				else {
					enrollfile.moveFilePointer(numrecords);
					enrollfile.writeEnroll(enroll);
					enrollfile.close();
				}
		
				JOptionPane.showMessageDialog(null, "Enrollment record was added.");
				enrollsearch.doClick();
				
				}
			}
				
				catch (Exception e)
				{
					String emessage = e.getMessage();
					JOptionPane.showMessageDialog(null, emessage);
					
				}
				
			//	end of save enroll button
			}
				
			
			
			else if (button2.getSource() == cancelenroll)
			{
				
				buildenrollpanel1();
				
				
				// end of cancelenroll bottom
			}
		
			else if (button2.getSource() == saveenroll)
		{
			
			try {
				enrollfile = new EnrollFile("Enroll.dat");
				long numrecords = enrollfile.getRecords();
				
				Enroll enroll1 = (Enroll) enrollobj2.get(index1);
				int ogcnum = enroll1.getcnum();
				int ogstid = enroll1.getstid();
				int ogyr = enroll1.getyear();
				String ogsemester = enroll1.getsemester();
				ogsemester = ogsemester.trim();
				
				
				cnum = Integer.parseInt(cidenrollfield.getText());
				stid = Integer.parseInt(stidenrollfield.getText());
				yr = Integer.parseInt(yrenrollfield.getText());
				semester = semestenrollfield.getText();
				semester = semester.trim();
				semester = semester.toUpperCase();
				
				Enroll update = new Enroll(stid, cnum, yr, semester);
				
				enrollobj = enrollfile.findMatches(numrecords, ogstid, ogcnum, ogyr, ogsemester);
				Enroll enroll2 = (Enroll) enrollobj.get(0);
				enrollfile.moveFilePointer(enroll2.getRecord()-1);
				
				studentfile = new StudentFile("Student.dat");
				coursefile = new CourseFile("Course.dat");
				studentrecords = studentfile.getRecords();
				courserecords = coursefile.getRecords();
				
				if (studentrecords == 0 || courserecords == 0)
				{
					throw new Exception ("Student ID or Course Num doesn't exist. Please try again");
				}
				
				enrollobj2 = new ArrayList <Enroll>();
				
				studobj = studentfile.noMatches(studentrecords, stid);
				courseobj  = coursefile.noMatches(courserecords, cnum);
				if (studobj.isEmpty() || courseobj.isEmpty())
				{
					throw new Exception("Student ID and Course Number doesn't exist in the database. Please try again");
				}
				
				else if (!enrollobj2.isEmpty())
				{
					throw new Exception("Student is already enrolled.");
				}
				
				else {
					
				enrollfile.writeEnroll(update);
				enrollfile.close();
				
				}
				
				JOptionPane.showMessageDialog(null, "Enrollment was saved.");
				enrollsearch.doClick();
				

				
				// end of try
			}
				
				catch(Exception e)
			{
					
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
				
				
				// end of addenroll button
			}
			
			else if (button2.getSource() == editenroll)
			{
				buildenrolleditpanel();
				Enroll enroll1 = (Enroll) enrollobj2.get(index1);
				String stid = Integer.toString(enroll1.getstid());
				String cid = Integer.toString(enroll1.getcnum());
				String yr = Integer.toString(enroll1.getyear());
				
				stidenrollfield.setText(stid);
				cidenrollfield.setText(cid);
				yrenrollfield.setText(yr);
				semestenrollfield.setText(enroll1.getsemester());
			}
		
		
			// END OF ENROLLMENT BUTTONS
			
			else if (button2.getSource() == searchgrade)
	
			{
				try
				{
					gradeobj2 = new ArrayList <grade>();
					cnum = Integer.parseInt(cidgradefield1.getText());
					stid = Integer.parseInt(stidgradefield1.getText());
					yr = Integer.parseInt(yrgradefield1.getText());
					semester = smgradefield1.getText();
					semester = semester.trim();
					semester = semester.toUpperCase();
					
				Gradefile = new gradefile("grade.dat");
				long numrecords = Gradefile.getRecords();
				if (numrecords == 0)
				{
					throw new Exception("Record doesn't exist");
				}
				
			
				
					
					gradeobj = new ArrayList <grade>();
					gradeobj = Gradefile.findMatches(numrecords, stid, cnum, yr, semester);
					int listlength = gradeobj.size();
					
				if (listlength > 0)
				{
					gradearray = new String[listlength];
					
					for (int a = 0; a < listlength; a++)
					{
					agrade = (grade) gradeobj.get(a);
					gradeobj2.add(agrade);
					
					String graderecordlist = "Student ID: " + agrade.getid()  + "       " + "Course ID: " + agrade.getcnum() + "       " +
							"Semester: " + agrade.getsemester() +"       " + "Year: " + agrade.getyear() + "       " + "Grade: " + agrade.getgrade();
					gradearray[a] = graderecordlist;
					}
					
					gradelist.setListData(gradearray);
					
		
				}
					
				
				
				}
				
				catch(Exception e)
				{
						
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
				
				
				// end of searchgrade button
			}
			
			else if (button2.getSource() == savegradebt)
			{
			try {

				Gradefile = new gradefile("grade.dat");
				long numrecords = Gradefile.getRecords();
				
				grade grade1 = (grade) gradeobj2.get(index);
				int ogcnum = grade1.getcnum();
				int ogstid = grade1.getid();
				int ogyr = grade1.getyear();
				String ogsemester = grade1.getsemester();
				char oggrade = grade1.getgrade();
				
				cnum = Integer.parseInt(cidgradefield2.getText());
				stid = Integer.parseInt(stidgradefield2.getText());
				yr = Integer.parseInt(yrgradefield2.getText());
				semester = smgradefield2.getText();
				semester = semester.trim();
				semester = semester.toUpperCase();
				String parse = grdgradefield2.getText();
				grade = parse.charAt(0);
				
				grade update = new grade(stid, cnum, yr, semester, grade);
			
			
				gradeobj2 = Gradefile.findMatches(numrecords, ogstid, ogcnum, ogyr, ogsemester);
				agrade = (grade) gradeobj2.get(0);
				Gradefile.moveFilePointer(agrade.getRecord() - 1);
				
					
					StudentFile studentfile = new StudentFile("Student.dat");
					CourseFile coursefile = new CourseFile("Course.dat");
					EnrollFile enrollfile = new EnrollFile("Enroll.dat");
					studentrecords = studentfile.getRecords();
					courserecords = coursefile.getRecords();
					enrollrecords = enrollfile.getRecords();

					if (studentrecords == 0 || courserecords == 0)
					{
						throw new Exception ("Student ID or Course Number doesn't exist. Please try again");
					}
					
					studobj = studentfile.noMatches(studentrecords, stid);
					courseobj = coursefile.noMatches(courserecords, cnum);
					enrollobj = enrollfile.noMatches(enrollrecords, stid, cnum, yr, semester);

					if (studobj.isEmpty() || courseobj.isEmpty() || enrollobj.isEmpty())
					{
						throw new Exception("Student isn't enrolled. Please try again");
					}
					
					else {
						Gradefile.writeGrade(update);
						Gradefile.close();
					}

					studentfile.close();
					enrollfile.close();
					coursefile.close();
					
					buildgradepanel1();
			}	

			catch(Exception e)
			{
					
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
				
		
				
				
				// end of savegradebt button
			}
			
			else if (button2.getSource() == cancelgrade)
			{
				
				buildgradepanel1();
				
				
				// end of cancel grade button
			}
			
			else if (button2.getSource() == addgrade)
				
			{
				try 
				{
					
				cnum = Integer.parseInt(cidgradefield2.getText());
				stid = Integer.parseInt(stidgradefield2.getText());
				yr = Integer.parseInt(yrgradefield2.getText());
				semester = smgradefield2.getText();
				semester = semester.trim();
				semester = semester.toUpperCase();
				String parse = grdgradefield2.getText();
				grade = parse.charAt(0);
				
			//	JOptionPane.showMessageDialog(null, grade);
				
				agrade = new grade(stid, cnum, yr, semester, grade);
				

				Gradefile = new gradefile("grade.dat");
				enrollfile = new EnrollFile("Enroll.dat");
				enrollrecords = enrollfile.getRecords();

				if (enrollrecords == 0)
				{
					throw new Exception ("Students are not enrolled in classes. Add Enrollments and Try again");
				}

				enrollobj = enrollfile.noMatches(enrollrecords, stid, cnum, yr, semester);


				if(enrollobj.isEmpty())
				{
					throw new Exception ("Enrollment doesn't exist in the database. Please try again");
				}


				else {
					
				long numrecords = Gradefile.getRecords();
				gradeobj = Gradefile.nodMatches(numrecords, stid, cnum, yr, semester);
				// System.out.println(numrecords);
				if (!gradeobj.isEmpty())
				{
					throw new Exception("Grade already exists for this student's course.");
				}
				else if (numrecords == 0) {
					
					Gradefile.writeGrade(agrade);
					Gradefile.close();
					
				}
				else {
					
					Gradefile.moveFilePointer(numrecords);
					Gradefile.writeGrade(agrade);
					Gradefile.close();

				}

				}
				
				buildgradepanel2();
				
			// end of try
				
			}
			
				catch(Exception e)
				{
						
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
					
			
				
				
				
				// end of searchgrade button
			}
			
			else if (button2.getSource() == editgradebt)
			{
				buildgradeedit();
				grade grade1 = (grade) gradeobj2.get(index);
				String stid = Integer.toString(grade1.getid());
				String cid = Integer.toString(grade1.getcnum());
				String yr = Integer.toString(grade1.getyear());
				String chgrade = Character.toString(grade1.getgrade());
				
				stidgradefield2.setText(stid);
				cidgradefield2.setText(cid);
				yrgradefield2.setText(yr);
				grdgradefield2.setText(chgrade);
				smgradefield2.setText(grade1.getsemester());
			}
		
			
			
			// end of grade buttons 
			
			
			else if (button2.getSource() == searchreport)
			{
				
			try 
			{
				gradeobj = new ArrayList <grade>();
				cnum = Integer.parseInt(stidreportfield.getText());
				yr = Integer.parseInt(yrreportfield.getText());
				
				enrollfile = new EnrollFile("Enroll.dat");
				studentfile = new StudentFile("Student.dat");
				coursefile = new CourseFile("Course.dat");
				Gradefile = new gradefile("grade.dat");
				studentrecords = studentfile.getRecords();
				courserecords = coursefile.getRecords();
				enrollrecords = enrollfile.getRecords();
				graderecords = Gradefile.getRecords();
				
				gradeobj = Gradefile.findMatches(graderecords, cnum, yr);
				int listlength = gradeobj.size();
				reportarray = new String[listlength];
				
				for (int a = 0; a <listlength; a++)
				{
					agrade = (grade) gradeobj.get(a);
					stid = agrade.getid();
					grade = agrade.getgrade();
					semester = agrade.getsemester();
					
					String reportstring = "StudentID: " + stid + "       " + "Semester: " + semester + "       " + "Grade: " + grade;
					
					reportarray[a] = reportstring;
				}
				
				reportlist.setListData(reportarray);
				reportlist.setVisible(true);
			// end of try
			}
			
			catch(Exception e)
			{
					
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
				
				// end of button
			}
			
		
			
			
			// end of action performed 
		}
	}
	
	public static void main(String[] args) 
	{
		
		MainWindow window = new MainWindow();

	}
	
		
	// end of Main Window Class
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	


