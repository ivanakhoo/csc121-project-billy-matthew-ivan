import processing.core.PApplet;

/** Represents the DoodleJumper!*/
public class DoodleJumper {
	Posn p; // Current position
	boolean isMovingLeft;
	boolean isMovingRight;
	double yAcceleration;
	double yVelocity;
	double xVelocity;
	
	//unchanging (for now)
	double xSpeed;
	
	// For hitbox - unchanging
	int width;
	int height;
	
	public DoodleJumper(Posn p, boolean isMovingLeft, boolean isMovingRight, double yAcceleration, double yVelocity, double xVelocity) {
//		super();  // I have no idea what this is - it generated with the constructor
		this.p = p;
		this.isMovingLeft = isMovingLeft;
		this.isMovingRight = isMovingRight;
		this.yAcceleration = yAcceleration;
		this.yVelocity = yVelocity;
		this.xVelocity = xVelocity;
		
		this.xSpeed = 5;
		
		this.width = 20;
		this.height = 30;
	}
	
	public DoodleJumper update() {
		if(this.isMovingRight || this.isMovingLeft) {
			if(this.isMovingRight && !this.isMovingLeft) {
				this.xVelocity = this.xSpeed;
			} else if(this.isMovingLeft && !this.isMovingRight) {
				this.xVelocity = -this.xSpeed;
			}
		}
		
		this.p.x += this.xVelocity;
		this.p.y += this.yVelocity;
		
		
		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity + this.yAcceleration, this.xVelocity);
	}
	
	public PApplet draw(PApplet c1) {
        c1.circle((float)this.p.x, (float)this.p.y, (float)this.width);
        return c1;
    }
	
	
}
// hello