/** Represents a platform that the DJ can jump off of*/
public class Platform {
	int length;
	int width;
	String color;
	Posn p; // position of the center-point of the platform.
	
	public Platform(int length, int width, String color, Posn p) {
		this.length = length;
		this.width = width;
		this.color = color;
		this.p = p;
	}
	
}
