package de.nulldrei.oop.ex3.template.business;


import de.nulldrei.oop.ex3.template.writers.ConcreteWriterCreator;
import de.nulldrei.oop.ex3.template.writers.WriterCreator;
import de.nulldrei.oop.ex3.template.writers.WriterProduct;
import de.nulldrei.oop.ex3.template.readers.ConcreteCsvReaderCreator;
import de.nulldrei.oop.ex3.template.readers.ReaderCreator;
import de.nulldrei.oop.ex3.template.readers.ReaderProduct;

import java.io.*;
import java.util.Arrays;

public class ArtikelModel {
	
	private Artikel[] artikel = new Artikel[100];
	private int anzahlArtikel;
	
	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}

	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}

	public void leseArtikelAusCsvDatei()
        throws IOException{
		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
		ReaderProduct readerProduct = readerCreator.factoryMethod();
		setAnzahlArtikel(readerProduct.readArticleCount());
		artikel = readerProduct.readArticles();
	}
	
	public void schreibeArtikelInTxtDatei()
	    throws IOException{
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod("TxtWriter");
		writerProduct.writeArticle(getAnzahlArtikel(), this.artikel);
	}


	public void schreibeArtikelInKonsole() throws IOException {
		WriterCreator writerCreator = new ConcreteWriterCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod("ConsoleWriter");
		writerProduct.writeArticle(getAnzahlArtikel(), this.artikel);
	}
}
