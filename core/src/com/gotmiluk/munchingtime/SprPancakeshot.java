package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gotmiluk.munchingtime.SprPancake;

public class SprPancakeshot extends Sprite {
    public SprPancakeshot(int nW, int nH, int nX, int nY) {
        super (new Texture(Gdx.files.internal("fireball.png"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
    }
    public void shoot (int nY) {
       
    }
}
