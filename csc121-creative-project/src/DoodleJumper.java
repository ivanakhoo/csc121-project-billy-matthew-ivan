import java.awt.Color;

import processing.core.PApplet;
import processing.event.KeyEvent;

/** Represents the DoodleJumper!*/
public class DoodleJumper {
	Posn p; // Current position -- top left of rectangle
	boolean isMovingLeft;
	boolean isMovingRight;
	double yAcceleration;
	double yVelocity;
	double xVelocity;
	Color color;

	//unchanging (for now)
	double xSpeed;

	// For hitbox - unchanging
	int width;
	int height;

	public DoodleJumper(Posn p, boolean isMovingLeft, boolean isMovingRight, double yAcceleration, double yVelocity, double xVelocity, Color color) {
		//		super();  // I have no idea what this is - it generated with the constructor
		this.p = p;
		this.isMovingLeft = isMovingLeft;
		this.isMovingRight = isMovingRight;
		this.yAcceleration = yAcceleration;
		this.yVelocity = yVelocity;
		this.xVelocity = xVelocity;
		this.color = color;

		this.xSpeed = 1;

		this.width = 20;
		this.height = 30;
	}

	public DoodleJumper update(Platform plat) {
		/** OK so basically. This isn't how collision is supposed to work.
		 * BUT I think this is actually really cool and maybe we could make our game around it. */
		
		// Collision
		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
			this.yVelocity = 0;
		}
		
		// Move left and right
		if(this.isMovingRight || this.isMovingLeft) {
			if(this.isMovingRight && !this.isMovingLeft) {
				this.xVelocity = this.xSpeed;
			} else if(this.isMovingLeft && !this.isMovingRight) {
				this.xVelocity = -this.xSpeed;
			} else {
				this.xVelocity = 0;
			}
		} else {
			this.xVelocity = 0;
		}
		
		// Update position
		this.p.x += this.xVelocity;
		this.p.y += this.yVelocity;


		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity + this.yAcceleration, this.xVelocity, this.color);
	}

	public PApplet draw(PApplet c1) {
		c1.fill(this.color.getRGB());
		c1.rect((float)this.p.x, (float)this.p.y, (float)this.width, (float)this.height);
		return c1;
	}
	
	public DoodleJumper keyPressed(KeyEvent kev) {
		if(kev.getKeyCode() == PApplet.LEFT) {
			this.isMovingLeft = true;
		}
		if(kev.getKeyCode() == PApplet.RIGHT) {
			this.isMovingRight = true;
		}
		if(kev.getKey() == ' ') {
			this.yVelocity = -2;
		}
		
////		while(kev.getKeyCode() == 37 && kev.getKeyCode() == 39) {
////			this.xVelocity = 0;
////		}
//		
////		if(kev.getKeyCode() == 37) {
////			this.isMovingLeft = true;
////		} 
//		
//		while(kev.getKeyCode() == 37 && kev.getKeyCode() != 39) {
//	        this.xVelocity = -this.xSpeed;
//		} 
//		
////		else if(kev.getKeyCode() == 37){
////			this.isMovingLeft = false;
////		}
//		
//		while(kev.getKeyCode() == 39 && kev.getKeyCode() != 37) {
//			this.xVelocity = this.xSpeed;
//		} 
//		
////		if(kev.getKeyCode() == 39) {
////			this.isMovingRight = true;
////		} 
////		else {
////			this.isMovingRight = false;
////		}
		
		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity, this.xVelocity, this.color);
    }
	
	public DoodleJumper keyReleased(KeyEvent kev) {
		if(kev.getKeyCode() == PApplet.LEFT) {
			this.isMovingLeft = false;
		}
		if(kev.getKeyCode() == PApplet.RIGHT) {
			this.isMovingRight = false;
		}
		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity, this.xVelocity, this.color);
	}
	
//	public DoodleJumper keyReleased(KeyEvent kev) {
//		if(kev.getKeyCode() == 37) {
//	        this.isMovingLeft = false;
//		}
//		if(kev.getKeyCode() == 39) {
//			this.isMovingRight = false;
//		}
//		
//		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity, this.xVelocity);
//    }

//	public DoodleJumper collide(Platform plat) {
//		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
//			return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, 0, this.xVelocity);
//		} else {
//			return this;
//		}
//	}


}