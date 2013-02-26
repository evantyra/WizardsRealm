package wizardsRealm;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class theRealm {
	protected int[][] blocks;
	protected BasicBlock block;
	
	public theRealm(){
		try{
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Wizard's Realm");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
		// General initialization 
		block = new BasicBlock();
		mapGeneration(0);
		
		// Initialization code OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 1920, 1080, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()){
			// Render
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			// Change this later to be much more efficient, only draw blocks on screen
			for(int i = 0; i < blocks.length; i++)
				for(int j = 0; j < blocks[0].length; j++){
					if(blocks[i][j] > 0)
						block.draw(i*15, j*15, blocks[i][j], block.blockAbove(blocks, i, j), block.blockBelow(blocks, i, j),
								block.blockLeft(blocks, i, j), block.blockRight(blocks, i, j));
				}
					
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		
	}
	
	public void mapGeneration(int size){
		
		if(size == 0)	// Small Map Size
			blocks = new int[400][100];
		if(size == 1)	// Medium Map Size
			blocks = new int[800][300];
		if(size == 2)	// Large Map Size
			blocks = new int[1200][300];
		
		//int startingY = (int)(Math.random()*100 + 125);
		int startingY = (int)(Math.random()*37) + 25;
		int hardTerrain = startingY + 15;
		int terrainType = (int)(Math.random()*5);
		
		for(int i = 0; i < blocks.length; i++){
			// Random number to allow for different changes in elevation
			int random = (int)(Math.random()*20);
			
			if(i % 40 == 0)
				terrainType = (int)(Math.random()*5);
			
			// Flatland
			if(terrainType == 0 || terrainType == 4){
				if(random < 3)
					startingY -= 1;
				else if(random > 16)
					startingY += 1;
			}
			// Stoneland
			else if(terrainType == 1){
				if(random < 1)
					startingY -= 1;
				else if(random > 18)
					startingY += 1;
			}
			// Mountain
			else if(terrainType == 2){
				if(i % 40 > 19){
					if(random < 6)
						startingY += 2;
					else if(random > 14)
						startingY += 1;
				}
				else{
					if(random < 6)
						startingY -= 2;
					else if(random > 14)
						startingY -= 1;
				}					
			}
			// Basin
			else if(terrainType == 3){
				if(i % 40 < 16){
					if(random < 6)
						startingY += 2;
					else if(random > 14)
						startingY += 1;
				}
				else if(i % 40 > 25){
					if(random < 6)
						startingY -= 2;
					else if(random > 14)
						startingY -= 1;
				}					
			}
			
			if(random <2)
				hardTerrain -= 1;
			else if(random > 17)
				hardTerrain += 1;
			
			for(int j = 0; j < blocks[0].length; j++){
				if(j >= startingY){
					if(terrainType == 1)
						blocks[i][j] = 3;
					else if(j >= hardTerrain)
						blocks[i][j] = 2;
					else
						blocks[i][j] = 1;
				}					
			}
		}
	}
	
	public static void main(String[] args){
		new theRealm();
	}
}
