package fr.uha.ensisa.gl.manualtesting.DataBase;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Timer {
	private String test, date;
	private boolean status;
	private int id;
	private Long timedebut, timefin;
	private String reportfailure;
	

	public Timer(String test, int id)
	{
		this.test = test;
		this.id = id;
		this.timefin=(long) 0;
		
		Date aujourdhui = new Date();
		DateFormat fullDateFormatEN = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, new Locale("EN","en"));
		Long longTime = new Long(aujourdhui.getTime()/1000);
		
		this.date = fullDateFormatEN.format(aujourdhui);
		this.timedebut=longTime;
		this.reportfailure="";
	}
	public String getTest() {
		return test;
	}
	public String getDate() {
		return date;
	}
	public Long getTimedebut() {
		return timedebut;
	}
	public Long getTimefin() {
		return timefin;
	}
	public void setTimefin(Long timefin) {
		this.timefin = timefin;
	}
	
	public Long getTime()
	{
		return timefin-timedebut;
	}
	
	public String getEndDate()
	{
		Date end = new Date(timefin);
		DateFormat fullDateFormatEN = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, new Locale("EN","en"));
		return fullDateFormatEN.format(end);
	}
	
	public int getId() {
		return id;
	}
	public boolean isStatus() {
		return status;
	}												
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getReportfailure() {
		return reportfailure;
	}
	public void setReportfailure(String reportfailure) {
		this.reportfailure = reportfailure;
	}

}