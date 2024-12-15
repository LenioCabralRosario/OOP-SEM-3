package de.nulldrei.oop.ex6.business.baelle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Supplier;

public class BallTest {
	
	
	private Ball ball;
	
	@BeforeEach
	void setUp() throws Exception {
		ball = new Ball(20200901, "Leder", null, "In Gebrauch", "Spiel", 4.20);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		ball = null;
	}
	
	
	@Test
	public void runTest() {
		try {
			// checkSportart gibt uns true zurück falls eine Sporart gesetzt ist, assertTrue gibt uns unsere Meldung aus wenn die Kondition false ist also gegen die Erwartung geht
			// wir haben noch keine Sportart gesetzt, folglich müssen wir überprüfen ob checkSportart true ist, ist dies der Fall so haben wir eine Sportart ungleich null			
			assertTrue(ball.checkSportart(), "Die Sportart ist nicht gesetzt");
			ball.setSportart("Eishockey");
			// Wir überprüfen checkSportart() das liefert uns TRUE wenn eine Sportart gesetzt wird, ist dem nicht der Fall so haben wir false was gegen unsere Assertion geht und die Nachricht
			// Wird ausgegeben
			assertTrue(ball.checkSportart()==false, "Die Sportart ist gesetzt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
