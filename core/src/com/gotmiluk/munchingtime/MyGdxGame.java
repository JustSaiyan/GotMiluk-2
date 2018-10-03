package com.gotmiluk.munchingtime;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	Texture Background1, Background2;
	SpriteBatch batch;
	float xMax, xCoordBg1, xCoordBg2;
	final int BACKGROUND_MOVE_SPEED = 100; // pixels per second. Put your value here.

	@Override
	public void create () {
		batch = new SpriteBatch();
		Background1 = new Texture(Gdx.files.internal("Background for game.jpg"));
		Background2 = new Texture(Gdx.files.internal("Background for game.jpg")); // identical
		xMax = 1280;
		xCoordBg1 = xMax*(-1); xCoordBg2 = 0;
	}

	@Override
	public void render () {
		xCoordBg1 += BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
		xCoordBg2 = xCoordBg1 + xMax;  // We move the background, not the camera
		if (xCoordBg1 >= 0) {
			xCoordBg1 = xMax*(-1); xCoordBg2 = 0;
		}
		batch.begin();
		batch.draw(Background1, 0, xCoordBg1);
		batch.draw(Background2, 0, xCoordBg2);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		Background1.dispose();
		Background2.dispose();
	}
}
