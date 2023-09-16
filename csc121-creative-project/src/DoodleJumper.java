import processing.core.PApplet;

/** Represents the DoodleJumper!*/
public class DoodleJumper {
	Posn p; // Current position -- top left of rectangle
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

	public DoodleJumper update(Platform plat) {
		if(this.isMovingRight || this.isMovingLeft) {
			if(this.isMovingRight && !this.isMovingLeft) {
				this.xVelocity = this.xSpeed;
			} else if(this.isMovingLeft && !this.isMovingRight) {
				this.xVelocity = -this.xSpeed;
			}
		}
		
//		this.collide(plat);
		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
			this.yVelocity = 0;
		}

		this.p.x += this.xVelocity;
		this.p.y += this.yVelocity;


		return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, this.yVelocity + this.yAcceleration, this.xVelocity);
	}

	public PApplet draw(PApplet c1) {
		c1.rect((float)this.p.x, (float)this.p.y, (float)this.width, (float)this.height);
		return c1;
	}

	public DoodleJumper collide(Platform plat) {
		if (this.p.y <= plat.p.y + plat.height && this.p.y + this.height >= plat.p.y && this.p.x <= plat.p.x + plat.width && this.p.x + this.width >= plat.p.x){
			return new DoodleJumper(this.p, this.isMovingLeft, this.isMovingRight, this.yAcceleration, 0, this.xVelocity);
		} else {
			return this;
		}
	}


}
// hello