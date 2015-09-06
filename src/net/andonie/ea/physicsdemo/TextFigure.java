package net.andonie.ea.physicsdemo;

import ea.Text;

/**
 * Figur aus Text
 * Created by andonie on 06.09.15.
 */
public class TextFigure
extends Text {

    private final String[] states;
    private int state=0;
    private boolean rotateStates = false;

    public TextFigure(int groesse, String... states) {
        super(states[0], 0, 0);
        this.states = states;
        this.setzeFont("Monospaced");
        this.groesseSetzen(groesse);
    }

    public void setState(int state) {
        this.state = state;
        this.inhaltSetzen(states[state]);
    }

    public void setRotateStates(boolean rotateStates) {
        this.rotateStates = rotateStates;
    }

    public void rotatePush() {
        if(rotateStates)
            setState(state+1 % states.length);
    }
}
