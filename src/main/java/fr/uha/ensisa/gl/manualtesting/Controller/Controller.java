package fr.uha.ensisa.gl.manualtesting.Controller;

import java.util.ArrayList;



public class Controller {
	
	public ArrayList list_test;
	public String namepage;
	
	

	public Controller(){
	this.namepage = new String("Hello World");
	}

	public void setPageTitle(String title)
	{
	this.namepage=title;
	}

	public String getPageTitle()
	{
	return this.namepage;
	}


}
