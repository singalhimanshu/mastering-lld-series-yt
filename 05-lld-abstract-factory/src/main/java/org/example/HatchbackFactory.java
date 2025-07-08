package org.example;

public class HatchbackFactory implements CarFactory {
    @Override
    public Engine getEngine() {
        return new HatchbackEngine();
    }

    @Override
    public Body getBody() {
        return new HatchbackBody();
    }
}
