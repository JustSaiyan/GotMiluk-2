package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprPancakeshot extends Sprite {
    float fY, fX, fDelayshot;
    public SprPancakeshot(int nW, int nH, int nX, int nY) {
        super (new Texture(Gdx.files.internal("fireball.png"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
    }
    void shoot (int _nY) {
        setY(_nY);
        setX(50);
    }
    void update () {
        fX = getX();
        fX+=20;
        setX(fX);
        System.out.println(getX());
    }
    //boolean isShot () {

    //}
}
