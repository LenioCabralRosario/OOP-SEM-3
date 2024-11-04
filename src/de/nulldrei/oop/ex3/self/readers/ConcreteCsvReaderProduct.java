package de.nulldrei.oop.ex3.self.readers;

import de.nulldrei.oop.ex3.self.Article;

import java.io.*;

public class ConcreteCsvReaderProduct extends ReaderProduct {

    @Override
    public int readArticleCount() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("articles.csv"));
        return Integer.parseInt(br.readLine());
    }

    @Override
    public Article[] readArticles() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("articles.csv"));
        String[] lines = (String[]) br.lines().toArray();
        br.close();
        Article[] articles = new Article[lines.length];
        int i = 0;
        for(String line : lines) {
            int id = Integer.parseInt(line.split(";")[0]);
            String product = line.split(";")[1];
            double price = Double.parseDouble(line.split(";")[2]);
            Article article = new Article(id, product, price);
            articles[i++] = article;
        }
        return articles;
    }
}
