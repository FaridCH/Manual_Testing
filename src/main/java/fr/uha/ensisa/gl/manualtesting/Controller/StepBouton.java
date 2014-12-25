package fr.uha.ensisa.gl.manualtesting.Controller;


import java.util.List;

import fr.uha.ensisa.gl.manualtesting.Model.Step;
import fr.uha.ensisa.gl.manualtesting.Model.ManualTest;

public class StepBouton {
	
	public static void down(int i, ManualTest model)
	{
		List<Step> st = model.getStep(); 
		if(i < st.size()-1) 
		{
			Step step = st.get(i); 
			st.remove(i);
			st.add(i+1, step);
		}
	}
	
	public static void up(int i, ManualTest model)
	{
		if(i>0)
		{
			List<Step> st = model.getStep();
			Step step = st.get(i);
			st.remove(i);
			st.add(i-1, step);
		}
	}
	
}