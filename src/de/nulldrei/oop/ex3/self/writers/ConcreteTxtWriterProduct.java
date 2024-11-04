package de.nulldrei.oop.ex3.self.writers;

import de.nulldrei.oop.ex3.self.Article;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteTxtWriterProduct extends WriterProduct {

    @Override
        public void writeArticle(int count, Article[] articles) throws IOException {
        for(int i = 0; i < count; i++) {
            System.out.println(articles[i]);
            Article currentArticle = articles[i];
            BufferedWriter bw = new BufferedWriter(new FileWriter("articles.txt", true));
            bw.write(String.valueOf(currentArticle.getId()));
            bw.newLine();
            bw.write(currentArticle.getName());
            bw.newLine();
            bw.write(String.valueOf(currentArticle.getPrice()));
            bw.newLine();
            bw.close();
        }
    }
}
