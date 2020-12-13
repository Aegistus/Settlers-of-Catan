import java.util.Scanner;

public class players {
	
	Scanner keyboard = new Scanner(System.in);
	
	private String name;
	private int number;

	private int wheatAmount = 10;
	private int sheepAmount = 10;
	private int stoneAmount = 10;
	private int brickAmount;
	private int lumberAmount;
	private int merchantAmount;
	private int victoryPoints;

	private int numOfRoads = 2;
	private int armySize;
	private int settlements[];
	private int cities[];
	private int numOfDevCards;
	private boolean settlementLocations[] = new boolean[100];
	private boolean cityLocations[] = new boolean[100];
	private boolean ownedDevelopmentCards[] = new boolean[26];
	
	private boolean largestArmy = false;
	private boolean longestRoad = false;
	
	public int getWheatAmount() {return wheatAmount;}
	public int getSheepAmount() {return sheepAmount;}
	public int getStoneAmount() {return stoneAmount;}
	public int getBrickAmount() {return brickAmount;}
	public int getLumberAmount() {return lumberAmount;}
	public int getMerchantAmount() {return merchantAmount;}
	public int getVPAmount() {return victoryPoints;}
	
	public int getNumOfRoads() {return numOfRoads;}
	public void setNumOfRoads(int num) {numOfRoads += num;}
	public boolean checkSettlementOwnership(int location) {
		if (settlementLocations[location])
			return true;
		else
			return false;
	}
	public boolean checkCityOwnership(int location) {
		if (cityLocations[location])
			return true;
		else
			return false;
	}
	public boolean checkDevCardOwnership(int devCard) {
		if (ownedDevelopmentCards[devCard])
			return true;
		else
			return false;
	}
	public void setWheatAmount(int change) {
		if (wheatAmount + change >= 0)
			wheatAmount += change;
	}
	public void setSheepAmount(int change) {
		if (sheepAmount + change >= 0)
			sheepAmount += change;
	}
	public void setStoneAmount(int change) {
		if (stoneAmount + change >= 0)
			stoneAmount += change;
	}
	public void setBrickAmount(int change) {
		if (brickAmount + change >= 0)
			brickAmount += change;
	}
	public void setLumberAmount(int change) {
		if (lumberAmount + change >= 0)
			lumberAmount += change;
	}
	public void setMerchantAmount(int change) {
		if (merchantAmount + change >= 0)
			merchantAmount += change;
	}
	public void setVPAmount(int change) {
		if (victoryPoints + change >= 0)
			victoryPoints += change;
	}
	public void resetVPAmount() {
		victoryPoints = 0;
	}
	public void addSettlementLocation(int location) {
		if (settlementLocations[location] == false && cityLocations[location] == false)
			settlementLocations[location] = true;
	}
	public void addCityLocation(int location) {
		if (settlementLocations[location] == false && cityLocations[location] == false)
			cityLocations[location] = true;
	}
	public boolean checkVictoryCondition(int totalVictoryPoints) {
		boolean victory = false;
		if (victoryPoints >= totalVictoryPoints)
			victory = true;
		return victory;
	}
	public void setPlayerNumber(int input) {
		number = input;
	}
	public int getPlayerNumber() {
		return number;
	}
	public void setPlayerName(String input) {
		name = input;
	}
	public String getPlayerName() {
		return name;
	}
	
	public void setNumOfDevCards(int input) {
		numOfDevCards += input;
	}

	public int getArmySize() {
		return armySize;
	}
	
	public void setArmySize(int input) {
		armySize += input;
	}
	public void setLargestArmy(boolean input) {
		largestArmy = input;
	}
	public boolean getLargestArmy() {
		return largestArmy;
	}
	public void setLongestRoad(boolean input) {
		longestRoad = input;
	}
	public boolean getLongestRoad() {
		return longestRoad;
	}
}
