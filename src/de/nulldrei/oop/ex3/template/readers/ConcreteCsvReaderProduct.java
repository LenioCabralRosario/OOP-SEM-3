package de.nulldrei.oop.ex3.template.readers;

import de.nulldrei.oop.ex3.self.Article;
import de.nulldrei.oop.ex3.template.business.Artikel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProduct {

    @Override
    public int readArticleCount() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Artikel.csv"));
        return Integer.parseInt(br.readLine());
    }

    @Override
    public Artikel[] readArticles() throws IOException {
        BufferedReader ein = new BufferedReader(new FileReader("Artikel.csv"));
        String[] zeile = null;
        Artikel[] artikel = new Artikel[readArticleCount()];
        for (int i = 0; i < readArticleCount(); i++) {
            String zeileString = ein.readLine();
            if (zeileString.contains(";")) {
                zeile = zeileString.split(";");
                artikel[i] = new Artikel(
                        Integer.parseInt(zeile[0]), zeile[1],
                        Double.parseDouble(zeile[2]));
            } else {
                // Erste Zeile in der CSV ist die Angabe der Anzahl der Artikel, da diese kein Artikel darstellt zählen wir diesen durchlauf nicht
                i--;
            }
        }
        ein.close();
        return artikel;
    }
}
