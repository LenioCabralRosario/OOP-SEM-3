package de.nulldrei.oop.ex6.business.baelle;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BallBuyTest {
	
	private Ball ball;
	
	@BeforeEach
	void setUp() throws Exception {
		ball = new Ball(20201019, "Krokodil", "Bask-Ice-Ball", "In Gebrauch", "Spiel", 69.9);		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		ball = null;
	}
	
	@Test
	public void runTest()  {
		double result;
		try {
			ball.calculatePricePerArticle(-1);
			fail("Exception: 'Das sollte einen Fehler liefern, da wir eine negative Anzahl haben'");
		} catch (Exception e) {
		}
		try {
			ball.calculatePricePerArticle(0);
			fail("Exception: 'Das sollte einen Fehler liefern, da wir eine Anzahl gleich 0 haben'");
		} catch (Exception e) {
			
		}
		result = ball.calculatePricePerArticle(500);
		System.out.println(ball.getPreis() - (ball.getPreis() * 0.25));
		assertEquals(52.425,  ball.calculatePricePerArticle(500), 0.001);
		result = ball.calculatePricePerArticle(1000);
		System.out.println(ball.getPreis() - (ball.getPreis() * 0.4));
		assertEquals(41.94,  ball.calculatePricePerArticle(1000), 0.001);
		result = ball.calculatePricePerArticle(1001);
		System.out.println(ball.getPreis() - (ball.getPreis() * 0.4));
		assertEquals(41.94,  ball.calculatePricePerArticle(1001), 0.001);
	}
	

}
