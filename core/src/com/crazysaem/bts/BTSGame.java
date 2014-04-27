package com.crazysaem.bts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BTSGame extends ApplicationAdapter
{
  private static final int COIN_NUMBER = 30;
  private static final float COIN_SPEED = 350f;
  private static final int SCREEN_HEIGHT = 800;
  private static final int SCREEN_WIDTH = 480;
  private final Random random = new Random();
  private SpriteBatch batch;
  private Sprite coin;
  private List<Sprite> coins;
  private long time = -1;
  private float timeDelta = -1.0f;

  @Override
  public void create()
  {
    batch = new SpriteBatch();
    Texture coinTexture = new Texture("coin32.png");
    coins = new ArrayList<Sprite>();
    for (int i = 0; i < COIN_NUMBER; i++)
    {
      coin = new Sprite(coinTexture);
      coin.setY(-coinTexture.getHeight());
      coin.setX(genRandomCoinXPos());
      coins.add(coin);
    }
  }

  @Override
  public void render()
  {
    timeDelta = (System.currentTimeMillis() - time) / 1000.0f;

    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();

    if (time != -1)
    {
      for (int i = 0; i < COIN_NUMBER; i++)
      {
        if (coin.getY() > SCREEN_HEIGHT)
        {
          coin.setY(-32);
        }

        coin = coins.get(i);
        coin.setY(coin.getY() + COIN_SPEED * timeDelta);
        coin.draw(batch);
      }
    }

    batch.end();

    time = System.currentTimeMillis();
  }

  private int genRandomCoinXPos()
  {

    return random.nextInt(SCREEN_WIDTH);
  }
}
