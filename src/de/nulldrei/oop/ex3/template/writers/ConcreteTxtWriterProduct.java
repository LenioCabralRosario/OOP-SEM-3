package de.nulldrei.oop.ex3.template.writers;

import de.nulldrei.oop.ex3.template.business.Artikel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteTxtWriterProduct extends WriterProduct {

    @Override
    public void writeArticle(int count, Artikel[] articles) throws IOException {
        for(int i = 0; i < count; i++) {
            Artikel currentArticle = articles[i];
            BufferedWriter bw = new BufferedWriter(new FileWriter("articles.txt", true));
            bw.write(String.valueOf(currentArticle.getArtikelnummer()));
            bw.newLine();
            bw.write(currentArticle.getArtikelname());
            bw.newLine();
            bw.write(String.valueOf(currentArticle.getBasispreis()));
            bw.newLine();
            bw.close();
        }
    }
}
