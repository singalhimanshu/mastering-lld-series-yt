package org.example;

public class SuvFactory implements CarFactory {
    @Override
    public Engine getEngine() {
        return new SuvEngine();
    }

    @Override
    public Body getBody() {
        return new SuvBody();
    }
}
