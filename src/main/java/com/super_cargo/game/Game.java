package com.super_cargo.game;

import com.super_cargo.IO.Input;
import com.super_cargo.IO.MouseInput;
import com.super_cargo.display.Display;
import com.super_cargo.game.level.EditorLevel;
import com.super_cargo.game.level.Level;
import com.super_cargo.graphics.TextureAtlas;
import com.super_cargo.utils.Time;

import java.awt.*;

public class Game implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 608;
    public static final int ACTION_WIDTH = Game.WIDTH - (6 * Player.SPRITE_SCALE);
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final int NUM_BUFFERS = 3;

    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    public static final String ATLAS_FILE_NAME = "texture_atlas.png";

    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics;
    private Input input;
    private TextureAtlas atlas;
    private Player player;
    private Level level;
    private EditorLevel editorLevel;
    private MouseInput mouseInput;


    public Game() {
        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
        graphics = Display.getGraphics();
        input = new Input();
        mouseInput = new MouseInput();
        Display.addInputListener(input);
        Display.addMouseListener(mouseInput);
        atlas = new TextureAtlas(ATLAS_FILE_NAME);
        player = new Player(300, 300, 2, 3, atlas);
        level = new Level(atlas);
        //editorLevel = new EditorLevel(atlas);

    }

    public synchronized void start() {

        if (running)
            return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();

    }

    public synchronized void stop() {

        if (!running)
            return;

        running = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cleanUp();

    }

    private void update() {
        player.update(input);
        level.update();
        if (mouseInput.isPressed()) {
            editorLevel.update(mouseInput);
        }
    }

    private void render() {
        Display.clear();
        level.render(graphics);
        player.render(graphics);
        level.renderGrass(graphics);
//        editorLevel.render(graphics);
        Display.swapBuffers();
    }

    public void run() {

        int fps = 0;
        int upd = 0;
        int updl = 0;

        long count = 0;

        float delta = 0;

        long lastTime = Time.get();
        while (running) {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count += elapsedTime;

            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);
            while (delta > 1) {
                update();
                upd++;
                delta--;
                if (render) {
                    updl++;
                } else {
                    render = true;
                }
            }

            if (render) {
                render();
                fps++;
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count >= Time.SECOND) {
                Display.setTitle(TITLE + " || Fps: " + fps + " | Upd: " + upd + " | Updl: " + updl);
                upd = 0;
                fps = 0;
                updl = 0;
                count = 0;
            }

        }

    }

    private void cleanUp() {
        Display.destroy();
    }

}