package de.nulldrei.oop.ex3.template.readers;

import de.nulldrei.oop.ex3.self.Article;
import de.nulldrei.oop.ex3.template.business.Artikel;

import java.io.IOException;

public abstract class ReaderProduct {

    public abstract int readArticleCount() throws IOException;
    public abstract Artikel[] readArticles() throws IOException;

}