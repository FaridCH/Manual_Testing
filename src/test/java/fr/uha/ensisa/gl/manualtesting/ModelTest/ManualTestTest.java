package fr.uha.ensisa.gl.manualtesting.ModelTest;

import org.junit.Test;

import junit.framework.TestCase;
import fr.uha.ensisa.gl.manualtesting.Model.*;
import static  junit.framework.Assert.*;

public class ManualTestTest extends TestCase
{
	@Test
	public void testManual()
	{
		ManualTest manual=new ManualTest("hh",false);
		assertEquals("hh",manual.getName());
		assertEquals(false,manual.getDone());
		
		ManualTest manual2=new ManualTest();
		manual2.setDone(true);
		manual2.setName("h");
		assertEquals("h",manual2.getName());
		assertEquals(true,manual2.getDone());
		
	}

}
