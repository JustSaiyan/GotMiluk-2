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
   Array araniDude = new Animation[8];
   float fW = walkSheet.getWidth() / 8;
   float fH = walkSheet.getHeight() / 8;

    public SprPizza(int nW, int nH, int nX, int nY) {
        walkSheet = new Texture("Pizza SpriteSheet.png");

        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);

        //Animation Stuff

        for (int i = 0; i < 3   ; i++) {
            Sprite[] arSprDude = new Sprite[8];
            for (int j = 0; j < 8; j++) {
                fSx = j * fW;
                fSy = i * fH;

                arSprDude[j] = new Sprite(walkSheet);
            }
            araniDude[i] = new Animation(0.8f, arSprDude);







    }
    public void draw(Batch batch) {


    }}}


