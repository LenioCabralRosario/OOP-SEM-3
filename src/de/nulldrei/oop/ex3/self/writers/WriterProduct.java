package de.nulldrei.oop.ex3.self.writers;

import de.nulldrei.oop.ex3.self.Article;
import de.nulldrei.oop.ex3.template.business.Artikel;

import java.io.IOException;

public abstract class WriterProduct {

    public abstract void writeArticle(int count, Article[] articles) throws IOException;

}