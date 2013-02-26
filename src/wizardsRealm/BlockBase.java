package wizardsRealm;

public abstract class BlockBase implements Block {
	
	public BlockBase(){}
	
	@Override
	public boolean destroy(int health) {
		return health < 1;
	}

	@Override
	public boolean blockLeft(int[][] blocks, int i, int j) {
		if(i > 0){
			return blocks[i-1][j] >= blocks[i][j];
		}
		else
			return false;
	}

	@Override
	public boolean blockRight(int[][] blocks, int i, int j) {
		if(i < blocks.length - 1){
			return blocks[i+1][j] >= blocks[i][j];
		}
		else
			return false;
	}

	@Override
	public boolean blockAbove(int[][] blocks, int i, int j) {
		if(j > 0){
			return blocks[i][j-1] >= blocks[i][j];
		}
		else
			return false;
	}

	@Override
	public boolean blockBelow(int[][] blocks, int i, int j) {
		if(j < blocks[0].length - 1){
			return blocks[i][j+1] >= blocks[i][j];
		}
		else
			return false;
	}

}
