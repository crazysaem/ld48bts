package com.crazysaem.bts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by crazysaem on 27.04.2014.
 */
public class Player
{
  private float PLAYER_SPEED = 800f;

  private Texture texture;
  private Sprite sprite;

  public Player()
  {
    texture = new Texture("player32.png");
    sprite = new Sprite(texture);
    sprite.setX(Gdx.graphics.getWidth()/2 - texture.getWidth() / 2);
    sprite.setY(Gdx.graphics.getHeight()/2 - texture.getHeight() / 2);
  }

  public void update(float delta)
  {
    boolean left = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
    boolean right = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);

    if (left && right || (!left && !right))
      return;

    if (left)
      sprite.setX(sprite.getX() - PLAYER_SPEED * delta);

    if (right)
      sprite.setX(sprite.getX() + PLAYER_SPEED * delta);

    if (sprite.getX() < 0)
      sprite.setX(0);

    if (sprite.getX() > Gdx.graphics.getWidth() - texture.getWidth())
      sprite.setX(Gdx.graphics.getWidth() - texture.getWidth());
  }

  public void render(SpriteBatch batch)
  {
    sprite.draw(batch);
  }
}
