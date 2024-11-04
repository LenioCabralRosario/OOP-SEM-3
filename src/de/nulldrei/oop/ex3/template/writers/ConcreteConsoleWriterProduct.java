package de.nulldrei.oop.ex3.template.writers;

import de.nulldrei.oop.ex3.template.business.Artikel;

import java.io.IOException;

public class ConcreteConsoleWriterProduct extends WriterProduct {

    @Override
    public void writeArticle(int count, Artikel[] articles) throws IOException {
        System.out.println("Anzahl vorhandener Artikel: " + count + "\n");
        for(int i = 0; i < count; i++) {
            Artikel currentArticle = articles[i];
            System.out.println(currentArticle.getArtikelnummer());
            System.out.println(currentArticle.getArtikelname());
            System.out.println(currentArticle.getBasispreis() + "\n");
        }
    }
}
