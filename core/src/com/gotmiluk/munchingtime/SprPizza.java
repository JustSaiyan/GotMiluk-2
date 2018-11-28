package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.lang.reflect.Array;

public class SprPizza  extends Sprite {

    Texture walkSheet;
    TextureRegion trTemp;
   int nFrame = 0;
   int nPos = 0;
   Animation araniPizza[];
   int fW = walkSheet.getWidth() / 8;
   int fH = walkSheet.getHeight() / 8;
   int  fSx, fSy;;
   Sprite sprFlyingPizza;

    public SprPizza(int nW, int nH, int nX, int nY) {
        walkSheet = new Texture("Pizza SpriteSheet.png");

        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);


    }
    public void show() {

        //Animation Stuff
        nFrame = 0;
        nPos = 0;
        araniPizza = new Animation[8];
        fW = walkSheet.getWidth() / 8;
        fH = walkSheet.getHeight() / 8;
        for (int i = 0; i < 8; i++) {
            Sprite[] arSprPizza = new Sprite[8];
            for (int j = 0; j < 8; j++) {
                fSx = j * fW;
                fSy = i * fH;
                sprFlyingPizza = new Sprite(walkSheet, fSx, fSy, fW, fH);
                sprFlyingPizza.setFlip(false, true);
                arSprPizza[j] = new Sprite(sprFlyingPizza);
            }
            araniPizza[i] = new Animation(0.8f, arSprPizza);


    }}}