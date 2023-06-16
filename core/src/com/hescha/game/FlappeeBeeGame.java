package com.hescha.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class FlappeeBeeGame extends Game {

    private AssetManager assetManager = new AssetManager();

    @Override
    public void create() {
        setScreen(new StartScreen(this));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
