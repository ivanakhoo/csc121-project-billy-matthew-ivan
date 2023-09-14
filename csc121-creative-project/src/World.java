import processing.core.PApplet;

/** Matthew Peterson, Billy Blood, and Ivan Khoo
 * Represents the World and the objects in it*/
public class World {
	Platform p;
//	Background background; // unsure if we need background yet if our background is a solid color
	DoodleJumper dj;
	
	//I tried but idk how all the draw stuff works in eclipse
	
	
	public PApplet draw(PApplet c, Platform p, DoodleJumper dj) {
		
        c.background(255);
//        c.text("NoodleHump!", 20, 20);
//        c.fill(135, 135, 0);
//        c.circle(100, 100, 15);
//        p.draw(c);
        dj.draw(c);
        return c;
    }	
	
}



