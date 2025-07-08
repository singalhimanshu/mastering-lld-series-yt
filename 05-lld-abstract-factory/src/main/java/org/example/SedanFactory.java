package org.example;

public class SedanFactory implements CarFactory {
    @Override
    public Engine getEngine() {
        return new SedanEngine();
    }

    @Override
    public Body getBody() {
        return new SedanBody();
    }
}
