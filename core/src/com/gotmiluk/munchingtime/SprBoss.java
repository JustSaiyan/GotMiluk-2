package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprBoss extends Sprite {

    public SprBoss(int nW, int nH, int nX, int nY){
        super (new Texture(Gdx.files.internal("Pizza Time.jpg"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);
    }
}
