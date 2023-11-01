import java.awt.Color;

import processing.core.PApplet;
//Game
public class Score {
	int scoredigits;
	///String text;
	
	public Score(int scoredigits) {
		this.scoredigits = scoredigits;
		//this.text = text;
	}
	
	public PApplet draw(PApplet c) {
		c.fill(255);
		c.text("Score: " + (this.scoredigits/50), 50, 750);
		return c;
	
	}
	
	// Updates the score 
		public Score update() {
			this.scoredigits += 1;
			return new Score(this.scoredigits);
		}
	
}
