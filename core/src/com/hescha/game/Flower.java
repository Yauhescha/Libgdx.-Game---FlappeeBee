package com.hescha.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Flower {
    private static final float COLLISION_RECTANGLE_WIDTH = 13f;
    private static final float COLLISION_RECTANGLE_HEIGHT = 447f;
    private static final float COLLISION_CIRCLE_RADIUS = 33f;
    private static final float MAX_SPEED_PER_SECOND = 100f;
    private static final float HEIGHT_OFFSET = -400f;
    private static final float DISTANCE_BETWEEN_FLOOR_AND_CEILING = 225F;

    public static final float WIDTH = COLLISION_CIRCLE_RADIUS * 2;

    private float x;
    private float y;

    private final Circle floorCollisionCircle;
    private final Rectangle floorCollisionRectangle;
    private final Circle ceilingCollisionCircle;
    private final Rectangle ceilingCollisionRectangle;

    public Flower() {
        this.y = MathUtils.random(HEIGHT_OFFSET);
        this.floorCollisionRectangle = new Rectangle(x, y, COLLISION_RECTANGLE_WIDTH, COLLISION_RECTANGLE_HEIGHT);
        this.floorCollisionCircle = new Circle(x + floorCollisionRectangle.width / 2, y + floorCollisionRectangle.height, COLLISION_CIRCLE_RADIUS);
        this.ceilingCollisionRectangle = new Rectangle(x, floorCollisionCircle.y + DISTANCE_BETWEEN_FLOOR_AND_CEILING, COLLISION_RECTANGLE_WIDTH, COLLISION_RECTANGLE_HEIGHT);
        this.ceilingCollisionCircle = new Circle(x + ceilingCollisionRectangle.width / 2, ceilingCollisionRectangle.y, COLLISION_CIRCLE_RADIUS);
    }

    public void setPosition(float x) {
        this.x = x;
        updateCollisionCircle();
        updateCollisionRectangle();
    }

//    private void updateCollisionCircle() {
//        floorCollisionCircle.setX(x + floorCollisionRectangle.width / 2);
//        floorCollisionCircle.setY(y + floorCollisionRectangle.height);
//    }

    private void updateCollisionCircle() {
        floorCollisionCircle.setX(x + floorCollisionRectangle.width / 2);
        ceilingCollisionCircle.setX(x + ceilingCollisionRectangle.width / 2);
    }

    private void updateCollisionRectangle() {
        floorCollisionRectangle.setX(x);
        ceilingCollisionRectangle.setX(x);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(floorCollisionCircle.x, floorCollisionCircle.y, floorCollisionCircle.radius);
        shapeRenderer.rect(floorCollisionRectangle.x, floorCollisionRectangle.y, floorCollisionRectangle.width, floorCollisionRectangle.height);
        shapeRenderer.circle(ceilingCollisionCircle.x, ceilingCollisionCircle.y, ceilingCollisionCircle.radius);
        shapeRenderer.rect(ceilingCollisionRectangle.x, ceilingCollisionRectangle.y, ceilingCollisionRectangle.width, ceilingCollisionRectangle.height);
    }

    public void update(float delta) {
        setPosition(x - (MAX_SPEED_PER_SECOND * delta));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
