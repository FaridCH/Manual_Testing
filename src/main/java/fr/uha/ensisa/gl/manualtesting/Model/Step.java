package fr.uha.ensisa.gl.manualtesting.Model;

public class Step 
{
	String desc;
	boolean type;
	
	public Step()
	{
	
	}
	
	public Step(String desc,boolean type)
	{
		this.type=type;
		this.desc=desc;
	}
	
	public boolean getType()
	{ 
		return type;
	}
	
	public String getDesc()
	{ 
		return desc;
	}
	
	public void setType(boolean type)
	{ 
		this.type=type;
	}
	
	public void setDesc(String desc)
	{ 
		this.desc=desc;
	}
	
	
	
}
