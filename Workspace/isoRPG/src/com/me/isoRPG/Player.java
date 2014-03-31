package com.me.isoRPG;

import com.badlogic.gdx.Input.Keys;

public class Player extends Entity{
	public Player() {
		health = 10;
		attack = 10;
		mana = 10;
		name = "Player";
	}
	public void input(int keycode, Enemy enemy) {
		if(keycode == Keys.SPACE) {
			attack(enemy);
		}
	}
}
