package com.example.tabletapp;

import java.util.ArrayList;
import android.util.Log;

public class Match implements Runnable {

	private Connection conn;
	private Information info;	
	private ArrayList<Time> times;
	
	public Match(Information info) {
		this.info = info;
		this.times = new ArrayList<Time>();
	}
	
	@Override
	public void run() {
		conn = new Connection();
    	conn.println(info.getRacerName() + " " + info.getDistance());

		// Listen for response
		String line;    			
		while ((line = conn.readLine()) != null) {
			if (line.equals("#"))
				break;				
			if (line.split(" ").length == 4)
				newTime(line);			
		}				
	}
	
	private void newTime(String line) {
		times.add(new Time(line));
		Log.i("tag", line);
		times.add(new Time(line));		
	}
	
	public ArrayList<Time> getTimes() {
		return times;
	}	
	
	public Information getInfo() {
		return info;
	}		
		
	/**
	 * Round time information
	 */
	private class Time {
		
		private int roundNumber;
		private int roundTime;
		private int totalMeters;
		private int totalTime;
		
		private Time(String line) {			
			String[] split = line.split(" ");
			this.roundNumber = Integer.parseInt(split[0]);
			this.roundTime = Integer.parseInt(split[3]);
			this.totalMeters = Integer.parseInt(split[1]);
			this.totalTime = Integer.parseInt(split[2]);				
		}

		public int getRoundNumber() {
			return roundNumber;
		}

		public int getRoundTime() {
			return roundTime;
		}

		public int getTotalMeters() {
			return totalMeters;
		}

		public int getTotalTime() {
			return totalTime;
		}

		@Override
		public String toString() {
			return "Time [roundNumber=" + roundNumber + ", roundTime="
					+ roundTime + ", totalMeters=" + totalMeters
					+ ", totalTime=" + totalTime + "]";
		}		
	}	
}
