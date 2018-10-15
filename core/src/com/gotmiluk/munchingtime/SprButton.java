package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprButton extends Sprite {
    public SprButton(int nW, int nH, int nX, int nY, String s){
        super(new Texture(Gdx.files.internal("Play_button.jpg"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, true);
    }
}
