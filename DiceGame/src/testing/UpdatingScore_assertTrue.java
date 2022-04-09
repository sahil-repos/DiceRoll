package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class UpdatingScore_assertTrue {

	@Test
	public void test() {
		Player p1= new Player(1);
		int prevScore=p1.getScore();
		int diceVal=8;
		
		p1.updateScore(diceVal);
		
		int latestScore=p1.getScore();
		
		assertTrue("latestScore should be updated correctly ",latestScore== (prevScore+diceVal));
	}

}
