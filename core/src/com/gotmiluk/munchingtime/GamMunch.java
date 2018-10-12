package com.gotmiluk.munchingtime;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class GamMunch extends ApplicationAdapter {
	Texture Background1, Background2;
	SpriteBatch batch;
	float xMax, xCoordBg1, xCoordBg2;
	final int BACKGROUND_MOVE_SPEED = 2; // pixels per second. Put your value here.


	@Override
	public void create () {
		batch = new SpriteBatch();
 Background1 = new Texture(Gdx.files.internal("Background for game.jpg"));
		Background2 = new Texture(Gdx.files.internal("Background for game.jpg")); // identical
		xMax = 1280;
		xCoordBg1 = 0;

	}


	@Override
	public void render () {
		xCoordBg1 += BACKGROUND_MOVE_SPEED;
		xCoordBg2 += BACKGROUND_MOVE_SPEED;

		batch.begin();
		batch.draw(Background1, xCoordBg1, 0);
		batch.draw(Background2, xCoordBg2, 0);
		Scroll();
		batch.end();
	}


	void Scroll(){
		if(xCoordBg1 == 1280){
			xCoordBg1 = -1280;
		}
		if(xCoordBg2 == 1280){
			xCoordBg2 = -1280;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		Background1.dispose();
		Background2.dispose();
	}
}

	// I've used this site to help me with setting a image as a background https://stackoverflow.com/questions/25468270/libgdx-how-do-i-add-a-background-image?rq=1