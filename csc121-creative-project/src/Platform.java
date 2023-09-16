import processing.core.PApplet;

/** Represents a platform that the DJ can jump off of*/
public class Platform {
	Posn p; // position of the top-left of the platform.
	int width;
	int height;
	String color;
	
	public Platform(Posn p, int width, int height, String color) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.color = color;
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
        c2.rect((float)this.p.x, (float)this.p.y, (float)this.width, (float)this.height);
        return c2;
    }
	
}
