package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprHeroshot extends Sprite {
    public SprHeroshot(int nW, int nH/*, int nX, int nY*/){
        super (new Texture(Gdx.files.internal("fireball.png"))); //Kieran's final project
        setSize(nW, nH);
//        setPosition(nX, nY);
        setFlip(false, false);
    }
}
