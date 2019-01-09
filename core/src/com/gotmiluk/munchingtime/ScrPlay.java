package com.gotmiluk.munchingtime;

import com.badlogic.gdx.*;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;


public class ScrPlay implements Screen, InputProcessor {
    SpriteBatch batch;
    SprPancake sprPancake;
    SprBurger sprBurger;
    SprPizza sprPizza;
    SprPancakeshot sprPancakeshot;
    GamMunch game;
    OrthographicCamera oc;
    Texture TxBackground1, TxBackground2;
    long startTime, currentTime;
    private int nLives;
    Music musPlay;
    private BitmapFont font;
    double dYspeedM;
    int xMax, xCoordBg1, xCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 2; // pixels per second. Put your value here.
    int nRamdomY;
    int nRamdomX;



    public ScrPlay(GamMunch _game) {
        batch = new SpriteBatch();
        game = _game;
        nLives = 3;
        font = new BitmapFont();
        startTime += Gdx.graphics.getDeltaTime();
        currentTime = (startTime) / 1000;

        sprPancake = new SprPancake(80, 100, 55, 128);
        sprBurger = new SprBurger(60, 100, 500, 45);
        sprPizza = new SprPizza(60, 100, 500, 400);
        sprPancakeshot = new SprPancakeshot(80,100, -100, -100);

        batch = new SpriteBatch();
        TxBackground1 = new Texture("Background.jpg");
        TxBackground2 = new Texture("Background.jpg"); // identical
        xMax = 1280;
        xCoordBg1 = 0;
        xCoordBg2 = -1280;

        Random rand = new Random();
        nRamdomY= rand.nextInt(400) + 200;
        nRamdomX= rand.nextInt(500) + 200;
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
        if(character =='w') {
            dYspeedM = 2;
            sprPancake.setY(sprPancake.getY() + 20);
        }

        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            sprPancakeshot.shoot((int) sprPancake.getY());
            if (sprPancakeshot.getX() > 500) {
                sprPancakeshot.setX(0);
            }
        }
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.updateState(0);
            musPlay.stop();
        }
        return true;
    }



    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        musPlay = Gdx.audio.newMusic(Gdx.files.internal("MMX.mp3"));
        musPlay.setLooping(true);
        musPlay.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        oc.update();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        batch.draw(TxBackground1, xCoordBg1, 0);
        batch.draw(TxBackground2, xCoordBg2, 0);
        Scroll();
        sprPancake.draw(batch);
        sprBurger.draw(batch);
        sprPizza.draw(batch);
        sprPancakeshot.draw(batch);

        xCoordBg1 += BACKGROUND_MOVE_SPEED;
        xCoordBg2 += BACKGROUND_MOVE_SPEED;


        if (nLives > 0) {
            batch.setProjectionMatrix(oc.combined);
            startTime++;
        } else if (nLives == 0) {
            sprPancake.setX(55);
            sprPancake.setY(128);
            sprBurger.setX(500);
            sprBurger.setY(45);
            sprPizza.setY(nRamdomY);
            sprPizza.setX(nRamdomX);
            nLives+=3;
            startTime = 0;
            game.updateState(0);
        }
        if (sprPancake.getY() > 50) {
            dYspeedM -= 1;
            sprPancake.translateY((float) dYspeedM);
        }
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.updateState(0);
            musPlay.stop();
        }

        batch.setProjectionMatrix(oc.combined);
        font.draw(batch, Integer.toString(nLives), 50, 450);
        font.draw(batch, Long.toString(startTime), 50, 470);
        String s1 = "Lives:";
        String s2 = "Time:";
        font.draw(batch, s1, 9, 450);
        font.draw(batch, s2, 9, 470);
        batch.end();

        if (sprPancake.getY() < 0) {
            sprPancake.setY(0);
        }
        if (sprPancake.getY() > 400) {
            sprPancake.setY(400);
        }
        if (sprPizza.getX() < 0) {
            sprPizza.setY(nRamdomY);
            sprPizza.setX(500);
        }
        if (sprPancake.getBoundingRectangle().overlaps(sprPizza.getBoundingRectangle())) {
            nLives--;
            sprPizza.setX(500);
            sprPizza.setY(nRamdomY);
        }
        if (sprPancake.getBoundingRectangle().overlaps(sprBurger.getBoundingRectangle())) {
            nLives--;
            sprBurger.setX(500);
            sprBurger.setY(45);
        }
        if (sprPancakeshot.getBoundingRectangle().overlaps(sprBurger.getBoundingRectangle())) {
            sprBurger.setX(640);
            sprBurger.setY(45);
        }
        if (sprPancakeshot.getBoundingRectangle().overlaps(sprPizza.getBoundingRectangle())) {
            sprPizza.setX(640);
            sprPizza.setY(nRamdomY);
        }
        xCoordBg1 += BACKGROUND_MOVE_SPEED;
        xCoordBg2 += BACKGROUND_MOVE_SPEED;
        sprPancakeshot.update();
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

    void Scroll() {
        if (xCoordBg1 == 1280) {
            xCoordBg1 = -1280;
        }
        if (xCoordBg2 == 1280) {
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
        musPlay.stop();
    }

    @Override
    public void dispose() {
        batch.dispose();
        TxBackground1.dispose();
        TxBackground2.dispose();
    }
}

