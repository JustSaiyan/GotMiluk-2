package com.gotmiluk.munchingtime;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrPlay implements Screen, InputProcessor {
    SpriteBatch batch;
    SprPancake sprHero;
    SprEnemy sprEnemy;
    Music musPlay;
    GamMunch game;
    OrthographicCamera oc;
    Texture Background1, Background2;
    double dYspeedM;
    int xMax, xCoordBg1, xCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 2; // pixels per second. Put your value here.


    // private Sprite sprHero; // a Sprite allows you to get the bounding rectangle

    public ScrPlay(GamMunch _game) {

        batch = new SpriteBatch();
        game = _game;

        sprHero = new SprPancake(80, 100, 0, 128);
        sprEnemy = new SprEnemy(80,100,500,128);

        batch = new SpriteBatch();
        Background1 = new Texture("Background.jpg");
        Background2 = new Texture("Background.jpg"); // identical
        xMax = 1280;
        xCoordBg1 = 0;
        xCoordBg2 = -1280;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        oc.update();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        batch.draw(Background1, xCoordBg1, 0);
        batch.draw(Background2, xCoordBg2, 0);
        Scroll();
        batch.end();

        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        sprHero.draw(batch);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.A)) {
            sprHero.setX(sprHero.getX() - 4);

        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            sprHero.setY(sprHero.getY() + 4);
            dYspeedM = 10;
            sprHero.setY(sprHero.getY() + 8);
        }
        if(sprHero.getY() > 50){
            dYspeedM -= 1;
            sprHero.translateY((float) dYspeedM);

        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            sprHero.setX(sprHero.getX() + 4);
        }
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.updateState(0);
        }

            batch.begin();
            batch.setProjectionMatrix(oc.combined);
            sprEnemy.draw(batch);
            batch.end();



        // make sure the bucket stays within the screen bounds
        /*if(bucket.x < 0) bucket.x = 0;
         if(bucket.x > 800 - 64) bucket.x = 800 - 64;*/
        if (sprHero.getX() < 0) {
            sprHero.setX(0);
        }
        if (sprHero.getX() > 800 - 64) {
            sprHero.setX(800 - 64);
        }
        if (sprHero.getY() < 0) {
            sprHero.setY(0);
        }
        if (sprHero.getY() > 400) {
            sprHero.setY(400);
        }

        xCoordBg1 += BACKGROUND_MOVE_SPEED;
        xCoordBg2 += BACKGROUND_MOVE_SPEED;
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
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        Background1.dispose();
        Background2.dispose();
    }
}

