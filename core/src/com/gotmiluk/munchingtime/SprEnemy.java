package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SprEnemy extends Sprite {
    Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    Texture walkSheet;
    // A variable for tracking elapsed time for the animation
    float stateTime;
//    TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 3, walkSheet.getHeight() / 1); //3 is columns 1 is rows
float elapsedTime, playablePosition;
float currentPosition = 500;




    public SprEnemy(int nW, int nH, int nX, int nY) {
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

     stateTime = 0f;

 }

    public void draw(Batch batch) {

        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);

       batch.draw(currentFrame, 500, 45, 100, 100);
        

        elapsedTime += (Gdx.graphics.getDeltaTime()) ;
       playablePosition = (Gdx.graphics.getWidth());
// float currentPosition = 0; // <-- this needs set outside ouside of the render method.
        currentPosition -= 5;
        batch.draw(walkAnimation.getKeyFrame(elapsedTime), currentPosition, 0, 100, 300);

    }}
