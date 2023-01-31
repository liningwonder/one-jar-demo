package org.cloud.demo;

public class Rectangle implements Sharp {
    private double width;
    private double height;
    @Override
    public double getArea() {
        return width * height;
    }
}
