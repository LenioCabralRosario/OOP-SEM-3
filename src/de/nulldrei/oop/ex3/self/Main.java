package de.nulldrei.oop.ex3.self;

import de.nulldrei.oop.ex3.self.writers.ConcreteTxtWriterCreator;
import de.nulldrei.oop.ex3.self.writers.ConcreteTxtWriterProduct;
import de.nulldrei.oop.ex3.self.writers.WriterCreator;
import de.nulldrei.oop.ex3.self.writers.WriterProduct;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Das ist meine Umsetzung, in dieser hatte ich die Basisanwendung noch nicht zur Verfügung, dieses komplette package ist also obsolet
        System.out.println("Hello world!");
        WriterCreator writerCreator = new ConcreteTxtWriterCreator();
        WriterProduct writer =  writerCreator.factoryMethod();
        Article article1 = new Article(3232, "Coole socken", 55.5);
        Article article2 = new Article(6352, "Gewaschene socken", 420.22);
        Article[] articles = new Article[] {article1, article2};
        writer.writeArticle(2, articles);
    }
}