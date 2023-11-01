import java.awt.Color;

import processing.core.PApplet;
//Game
public class Score {
	double scoredigits;
	String text;
	
	public Score(double scoredigits, String text) {
		this.scoredigits = scoredigits;
		this.text = text;
	}
	
	public PApplet draw(PApplet c) {
		c.text(this.text, 50, 750);
		return c;
	
	}
	
	// Updates the score 
		public Score update() {
			this.scoredigits += 0.5;
			return new Score(this.scoredigits, "Score: " + this.scoredigits);
		}
	
}
