package com.example.tabletapp;

public class Information {

	private String racerName;
	private String opponentName;	
	private String raceDescription;	
	private int distance;
	private int goldenGoal;
	private int silverGoal;
	private int bronzeGoal;
	
	public Information() {		
	}	
	
	public Information(String racerName, String opponentName, String raceDescription, int distance, int goldenGoal, int silverGoal, int bronzeGoal) {
		this.racerName = racerName;
		this.opponentName = opponentName;
		this.raceDescription = raceDescription;
		this.distance = distance;
		this.goldenGoal = goldenGoal;
		this.silverGoal = silverGoal;
		this.bronzeGoal = bronzeGoal;
	}

	public String getRacerName() {
		return racerName;
	}
	public void setRacerName(String racerName) {
		this.racerName = racerName;
	}
	public String getOpponentName() {
		return opponentName;
	}
	public void setOpponentName(String opponentName) {
		this.opponentName = opponentName;
	}
	public String getRaceDescription() {
		return raceDescription;
	}
	public void setRaceDescription(String raceDescription) {
		this.raceDescription = raceDescription;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getGoldenGoal() {
		return goldenGoal;
	}
	public void setGoldenGoal(int goldenGoal) {
		this.goldenGoal = goldenGoal;
	}
	public int getSilverGoal() {
		return silverGoal;
	}
	public void setSilverGoal(int silverGoal) {
		this.silverGoal = silverGoal;
	}
	public int getBronzeGoal() {
		return bronzeGoal;
	}
	public void setBronzeGoal(int bronzeGoal) {
		this.bronzeGoal = bronzeGoal;
	}

	@Override
	public String toString() {
		return "Information [racerName=" + racerName + ", opponentName="
				+ opponentName + ", raceDescription=" + raceDescription
				+ ", distance=" + distance + ", goldenGoal=" + goldenGoal
				+ ", silverGoal=" + silverGoal + ", bronzeGoal=" + bronzeGoal
				+ "]";
	}	
	
	
	
}
