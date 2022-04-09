package testing;

import static org.junit.Assert.*;
import game.PlayGame;

import org.junit.Test;

public class numberOfPlayersGreaterThanZero_AssertsTrue {

	@Test
	public void test() {
		//fail("Not yet implemented");
		PlayGame game= new PlayGame(2);
		assertTrue("Number of players should be greater than 0 ", game.getQueueSize() > 0);
	}

}
