package de.nulldrei.oop.ex3.self.readers;

public class ConcreteCsvReaderCreator extends ReaderCreator {

    public ConcreteCsvReaderCreator() {

    }

    @Override
    public ReaderProduct factoryMethod() {
        return new ConcreteCsvReaderProduct();
    }
}
