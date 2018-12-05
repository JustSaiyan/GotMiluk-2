package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprPancake extends Sprite {
    private int nlives;
    private long startTime, currentTime;
    private SprPancake sprPancake;


    public SprPancake(int nW, int nH, int nX, int nY){
        super (new Texture(Gdx.files.internal("New Piskel.gif"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);

    }
    public void Lives ( int values) {
      nlives=values;
        if (nlives > 0) {
            startTime++;
        } else if (nlives == 0) {
            sprPancake.setX(55);
            sprPancake.setY(128);
            nlives++;
            startTime = 0;

        }

}}