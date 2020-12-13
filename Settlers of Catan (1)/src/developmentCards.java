
public class developmentCards {
	
	private int type;
	private String typeName;
	private int number;
	private String typeDescription;
	private int playerOwner = 0;
	
	public void createDevelopmentCard() {
		int random = (int) (Math.random() * 13) + 1;
		switch (random) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7: type = 1; typeName = "Knight"; typeDescription = "Move the robber to another player's settlement."; break;
		case 8:
		case 9:
		case 10: type = 2; typeName = "Victory Point"; typeDescription = "Gain 1 Victory Point."; break;
		case 11: type = 3; typeName = "Road Building"; typeDescription = "Get 2 free roads."; break;
		case 12: type = 4; typeName = "Monopoly"; typeDescription = "Choose 1 resource. Every other player loses their"
				+ " stockpile of that resource and gives it to you."; break;
		case 13: type = 5; typeName = "Year of Plenty"; typeDescription = "Gain two of a resource of your choosing."; break;
		}
	}
	
	public void playDevelopmentCard(players player) {
		switch (type) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		}
	}
	public void setDevCardNumber(int input) {
		number = input;
	}
	public int getDevCardOwner() {
		return playerOwner;
	}
	public void setDevCardOwner(int playerNum) {
		playerOwner = playerNum;
	}
	public int getType() {
		return type;
	}
	public String getTypeName(int i) {
		return typeName;
	}
	public int getDevCardNumber() {
		return number;
	}
	public String getDevCardTypeName() {
		return typeName;
	}
	public String getDevCardDescription() {
		return typeDescription;
	}
	
	
}
