/**
Class for settlement locations
 */

public class locations {
	
	private int number;
	private String resources[] = new String[4];
	private int chipNumber[] = new int[4];
	private boolean blocked;
	private int playerOwner;
	private boolean settlementBuilt;
	private boolean cityBuilt;
	
	public String getLocationResource(int resourceNum) {
		String resource = resources[resourceNum];
		return resource;
	}
	
	public int getLocationChipNumber(int num) {
		int chipNum = chipNumber[num];
		return chipNum;
	}
	
	public boolean getLocationSettlement() {
		return settlementBuilt;
	}
	
	public void setLocationSettlement(boolean input) {
		settlementBuilt = input;
	}
	
	public boolean getLocationCity() {
		return cityBuilt;
	}
	
	public void setLocationCity(boolean input) {
		cityBuilt = input;
	}
	
	public int getPlayerOwner() {
		return playerOwner;
	}
	
	public void setPlayerOwner(int player) {
		playerOwner = player;
	}
	
	public int getLocationNumber() {
		return number;
	}
	public void setLocationNumber(int input) {
		number = input;
	}
	
	public void changePlayerOwner(int player) {
		if (player > 0)
			playerOwner = player;
	}
	
	public void setLocationResource(String resourceName, int resourceNum) {
		if (resourceNum >= 0 && resourceNum < 5)
			resources[resourceNum] = resourceName;
	}
	
	public void setLocationChipNumber(int input, int chipNum) {
		chipNumber[chipNum] = input;
	}
	public void setBlock(boolean input) {
		blocked = input;
	}
	
	
}
