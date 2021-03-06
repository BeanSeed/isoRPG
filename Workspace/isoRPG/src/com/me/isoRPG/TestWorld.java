package com.me.isoRPG;

import physicalObject.Entity;
import physicalObject.Character;
import physicalObject.Enemy;
import physicalObject.Player;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class TestWorld extends DefaultScreen implements InputProcessor {
	public Environment environment;
	
	public CameraInputController camController;
	
	public PerspectiveCamera cam;
	public ModelBatch modelBatch;
	
	public Enemy enemy;
	public Player player;
	
	public TestWorld(Game game) {
		super(game);
		
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		
		player = new Player();
		enemy = new Enemy(15,0);
		
		modelBatch = new ModelBatch();
		
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setInputProcessor(this);
		
		//initialize camera
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//Vector3 camOffset = new Vector3(20,20,20);
		cam.position.set(60f,60f,60f);
		cam.lookAt(player.getPosition());
		cam.near = 0.1f;
		cam.far = 3000f;
		cam.update();
		
		
		// render init stuff
		Gdx.gl.glClearColor(0, 0, 0, 0);
	}
	
	public void render(float delta) {
		// TODO Auto-generated method stub.
		cam.update();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		// render
		//player.render();
		//enemy.render();
		
		modelBatch.begin(cam);
		modelBatch.render(player.instance, environment);
		modelBatch.render(enemy.instance,  environment);
		modelBatch.end();
	}

	public void resize(int width, int height) {
	}

	public void show() {
		// TODO Auto-generated method stub

	}

	public void hide() {
		// TODO Auto-generated method stub

	}

	public void pause() {
	}

	public void resume() {
	}

	public void dispose() {
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		//player.input(keycode, enemy); bugging out.
		
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
