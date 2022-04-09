package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import game.PlayGame;

public class GameHasPlayer_3_assertTrue {

	@Test
	public void test() {
		PlayGame game= new PlayGame(4);
		
		
		assertTrue("Game should have 'Player_3' : ", game.getPlayersInPlayingOrder().stream().filter(player ->
		player.getPlayerName().equals("Player_3")).findAny().isPresent() );

	}

}
