package com.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import java.util.ArrayList;
import java.util.Random;

public class PacmanLevel extends BaseScreen {
    public static final int WIDTH = 250;

    private BaseActor wall1;
    private BaseActor wall2;
    private BaseActor wall3;
    private BaseActor wall4;
    private BaseActor wall5;
    private BaseActor wall6;
    private BaseActor wall7;
    private BaseActor wall8;
    private BaseActor wall9;
    private BaseActor wall10;
    private BaseActor wall11;
    private BaseActor wall12;
    private BaseActor wall13;
    private BaseActor wall14;
    private BaseActor wall15;
    private BaseActor wall16;
    private BaseActor wall17;
    private BaseActor wall18;
    private BaseActor wall19;
    private BaseActor wall20;
    private BaseActor wall21;
    private BaseActor wall22;
    private BaseActor wall23;
    private BaseActor wall24;
    private BaseActor wall25;
    private BaseActor wall26;
    private BaseActor wall27;
    private BaseActor wall28;
    private BaseActor wall29;
    private BaseActor wall30;
    private BaseActor wall31;
    private BaseActor wall32;

    private PhysicsActor pacman;
    private ArrayList<BaseActor> sunList;
    private BaseActor[] walls;
    private PhysicsActor ghostRed;
    private PhysicsActor ghostBlue;
    private PhysicsActor ghostPink;
    private PhysicsActor ghostYellow;
    private Random random;

    private Label scoreLable;
    private int score;

    public PacmanLevel(Game g) {
        super(g);
    }

    @Override
    public void create() {
        random = new Random();
        score = 0;
        walls = new BaseActor[]{wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10,
                wall11, wall12, wall13, wall14, wall15, wall16, wall17, wall18, wall19, wall20,
                wall21, wall22, wall23, wall24, wall25, wall26, wall27, wall28, wall29, wall30, wall31, wall32};
        for(int n = 0; n <=31; n++) {
            walls[n] = new BaseActor();
            walls[n].setTexture(new Texture((n+1) + ".png"));
            walls[n].setPosition(0,0);
            mainStage.addActor(walls[n]);
        }
        walls[0].setCustomRectangleBoundary(0,0,0,109,10,109,10,0);
        walls[1].setCustomRectangleBoundary(0,110,0, 144,38,144,38, 110);
        walls[2].setCustomRectangleBoundary(0,158,0,192,38,192,38,158);
        walls[3].setCustomRectangleBoundary(0,190,0,300,10,300,10,190);
        walls[4].setCustomRectangleBoundary(0,290,0,300,250,300,250,290);
        walls[5].setCustomRectangleBoundary(240,190,240,300,250,300,250,190);
        walls[6].setCustomRectangleBoundary(212,158,212,192,250,192,250,158);
        walls[7].setCustomRectangleBoundary(212,110,212,144,250,144,250,110);
        walls[8].setCustomRectangleBoundary(240,0,240,109,250,109,250,109);
        walls[9].setCustomRectangleBoundary(0,0,0,10,250,10,250,0);
        walls[10].setCustomRectangleBoundary(25,53,25,94,38,94,38,53);
        walls[11].setCustomRectangleBoundary(25,81,25,94,104,94,104,81);
        walls[12].setCustomRectangleBoundary(213,53,213,94,226,94,226,53);
        walls[13].setCustomRectangleBoundary(147,81,147,94,225,94,225,81);
        walls[14].setCustomRectangleBoundary(25,25,25,38,104,38,104,25);
        walls[15].setCustomRectangleBoundary(53,38,53,66,66,66,66,38);
        walls[16].setCustomRectangleBoundary(81,53,81,66, 170, 66,170,53);
        walls[17].setCustomRectangleBoundary(119,25,119,66,132,66,132,25);
        walls[18].setCustomRectangleBoundary(147,25,147,38,226,38,226,25);
        walls[19].setCustomRectangleBoundary(184,25,184,66,197,66,197,25);

        walls[20].setCustomRectangleBoundary(80,109,80,122,170,122,170,109);
        walls[21].setCustomRectangleBoundary(118,81,118,110,131,110,131,81);

        walls[22].setCustomRectangleBoundary(80,137,80,178,170,178,170,137);

        walls[23].setCustomRectangleBoundary(80,234,80,247,170,247,170, 234);
        walls[24].setCustomRectangleBoundary(118,193,118,247,131, 247,131, 193);

        walls[25].setCustomRectangleBoundary(53,110,53,247,66,247,66,110);
        walls[26].setCustomRectangleBoundary(66,193,66,219,103,219,103,193);

        walls[27].setCustomRectangleBoundary(184,110,184,247,198,247,198,110);
        walls[28].setCustomRectangleBoundary(146,193,146,219,184,219,184,193);

        walls[29].setCustomRectangleBoundary(25,206,25,275,38,275,38,206);
        walls[30].setCustomRectangleBoundary(25,262,25,275,225,275,225,262);
        walls[31].setCustomRectangleBoundary(212,206,212,275,225,275,225,206);

        pacman = new PhysicsActor();
        TextureRegion[] framesPac = new TextureRegion[3];
        for (int n = 1; n <= 3; n++) {
            String fileName = "pacman" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            framesPac[n-1] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArray = new Array<TextureRegion>(framesPac);
        Animation animPac = new Animation(0.1f, framesArray, Animation.PlayMode.LOOP);
        pacman.storeAnimation( "go", animPac );
        pacman.setOrigin( pacman.getWidth()/2, pacman.getHeight()/2 );
        pacman.setPosition( 118, 122 );
        pacman.setRotation(90);
        pacman.setDefaultRectangleBoundary();
        mainStage.addActor(pacman);

        BaseActor sun = new BaseActor();
        sun.setTexture(new Texture("sun.png"));
        sun.setDefaultRectangleBoundary();
        sunList = new ArrayList<>();
        int[] sunCoords = {11,11, 11,25, 11,39, 11,53, 11,67, 11,81, 11,96,
            28,11, 42,11, 56,11, 70,11, 84,11, 98,11, 112,11, 126,11, 140,11, 154,11, 168,11, 182,11, 196,11, 210,11, 226,11,
            226,25, 226,39, 226,53, 226,67, 226,81, 226,96,
            25,39, 39,39, 67,39, 79,39, 91,39, 104,39, 132,39, 144,39, 157,39, 170,39, 198,39, 212,39,
            104,25, 132,25, 39,53, 39,67, 67,53, 67,67, 170,53, 170,67, 198,53, 198,67,
            53,67, 81,67, 97,67, 111,67, 126,67, 141,67, 156,67, 184,67, 104,81, 132,81,
                28,96, 43,96, 57,96, 72,96, 87,96, 104,96, 132,96, 149,96, 164,96, 179,96, 193,96, 208,96,
                39,110, 39,124, 39,138, 39,152, 39,166, 39,180, 39,194, 39,208, 39,222, 39,234, 39,248,
                198,110, 198,124, 198,138, 198,152, 198,166, 198,180, 198,194, 198,208, 198,222, 198,234, 198,248,
                55,248, 69,248, 83,248, 98,248, 112,248, 126,248, 140,248, 154,248, 168,248, 182,248,
                67,110, 67,110, 67,124, 67,138, 67,152, 67,166, 67,180,
                170,110, 170,110, 170,124, 170,138, 170,152, 170,166, 170,180,
                84,180, 98,180, 112,180, 126,180, 140,180, 154,180,
                132,192, 132,206, 132,220, 105,192, 105,206, 105,220,
                146,220, 158,220, 170,220, 170,234,
                92,220, 80,220, 67,220, 67,234,
                10,276, 10,262, 10,248, 10,234, 10,220, 10,206, 10,192, 25,192,
                28,276, 42,276, 56,276, 70,276, 84,276, 98,276, 112,276, 126,276, 140,276, 154,276, 168,276, 182,276, 196,276, 210,276, 226,276,
                226,276, 226,262, 226,248, 226,234, 226,220, 226,206, 226,192, 212,192
        };
        for (int i = 0; i < 169; i++) {
            BaseActor s = sun.clone();
            s.setPosition(sunCoords[2*i], sunCoords[2*i + 1]);
            mainStage.addActor(s);
            sunList.add(s);
        }

        ghostRed = new PhysicsActor();
        TextureRegion[]  framesGhost = new TextureRegion[2];
        for (int n = 1; n <= 2; n++) {
            String fileName = "redGhost" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            framesGhost[n-1] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArrayGhost = new Array<>(framesGhost);
        Animation animGhost = new Animation(0.1f, framesArrayGhost, Animation.PlayMode.LOOP);
        ghostRed.storeAnimation( "goGhost", animGhost );
        ghostRed.setOrigin(ghostRed.getWidth() / 2, ghostRed.getHeight() / 2);
        ghostRed.setPosition(10,10);
        ghostRed.setDefaultRectangleBoundary();
        mainStage.addActor(ghostRed);

        ghostBlue = new PhysicsActor();
        TextureRegion[]  framesGhostBl = new TextureRegion[2];
        for (int n = 1; n <= 2; n++)
        {
            String fileName = "blueGhost" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            framesGhostBl[n-1] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArrayGhostBl = new Array<>(framesGhostBl);
        Animation animGhostBl = new Animation(0.1f, framesArrayGhostBl, Animation.PlayMode.LOOP);
        ghostBlue.storeAnimation( "goGhost", animGhostBl );
        ghostBlue.setOrigin(ghostBlue.getWidth() / 2, ghostBlue.getHeight() / 2);
        ghostBlue.setPosition(226,10);
        ghostBlue.setDefaultRectangleBoundary();
        mainStage.addActor(ghostBlue);

        ghostPink = new PhysicsActor();
        TextureRegion[]  framesGhostPi = new TextureRegion[2];
        for (int n = 1; n <= 2; n++)
        {
            String fileName = "pinkGhost" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            framesGhostPi[n-1] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArrayGhostPi = new Array<>(framesGhostPi);
        Animation animGhostPi = new Animation(0.1f, framesArrayGhostPi, Animation.PlayMode.LOOP);
        ghostPink.storeAnimation( "goGhost", animGhostPi );
        ghostPink.setOrigin(ghostPink.getWidth() / 2, ghostPink.getHeight() / 2);
        ghostPink.setPosition(10,276);
        ghostPink.setDefaultRectangleBoundary();
        mainStage.addActor(ghostPink);

        ghostYellow = new PhysicsActor();
        TextureRegion[]  framesGhostYe = new TextureRegion[2];
        for (int n = 1; n <= 2; n++)
        {
            String fileName = "yellowGhost" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            framesGhostYe[n-1] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArrayGhostYe = new Array<>(framesGhostYe);
        Animation animGhostYe = new Animation(0.1f, framesArrayGhostYe, Animation.PlayMode.LOOP);
        ghostYellow.storeAnimation( "goGhost", animGhostYe );
        ghostYellow.setOrigin(ghostYellow.getWidth() / 2, ghostYellow.getHeight() / 2);
        ghostYellow.setPosition(226,276);
        ghostYellow.setDefaultRectangleBoundary();
        mainStage.addActor(ghostYellow);

        BitmapFont font = new BitmapFont();
        LabelStyle style = new LabelStyle(font, Color.YELLOW);
        scoreLable = new Label("Score: 0", style);
        scoreLable.setFontScale(1);
        scoreLable.setPosition(0,301);
        uiStage.addActor(scoreLable);
    }

    @Override
    public void update(float dt) {
        if(Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.DOWN)) {
            if(Gdx.input.isKeyPressed(Keys.UP)) {
                pacman.setVelocityXY(0, 40);
                pacman.setRotation(90);
            }
            else {
                pacman.setVelocityXY(0, -40);
                pacman.setRotation(270);
            }
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
            if(Gdx.input.isKeyPressed(Keys.LEFT)) {
                pacman.setVelocityXY(-40, 0);
                pacman.setRotation(180);
            }
            else {
                pacman.setVelocityXY(40, 0);
                pacman.setRotation(0);
            }
        }

        if(pacman.getX() > WIDTH) pacman.setPosition(0, pacman.getY());
        if((pacman.getX() + pacman.getWidth()) < 0) pacman.setPosition(WIDTH, pacman.getY());

        // RED GHOST
        if(ghostRed.getX() >= 10 && ghostRed.getX() <= 11 && ghostRed.getY() >= 10 && ghostRed.getY() <= 11) {
            if (ghostRed.velocity.x < 0 || ghostRed.velocity.x == 0) { ghostRed.setVelocityXY(0, 40); }
            else { ghostRed.setVelocityXY(40, 0); }
        }
        if(ghostRed.getX() >= 10 && ghostRed.getX() <= 11 && ghostRed.getY() >= 94 && ghostRed.getY() <= 95) {
            if (ghostRed.velocity.x < 0 ) { ghostRed.setVelocityXY(0, -40); }
            else { ghostRed.setVelocityXY(40, 0); }
        }
        if(ghostRed.getX() >= 104 && ghostRed.getX() <= 105 && ghostRed.getY() >= 94 && ghostRed.getY() <= 95) {
            if (ghostRed.velocity.x > 0) { ghostRed.setVelocityXY(0, -40); }
            else { ghostRed.setVelocityXY(-40, 0); }
        }
        if(ghostRed.getX() >= 38 && ghostRed.getX() <= 39 && ghostRed.getY() >= 65 && ghostRed.getY() <= 66) {
            if (ghostRed.velocity.y > 0) { ghostRed.setVelocityXY(40, 0); }
            else { ghostRed.setVelocityXY(0, -40); }
        }
        if(ghostRed.getX() >= 38 && ghostRed.getX() <= 39 && ghostRed.getY() >= 38 && ghostRed.getY() <= 39) {
            if (ghostRed.velocity.x > 0) ghostRed.setVelocityXY(0, 40);
            else ghostRed.setVelocityXY(-40, 0);
        }
        if(ghostRed.getX() >= 66 && ghostRed.getX() <= 67 && ghostRed.getY() >= 38 && ghostRed.getY() <= 39) {
            if (ghostRed.velocity.x > 0) ghostRed.setVelocityXY(0, 40);
            else ghostRed.setVelocityXY(40, 0);
        }
        if(ghostRed.getX() >= 104 && ghostRed.getX() <= 105 && ghostRed.getY() >= 38 && ghostRed.getY() <= 39) {
            if (ghostRed.velocity.x > 0) ghostRed.setVelocityXY(0, -40);
            if (ghostRed.velocity.y > 0) ghostRed.setVelocityXY(40, 0);
        }
        if(ghostRed.getX() >= 104 && ghostRed.getX() <= 105 && ghostRed.getY() >= 65 && ghostRed.getY() <= 66) {
            if (ghostRed.velocity.x > 0) ghostRed.setVelocityXY(0, 40);
            if (ghostRed.velocity.y < 0) ghostRed.setVelocityXY(-40, 0);
        }
        if(ghostRed.getX() >= 104 && ghostRed.getX() <= 105 && ghostRed.getY() >= 10 && ghostRed.getY() <= 11) {
            if (ghostRed.velocity.x > 0) ghostRed.setVelocityXY(0, 40);
            if (ghostRed.velocity.y < 0) ghostRed.setVelocityXY(-40, 0);
        }
        if(ghostRed.getX() >= 10 && ghostRed.getX() <= 11 && ghostRed.getY() >= 38 && ghostRed.getY() <= 39) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostRed.velocity.x < 0) {
                if(r % 2 == 0) ghostRed.setVelocityXY(0,40);
                else ghostRed.setVelocityXY(0,-40);
            }
            else {
                if(r % 2 == 0) ghostRed.setVelocityXY(40,0);
            }
        }
        if(ghostRed.getX() >= 66 && ghostRed.getX() <= 67 && ghostRed.getY() >= 65 && ghostRed.getY() <= 66) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostRed.velocity.y > 0) {
                if(r % 2 == 0) ghostRed.setVelocityXY(0,40);
                else ghostRed.setVelocityXY(0,-40);
            }
            else {
                if(r % 2 == 0) ghostRed.setVelocityXY(0,-40);
            }
        }

        // BLUE GHOST
        if(ghostBlue.getX() >= 226 && ghostBlue.getX() <= 227 && ghostBlue.getY() >= 10 && ghostBlue.getY() <= 11) {
            if (ghostBlue.velocity.x > 0 || ghostBlue.velocity.x == 0) { ghostBlue.setVelocityXY(0, 40); }
            else { ghostBlue.setVelocityXY(40, 0); }
        }
        if(ghostBlue.getX() >= 226 && ghostBlue.getX() <= 227 && ghostBlue.getY() >= 94 && ghostBlue.getY() <= 95) {
            if (ghostBlue.velocity.y > 0) { ghostBlue.setVelocityXY(-40,0); }
            else { ghostBlue.setVelocityXY(0,-40); }
        }
        if(ghostBlue.getX() >= 132 && ghostBlue.getX() <= 133 && ghostBlue.getY() >= 94 && ghostBlue.getY() <= 95) {
            if (ghostBlue.velocity.x < 0) { ghostBlue.setVelocityXY(0,-40); }
            else { ghostBlue.setVelocityXY(40,0); }
        }
        if(ghostBlue.getX() >= 132 && ghostBlue.getX() <= 133 && ghostBlue.getY() >= 65 && ghostBlue.getY() <= 66) {
            if (ghostBlue.velocity.x < 0) { ghostBlue.setVelocityXY(0,40); }
            else { ghostBlue.setVelocityXY(40,0); }
        }
        if(ghostBlue.getX() >= 198 && ghostBlue.getX() <= 199 && ghostBlue.getY() >= 65 && ghostBlue.getY() <= 66) {
            if (ghostBlue.velocity.y > 0) { ghostBlue.setVelocityXY(-40,0); }
            if (ghostBlue.velocity.x > 0) { ghostBlue.setVelocityXY(0,-40); }
        }
        if(ghostBlue.getX() >= 198 && ghostBlue.getX() <= 199 && ghostBlue.getY() >= 38 && ghostBlue.getY() <= 39) {
            if (ghostBlue.velocity.y < 0) { ghostBlue.setVelocityXY(40,0); }
            else { ghostBlue.setVelocityXY(0,40); }
        }
        if(ghostBlue.getX() >= 170 && ghostBlue.getX() <= 171 && ghostBlue.getY() >= 38 && ghostBlue.getY() <= 39) {
            if (ghostBlue.velocity.y < 0) { ghostBlue.setVelocityXY(-40,0); }
            if (ghostBlue.velocity.x > 0) { ghostBlue.setVelocityXY(0,40); }
        }
        if(ghostBlue.getX() >= 132 && ghostBlue.getX() <= 133 && ghostBlue.getY() >= 38 && ghostBlue.getY() <= 39) {
            if (ghostBlue.velocity.x < 0) { ghostBlue.setVelocityXY(0,-40); }
            if (ghostBlue.velocity.y > 0) { ghostBlue.setVelocityXY(40,0); }
        }
        if(ghostBlue.getX() >= 132 && ghostBlue.getX() <= 133 && ghostBlue.getY() >= 10 && ghostBlue.getY() <= 11) {
            if (ghostBlue.velocity.y < 0) { ghostBlue.setVelocityXY(40,0); }
            else { ghostBlue.setVelocityXY(0,40); }
        }
        if(ghostBlue.getX() >= 226 && ghostBlue.getX() <= 227 && ghostBlue.getY() >= 38 && ghostBlue.getY() <= 39) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostBlue.velocity.x > 0) {
                if(r % 2 == 0) ghostBlue.setVelocityXY(0,40);
                else ghostBlue.setVelocityXY(0,-40);
            }
            if(r % 2 == 0) ghostBlue.setVelocityXY(-40,0);
        }
        if(ghostBlue.getX() >= 170 && ghostBlue.getX() <= 171 && ghostBlue.getY() >= 65 && ghostBlue.getY() <= 66) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostBlue.velocity.y > 0) {
                if(r % 2 == 0) ghostBlue.setVelocityXY(40,0);
                else ghostBlue.setVelocityXY(-40,0);
            }
            if(r % 2 == 0) ghostBlue.setVelocityXY(0,-40);
        }

        // PINK GHOST
        if(ghostPink.getX() >= 10 && ghostPink.getX() <= 11 && ghostPink.getY() >= 276 && ghostPink.getY() <= 277) {
            if (ghostPink.velocity.x < 0 || ghostPink.velocity.x == 0) { ghostPink.setVelocityXY(0, -40); }
            else { ghostPink.setVelocityXY(55, 0); }
        }
        if(ghostPink.getX() >= 10 && ghostPink.getX() <= 11 && ghostPink.getY() >= 191 && ghostPink.getY() <= 192) {
            if (ghostPink.velocity.x < 0) { ghostPink.setVelocityXY(0, 55); }
            else { ghostPink.setVelocityXY(55, 0); }
        }
        if(ghostPink.getX() >= 38 && ghostPink.getX() <= 39 && ghostPink.getY() >= 191 && ghostPink.getY() <= 192) {
            if (ghostPink.velocity.x > 0) { ghostPink.setVelocityXY(0, 55); }
            else { ghostPink.setVelocityXY(-55, 0); }
        }
        if(ghostPink.getX() >= 38 && ghostPink.getX() <= 39 && ghostPink.getY() >= 248 && ghostPink.getY() <= 249) {
            if (ghostPink.velocity.y > 0) { ghostPink.setVelocityXY(55, 0); }
            if (ghostPink.velocity.x < 0) { ghostPink.setVelocityXY(0, -55); }
        }
        if(ghostPink.getX() >= 66 && ghostPink.getX() <= 67 && ghostPink.getY() >= 219 && ghostPink.getY() <= 220) {
            if (ghostPink.velocity.y < 0) { ghostPink.setVelocityXY(55, 0); }
            if (ghostPink.velocity.x < 0) { ghostPink.setVelocityXY(0, 55); }
        }
        if(ghostPink.getX() >= 104 && ghostPink.getX() <= 105 && ghostPink.getY() >= 219 && ghostPink.getY() <= 220) {
            if (ghostPink.velocity.x > 0) { ghostPink.setVelocityXY(0, -55); }
            else { ghostPink.setVelocityXY(-55, 0); }
        }
        if(ghostPink.getX() >= 104 && ghostPink.getX() <= 105 && ghostPink.getY() >= 178 && ghostPink.getY() <= 179) {
            if (ghostPink.velocity.y < 0) { ghostPink.setVelocityXY(-55, 0); }
            else { ghostPink.setVelocityXY(0, 55); }
        }
        if(ghostPink.getX() >= 66 && ghostPink.getX() <= 67 && ghostPink.getY() >= 178 && ghostPink.getY() <= 179) {
            if (ghostPink.velocity.x < 0) { ghostPink.setVelocityXY(0, -55); }
            else { ghostPink.setVelocityXY(55, 0); }
        }
        if(ghostPink.getX() >= 66 && ghostPink.getX() <= 67 && ghostPink.getY() >= 122 && ghostPink.getY() <= 123) {
            ghostPink.setVelocityXY(0,55);
        }
        if(ghostPink.getX() >= 226 && ghostPink.getX() <= 227 && ghostPink.getY() >= 276 && ghostPink.getY() <= 277) {
            if (ghostPink.velocity.x > 0) { ghostPink.setVelocityXY(0, -55); }
            else { ghostPink.setVelocityXY(-55, 0); }
        }
        if(ghostPink.getX() >= 226 && ghostPink.getX() <= 227 && ghostPink.getY() >= 191 && ghostPink.getY() <= 192) {
            if (ghostPink.velocity.y < 0) { ghostPink.setVelocityXY(-55, 0); }
            else { ghostPink.setVelocityXY(0, 55); }
        }
        if(ghostPink.getX() >= 198 && ghostPink.getX() <= 199 && ghostPink.getY() >= 191 && ghostPink.getY() <= 192) {
            if (ghostPink.velocity.x < 0) { ghostPink.setVelocityXY(0,55); }
            else { ghostPink.setVelocityXY(55,0); }
        }
        if(ghostPink.getX() >= 198 && ghostPink.getX() <= 199 && ghostPink.getY() >= 248 && ghostPink.getY() <= 249) {
            if (ghostPink.velocity.y > 0) { ghostPink.setVelocityXY(-55,0); }
            else { ghostPink.setVelocityXY(0,-55); }
        }
        if(ghostPink.getX() >= 66 && ghostPink.getX() <= 67 && ghostPink.getY() >= 248 && ghostPink.getY() <= 249) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostPink.velocity.y > 0) {
                if(r % 2 == 0) ghostPink.setVelocityXY(55,0);
                else ghostPink.setVelocityXY(-55,0);
            }
            else {
                if(r % 2 == 0) ghostPink.setVelocityXY(0,-55);

            }
        }

        // YELLOW GHOST
        if(ghostYellow.getX() >= 226 && ghostYellow.getX() <= 227 && ghostYellow.getY() >= 276 && ghostYellow.getY() <= 277) {
            if (ghostYellow.velocity.x > 0 || ghostYellow.velocity.x == 0) { ghostYellow.setVelocityXY(0, -55); }
            else { ghostYellow.setVelocityXY(-55, 0); }
        }
        if(ghostYellow.getX() >= 226 && ghostYellow.getX() <= 227 && ghostYellow.getY() >= 191 && ghostYellow.getY() <= 192) {
            if (ghostYellow.velocity.y < 0) { ghostYellow.setVelocityXY(-55, 0); }
            else { ghostYellow.setVelocityXY(0, 55); }
        }
        if(ghostYellow.getX() >= 198 && ghostYellow.getX() <= 199 && ghostYellow.getY() >= 191 && ghostYellow.getY() <= 192) {
            if (ghostYellow.velocity.x < 0) { ghostYellow.setVelocityXY(0,55); }
            else { ghostYellow.setVelocityXY(55,0); }
        }
        if(ghostYellow.getX() >= 198 && ghostYellow.getX() <= 199 && ghostYellow.getY() >= 248 && ghostYellow.getY() <= 249) {
            if (ghostYellow.velocity.y > 0) { ghostYellow.setVelocityXY(-55,0); }
            else { ghostYellow.setVelocityXY(0,-55); }
        }
        if(ghostYellow.getX() >= 170 && ghostYellow.getX() <= 171 && ghostYellow.getY() >= 219 && ghostYellow.getY() <= 220) {
            if (ghostYellow.velocity.y < 0) { ghostYellow.setVelocityXY(-55,0); }
            else { ghostYellow.setVelocityXY(0,55); }
        }
        if(ghostYellow.getX() >= 132 && ghostYellow.getX() <= 133 && ghostYellow.getY() >= 219 && ghostYellow.getY() <= 220) {
            if (ghostYellow.velocity.x < 0) { ghostYellow.setVelocityXY(0,-55); }
            else { ghostYellow.setVelocityXY(55,0); }
        }
        if(ghostYellow.getX() >= 132 && ghostYellow.getX() <= 133 && ghostYellow.getY() >= 178 && ghostYellow.getY() <= 179) {
            if (ghostYellow.velocity.y < 0) { ghostYellow.setVelocityXY(55,0); }
            else { ghostYellow.setVelocityXY(0,55); }
        }
        if(ghostYellow.getX() >= 170 && ghostYellow.getX() <= 171 && ghostYellow.getY() >= 178 && ghostYellow.getY() <= 179) {
            if (ghostYellow.velocity.y > 0) { ghostYellow.setVelocityXY(-55,0); }
            else { ghostYellow.setVelocityXY(0,-55); }
        }
        if(ghostYellow.getX() >= 170 && ghostYellow.getX() <= 171 && ghostYellow.getY() >= 122 && ghostYellow.getY() <= 123) {
            ghostYellow.setVelocityXY(0,55);
        }
        if(ghostYellow.getX() >= 10 && ghostYellow.getX() <= 11 && ghostYellow.getY() >= 276 && ghostYellow.getY() <= 277) {
            if (ghostYellow.velocity.x < 0) { ghostYellow.setVelocityXY(0, -40); }
            else { ghostYellow.setVelocityXY(55, 0); }
        }
        if(ghostYellow.getX() >= 10 && ghostYellow.getX() <= 11 && ghostYellow.getY() >= 191 && ghostYellow.getY() <= 192) {
            if (ghostYellow.velocity.x < 0) { ghostYellow.setVelocityXY(0, 55); }
            else { ghostYellow.setVelocityXY(55, 0); }
        }
        if(ghostYellow.getX() >= 38 && ghostYellow.getX() <= 39 && ghostYellow.getY() >= 191 && ghostYellow.getY() <= 192) {
            if (ghostYellow.velocity.x > 0) { ghostYellow.setVelocityXY(0, 55); }
            else { ghostYellow.setVelocityXY(-55, 0); }
        }
        if(ghostYellow.getX() >= 38 && ghostYellow.getX() <= 39 && ghostYellow.getY() >= 248 && ghostYellow.getY() <= 249) {
            if (ghostYellow.velocity.y > 0) { ghostYellow.setVelocityXY(55, 0); }
            if (ghostYellow.velocity.x < 0) { ghostYellow.setVelocityXY(0, -55); }
        }
        if(ghostYellow.getX() >= 170 && ghostYellow.getX() <= 171 && ghostYellow.getY() >= 248 && ghostYellow.getY() <= 249) {
            int r = random.nextInt((4 - 1) + 1) + 1;
            if(ghostYellow.velocity.y > 0) {
                if(r % 2 == 0) ghostYellow.setVelocityXY(55,0);
                else ghostYellow.setVelocityXY(-55,0);
            }
            if(r % 2 == 0) ghostYellow.setVelocityXY(0,-55);
        }

        //обработка столкновений со стенамии
        for(int n = 0; n <= 31; n++) {
            pacman.overlaps(walls[n], true);
            pacman.overlaps(ghostRed, false);
            pacman.overlaps(ghostBlue, false);
            pacman.overlaps(ghostPink, false);
            pacman.overlaps(ghostYellow, false);
        }

        if(pacman.overlaps(ghostRed, true) || pacman.overlaps(ghostBlue, true) ||
                pacman.overlaps(ghostPink, true)|| pacman.overlaps(ghostYellow, true)) Gdx.app.exit();

        ArrayList<BaseActor> removeList = new ArrayList<BaseActor>();
        for (BaseActor s : sunList) {
            if (pacman.overlaps(s,true)) {
                score++;
                removeList.add(s);
            }
        }

        for (BaseActor b : removeList) {
            b.remove();
            sunList.remove(b);
        }

        scoreLable.setText("Score:" + score);
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
