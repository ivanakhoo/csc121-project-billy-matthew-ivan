/** 
 * Represents a Stage with an array of platforms
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import processing.core.PApplet;
public class Stage {
	Color bkg;
	Platform[] platforms;   // pattern of platforms to generate (potentially infinitely)
	double speed;
	ArrayList<Platform> livePlatforms;  // the actual platforms visible right now, the last (right-most) should always be offscreen
	
	private static Random rgenerator = new Random();
			// 		rgenerator.nextInt(n)   generates an integer between 0 and (n-1) inclusive
	
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
			cur = curP.nextLabels[0];   // TODO:  cur = curP.nextLabels[   randomnumberbetweewn 0 and length of curP.nextLabels.length ];
			
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
		
		Platform last = livePlatforms.get(livePlatforms.size() - 1);
		
		if (livePlatforms.get(0).isOffscreen()) {  // if the first platform (left-most) has gone off screen, remove it
			livePlatforms.remove(0);
		}
		
		if (last.isOnscreen()) { // if the last platform has come on screen
			// need to generate a new offscreen one
//			int next = last.nextLabels[0];    // TODO: should really be a randomly chosen next label
			int next = last.nextLabels[rgenerator.nextInt(last.nextLabels.length)];
			Platform nextP = platforms[next];
			Platform realP = new Platform(new Posn(nextP.p.x + last.p.x, nextP.p.y), nextP.width, nextP.height, nextP.color, nextP.nextLabels);
			this.livePlatforms.add(realP);
		}
		
		return this;   ///new Stage(this.bkg, this.platforms, this.speed);
	}

	@Override
	public String toString() {
		return "Stage [bkg=" + bkg + ", platforms=" + Arrays.toString(platforms) + ", speed=" + speed
				+ ", livePlatforms=" + livePlatforms + "]";
	}

}




