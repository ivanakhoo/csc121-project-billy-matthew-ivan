import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class DoodleApp extends PApplet {
    World w;
    DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0);
    Platform p = new Platform(new Posn(100, 200), 100, 20, "red");
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
        w = new World(dj, p);
    }
    
    public void draw() {
//        w = w.update();
    	dj = dj.update(p);
//    	p = p.update();
        w.draw(this, dj, p);
    }
    
    public void mousePressed(MouseEvent mev) {
//        w = w.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
        // w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "DoodleApp" }, new DoodleApp());
    }
}
