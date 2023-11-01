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
	
	int jumpvelo;
	int jumps;

	public DoodleJumper(Posn p, boolean isMovingLeft, boolean isMovingRight, double yAcceleration, double yVelocity, double xVelocity, Color color, int jumps, int jumpvelo) {
		//		super();  // I have no idea what this is - it generated with the constructor
		this.p = p;
		this.isMovingLeft = isMovingLeft;
		this.isMovingRight = isMovingRight;
		this.yAcceleration = yAcceleration;
		this.yVelocity = yVelocity;
		this.xVelocity = xVelocity;
		this.color = color;

		this.xSpeed = 2;

		this.width = 20;
		this.height = 30;
		
		this.jumpvelo = jumpvelo;
		
		this.jumps = jumps;
		
	}
	
	
	// Updates the character's position
//	public DoodleJumper update(Platform plat) {
	public DoodleJumper update(Stage stage) {
		// Collision
//		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
//			this.yVelocity = 0;
//		}
//		this.yVelocity = collide(plat);
//		this.yVelocity = collide(stage);
		this.collide(stage);
		
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


		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity + this.yAcceleration, this.xVelocity, this.color, this.jumps, this.jumpvelo);
	}
	
	
	// Draws the character
	public PApplet draw(PApplet c1) {
		c1.fill(this.color.getRGB());
		c1.rect((float)this.p.x, (float)this.p.y, (float)this.width, (float)this.height);
		return c1;
	}
	
	
	// Checks if a key is pressed, and does the relevant action. Then returns a new dj (I'm not sure why)
	public DoodleJumper keyPressed(KeyEvent kev) {
		// Move left
		if(kev.getKeyCode() == PApplet.LEFT) {
			this.isMovingLeft = true;
		}
		
		// Move right
		if(kev.getKeyCode() == PApplet.RIGHT) {
			this.isMovingRight = true;
		}
		
		// Jump
		if(kev.getKey() == ' ' && this.jumps > 0) {
			this.yVelocity = jumpvelo;
			this.jumps -= 1;
		}
		
		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity, this.xVelocity, this.color, this.jumps, this.jumpvelo);
    }
	
	
	// Checks if a key is released so the character will stop moving when not pressed. Then returns a dj (again don't know why)
	public DoodleJumper keyReleased(KeyEvent kev) {
		if(kev.getKeyCode() == PApplet.LEFT) {
			this.isMovingLeft = false;
		}
		if(kev.getKeyCode() == PApplet.RIGHT) {
			this.isMovingRight = false;
		}
		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity, this.xVelocity, this.color, this.jumps, this.jumpvelo);
	}

	
	// Checks collision for a single platform
	public boolean platformCollide(Platform plat) {
//	public DoodleJumper collide(Platform plat) {
		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
//			return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, 0, this.xVelocity, this.color);
			return true;
		} else {
			return false;
//			return this;
		}
	}
	
	
	// Checks collision for the list of platforms in the stage
	public void collide(Stage stage) {
		for(int i = 0; i < stage.platforms.length; i++) {
			if(platformCollide(stage.platforms[i])) {
//				return 0;
				this.yVelocity = -3;
				this.jumps = 3;
			} else {
//				return this.yVelocity;
			}
		}
	}

		public boolean gameOver() {
			int stageWidth = DoodleApp.WIDTH;  //width and height of the stage (need to change later)
			int stageHeight = DoodleApp.HEIGHT;
			
			if(this.p.x <=0) {
				return true;
			}else
			if(this.p.y >= stageHeight) {
				return true;
			}else 
				return false;
		}

}