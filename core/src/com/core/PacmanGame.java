package com.core;

import com.badlogic.gdx.Game;

public class PacmanGame extends Game {
	PacmanLevel tl;

	public void create()
	{
		tl = new PacmanLevel(this);
		setScreen( tl);
	}
}
