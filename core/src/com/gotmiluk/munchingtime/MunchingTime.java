package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Game;
import com.gotmiluk.munchingtime.ScrPlay;

public class MunchingTime extends Game {
    ScrMenu scrMenu;
    ScrPlay scrPlay;
    MunchingTime munchingTime;


    int nScreen; // 0 for menu, 1 for play

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(scrPlay);
        }

    }


    @Override
    public void create() {
        nScreen = 0;
        // notice that "this" is passed to each screen. Each screen now has access to methods within the "game" master program
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);

        updateState(0);
    }


    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}