package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import game.PlayGame;

public class NumberOfPlayersLessThanOne_AssertFalse {

	@Test
	public void test() {
		PlayGame game= new PlayGame(2);
		assertFalse("Number of players should be less than one ", game.getQueueSize() < 1);
	
	}

}
