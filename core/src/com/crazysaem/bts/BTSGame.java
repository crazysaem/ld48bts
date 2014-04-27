package com.crazysaem.bts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BTSGame extends ApplicationAdapter
{
  private SpriteBatch batch;
  private Coins coins;
  private BitmapFont font;
  private Player player;

  @Override
  public void create()
  {
    batch = new SpriteBatch();
    coins = new Coins();
    font = new BitmapFont();
    player = new Player();
  }

  @Override
  public void render()
  {
    float delta = Gdx.graphics.getRawDeltaTime();

    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    coins.update(delta);
    coins.render(batch);
    player.update(delta);
    player.render(batch);
    font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond() + " DELTA: " + delta, 0, Gdx.graphics.getHeight());
    batch.end();
  }

  @Override
  public void dispose()
  {
    super.dispose();
  }
}
