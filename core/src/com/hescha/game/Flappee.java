package com.hescha.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Flappee {
    private static final float COLLISION_RADIUS = 24f;
    private static final float DIVE_ACCEL = 0.3f;
    private static final float FLE_ACCEL = 5f;
    private float ySpeed = 0;

    public Circle getCollisonCircle() {
        return collisonCircle;
    }

    private final Circle collisonCircle;

    private float x = 0;
    private float y = 0;

    public Flappee() {
        collisonCircle = new Circle(x, y, COLLISION_RADIUS);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(collisonCircle.x, collisonCircle.y, collisonCircle.radius);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updateCollisionCircle();
    }

    private void updateCollisionCircle() {
        collisonCircle.setX(x);
        collisonCircle.setY(y);
    }

    public void update() {
        ySpeed -= DIVE_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public void flyUp(){
        ySpeed=FLE_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
