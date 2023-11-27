/** 
 * Represents a Stage with an array of platforms
 */
import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
public class Stage {
	Color bkg;
	Platform[] platforms;   // pattern of platforms to generate (potentially infinitely)
	ArrayList<Platform> livePlatforms;  // the actual platforms visible right now
	
	double speed;
	
	public Stage(Color bkg, Platform[] platforms, ArrayList<Platform> livePlatforms, double speed) {
		this.bkg = bkg;
		this.platforms = platforms;
		this.livePlatforms = livePlatforms;
		this.speed = speed;
	}

	public PApplet draw(PApplet c) {
		for(int i = 0; i < platforms.length; i++) {
			platforms[i].draw(c);
		}
		
		return c;
	}
	
	// Updates the position of all the platforms in the stage
	public Stage update() {
		for(int i = 0; i < platforms.length; i++) {
			platforms[i].update(this.speed);
		}
		return new Stage(this.bkg, this.platforms, this.livePlatforms, this.speed);
	}

}




