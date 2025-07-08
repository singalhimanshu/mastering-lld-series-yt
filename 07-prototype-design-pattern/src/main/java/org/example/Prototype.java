package org.example;

public interface Prototype<T> extends Cloneable {
    T clone();
}
