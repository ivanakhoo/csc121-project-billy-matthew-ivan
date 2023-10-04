/** Represents a Stage of platforms*/
import java.awt.Color;

import processing.core.PApplet;
public class Stage {
	Color bkg;
	Platform[] platforms;

	public Stage(Color bkg, Platform[] platforms) {
		this.bkg = bkg;
		this.platforms = platforms;
		
	}
	
	public PApplet draw(PApplet c) {
		for(int i = 0; i < platforms.length; i++) {
			platforms[i].draw(c);
		}
		
		return c;
	}
	
}




