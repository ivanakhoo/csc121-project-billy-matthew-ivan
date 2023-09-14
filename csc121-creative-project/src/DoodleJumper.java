/** Represents the DoodleJumper!*/
public class DoodleJumper {
	Posn p; // Current position
	boolean isMovingLeft;
	boolean isMovingRight;
	double yAcceleration;
	double yVelocity;
	double xSpeed;
	
	// For hitbox - unchanging
	int width;
	int height;
	
	public DoodleJumper(Posn p, boolean isMovingLeft, boolean isMovingRight, double yAcceleration, double yVelocity, double xSpeed) {
//		super();  // I have no idea what this is - it generated with the constructor
		this.p = p;
		this.isMovingLeft = isMovingLeft;
		this.isMovingRight = isMovingRight;
		this.yAcceleration = yAcceleration;
		this.yVelocity = yVelocity;
		this.xSpeed = xSpeed;
		
		this.width = 20;
		this.height = 30;
	}
	
	
}
