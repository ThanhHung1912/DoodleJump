package com.oop.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oop.Box2DTutorial;


public class MenuScreen implements Screen {
    private Box2DTutorial parent;
    private Stage stage;


    public MenuScreen(Box2DTutorial box2dTutorial){
        parent = box2dTutorial;

        // Add a stage
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void show() {
        // Table that fills the screen. Making everything go inside this table
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);


        // Create Buttons for menu
        Skin skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
        TextButton newGame = new TextButton("NewGame", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);

        // add buttons to menu
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10 ,0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        // Add exit listeners
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Box2DTutorial.PREFERENCES);
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Box2DTutorial.APPLICATION);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

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
        stage.dispose();
    }

}
