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
	"-1,	4, 500, Invalid Input",
	"0,		4, 500, Standard",
	"1,		4, 500, Standard",
	"50000,	4, 500, Gold",
	"99999,	4, 500, Gold",
	"100000,4, 500, Gold",
	"100001,4, 500, Standard",
	
	"50000, -1, 500, Invalid Input",
	"50000, 0, 500, Standard",
	"50000, 1, 500, Silver",
	"50000, 6, 500, Standard",
	"50000, 7, 500, Standard",
	"50000, 8, 500, Standard",
	
	"50000, 4, -1, Invalid Input",
	"50000, 4, 0, Standard",
	"50000, 4, 1, Standard",
	"50000, 4, 999, Gold",
	"50000, 4, 1000, Gold",
	"50000, 4, 1001, Standard"
	})
	void testBoundary(int purchaseTotal, int frequency, int pointCollected, String expected) {
		assertEquals(expected, test.CalculateMembershipRank(purchaseTotal, frequency, pointCollected));
	}

}
