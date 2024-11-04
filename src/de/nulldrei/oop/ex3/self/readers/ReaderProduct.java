package de.nulldrei.oop.ex3.self.readers;

import de.nulldrei.oop.ex3.self.Article;

import java.io.IOException;

public abstract class ReaderProduct {

    public abstract int readArticleCount() throws IOException;
    public abstract Article[] readArticles() throws IOException;

}