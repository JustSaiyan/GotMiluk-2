package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprPancake extends Sprite {
    private int nLives;
    private long startTime, currentTime;
    private SprPancake sprPancake;
    private GamMunch game;


    public SprPancake(int nW, int nH, int nX, int nY) {
        super(new Texture(Gdx.files.internal("New Piskel.gif"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        nLives = 3;
    }


    int getnLives() {
        return nLives;
    }

    void loseLife() {
        nLives--;
    }

    void setnLives() {
       nLives++;
       nLives ++;
       nLives++;

    }








}


