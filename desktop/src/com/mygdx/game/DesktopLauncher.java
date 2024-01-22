package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		Mapa.wysokosc = 800;
		Mapa.szerokosc = 800;
		config.setWindowedMode(Mapa.szerokosc,Mapa.wysokosc);
		config.setForegroundFPS(60);

		config.setTitle("Tetris");
		new Lwjgl3Application(new MyGdxGame(), config);
	}

}
