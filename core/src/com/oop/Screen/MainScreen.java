package com.oop.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.oop.Box2DTutorial;
import com.oop.Tools.MegamanWorld;

public class MainScreen implements Screen {
    private Box2DTutorial parent;
    private MegamanWorld model;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
//    private KeyBoard keyBoard;

    public MainScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;
//        keyBoard = new KeyBoard();
        camera = new OrthographicCamera(32, 24);
        model = new MegamanWorld(camera);
        debugRenderer = new Box2DDebugRenderer(true, true, true,
                true, true, true);
    }
    @Override
    public void show() {
//        Gdx.input.setInputProcessor(keyBoard);

    }

    @Override
    public void render(float delta) {
        model.logicStep(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(model.world, camera.combined);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
