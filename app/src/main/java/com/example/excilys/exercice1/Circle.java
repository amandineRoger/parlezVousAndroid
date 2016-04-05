package com.example.excilys.exercice1;

/**
 * Created by excilys on 05/04/16.
 */
public class Circle {
    private float x;
    private float y;
    private float radius;

    public Circle(float x, float y){
        this.x = x;
        this.y = y;
        this.radius = 15;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    private float distance(Circle c) {
        return (float)Math.sqrt(((this.x - c.getX())*(this.x - c.getX())) + ((this.y - c.getY())*(this.y - c.getY())));
    }

    public boolean isInside(Circle circle){
        if (this.distance(circle) <= radius)  return true;
        return false;
    }
}
