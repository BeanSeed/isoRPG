package com.me.isoRPG;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Entity {
	public int health = 10;
	public int attack = 10;
	public int mana = 10;
	public Vector3 position = new Vector3(0f,0f,0f);
	
	private static ModelBuilder modelBuilder = new ModelBuilder();
	private Model model;
	public ModelInstance instance;
	
	public boolean alive = true;
	public String name = "Entity";
	public Entity(){
		initModel();
	}
	private void initModel() {
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
	}
	public int attack(Entity enemy){
		if((enemy.health -= this.attack) <= 0) {
			enemy.alive = false;
			enemy.health = 0;
		}
		stats();
		enemy.stats();
		return attack;
	}
	public void stats(){
		if(alive){
			System.out.println(name + ": Health " + health);
		}
		else {
			System.out.println(name + " is dead");
		}
	}
	public void move(Vector2 direction) {
		// the magnitude of the vector is it's speed
		// enemies move at random. some track and move towards the player.
	}
	
		
}
