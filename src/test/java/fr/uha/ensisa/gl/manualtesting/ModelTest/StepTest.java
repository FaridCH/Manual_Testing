package fr.uha.ensisa.gl.manualtesting.ModelTest;

import org.junit.Test;

import junit.framework.TestCase;
import fr.uha.ensisa.gl.manualtesting.Model.Step;
import static  junit.framework.Assert.*;

public class StepTest extends TestCase

{
	@Test
	public void testStep(){
		Step step = new Step();
		step.setType(true);
		step.setDesc("h");
		assertEquals("h",step.getDesc());
		assertEquals(true,step.getType());
		
		
		Step steps = new Step("h",true);
		assertEquals("h",steps.getDesc());
		assertEquals(true,steps.getType());
	}

}
