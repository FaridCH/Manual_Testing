package fr.uha.ensisa.gl.manualtesting.DataBaseTest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import junit.framework.TestCase;
import fr.uha.ensisa.gl.manualtesting.DataBase.Timer;

public class TimerTest extends TestCase {
	
	Timer timer = new Timer("test",1);
	
	@Test
	public void testgetTest() 
	{
		String test = timer.getTest();
		assertEquals(test,"test");
	}
	
	@Test
	public void testgetId()
	{
		int id = timer.getId();
		assertEquals(id,1);
	}
	
	@Test
	public void testgetDate()
	{
		Date aujourdhui = new Date();
		DateFormat fullDateFormatEN = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, new Locale("EN","en"));
		String newDate = fullDateFormatEN.format(aujourdhui);
		
		String date = timer.getDate();
		assertEquals(date,newDate);
	}
	
	@Test
	public void testgetTimedebut()
	{
		Date aujourdhui = new Date();
		Long newLongTime = new Long(aujourdhui.getTime()/1000);
		
		Long longTime = timer.getTimedebut();
		assertEquals(longTime,newLongTime);
	}
	
	@Test
	public void testgetTimefin()
	{
		Long timeFin = (long) 0;
		assertEquals(timer.getTimefin(),timeFin);
	}
	
	@Test
	public void testsetTimefin()
	{
		Long newTimeFin = (long) 10;
		timer.setTimefin(newTimeFin);
		assertEquals(timer.getTimefin(),newTimeFin);
	}
	
	@Test
	public void testgetTime()
	{
		Long time = timer.getTimefin() - timer.getTimedebut();
		assertEquals(timer.getTime(),time);
	}
	
	@Test
	public void testgetEndDate()
	{
		Date end = new Date(timer.getTimefin()*1000);
		DateFormat fullDateFormatEN = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, new Locale("EN","en"));
		String newEndDate =  fullDateFormatEN.format(end);
		assertEquals(timer.getEndDate(),newEndDate);
	}
	
	@Test
	public void testisStatus()
	{
		boolean statut = false;
		assertEquals(timer.isStatus(),statut);
	}
	
	@Test
	public void testsetStatus()
	{
		timer.setStatus(true);
		assertEquals(timer.isStatus(),true);
	}
	
	@Test
	public void testgetReportfailure()
	{
		String report = "";
		assertEquals(timer.getReportfailure(),report);
	}
	
	@Test
	public void testsetReportfailure()
	{
		timer.setReportfailure("Rapport du Test");
		assertEquals(timer.getReportfailure(),"Rapport du Test");
	}

}
