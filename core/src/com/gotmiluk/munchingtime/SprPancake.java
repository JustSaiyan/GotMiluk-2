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

    /*   public void Lives() {

           if (nLives > 0) {
               startTime++;
           } else if (nLives == 0) {
               sprPancake.setX(55);
               sprPancake.setY(128);
               nLives+=3;
               startTime = 0;
               game.updateState(0);
           }
       }
   */
    int getnLives() {
        return nLives;
    }

    void loseLife() {
        nLives--;
    }

  public  void getLives() {
       nLives++;
      nLives++;
      nLives++;

    }
}
