package com.me.isoRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TitleScreen extends DefaultScreen implements
		InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture[] background = new Texture[3];
	private Sprite[] sprite = new Sprite[3];
	private boolean killScreen = false;

	public TitleScreen(Game game) {
		super(game);
		
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setInputProcessor(this);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, h / w);
		batch = new SpriteBatch();

		background[0] = new Texture(Gdx.files.internal("data/sky_background.png"));

		background[1] = new Texture(Gdx.files.internal("data/mountain_background.png"));
		
		background[2] = new Texture(Gdx.files.internal("data/grass_foreground.png"));
		
		for (int i = 0; i<3;i++) {
			background[i].setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		TextureRegion region[] = new TextureRegion[3];
				
		for (int i = 0; i <3;i++) {
				region[i] = new TextureRegion(background[i], 0, 0, 1280, 640);
		}
		
		for (int i =0; i <3; i++) {
			sprite[i] = new Sprite(region[i]);
			sprite[i].setSize(1f, 1f * sprite[i].getHeight() / sprite[i].getWidth());
			sprite[i].setOrigin(sprite[i].getWidth() / 2, sprite[i].getHeight() / 2);
			sprite[i].setPosition(-sprite[i].getWidth() / 2, -sprite[i].getHeight() / 2);
		}
		// render init stuff
		Gdx.gl.glClearColor(1, 1, 1, 1);
	}

	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (int i = 0; i<3; i++) {
			sprite[i].draw(batch);
			
		}
		batch.end();
		if(killScreen) {
			game.setScreen(new TestWorld(game));
		}
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
		batch.dispose();
		for (int i = 0;i<3;i++) {
			background[i].dispose();
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(Gdx.input.isTouched()) {
			killScreen = true;
		}
		if(keycode == Input.Keys.ENTER | keycode == Input.Keys.SPACE) {
			killScreen = true;
		}
		// player.input(keycode);
		// ui.input(keycode);
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
		killScreen = true;
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
