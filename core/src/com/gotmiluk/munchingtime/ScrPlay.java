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
    SprPancake sprHero;
    SprEnemy sprEnemy;
    SprPizza sprPizza;
    GamMunch game;
    OrthographicCamera oc;
    Texture TxBackground1, TxBackground2;
    long startTime, currentTime;
    private int nLives, nTime;
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
        Scanner SC = new Scanner(System.in);
        startTime = System.currentTimeMillis();
        currentTime = (startTime) / 1000;
        Timer timer = new Timer();

        sprHero = new SprPancake(80, 100, 55, 128);
        sprEnemy = new SprEnemy(60, 100, 500, 45);
        sprPizza = new SprPizza(60, 100, 500, 400);

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
            sprHero.setY(sprHero.getY() + 20);

        }
        return true;
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
        sprHero.draw(batch);
        sprEnemy.draw(batch);
        sprPizza.draw(batch);

        xCoordBg1 += BACKGROUND_MOVE_SPEED;
        xCoordBg2 += BACKGROUND_MOVE_SPEED;


        if (nLives > 0) {
            batch.setProjectionMatrix(oc.combined);
        } else if (nLives == 0) {
            sprHero.setX(55);
            sprHero.setY(128);
            sprEnemy.setX(500);
            sprEnemy.setY(45);
            sprPizza.setY (nRamdomY);
            sprPizza.setX(nRamdomX);
            nLives++;
            nLives++;
            nLives++;
            game.updateState(0);
        }

        if (sprHero.getY() > 50) {
            dYspeedM -= 1;
            sprHero.translateY((float) dYspeedM);

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
        if(sprEnemy.getX()==0) {
            sprEnemy.setX(600);
        }
        if(sprPizza.getX()==0) {
            sprPizza.setY(nRamdomY);
            sprPizza.setX(500);
        }
        if (sprHero.getBoundingRectangle().overlaps(sprEnemy.getBoundingRectangle())) {
            nLives--;
            sprEnemy.setX(500);
            sprEnemy.setY(45);
        }
        if (sprHero.getBoundingRectangle().overlaps(sprPizza.getBoundingRectangle())) {
            nLives--;
            sprPizza.setX(500);
            sprPizza.setY(nRamdomY);
        }
        xCoordBg1 += BACKGROUND_MOVE_SPEED;
        xCoordBg2 += BACKGROUND_MOVE_SPEED;
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
        batch.dispose();
    }
}

