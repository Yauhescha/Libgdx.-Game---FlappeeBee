package com.hescha.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("FlappeeBeeGame");
		config.setWindowedMode(240, 320);
		TexturePacker.process("assets", "assets", "flappee_bee_assets");
		new Lwjgl3Application(new FlappeeBeeGame(), config);
	}
}
