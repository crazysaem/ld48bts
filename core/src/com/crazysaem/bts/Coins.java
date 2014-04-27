package com.crazysaem.bts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazysaem on 27.04.2014.
 */
public class Coins
{
  private static final int COINS_NUMBER = 50;
  private static final double COIN_SPAWN = 0.1;

  private List<Coin> coinsDisabled;
  private List<Coin> coinsEnabled;
  //private Coin coin;

  public Coins()
  {
    Texture coinTexture = new Texture("coin32.png");
    coinsDisabled = new ArrayList<Coin>();
    for (int i = 0; i < COINS_NUMBER; i++)
    {
      Coin coin = new Coin(coinTexture);
      coinsDisabled.add(coin);
    }
    coinsEnabled = new ArrayList<Coin>();
  }

  public void update(float delta)
  {
    if (coinsDisabled.size() > 0)
    {
      if (Math.random() <= COIN_SPAWN)
      {
        Coin coin = coinsDisabled.get(0);
        coin.reset();
        coinsEnabled.add(coin);
        coinsDisabled.remove(0);
      }
    }

    for (int i = 0; i < coinsEnabled.size(); i++)
    {
      Coin coin = coinsEnabled.get(i);
      coin.update(delta);

      if (!coin.isEnabled())
      {
        coinsEnabled.remove(coin);
        coinsDisabled.add(coin);
        i = 0;
      }
    }
  }

  public void render(SpriteBatch batch)
  {
    for (Coin coin : coinsEnabled)
    {
      coin.render(batch);
    }
  }
}
