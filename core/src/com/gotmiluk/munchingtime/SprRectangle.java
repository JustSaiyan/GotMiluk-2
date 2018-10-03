package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class SprRectangle extends Sprite {
    public SprRectangle (int nW, int nH, int nX, int nY, String sFilename){
        super(new Texture(Gdx.files.internal(sFilename))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, true);
    }
}
