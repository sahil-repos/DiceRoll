package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class GetCorrectScoreAfterRolling_assertTrue {

	@Test
	public void test() {
		Player p1= new Player(1);
		
		p1.processThrow(1);
		p1.processThrow(4);
		p1.processThrow(6);
		
		
		int totalScore=p1.getScore();
		
		
		assertTrue("Total Score should be 11 ",totalScore ==11);
	}

}
