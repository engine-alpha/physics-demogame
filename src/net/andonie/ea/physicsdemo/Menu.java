package net.andonie.ea.physicsdemo;

import ea.*;

/**
 * Spielmenü.
 * Created by andonie on 06.09.15.
 */
public class Menu
extends Knoten
implements TastenReagierbar {

    private final Text[] options;
    private final Runnable[] actions;

    //Farben für selection und nichtselektion
    private Farbe f_normal=new Farbe(0, 200, 50),
            f_selected=new Farbe(150, 200, 200),
            f_title = new Farbe(0, 150, 200);

    //Der aktuell selektierte Wert im Menu
    private int selected;

    public Menu(String title, String... options) {

        Rechteck hintergrund = new Rechteck(0,0, 300, 5 + 30*options.length + 50);
        hintergrund.farbeSetzen(new Farbe(255, 255, 200, 50));
        add(hintergrund);

        Text titletext = new Text(title, 10, 5);
        titletext.farbeSetzen(f_title);
        add(titletext);


        this.options = new Text[options.length];
        for(int i = 0; i < options.length; i++) {
            this.options[i] = new Text(options[i], 5, 55+30*i);
            this.options[i].fontSetzen("Monospaced");
            add(this.options[i]);
        }

        this.actions = new Runnable[options.length];

        selected = 0;

        updateVisuals();

    }

    /**
     * Kümmert sich darum, dass das richtige Element an Text hervorgehoben wird.
     */
    private void updateVisuals() {
        for(int i = 0; i < options.length; i++) {
            options[i].farbeSetzen(i==selected ? f_selected : f_normal);
        }

    }

    public void setAction(Runnable action, int optionNum) {
        actions[optionNum] = action;
    }

    public void setActive(boolean active) {

    }

    private void activateOption(int selected) {
        if(actions[selected] != null) {
            actions[selected].run();
        }
    }

    @Override
    public void reagieren(int i) {
        switch(i) {
            case Taste.W:
            case Taste.OBEN:
                if(selected != 0) {
                    selected--;
                    updateVisuals();
                }
                break;
            case Taste.UNTEN:
            case Taste.S:
                if(selected != options.length-1) {
                    selected++;
                    updateVisuals();
                }
                break;
            case Taste.ENTER:
                activateOption(selected);
                break;
        }
    }
}
