import java.awt.Color;

import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class DoodleApp extends PApplet {
	IWorld w;
    
    public void settings() {
        this.size(800, 800);
    }
    
    public void setup() {
        w = new StartWorld();
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
