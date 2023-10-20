import java.awt.Color;

import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class DoodleApp extends PApplet {
    World w;
    
    public void settings() {
        this.size(800, 800);
    }
    
    public void setup() {
        DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3);
        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
//        Platform[] lvl1 = {p1, p2, p3};
        Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3});
        w = new World(dj, stage1);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }
    
    public void keyReleased(KeyEvent kev) {
    	w = w.keyReleased(kev);
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
//        w = w.mousePressed(mev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "DoodleApp" }, new DoodleApp());
    }
}
