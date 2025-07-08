package org.example;

public class Car {

    public static void build(CarFactory carFactory) {
        System.out.println("Building car");
        carFactory.getEngine().build();
        carFactory.getBody().build();
    }

    public static void main(String[] args) {
        final CarFactory suvFactory = new SuvFactory();
        build(suvFactory);
        final CarFactory sedanFactory = new SedanFactory();
        build(sedanFactory);
        final CarFactory hatchbackFactory = new HatchbackFactory();
        build(hatchbackFactory);
    }
}