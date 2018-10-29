package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprLogo extends Sprite {
    public SprLogo(int nW, int nH, int nX, int nY, String sFilename){
        super (new Texture(Gdx.files.internal(sFilename)));
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, true);
    }
}
