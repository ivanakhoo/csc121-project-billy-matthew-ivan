import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        
        stage.draw(c);
        c.fill(258, 0, 255, 100);
        dj.draw(c);
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
    
    
    private static Platform[] readAllPlatforms(Scanner sc) {
    	int platformCount = sc.nextInt();
    	//System.out.println(platformCount);
		Platform[] platforms = new Platform[platformCount];
		for (int i = 0; i < platformCount; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			String[] nextStrs = sc.next().split(",");
			int[] nextLabels = new int[nextStrs.length];
			for (int j = 0; j < nextStrs.length; j++) { nextLabels[j] = Integer.parseInt(nextStrs[j]); }
			
			Platform p = new Platform(new Posn(x, y), 100, 20, new Color(r, g, b), nextLabels);
			//System.out.println("Made " + p);
			platforms[i] = p;
		}
		
		return platforms;
    }
    
    /*
    private static ArrayList<Platform> readPattern(Scanner sc) {
    	ArrayList<Platform> platforms = new ArrayList<Platform>();
    	
    	for (int i = 0; i < platforms.size(); i++) {
    		
    		String[] nexts = sc.next().split(",");
    	}
    }
    */
    
    public static PlayWorld buildLevel(int level, String username) {
		try {
			
			// TODO:   open a     "user-" + username + ".txt"  file and read user data from it to create the DoodleJumper.
			//   make a new file if they're not already a user
	    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116, 1), 3, -4);

	    	String filename = "level" + level + ".txt";
			Scanner sc = new Scanner(new File(filename));
			
			Platform[] allPlatforms = readAllPlatforms(sc);
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			int r3 = sc.nextInt();
			float speed = sc.nextFloat();
			
			Stage stage = new Stage(new Color(r1, r2, r3), allPlatforms, speed);
	        
	        Score startscore = new Score(0);
	        return new PlayWorld(dj, stage, startscore);
			
		} catch (FileNotFoundException e) {
			System.out.println("Invalid level #: " + level);
			e.printStackTrace();
			System.exit(-1);
		}

		return null;  // should never get here
    }

    
    public static PlayWorld buildLevel1() {
    	return buildLevel(1, "nadeem");
    	
    	/*
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
        */
    }
    
    public static PlayWorld buildLevel2() {
    	return buildLevel(2, "nadeem");
//    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3, -3);
//    	// LOL what if we made different doodlejumpers with different abilities
//    	DoodleJumper ivan = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (150, 150, 0), 3, -4);
//    	DoodleJumper matthew = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -5);
//    	DoodleJumper billy = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -4);
//    	DoodleJumper sean = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (0), 3, -6);
//    	
//    	
//        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
//       // Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
//        //Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
//        
//        Platform p4 = new Platform(new Posn(300, 400), 100, 20, new Color(65, 206, 93));
//        Platform p5 = new Platform(new Posn(800, 300), 100, 20, new Color(65, 206, 93));
//        Platform p6 = new Platform(new Posn(1100, 200), 100, 20, new Color(65, 206, 93));
//        Platform p7 = new Platform(new Posn(1400, 500), 100, 20, new Color(65, 206, 93));
////        Platform[] lvl1 = {p1, p2, p3};
//    //    Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
//        Stage stage2 = new Stage(new Color(100, 0, 200), new Platform[] {p1, p4, p5, p6, p7}, -2);
//        
//        Score startscore = new Score(0);
//        return new PlayWorld(dj, stage2, startscore);
    }
    
    public static PlayWorld buildLevel3() {
    	return buildLevel(3, "nadeem");
//    	DoodleJumper dj = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (206, 65, 116), 3, -3);
//    	// LOL what if we made different doodlejumpers with different abilities
//    	DoodleJumper ivan = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (150, 150, 0), 3, -4);
//    	DoodleJumper matthew = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255, 255, 255), 3, -5);
//    	DoodleJumper billy = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (255), 3, -4);
//    	DoodleJumper sean = new DoodleJumper(new Posn(100, 100), false, false, 0.1, 0, 0, new Color (0), 3, -6);
//    	
//    	
//        Platform p1 = new Platform(new Posn(100, 200), 100, 20, new Color(65, 206, 93));
//        Platform p2 = new Platform(new Posn(250, 300), 100, 20, new Color(65, 206, 93));
//        Platform p3 = new Platform(new Posn(500, 100), 100, 20, new Color(65, 206, 93));
//        
//        Platform p4 = new Platform(new Posn(300, 400), 100, 20, new Color(65, 206, 93));
//        Platform p5 = new Platform(new Posn(800, 300), 100, 20, new Color(65, 206, 93));
//        Platform p6 = new Platform(new Posn(1100, 200), 100, 20, new Color(65, 206, 93));
//        Platform p7 = new Platform(new Posn(1400, 500), 100, 20, new Color(65, 206, 93));
//        
//        Platform p8 = new Platform(new Posn(1800, 500), 100, 20, new Color(65, 206, 93));
//        Platform p9 = new Platform(new Posn(2000, 300), 100, 20, new Color(65, 206, 93));
//        Platform p10 = new Platform(new Posn(2300, 200), 100, 20, new Color(65, 206, 93));
//        Platform p11 = new Platform(new Posn(2700, 400), 100, 20, new Color(65, 206, 93));
//        Platform p12 = new Platform(new Posn(3200, 200), 100, 20, new Color(65, 206, 93));
////        Platform[] lvl1 = {p1, p2, p3};
//       // Stage stage1 = new Stage(new Color(42), new Platform[]{p1, p2, p3}, -1);
//       // Stage stage2 = new Stage(new Color(42), new Platform[] {p1, p4, p5, p6, p7}, -2);
//        Stage stage3 = new Stage(new Color(120, 0, 0), new Platform[] {p1, p4, p5, p6, p7, p8, p9, p10, p11, p12}, -2.5);
//        
//        Score startscore = new Score(0);
//        return new PlayWorld(billy, stage3, startscore);
    }
    
    public Stage getStage() {
    	return this.stage;
    }
    public Score getScore() {
    	return this.score;
    }

}



