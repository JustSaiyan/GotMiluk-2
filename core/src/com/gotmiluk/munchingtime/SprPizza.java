package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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
   Texture txPizza;
   int fW = walkSheet.getWidth() / 1;
   int fH = walkSheet.getHeight() / 1;
   int  fSx, fSy;
   Sprite sprFlyingPizza;

    public SprPizza(int nW, int nH, int nX, int nY) {
        walkSheet = new Texture("Pizza SpriteSheet.png");
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);


    }

    public void create () {

        nFrame = 0;
        nPos = 0; // the position in the SpriteSheet - 0 to 7
        araniPizza= new Animation[8];
        walkSheet = new Texture("Pizza SpriteSheet.png");
        sprFlyingPizza = new Sprite(txPizza, 0, 0, 48, 48); // this works - I got one dude in the lower corner.
        fW = txPizza.getWidth() / 8;
        fH = txPizza.getHeight() / 8;
        System.out.println(fW + " " + fH);
        for (int i = 0; i < 1; i++) {
            Sprite[] arSprVlad = new Sprite[8];
            for (int j = 0; j < 1; j++) {
                fSx = j * fW;
                fSy = i * fH;
               sprFlyingPizza = new Sprite(txPizza, fSx, fSy, fW, fH);
                arSprVlad[j] = new Sprite(sprFlyingPizza);
            }
            araniPizza[i] = new Animation(5.2f, arSprVlad);
        }}
        public void render() {

            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            nFrame++;
            if (nFrame > 7) {
                nFrame = 0;
            }
            System.out.println(nPos + " " + nFrame);


        }

    }



