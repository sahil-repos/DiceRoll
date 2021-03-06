package game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import models.Player;

public class PlayGame {
	private Queue<Player> playerQueue;
	private int targetScore;
	private ArrayList<Player> winnersList;
	
	/**
	 * Take number of players as input n
	 *  and creates a random sequence for shuffling players
	 * @param n Number of players
	 * @return shuffled sequence list
	 */
	private ArrayList<Integer> createRandomSequence(int n) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		    for (int i = 1; i <= n; i++) {
		        seq.add(i);
		    }
		    Collections.shuffle(seq);
		    return seq;
	}
	
	/**
	 * Generates a Player Queue from the shuffled Sequence for the game
	 * @param sequence shuffled Sequence of integers
	 */
	private void createPlayers(ArrayList<Integer> sequence) {
		for(int s: sequence) {
			Player p= new Player(s);
			playerQueue.add(p);
		}
	}
	
	/**
	 * Returns size of PlayerQueue
	 * @return int value denoting size of playerQueue
	 */
	public int getQueueSize() {
		return this.playerQueue.size();
	}
	
	/**
	 * Return TargetScore for the game
	 * @return targetScore
	 */
	public int getTargetScore() {
		return this.targetScore;
	}
	
	/**
	 * Sets Target Score for the game
	 * @param t target score
	 */
	public void setTargetScore(int t) {
		this.targetScore=t;
	}
	
	/**
	 * Returns Players in playing order
	 * @return List of players in playing order
	 */
	public ArrayList<Player> getPlayersInPlayingOrder(){
		return new ArrayList<Player>(playerQueue);
	}
	
	/***
	 * Constructor for PlayGame class
	 * @param numberOfPlayers number of player for the game
	 */
	public PlayGame(int numberOfPlayers){
		this.targetScore=0;
		 playerQueue = new ArrayDeque<Player>();
		 this.winnersList= new ArrayList<Player>();
		ArrayList<Integer> sequence= this.createRandomSequence(numberOfPlayers);
		this.createPlayers(sequence);	
	}
	
	/**
	 * Rolls dice and returns the face value
	 * @return dice roll value
	 */
	public int rollDice() {
		int min=1,max=7;
	    //Random random = new Random();
	    //return random.nextInt(max - min) + min;
		return 4;
	}
	
	/**
	 * Utility function for Press any key to continue message in game
	 */
	public void pressEnterKeyToContinue()
	{ 
	        System.out.println("Press Enter key to continue dice roll...");
	        Scanner s = new Scanner(System.in);
	        s.nextLine();
	}
	
	/**
	 * Processes the message for player skipped due to acheiving targetScore
	 *  or having penalty.
	 * @param player
	 * @param targetScore
	 */
	private void skippingMessage(Player player,int targetScore){
		if(player.getScore() >= targetScore) {
			System.out.println(player.getPlayerName()+ " has already achieved the target score.\n No more dice rolls required");
		}
		else if(player.checkPenalty()){
			System.out.println("Player is serving a penalty due to two consecutive 1s");
			player.resetPenalty();
		}
	}
	
	/**
	 * Comparator class for comparing players by their score values 
	 * 
	 */
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
	
	/**
	 * Utility function for printing scoreCard
	 */
	public void printScoreCard() {
		ArrayList<Player> scoreList=getHighScores();
		System.out.println("\n************************************\n");
		System.out.println("Player Name  :  Score  :  Game Status \n");
		for(Player p: this.winnersList) {
			System.out.println(p.getPlayerName() + "     :    " + p.getScore()+ "  :    Completed ");
		}
		
		for(Player p: scoreList) {
			System.out.println(p.getPlayerName() + "     :    " + p.getScore() +"  :    in Progress");
		}
		System.out.println("\n************************************\n");

	}
	
	/**
	 * Returns players list sorted by highest score first
	 * @return List of players
	 */
	public ArrayList<Player> getHighScores(){
		 ArrayList<Player> scoreList= new ArrayList<Player>(this.playerQueue);
		 Collections.sort(scoreList, new PlayerComparator());
		 return scoreList;
	}
	
	/**
	 * Returns list of winners by rank
	 * @return List of players
	 */
	public ArrayList<Player> getWinnersList(){
		
		 return this.winnersList;
	}
	
	/**
	 * Checks if player has rolled a 6 or not
	 * @param player
	 */
	public void checkRollLuck(Player player) {
		if(player.checkLuck() ){
			//no modification to queue
			//players gets another go
			System.out.printf("It's a 6 ! %s will get an extra chance to roll the dice again \n ",player.getPlayerName()); 
		 }
		 else {
			 this.playerQueue.poll();
			 this.playerQueue.add(player);
		
		 }
	}
	
	/***
	 * check Roll penalty in case of consecutive 1 
	 * @param player
	 */
	public void checkRollPenalty(Player player){
		 if(player.checkPenalty()) {
			 System.out.printf("\n A second consecutive 1 means %s will miss their next turn \n ",player.getPlayerName());
		 }
	}
	
	/**
	 * Input utility
	 * @return array containing playerCount and target Score
	 */
	public static int[] takeInput() {
		Scanner in = new Scanner(System.in);
        System.out.println("\nPlease enter the number of players: ");
        int playerCount=in.nextInt();
		System.out.println("\nPlease enter the target score:");
        int target=in.nextInt();
        return new int[]{playerCount,target};
	}
	
	

	public static void main(String[] args) {
		
		try {
			System.out.println("\n -----------READY TO PLAY----------- \n");
			
			//taking input
			int inp[]=takeInput();
			int playerCount=inp[0];
			int target=inp[1];
	        while(playerCount<1 || target<1) {
	        	System.out.println("Please enter  valid input values greater than 1 !");
	        	inp=takeInput();
				playerCount=inp[0];
				target=inp[1];
	        }
			
			//start game
			PlayGame game = new PlayGame(playerCount);
			game.setTargetScore(target);

			//initial positions
			game.printScoreCard();
			
		 
			 while(game.getQueueSize()>0)
			 {
				 Player currentPlayer= game.playerQueue.peek();
				 System.out.println(" Throwing dice for :" + currentPlayer.getPlayerName() );
				 game.pressEnterKeyToContinue();
				 
				 if(!currentPlayer.checkPenalty() && (currentPlayer.getScore() < game.getTargetScore()) ){
					 //Player gets to roll the dice 
					 int throwVal=game.rollDice();
					 System.out.println("Dice value: "+ throwVal);
					 currentPlayer.processThrow(throwVal);
					 
					 game.checkRollPenalty(currentPlayer);
					 
					 if( (currentPlayer.getScore() ) >= game.getTargetScore() ){
						 
						 System.out.println("-------------------------------------------");
						 System.out.printf( "%s has reached the target value \n with a score of %d \n Rank: %d \n" ,currentPlayer.getPlayerName()
						 ,currentPlayer.getScore(),(game.winnersList.size()+1));
						 System.out.println("-------------------------------------------");
						 
						 //add to winner list
						 game.winnersList.add(currentPlayer);
						 
						 //remove winners from queue
						 game.playerQueue.poll();
						 game.printScoreCard();
						 continue;
					 }
					 
					 game.checkRollLuck(currentPlayer);
					 
					 
				 }
				 else {
					 //move queue without giving dice roll to player
					 
					 game.skippingMessage(currentPlayer,game.getTargetScore());
					 game.playerQueue.poll();
					 game.playerQueue.add(currentPlayer);
				 }
				 
				 //print ScoreCard
				 game.printScoreCard();
				 
			 }
		     System.out.println("******** Final Score Card *********");
		
		     System.out.println("************ Game Over ************");

		}
		catch(Exception e) {
			System.out.println("Exception occured: "+ e.getMessage());
			e.printStackTrace();
		}
		 
	  }
		
	

	}


