package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SprBurger extends Sprite {
    Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    Texture walkSheet;
    // A variable for tracking elapsed time for the animation
    float fstateTime;
//    TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 3, walkSheet.getHeight() / 1); //3 is columns 1 is rows





    public SprBurger(int nW, int nH, int nX, int nY) {
     walkSheet = new Texture("Sprite Sheet .png");
     TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 3, walkSheet.getHeight() / 1); //3 is columns 1 is rows
     setSize(nW, nH);
     setPosition(nX, nY);
     setFlip(false, false);
     TextureRegion[] walkFrames = new TextureRegion[3 * 1];//how many frames are in texture region array;
     int index = 0;
     for (int i = 0; i < 1; i++) { //row #
         for (int j = 0; j < 3; j++) { //column #
             walkFrames[index++] = tmp[i][j];
         }
     }
     walkAnimation = new Animation<TextureRegion>(1 / 4f, walkFrames);

     // Instantiate a SpriteBatch for drawing and reset the elapsed animation
     // time to 0

     fstateTime = 0f;

 }

    public void draw(Batch batch) {

        fstateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(fstateTime, true);




        batch.draw(currentFrame, getX(), getY(), 100, 100);
        setX(getX()-1);
    }}

