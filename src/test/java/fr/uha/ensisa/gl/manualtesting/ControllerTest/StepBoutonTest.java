package fr.uha.ensisa.gl.manualtesting.ControllerTest;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.uha.ensisa.gl.manualtesting.Controller.*;
import fr.uha.ensisa.gl.manualtesting.Model.*;
import junit.framework.TestCase;

public class StepBoutonTest extends TestCase {

	@Test
	public void testStepBouton(){
		new StepBouton();
    	Step step1 = new Step();
    	Step step2 = new Step();
    	ManualTest test = new ManualTest();
    	List<Step> steps = test.getStep();
    	steps.add(step1);
    	steps.add(step2);
    	
    	StepBouton.up(1,test);
    	assertEquals(step2,steps.get(0));
    	assertEquals(step1,steps.get(1));
    	
    	steps.clear();
    	steps.add(step1);
    	steps.add(step2);
    	
    	StepBouton.down(0,test);
    	assertEquals(step2,steps.get(0));
    	assertEquals(step1,steps.get(1));
    	
    	steps.clear();
    	steps.add(step1);
    	steps.add(step2);
    	
    	StepBouton.up(0,test);
    	assertEquals(step1,steps.get(0));
    	assertEquals(step2,steps.get(1));
    	
    	StepBouton.down(1,test);
    	assertEquals(step1,steps.get(0));
    	assertEquals(step2,steps.get(1));
	}

}
