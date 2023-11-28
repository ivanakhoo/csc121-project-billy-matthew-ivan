/** 
 * Represents a Stage with an array of platforms
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;
public class Stage {
	Color bkg;
	Platform[] platforms;   // pattern of platforms to generate (potentially infinitely)
	double speed;
	ArrayList<Platform> livePlatforms;  // the actual platforms visible right now
	

	public Stage(Color bkg, Platform[] platforms, double speed) {
		this.bkg = bkg;
		this.platforms = platforms;
		this.speed = speed;
		
		
		this.livePlatforms = new ArrayList<Platform>();
		boolean done = false;
		int cur = 0;
		double curX = 0;
		while (! done) {
			Platform curP = platforms[cur];
			Platform realP = new Platform(new Posn(curP.p.x + curX, curP.p.y), curP.width, curP.height, curP.color, curP.nextLabels);
			this.livePlatforms.add(realP);
			curX = curP.p.x + curX;
			cur = curP.nextLabels[0];   // cur = curP.nextLabels[   randomnumberbetweewn 0 and length of curP.nextLabel ];
			
			if (curX > DoodleApp.WIDTH) { done = true; }
		}
	}
	// change update adn draw to use livePlatforms

	public PApplet draw(PApplet c) {
		for(int i = 0; i < livePlatforms.size()/**platforms.length*/; i++) {
		//	platforms[i].draw(c);
		livePlatforms.get(i).draw(c);
		}
		
		return c;
	}
	
	// Updates the position of all the platforms in the stage
	public Stage update() {
		for(int i = 0; i < livePlatforms.size(); i++) {
			livePlatforms.get(i).update(this.speed);
		}
		return new Stage(this.bkg, this.platforms, this.speed);
	}

	@Override
	public String toString() {
		return "Stage [bkg=" + bkg + ", platforms=" + Arrays.toString(platforms) + ", speed=" + speed
				+ ", livePlatforms=" + livePlatforms + "]";
	}

}




