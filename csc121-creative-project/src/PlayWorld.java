import java.awt.Color;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class PlayWorld implements IWorld {
    DoodleJumper dj;
    Stage stage;
    Score score;


    public PlayWorld(DoodleJumper dj, Stage stage, Score score) {
        this.dj = dj;
        this.stage = stage;
        this.score = score;
    }	

    public PApplet draw(PApplet c) {
        c.background(this.stage.bkg.getRGB());
        //        c.text("NoodleHump!", 20, 20);
//        dj.collide(stage);
//        dj.update();
        dj.draw(c);
        stage.draw(c);
        score.draw(c);
        return c;
    }

    public IWorld keyPressed(KeyEvent kev) {
    	if (kev.getKey() == 'q') {
    		return new StartWorld();
    	} else {
    		return new PlayWorld(this.dj.keyPressed(kev), this.stage, this.score);
    	}
    }

    public IWorld keyReleased(KeyEvent kev) {
        return new PlayWorld(this.dj.keyReleased(kev), this.stage, this.score);
    }

    public IWorld update() {
    	this.stage.update();
        return new PlayWorld(this.dj.update(this.stage), this.stage, this.score);
    }


    
    public static PlayWorld buildStandard() {
    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3);
        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
        
        Platform p4 = new Platform(new Posn(100, 100), 100, 20, new Color(65, 206, 93));
        Platform p5 = new Platform(new Posn(250, 400), 100, 20, new Color(65, 206, 93));
        Platform p6 = new Platform(new Posn(500, 300), 100, 20, new Color(65, 206, 93));
        Platform p7 = new Platform(new Posn(750, 200), 100, 20, new Color(65, 206, 93));
        Platform p8 = new Platform(new Posn(800, 100), 100, 20, new Color(65, 206, 93));
//        Platform[] lvl1 = {p1, p2, p3};
        Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
        Stage stage2 = new Stage(new Color(42), new Platform[] {p4, p5, p6, p7, p8}, -2);
        
        Score startscore = new Score(0, "Score: " + 0);
        return new PlayWorld(dj, stage1, startscore);
    }

}



