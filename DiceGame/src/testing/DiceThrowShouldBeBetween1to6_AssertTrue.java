package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import game.PlayGame;

public class DiceThrowShouldBeBetween1to6_AssertTrue {

	@Test
	public void test() {
		PlayGame game= new PlayGame(2);
		int rollValue=game.rollDice();
		
		assertTrue("Dice Roll : "+ rollValue + " should be in range [1,6] ", (rollValue <7) && (rollValue>0 ) );


}
}
