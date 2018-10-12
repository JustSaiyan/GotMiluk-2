package com.gotmiluk.munchingtime;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrOld implements Screen, InputProcessor {
    SpriteBatch batch;
    SprMario sprHero;
    GamMunch game;
    OrthographicCamera oc;
    Texture Background1, Background2;
    int xMax, xCoordBg1, xCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 2; // pixels per second. Put your value here.


   // private Sprite sprHero; // a Sprite allows you to get the bounding rectangle

    public ScrOld(GamMunch _game) {

        batch = new SpriteBatch();
        game = _game;

        sprHero = new SprMario(80, 100, 0, 360);

        batch = new SpriteBatch();
        Background1 = new Texture("Background.jpg");
        Background2 = new Texture("Background.jpg"); // identical
        xMax = 1280;
        xCoordBg1 = 0;
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
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
 //       sprHero = new SprMario(100,100, 150, 150, "mario.png");
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0); //Green background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        sprHero.draw(batch);
        batch.end();

        if (Gdx.input.isKeyPressed(Keys.A)) {
            sprHero.setX(sprHero.getX() - 4);
            System.out.println("Move Left");
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            sprHero.setY(sprHero.getY() - 4);
            System.out.println("Move Up");
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            sprHero.setX(sprHero.getX() + 4);
            System.out.println("Move Right");
        }


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

        batch.begin();
        batch.setProjectionMatrix(oc.combined);
//        batch.draw(Background1, xCoordBg1, 0);
        batch.draw(Background2, 0, 0);
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
