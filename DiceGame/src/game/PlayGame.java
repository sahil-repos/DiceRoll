package game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

//import models.Player;

public class PlayGame {
	private Queue<Player> playerQueue;
	
	private ArrayList<Integer> createRandomSequence(int n) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		    for (int i = 1; i <= n; i++) {
		        seq.add(i);
		    }
		    Collections.shuffle(seq);
		    return seq;
	}
	private void createPlayers(ArrayList<Integer> sequence) {
		for(int s: sequence) {
			Player p= new Player(s);
			playerQueue.add(p);
		}
	}
	
	
	public PlayGame(int numberOfPlayers){
		 playerQueue = new ArrayDeque<Player>();
		ArrayList<Integer> sequence= this.createRandomSequence(numberOfPlayers);
		this.createPlayers(sequence);
		System.out.println("\n -----------READY TO PLAY----------- \n");
		
	}
	
	public int rollDice() {
		int min=1,max=7;
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	public void pressEnterKeyToContinue()
	{ 
	        System.out.println("Press Enter key to continue dice roll...");
	        Scanner s = new Scanner(System.in);
	        s.nextLine();
	}
	private void skippingMessage(Player player,int targetScore){
		if(player.getScore() >= targetScore) {
			System.out.println(player.getPlayerName()+ " has already achieved the target score.");
		}
		else if(player.checkPenalty()){
			System.out.println("Player is serving a penalty due to two consecutive 1s");
			player.resetPenalty();
		}
	}
	
	public class PlayerComparator implements Comparator<Player>{
        
        // Overriding compare()method of Comparator 
       // for descending order of score
        public int compare(Player p1, Player p2) {
            if (p1.getScore() < p2.getScore()) {
                return 1;
            }
            else if (p1.getScore() > p2.getScore()) {
                return -1;
            }
            return 0;
            }
    }
	
	public void printScoreCard() {
		ArrayList<Player> scoreList=getHighScores();
		System.out.println("\n***************************\n");
		System.out.println("Player Name  : Score\n");
		for(Player p: scoreList) {
			System.out.println(p.getPlayerName() + "    :     " + p.getScore());
		}
		System.out.println("\n***************************\n");

	}
	
	public ArrayList<Player> getHighScores(){
		 ArrayList<Player> scoreList= new ArrayList<Player>(this.playerQueue);
		 Collections.sort(scoreList, new PlayerComparator());
		 return scoreList;
	}
	
	

	public static void main(String[] args) {
		
		try {
			int targetScore=0,numberOfPlayers=0;
			Scanner in = new Scanner(System.in);
	        System.out.println("Please enter the number of players: ");
	        numberOfPlayers= in.nextInt();
		    
	        System.out.println("Please enter the target score:");
	        targetScore= in.nextInt();

			PlayGame game = new PlayGame(numberOfPlayers);
			int winners=0;
		 
			 while(winners<game.playerQueue.size())
			 {
				 Player currentPlayer= game.playerQueue.peek();
				 System.out.println(" Throwing dice for :" + currentPlayer.getPlayerName() );
				 game.pressEnterKeyToContinue();
				 
				 if(!currentPlayer.checkPenalty() && (currentPlayer.getScore() < targetScore) ){
					
					 int throwVal=game.rollDice();
					 System.out.println("Dice value: "+ throwVal);
					 currentPlayer.processThrow(throwVal);
					 if( (currentPlayer.getScore() ) >= targetScore ){
						 winners++;
					 }
					 if(!currentPlayer.checkLuck() ){
						 
						 game.playerQueue.poll();
						 game.playerQueue.add(currentPlayer);
						 
					 }
					 else {
						 //no modification to queue
						 //players gets another go
						 System.out.println("It's a 6 ! You will get an extra chance to roll the dice again ");
					 }	 
					 
				 }
				 else {
					 //move queue without giving dice roll to player
					 game.skippingMessage(currentPlayer,targetScore);
					 game.playerQueue.poll();
					 game.playerQueue.add(currentPlayer);
				 }
				 
				 //print Score
				 //System.out.println(game.playerQueue.size());
				 game.printScoreCard();
				 
				 
			 }
		        //Scanner in = new Scanner(System.in);
		     System.out.println("********Final Score Card*********");
			 game.printScoreCard();
		     System.out.println("********Game Over*********");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
	    }
		
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


	}

