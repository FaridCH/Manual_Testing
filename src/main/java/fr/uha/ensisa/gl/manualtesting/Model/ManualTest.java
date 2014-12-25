package fr.uha.ensisa.gl.manualtesting.Model;

import java.util.ArrayList;
import java.util.List;


public class ManualTest {
	
	private List<Step> step = new ArrayList<Step>();
	boolean done =false;
	String nameTest;
	
	public ManualTest()
	{
		
	}
	
	public ManualTest(String nameTest,  boolean done)
	{
		this.nameTest=nameTest;
		this.done=done;
		
	}

	public List<Step> getStep() {
		// TODO Auto-generated method stub
		return step;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return nameTest;
	}
	
	public boolean getDone() 
	{
		// TODO Auto-generated method stub
		return done;
	}
	
	
	public void setName(String nameTest) 
	{
		this.nameTest=nameTest;

	}
	
	public void setDone(boolean done) 
	{
		this.done=done;

	}
	
	
	

	
	

}
