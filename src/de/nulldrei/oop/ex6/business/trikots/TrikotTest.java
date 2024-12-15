package de.nulldrei.oop.ex6.business.trikots;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class TrikotTest {
	
	private Trikot trikot;
	
	@AfterEach
	void tearDown() throws Exception {
		this.trikot = null;
	}
	
	@Test
	public void runTest() {
		// Wir erstellen unser Test-Objekt
		Trikot trikot = new Trikot(-1, 9, 4.2, 20200901);
		// Wir gehen davon aus, dass diese Abfragen TRUE liefern, tun sie das nicht, so haben wir den Fehler dass wir Nummern kleiner 0 haben, was wir nicht erlauben, folglich wird der Fehler ausgegeben
		assertTrue(trikot.getTrikotnummer()>0, "Diese Trikotnummer ist kleiner als 0, fehler");
		assertTrue(trikot.getGroesse()>0, () -> "Dieser Trikotgröße ist kleiner als 0, fehler");
		// Wir haben eine Exception welche wir mittels assertTrhows instanzieren, dabei erstellen wir ein Trikot was eine Exception liefert, sobald diese Exception gelifert wurde, geben wir eine Nachricht mittels assertEquals aus
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> {
			new Trikot(-1, 40, 29.99, 20220919);
		});
		// Wir überprüfen ob die Fehlermeldung die wir aus der Exception kriegen wirklich die korrekte ist
		assertEquals("Die Trikotnummer darf nicht 0 oder negativ sein.", exc.getMessage());
	}
}
