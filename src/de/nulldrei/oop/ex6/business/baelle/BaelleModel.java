package de.nulldrei.oop.ex6.business.baelle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import de.nulldrei.oop.ex5.business.SportartikelListe;

public class BaelleModel {
 	
	private SportartikelListe<Ball> baelle = new SportartikelListe<Ball>();

	
	public SportartikelListe<Ball> holeBaelle() {
		return baelle;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		for(int i = 0; i <= baelle.getAnzahlSportartikel(); i++) {
			Ball ball = baelle.getSportartikel(i);
			if(Integer.parseInt(einkaufsdatum) == ball.getEinkaufsdatum()) {
				return ball;
			}
		}
		return null;
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
		System.out.println("Gib ihm");
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	    int count = Integer.parseInt(ein.readLine());
	   	for(int i = 0; i < count; i++) {
	   		String[] line = ein.readLine().split(";");
	   	 	Ball tmpBall = new Ball(
		   			Integer.parseInt(line[0]), 
		   			line[1], line[2], line[3], line[4], 
		   			Double.parseDouble(line[5]));
	   	 	baelle.addSportartikel(tmpBall);
	   	}
	    ein.close();
 	}
	
	/* ArrayList implementation
	 * 
	 * 
	private ArrayList<Ball> baelle = new ArrayList<Ball>();

	
	public Ball[] holeBaelle() {
		Ball[] result = new Ball[baelle.size()];		
		for(int i = 0; i <= baelle.size(); i++) {
			result[i] = baelle.get(i);
		}
		return result;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		for(Ball ball : baelle) {
			if(Integer.parseInt(einkaufsdatum) == ball.getEinkaufsdatum()) {
				return ball;
			}
		}
		return null;
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	    int count = Integer.parseInt(ein.readLine());
	   	for(int i = 0; i < count; i++) {
	   		String[] line = ein.readLine().split(";");
	   	 	Ball tmpBall = new Ball(
		   			Integer.parseInt(line[0]), 
		   			line[1], line[2], line[3], line[4], 
		   			Double.parseDouble(line[5]));
	   	 	baelle.add(tmpBall);
	   	}
	    ein.close();
 	}
	*/
	
	
}