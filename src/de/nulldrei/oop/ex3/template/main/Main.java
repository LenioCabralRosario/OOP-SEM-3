package de.nulldrei.oop.ex3.template.main;

import de.nulldrei.oop.ex3.template.business.ArtikelModel;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		ArtikelModel artikelModel = new ArtikelModel();
		try {
			artikelModel.leseArtikelAusCsvDatei();
			artikelModel.schreibeArtikelInTxtDatei();
			artikelModel.schreibeArtikelInKonsole();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
