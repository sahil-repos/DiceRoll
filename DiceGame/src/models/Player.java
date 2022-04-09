package models;

public class Player {
private int playerId;
private String playerName;
private int lastDiceValue;
private boolean hasPenalty;
private boolean isLucky;
private int score;

	public Player(int id){
		this.playerId=id;
		this.playerName="Player_"+this.playerId;
		this.lastDiceValue=0;
		this.hasPenalty=false;
		this.isLucky=false;
		this.score=0;
	}
	
	public int getLastDiceValue() {
		
		return lastDiceValue ;
	}
	public int getScore(){
		return score;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void updateScore(int s) {
		this.score+=s;
	}
	
	public void updateLastDiceValue(int currentDiceThrow) {
		this.lastDiceValue=currentDiceThrow;
	}
	
	public boolean checkPenalty(){
		return hasPenalty;
	}
	public boolean checkLuck(){
		return isLucky;
	}
	
	public void resetPenalty() {
		this.hasPenalty=false;
	}
	
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

