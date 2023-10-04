import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class World {
    DoodleJumper dj;
    Stage stage;


    public World(DoodleJumper dj, Stage stage) {
        this.dj = dj;
        this.stage = stage;
    }	

    public PApplet draw(PApplet c) {
        c.background(this.stage.bkg.getRGB());
        //        c.text("NoodleHump!", 20, 20);
        dj.collide(stage);
        dj.update(stage);
        dj.draw(c);
        stage.draw(c);
        return c;
    }

    public World keyPressed(KeyEvent kev) {
        return new World(this.dj.keyPressed(kev), this.stage);
    }

    public World keyReleased(KeyEvent kev) {
        return new World(this.dj.keyReleased(kev), this.stage);
    }

    public World update() {
        return new World(this.dj.update(this.stage), this.stage);
    }



}



