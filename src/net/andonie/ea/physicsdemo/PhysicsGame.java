package net.andonie.ea.physicsdemo;

/**
 * Created by andonie on 06.09.15.
 */
public class PhysicsGame
extends ea.Game {

    private Menu menu;
    private Level currentLevel = null;

    public static void main(String[] args) {
        new PhysicsGame();
    }

    public PhysicsGame() {
        super(812, 612, "Texcxt Adventure - A Physics Game");
    }

    @Override
    public void initialisieren() {

        init_menu();
    }

    private void init_menu() {
        menu = new Menu("Welcome!", "Start", "Options", " ~ ? ~");
        wurzel.add(menu);
        anmelden.tastenReagierbar(menu);
        menu.position.set(140, 140);

        menu.setAction(new Runnable() {
            @Override
            public void run() {
                resetGame();
            }
        }, 0);
    }

    private void resetGame() {
        menu.sichtbarSetzen(false);

        startLevel(0);
    }

    private void startLevel(int level) {
        if(currentLevel != null) {
            wurzel.entfernen(currentLevel);
        }
        currentLevel = Level.load(level);
        wurzel.add(currentLevel);
    }

    @Override
    public void tasteReagieren(int i) {

    }
}
