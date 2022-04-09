package models;

public class Player {
private int playerId;
private String playerName;
private int lastDiceValue;
private boolean hasPenalty;
private boolean isLucky;
private int score;
	/**
	 * Constructor for Player class
	 * @param id id number for player to be initialised
	 */
	public Player(int id){
		this.playerId=id;
		this.playerName="Player_"+this.playerId;
		this.lastDiceValue=0;
		this.hasPenalty=false;
		this.isLucky=false;
		this.score=0;
	}
	
	/**
	 * Checks player's last roll and returns dice value
	 * @return last value of dice rolled by player
	 */
	public int getLastDiceValue() {
		
		return this.lastDiceValue ;
	}
	
	/**
	 * Returns latest score of player 
	 * @return Current Score of player
	 */
	public int getScore(){
		return this.score;
	}
	
	/**
	 * getPlayerName
	 * @return Player's name
	 */
	public String getPlayerName(){
		return this.playerName;
	}
	
	/**
	 * Takes dice roll value and add it to player's current score
	 * @param s latest dice roll value
	 */
	public void updateScore(int s) {
		this.score+=s;
	}
	
	/**
	 * Updates last dice roll value of player
	 * @param currentDiceThrow Latest dice roll value by player
	 */
	public void updateLastDiceValue(int currentDiceThrow) {
		this.lastDiceValue=currentDiceThrow;
	}
	
	/**
	 * Checks and returns true if player has a penalty
	 * @return hasPenalty boolean flag
	 */
	public boolean checkPenalty(){
		return this.hasPenalty;
	}
	
	/**
	 *Checks and returns true if player has a lucky second roll chance
	 * @return isLucky boolean flag
	 */
	public boolean checkLuck(){
		return this.isLucky;
	}
	
	/**
	 * Resets hasPenalty flag for player to false
	 */
	public void resetPenalty() {
		this.hasPenalty=false;
	}
	
	/**
	 * Takes latest dice roll value and process hasPenalty, isLucky flag
	 *  and updates player's score and last dice value
	 * @param currentThrowVal Dice roll value
	 */
	public void processThrow(int currentThrowVal){
		if(currentThrowVal==6){
			this.isLucky=true;
			this.hasPenalty=false;
		}
		else if( (currentThrowVal==this.lastDiceValue) && (currentThrowVal==1)){
			this.hasPenalty=true;
		}
		else {
			this.hasPenalty=false;
			this.isLucky=false;

		}
		
		updateScore(currentThrowVal);
		updateLastDiceValue(currentThrowVal);
	}
	
}

