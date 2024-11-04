package de.nulldrei.oop.ex3.template.writers;

public class ConcreteWriterCreator extends WriterCreator {
    @Override
    public WriterProduct factoryMethod(String type) {
        switch(type) {
            case "ConsoleWriter": return new ConcreteConsoleWriterProduct();
            case "TxtWriter": return new ConcreteTxtWriterProduct();
        }
        return null;
    }
}
