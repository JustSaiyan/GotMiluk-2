package com.gotmiluk.munchingtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SprEnemy extends Sprite {


    public SprEnemy(int nW, int nH, int nX, int nY) {
        super(new Texture(Gdx.files.internal("Sprite Sheet .png"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);


        OrthographicCamera oc;
       Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
        Texture walkSheet;


        // A variable for tracking elapsed time for the animation
        float stateTime;


        // private Sprite sprHero; // a Sprite allows you to get the bounding rectangle





            walkSheet = new Texture("Sprite Sheet .png");

            // Use the split utility method to create a 2D array of TextureRegions. This is
            // possible because this sprite sheet contains frames of equal size and they are
            // all aligned.
            TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 3, walkSheet.getHeight() / 1); //3 is columns 1 is rows


            TextureRegion[] walkFrames = new TextureRegion[3 * 1];//how many frames are in texture region array;
            int index = 0;
            for (int i = 0; i < 1; i++) { //row #
                for (int j = 0; j < 3; j++) { //column #
                    walkFrames[index++] = tmp[i][j];
                }
            }

            walkAnimation = new Animation<TextureRegion>(1 / 5f, walkFrames);

            // Instantiate a SpriteBatch for drawing and reset the elapsed animation
            // time to 0

            stateTime = 0f;
        }


        @Override
        public void show () {
            oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            oc.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            oc.update();
            batch = new SpriteBatch();



        }

        @Override
        public void render ( float delta) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
            oc.update();


            stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

            // Get current frame of animation for the current stateTime
            TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);

            //batch.draw(currentFrame, 50, -200); // Draw current frame at (50, 50)
            batch.draw(currentFrame, 500, 45, 100, 100);

        }}

















