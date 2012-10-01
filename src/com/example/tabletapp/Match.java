package com.example.tabletapp;

import java.util.ArrayList;
import android.util.Log;

public class Match implements Runnable {

	private static Match instance = null;
	private Connection conn;
	private Information info;	
	private ArrayList<Time> times;
	private int bestLapTime = 0;
	private int currentTime;
	
	private Match() {
		this.times = new ArrayList<Time>();
	}
	
	public static Match getInstance() {
		if (instance == null) {
			instance = new Match();
			return instance;
		}	
		return instance;
	}
	
	@Override
	public void run() {
		
		// Reset instance
		times.clear();
		
		// Request server
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
		Time roundTime = new Time(line);		
		times.add(roundTime);
		currentTime = roundTime.getRoundTime();
		checkCurrentLane();
		if (roundTime.getTotalMeters() < 400)
			checkMatchTimes(roundTime);
	}
	
	private void checkCurrentLane() {
		if(info.getLane())
			info.setLane(false);
		else
			info.setLane(true);
	}
	
	private void checkMatchTimes(Time roundTime) {		
		if(bestLapTime != 0) {
			if(roundTime.getRoundTime() < bestLapTime)
				bestLapTime = roundTime.getRoundTime();
		}
		else
			bestLapTime = roundTime.getRoundTime();		
	}
	
	public ArrayList<Time> getTimes() {
		return times;
	}	
	
	public void setInfo(Information info) {
		this.info = info;
	}
	
	public Information getInfo() {
		return info;
	}		
	
	public int getBestLapTime() {
		return bestLapTime;
	}
	
	public int getCurrentTime() {
		return currentTime;
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
			
			Log.i("NEW TIME", this.toString());
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
