import processing.core.PApplet;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class World {
	Platform p;
//	Background background; // unsure if we need background yet if our background is a solid color
	//DoodleJumper dj;
	
	
	public PApplet draw(PApplet c) {
        c.background(255);
        c.text("NoodleHump!", 20, 20);
        c.fill(0, 0, 255);
        c.square((int)this.x, (int)this.y, 15);
        return c;
    }	
}



