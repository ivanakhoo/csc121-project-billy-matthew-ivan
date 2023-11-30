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


}



