package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Game;
import com.gotmiluk.munchingtime.ScrOld;


public class GamMunch extends Game {
    ScrOld scrOld;
    ScrPlay scrPlay;
    GamMunch munchingTime;


    int nScreen; // 0 for menu, 1 for play

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(scrOld);
        }


        }


        @Override
        public void create () {
            nScreen = 0;
            // notice that "this" is passed to each screen. Each screen now has access to methods within the "game" master program
            scrOld = new ScrOld(this);

            updateState(0);
        }


        @Override
        public void render () {
            super.render();
        }

        @Override
        public void dispose () {
            super.dispose();
        }



}