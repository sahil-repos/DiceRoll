package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class GettingLastThrowValue_AssertTrue {

	@Test
	public void test() {
		Player p1= new Player(1);
		p1.processThrow(1);
		
		int lastThrow=p1.getLastDiceValue();
		
		
		assertTrue("Last dice value was 1 ",lastThrow == 1);
	}

}
