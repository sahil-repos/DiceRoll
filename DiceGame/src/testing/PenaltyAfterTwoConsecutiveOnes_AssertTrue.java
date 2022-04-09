package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class PenaltyAfterTwoConsecutiveOnes_AssertTrue {

	@Test
	public void test() {
		Player p1= new Player(1);
		p1.processThrow(1);
		p1.processThrow(1);
		boolean penalty= p1.checkPenalty();
		
		assertTrue("Should have a penalty ",penalty);
		
	}

}
