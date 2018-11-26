package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.sql.Array;

public class SprEnemy extends Sprite {

    Texture walkSheet,txSheet;
    int  nFrame,nPos;
    float fW,fH,fSx,fSy;
    Array   araniVlad;





    public SprEnemy(int nW, int nH, int nX, int nY) {
        walkSheet = new Texture("Sprite Sheet .png");

        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);


    }
    public void create() {
        Gdx.input.setInputProcessor((this));
        nFrame = 0;
        nPos = 0; // the position in the SpriteSheet - 0 to 7
        araniVlad = new Animation[8];
        txSheet = new Texture("Vlad.png");
        fW = txSheet.getWidth() / 8;
        fH = txSheet.getHeight() / 8;
        System.out.println(fW + " " + fH);
        for (int i = 0; i < 8; i++) {
            Sprite[] arSprVlad = new Sprite[8];
            for (int j = 0; j < 8; j++) {
                fSx = j * fW;
                fSy = i * fH;
                walkSheet = new Sprite(txSheet, fSx, fSy, fW, fH);
                arSprVlad[j] = new Sprite(walkSheet);
            }
            araniVlad[i] = new Animation(5.2f, arSprVlad);
        }
    }}