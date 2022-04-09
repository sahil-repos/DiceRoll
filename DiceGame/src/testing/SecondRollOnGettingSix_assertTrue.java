package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class SecondRollOnGettingSix_assertTrue {

	@Test
	public void test() {
		Player p1= new Player(1);
		p1.processThrow(6);
		
		boolean hasLuckySecondRoll= p1.checkLuck();
		
		assertTrue("Should have a second lucky throw after drawing 6 ",hasLuckySecondRoll);
	}

}
