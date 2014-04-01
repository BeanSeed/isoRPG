package com.me.isoRPG;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "isoRPG";
		cfg.width = 1280;
		cfg.height = 640;
		
		new LwjglApplication(new mainRPG(), cfg);
	}
}
