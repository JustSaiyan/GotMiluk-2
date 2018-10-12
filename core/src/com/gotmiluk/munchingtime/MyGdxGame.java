package com.gotmiluk.munchingtime;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	Texture Background1, Background2;
	SpriteBatch batch;
	int nMax, nCoordBg1, nCoordBg2;
	final int BACKGROUND_MOVE_SPEED = 2; // pixels per second. Put your value here.

	@Override
	public void create () {
		batch = new SpriteBatch();
		Background1 = new Texture("Background for game.jpg");
		Background2 = new Texture("Background for game.jpg");// identical
		nMax = 1280;
		nCoordBg1 = 0;
		nCoordBg2 = -1280;
	}

	@Override
	public void render () {
		nCoordBg1 += BACKGROUND_MOVE_SPEED;
        nCoordBg2 += BACKGROUND_MOVE_SPEED;

        batch.begin();
		batch.draw(Background1, nCoordBg1, 0);
        batch.draw(Background2, nCoordBg2, 0);
        Scroll();
		batch.end();
	}


	void Scroll(){
        if(nCoordBg1 == 1280){
            nCoordBg1 = -1280;
        }
        if(nCoordBg2 == 1280){
            nCoordBg2 = -1280;
        }
    }

	@Override
	public void dispose () {
		batch.dispose();
		Background1.dispose();
		Background2.dispose();
	}
}
