package com.crazysaem.bts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by crazysaem on 27.04.2014.
 */
public class Coin
{
  private static final float COIN_SPEED = 350f;

  private Texture texture;
  private Sprite sprite;
  private boolean isEnabled;
  private boolean isUpdated;
  private Random random = new Random();

  public Coin(Texture texture)
  {
    this.texture = texture;
    sprite = new Sprite(texture);
    isEnabled = false;
    isUpdated = false;
  }

  public void update(float delta)
  {
    if (!isEnabled || isUpdated)
      return;

    isUpdated = true;

    if (sprite.getY() > Gdx.graphics.getHeight() + texture.getHeight())
      isEnabled = false;

    sprite.setY(sprite.getY() + COIN_SPEED * delta);
  }

  public void render(SpriteBatch batch)
  {
    if (isEnabled)
    {
      sprite.draw(batch);
    }

    isUpdated = false;
  }

  public void reset()
  {
    sprite.setY(-texture.getHeight());
    sprite.setX(random.nextInt(Gdx.graphics.getWidth() - texture.getWidth()));
    isEnabled = true;
  }

  public boolean isEnabled()
  {
    return isEnabled;
  }
}
