package com.hescha.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Flappee {
    private static final float COLLISION_RADIUS = 24f;
    private static final float DIVE_ACCEL = 0.3f;
    private static final float FLE_ACCEL = 5f;
    private static final int TILE_WIDTH = 48;
    private static final int TILE_HEIGHT = 48;
    private static final float FRAME_DURATION = 0.25F;

    private final Circle collisionCircle;
    private final Animation animation;

    private float x = 0;
    private float y = 0;
    private float ySpeed = 0;
    private float animationTimer = 0;


    public Flappee(TextureRegion flappeeTexture) {
        TextureRegion[][] flappeeTextures = new TextureRegion(flappeeTexture).split(TILE_WIDTH, TILE_HEIGHT);
        animation = new Animation(FRAME_DURATION, flappeeTextures[0][0], flappeeTextures[0][1]);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        collisionCircle = new Circle(x, y, COLLISION_RADIUS);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius);
    }

    public void draw(SpriteBatch batch) {
        TextureRegion flappeeTexture = (TextureRegion) animation.getKeyFrame(animationTimer);
        float textureX = collisionCircle.x - flappeeTexture.getRegionWidth() / 2;
        float textureY = collisionCircle.y - flappeeTexture.getRegionHeight() / 2;
        batch.draw(flappeeTexture, textureX, textureY);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updateCollisionCircle();
    }

    private void updateCollisionCircle() {
        collisionCircle.setX(x);
        collisionCircle.setY(y);
    }

    public void update(float delta) {
        animationTimer += delta;
        ySpeed -= DIVE_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public void flyUp() {
        ySpeed = FLE_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Circle getCollisionCircle() {
        return collisionCircle;
    }
}
