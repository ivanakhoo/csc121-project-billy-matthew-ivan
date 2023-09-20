import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class World {
    DoodleJumper dj;
    Platform p;
    //	Background background; // unsure if we need background yet if our background is a solid color


    public World(DoodleJumper dj, Platform p) {
        this.dj = dj;
        this.p = p;
    }	

    public PApplet draw(PApplet c) {
        c.background(255);
        //        c.text("NoodleHump!", 20, 20);
        //        c.fill(135, 135, 0);
        //        c.circle(100, 100, 15);
        //        p.draw(c);
        //        dj.collide(p);
        dj.update(p);
        dj.draw(c);
        p.draw(c);
        return c;
    }

    public World keyPressed(KeyEvent kev) {
        return new World(this.dj.keyPressed(kev), this.p);
    }

    public World keyReleased(KeyEvent kev) {
        return new World(this.dj.keyReleased(kev), this.p);
    }

    public World update() {
        return new World(this.dj.update(this.p), this.p);
    }



}



