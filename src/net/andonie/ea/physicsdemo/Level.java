package net.andonie.ea.physicsdemo;

import ea.*;

/**
 * Created by andonie on 06.09.15.
 */
public class Level
extends Knoten {

    private final TextFigure hero;

    public Level(TextFigure hero) {
        this.hero = hero;
    }

    public static Level load(int level) {
        Level lev = new Level(null);



        return lev;
    }
}
