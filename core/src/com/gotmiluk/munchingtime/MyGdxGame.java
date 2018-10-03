package com.gotmiluk.munchingtime;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	Texture Background1, Background2;
	SpriteBatch batch;
	float yMax, yCoordBg1, yCoordBg2;
	final int BACKGROUND_MOVE_SPEED = 100; // pixels per second. Put your value here.

	@Override
	public void create () {
		batch = new SpriteBatch();
		Background1 = new Texture(Gdx.files.internal("Background for game.jpg"));
		Background2 = new Texture(Gdx.files.internal("Background for game.jpg")); // identical
		yMax = 1280;
		yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
	}

	@Override
	public void render () {
		yCoordBg1 += BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
		yCoordBg2 = yCoordBg1 + yMax;  // We move the background, not the camera
		if (yCoordBg1 >= 0) {
			yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
		}
		batch.begin();
		batch.draw(Background1, 0, yCoordBg1);
		batch.draw(Background2, 0, yCoordBg2);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		Background1.dispose();
		Background2.dispose();
	}
}
