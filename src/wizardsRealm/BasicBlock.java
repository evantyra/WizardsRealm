package wizardsRealm;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class BasicBlock extends BlockBase {
	protected int width;

	public BasicBlock(){
		width = 15;
	}
	
	@Override
	public void draw(int x, int y, int durability, boolean above, boolean below, boolean left, boolean right) {
		if(durability == 1)
			glColor4f(0,.1f,.1f,.1f);
		else if(durability == 2)
			glColor4f(.1f,0,.1f,.1f);
		else if(durability == 3)
			glColor4f(.1f,.1f,0,.1f);
		
		glRecti(x,y,x+width,y+width);
		
		if(durability == 1)
			glColor4f(0,1,1,.5f);
		else if(durability == 2)
			glColor4f(1,0,1,.5f);
		else if(durability == 3)
			glColor4f(1,1,0,1);
		glBegin(GL_LINES);
		if(!above){
			glVertex2f(x, y);
			glVertex2f(x+width, y);
		} if(!right){
			glVertex2f(x+width, y);
			glVertex2f(x+width, y+width);
		} if(!below){
			glVertex2f(x+width, y+width);
			glVertex2f(x, y+width);
		} if(!left){
			glVertex2f(x, y+width);
			glVertex2f(x, y);
		}
		glEnd();
	}

}
