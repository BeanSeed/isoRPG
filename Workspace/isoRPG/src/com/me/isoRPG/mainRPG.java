package com.me.isoRPG;

import com.badlogic.gdx.Game;

// mainRPG has to be a Game so we can switch screens
public class mainRPG extends Game {

	@Override
	public void create() {
		setScreen(new TitleScreen(this));
	}

}
