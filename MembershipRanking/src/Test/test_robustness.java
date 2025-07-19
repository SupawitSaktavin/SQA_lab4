package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class test_robustness {
	
	Ranking test;
	
	@BeforeEach
	public void setUp() throws Exception {
		test = new Ranking();
	}
	
	@DisplayName("Robustness testing")
	@ParameterizedTest
	@CsvSource({
	"-1,	15, 500, Invalid Input",
	"0,		15, 500, Standard",
	"1,		15, 500, Standard",
	"50000,	15, 500, Standard",
	"99999,	15, 500, Standard",
	"100000,15, 500, Standard",
	"100001,15, 500, Standard",
	
	"50000, -1, 500, Invalid Input",
	"50000, 0, 500, Standard",
	"50000, 1, 500, Standard",
	"50000, 29, 500, Standard",
	"50000, 30, 500, Standard",
	"50000, 31, 500, Standard",
	
	"50000, 15, -1, Invalid Input",
	"50000, 15, 0, Standard",
	"50000, 15, 1, Standard",
	"50000, 15, 999, Standard",
	"50000, 15, 1000, Standard",
	"50000, 15, 1001, Standard"
	})
	void testBoundary(int purchaseTotal, int frequency, int pointCollected, String expected) {
		assertEquals(expected, test.CalculateMembershipRank(purchaseTotal, frequency, pointCollected));
	}

}
