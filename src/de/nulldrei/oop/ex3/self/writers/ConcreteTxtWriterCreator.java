package de.nulldrei.oop.ex3.self.writers;

public class ConcreteTxtWriterCreator extends WriterCreator {

    public ConcreteTxtWriterCreator() {

    }

    @Override
    public WriterProduct factoryMethod() {
        return new ConcreteTxtWriterProduct();
    }
}
