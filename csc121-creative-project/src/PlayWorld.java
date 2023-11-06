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
        score.draw(c, dj);
        
       // c.fill(0, 0, 255, 100);  // alpha = transparency
       // c.rect(0, 0, 800, 800);
        return c;
    }

    // Need to implement an else if case to send to PauseWorld
    public IWorld keyPressed(KeyEvent kev) {
    	if (kev.getKey() == 'r') {
    		return new StartWorld();
    	} else if (kev.getKey() == 'p') {
    		return new PauseWorld(this);
    	} else {
    		return new PlayWorld(this.dj.keyPressed(kev), this.stage, this.score);
    	}
    }
    

    public IWorld keyReleased(KeyEvent kev) {
        return new PlayWorld(this.dj.keyReleased(kev), this.stage, this.score);
    }

    public IWorld update() {
    	if (this.dj.gameOver()) {
    		 return new GameOverWorld();
    	} else {
    		this.stage.update();
    		return new PlayWorld(this.dj.update(this.stage), this.stage, this.score.update());
    	}
    }

    
    public static PlayWorld buildLevel1() {
    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3, -3);
    	// LOL what if we made different doodlejumpers with different abilities
    	DoodleJumper ivan = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (150, 150, 0), 3, -4);
    	DoodleJumper matthew = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -5);
    	DoodleJumper billy = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -4);
    	DoodleJumper sean = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (0), 3, -6);
    	
    	
        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
        
        Platform p4 = new Platform(new Posn(300, 400), 100, 20, new Color(65, 206, 93));
        Platform p5 = new Platform(new Posn(800, 300), 100, 20, new Color(65, 206, 93));
        Platform p6 = new Platform(new Posn(1100, 200), 100, 20, new Color(65, 206, 93));
        Platform p7 = new Platform(new Posn(1400, 500), 100, 20, new Color(65, 206, 93));
//        Platform[] lvl1 = {p1, p2, p3};
        Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
        Stage stage2 = new Stage(new Color(42), new Platform[] {p1, p4, p5, p6, p7}, -2);
        
        Score startscore = new Score(0);
        return new PlayWorld(dj, stage1, startscore);
    }
    
    public static PlayWorld buildLevel2() {
    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3, -3);
    	// LOL what if we made different doodlejumpers with different abilities
    	DoodleJumper ivan = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (150, 150, 0), 3, -4);
    	DoodleJumper matthew = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -5);
    	DoodleJumper billy = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -4);
    	DoodleJumper sean = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (0), 3, -6);
    	
    	
        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
        
        Platform p4 = new Platform(new Posn(300, 400), 100, 20, new Color(65, 206, 93));
        Platform p5 = new Platform(new Posn(800, 300), 100, 20, new Color(65, 206, 93));
        Platform p6 = new Platform(new Posn(1100, 200), 100, 20, new Color(65, 206, 93));
        Platform p7 = new Platform(new Posn(1400, 500), 100, 20, new Color(65, 206, 93));
//        Platform[] lvl1 = {p1, p2, p3};
        Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
        Stage stage2 = new Stage(new Color(100, 0, 200), new Platform[] {p1, p4, p5, p6, p7}, -2);
        
        Score startscore = new Score(0);
        return new PlayWorld(dj, stage2, startscore);
    }
    
    public static PlayWorld buildLevel3() {
    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3, -3);
    	// LOL what if we made different doodlejumpers with different abilities
    	DoodleJumper ivan = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (150, 150, 0), 3, -4);
    	DoodleJumper matthew = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255, 255, 255), 3, -5);
    	DoodleJumper billy = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -4);
    	DoodleJumper sean = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (0), 3, -6);
    	
    	
        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
        
        Platform p4 = new Platform(new Posn(300, 400), 100, 20, new Color(65, 206, 93));
        Platform p5 = new Platform(new Posn(800, 300), 100, 20, new Color(65, 206, 93));
        Platform p6 = new Platform(new Posn(1100, 200), 100, 20, new Color(65, 206, 93));
        Platform p7 = new Platform(new Posn(1400, 500), 100, 20, new Color(65, 206, 93));
        
        Platform p8 = new Platform(new Posn(1800, 500), 100, 20, new Color(65, 206, 93));
        Platform p9 = new Platform(new Posn(2000, 300), 100, 20, new Color(65, 206, 93));
        Platform p10 = new Platform(new Posn(2300, 200), 100, 20, new Color(65, 206, 93));
        Platform p11 = new Platform(new Posn(2700, 400), 100, 20, new Color(65, 206, 93));
        Platform p12 = new Platform(new Posn(3200, 200), 100, 20, new Color(65, 206, 93));
//        Platform[] lvl1 = {p1, p2, p3};
        Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
        Stage stage2 = new Stage(new Color(42), new Platform[] {p1, p4, p5, p6, p7}, -2);
        Stage stage3 = new Stage(new Color(120, 0, 0), new Platform[] {p1, p4, p5, p6, p7, p8, p9, p10, p11, p12}, -2.5);
        
        Score startscore = new Score(0);
        return new PlayWorld(billy, stage3, startscore);
    }

}



