import java.awt.Color;

import processing.core.PApplet;

/** Represents a platform that the DJ can jump off of*/
public class Platform {
	String label;
	Posn p; // position of the top-left of the platform.
	int width;
	int height;
	Color color;
	String[] nextLabels;
	
	
	public Platform(String label, Posn p, int width, int height, Color color, String[] nextLabels) {
		this.label = label;
		this.p = p;
		this.width = width;
		this.height = height;
		this.color = color;
		this.nextLabels = nextLabels;
	}

	// We can add an update function later, I think moving platforms would be cool
//	public DoodleJumper update() {
//		if(this.isMovingRight || this.isMovingLeft) {
//			if(this.isMovingRight && !this.isMovingLeft) {
//				this.xVelocity = this.xSpeed;
//			} else if(this.isMovingLeft && !this.isMovingRight) {
//				this.xVelocity = -this.xSpeed;
//			}
//		}
//		
//		this.p.x += this.xVelocity;
//		this.p.y += this.yVelocity;
//		
//		
//		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity + this.yAcceleration, this.xVelocity);
//	}
	
	public PApplet draw(PApplet c2) {
		c2.fill(this.color.getRGB());
        c2.rect((float)this.p.x, (float)this.p.y, (float)this.width, (float)this.height);
        return c2;
    }
	
	// Updates the platform's position
	public Platform update(double speed) {
		this.p.x += speed;
		return new Platform(this.label, this.p, this.width, this.height, this.color, this.nextLabels);
	}
	
}
