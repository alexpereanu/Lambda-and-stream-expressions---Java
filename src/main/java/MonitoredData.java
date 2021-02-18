package Tema5.Tema5;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class MonitoredData {

	public DateTime start;
	public DateTime end;
	public String activities;

	
	
	public MonitoredData(DateTime start, DateTime end, String activities) {
		//super();
		this.start = start;
		this.end = end;
		this.activities = activities;
	}
	
	public MonitoredData() {
		
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "MonitoredData [start=" + start + ", end=" + end + ", activities=" + activities + "]";
	}

	
	
	
	
	
}
