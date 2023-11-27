/** 
 * Represents a Stage with an array of platforms
 */
import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
public class Stage {
	Color bkg;
	Platform[] platforms;   // pattern of platforms to generate (potentially infinitely)
	double speed;
	ArrayList<Platform> livePlatforms;  // the actual platforms visible right now
	

	public Stage(Color bkg, Platform[] platforms, double speed, ArrayList<Platform> livePlatforms) {
		this.bkg = bkg;
		this.platforms = platforms;
		this.speed = speed;
		this.livePlatforms = livePlatforms;
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
		return new Stage(this.bkg, this.platforms, this.speed, this.livePlatforms);
	}

}




