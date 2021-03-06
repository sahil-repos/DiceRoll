package testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({numberOfPlayersGreaterThanZero_AssertsTrue.class,
	DiceThrowShouldBeBetween1to6_AssertTrue.class,
	NumberOfPlayersLessThanOne_AssertFalse.class,
	PenaltyAfterTwoConsecutiveOnes_AssertTrue.class,
	GettingLastThrowValue_AssertTrue.class,
	SecondRollOnGettingSix_assertTrue.class,
	GetCorrectScoreAfterRolling_assertTrue.class,
	UpdatingScore_assertTrue.class,
	GetPlayerName.class,
	GameHasPlayer_3_assertTrue.class,})
public class AllTests {

	@Test
	public void ShouldCreateTest() {}
	
}
