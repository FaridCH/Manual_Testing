package fr.uha.ensisa.gl.manualtesting.DataBase;
import fr.uha.ensisa.gl.manualtesting.Model.ManualTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase {
	private static ArrayList<ManualTest> tests = new ArrayList<ManualTest>();
	private static List<Timer> historique = new ArrayList<Timer>();
	
	public static void add(ManualTest test)
	{
		tests.add(test);
	}
	
	public static void delete(int index)
	{
		if(index < tests.size())
			tests.remove(index);
	}
	
	public static ManualTest get(int index)
	{
		if(index < tests.size())
			return tests.get(index);
		return null; 
	}
	
	public static void clear()
	{
		tests.clear();
	}
	
	public static ArrayList<ManualTest> getAll()
	{
		return tests;
	}
	
	public static boolean contient(ManualTest test)
	{
		Iterator<ManualTest> it = tests.iterator();
		if(!tests.isEmpty()){
			while (it.hasNext()) 
				if(test == (ManualTest) it.next())
					return true; 
			}
		return false;
	}
	
	public static List<Timer> getHistorique() {
		return historique;
	}
	
	
	
	
}
