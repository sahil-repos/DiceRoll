package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Player;

public class GetPlayerName {

	@Test
	public void test() {
		int id=2;
		Player p1= new Player(id);
		
		String expectedName="Player_"+id;
		String actualName=p1.getPlayerName();
		
		
		assertTrue("Actual name should be equal to expectedName ",expectedName.equals(actualName));
	}

}
