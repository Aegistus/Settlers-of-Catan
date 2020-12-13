/**
 * SETTLERS OF CATAN VERSION 1
 * By Joe Ballanderson
 * 
 * Planning Notes:
 * -Introduction
 * -Settings:
 * 		Number of players?
 * 		Size of map
 * 		Number of Victory points
 * -Map Generation
 * 		Input: numOfTiles
 * 		Loop x 4 times
 * 			Create resource 1
 * 			Create tile number 1
 * 			Create resource 2
 * 			Create tile number 2
 * 			Create resource 3
 * 			Create tile number 3
 * -Initial Settlement Placement
 * 		Loop x2:
 * 			Player 1 choose location
 * 			Player 2 choose location
 * 			Player 3 choose location
 * 			Player 4 choose location
 * 
 * -Players get initial resources
 * -Rounds begin:
 * 		Loop:
 * 			Roll dice
 * 			Loop:
 * 				Player i's turn
 * 				Options:
 * 					Trade Resource:
 * 						-With other players
 * 						-With a merchant
 * 					Build Road:
 * 						-Choose location
 * 					Settle location:
 * 						-Choose location
 * 					Upgrade a settlement:
 * 						-Choose settlement
 * 					Play Development Card:
 * 						-Pick development card
 * 			Check for longest road
 * 			Check for largest army
 *  		Check victory points
 * Round Ends
 * 
 */


import java.util.Scanner;

public class mainGame {
	
	public static final String RESOURCE_CODE_TO_NAME[] = new String[] {"ERROR", "Wheat", "Sheep", "Stone", "Brick", "Lumber", "Port"};


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		gameMenus menus = new gameMenus();
		
		players playerEmpty = new players();
		players player1 = new players();
		players player2 = new players();
		players player3 = new players();
		players player4 = new players();
		players player5 = new players();
		
		players playerArray[] = new players[] {playerEmpty, player1, player2, player3, player4, player5};
		
		for (int i = 0; i <= 5; i++)
			playerArray[i].setPlayerNumber(i);
		
		// Generate development cards
		developmentCards cards[] = new developmentCards[26];
		for (int i = 1; i <= 25; i++) {
			cards[i] = new developmentCards();
			cards[i].createDevelopmentCard();
			cards[i].setDevCardNumber(i);
		}

		System.out.println("  ~         ~~          __\r\n" + 
				"       _T      .,,.    ~--~ ^^\r\n" + 
				" ^^   // \\                    ~\r\n" + 
				"      ][O]    ^^      ,-~ ~\r\n" + 
				"   /''-I_I         _II____\r\n" + 
				"__/_  /   \\ ______/ ''   /'\\_,__\r\n" + 
				"  | II--'''' \\,--:--..,_/,.-{ },\r\n" + 
				"; '/__\\,.--';|   |[] .-.| O{ _ }\r\n" + 
				":' |  | []  -|   ''--:.;[,.'\\,/\r\n" + 
				"'  |[]|,.--'' '',   ''-,.    |\r\n" + 
				"  ..    ..-''    ;       ''. ' ");

		System.out.println("SETTLERS OF CATAN");
		
		
		//Introduction
		int input = 0, numOfPlayers = 0, totalVictoryPoints = 0, mapSize = 0;

		while (true) {
			System.out.print("Enter Number of Players (min 2, max 5): ");
			input = Integer.parseInt(keyboard.nextLine());
			if (input >= 2 && input <= 5) {
				numOfPlayers = input; break;
			} else {
				System.out.println("INVALID ENTRY. Try Again.");
			}
		}
		while (true) {
			System.out.print("Enter Number of Victory Points to Win (Default 10): ");
			input = Integer.parseInt(keyboard.nextLine());
			if (input >= 5 && input <= 30) {
				totalVictoryPoints = input; break;
			} else {
				System.out.println("INVALID ENTRY. Try Again.");
			}
		}
		while (true) {
			System.out.print("Enter a Map Size (Default 30): ");
			input = Integer.parseInt(keyboard.nextLine());
			if (input >= 15 && input <= 60) {
				mapSize = input; break;
			} else {
				System.out.println("INVALID ENTRY. Try Again.");
			}
		}
		
		// Initialize location objects
		locations location[] = new locations[mapSize];
		for (int i = 0; i <= mapSize - 1; i++) {
			location[i] = new locations();
			location[i].setLocationNumber(i);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		
		//Enter player names
		System.out.println("ENTER PLAYER NAMES: ");
		for (int i = 1; i <= numOfPlayers; i++) {
			System.out.printf("Player %d: ", i);
			playerArray[i].setPlayerName(keyboard.nextLine());
		}
		
		//Generate starting locations
		int numOfStartingLocations = numOfPlayers * 2;
				
		int loopResourceArray[] = new int[4];
		String resourceName = "";
		
		for (int i = 1; i <= numOfStartingLocations; i++) {
			for (int r = 1; r <= 3; r++ ) { //create three resources
				int resourceCode = (int) (Math.random() * 6) + 1;
				loopResourceArray[r] = resourceCode;
			}
			for (int r = 1; r <= 3; r++) {
			location[i].setLocationResource(RESOURCE_CODE_TO_NAME[loopResourceArray[r]], r);
			}
			for (int c = 1; c <= 3; c++) {
				location[i].setLocationChipNumber(((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1), c);
			}
			location[i].changePlayerOwner(0);
		}
		
		//Players Choosing starting positions (Round 1 of picking)
		int playerChoice = 0;
		for (int i = 1; i <= numOfPlayers; i++) { //player loop
			System.out.println("PICK STARTING LOCATION: ROUND 1");
			for (int l = 1; l <= numOfStartingLocations; l++) { //location loop
				if (location[l].getPlayerOwner() == 0) {
					String resource1 = location[l].getLocationResource(1);
					String resource2 = location[l].getLocationResource(2);
					String resource3 = location[l].getLocationResource(3);
					int chipNumber1 = location[l].getLocationChipNumber(1);
					int chipNumber2 = location[l].getLocationChipNumber(2);
					int chipNumber3 = location[l].getLocationChipNumber(3);
					System.out.println("----------------------------------------------------------------------");
					System.out.printf("Location %d: %s, %s, %s.\n", l, resource1,  resource2,  resource3);
				}
			}
			System.out.println();
			while (true) {
				System.out.printf("Player %d (%s) enter the number of your first starting location: ", i, playerArray[i].getPlayerName());
				input = keyboard.nextInt();
				if (location[input].getPlayerOwner() == 0 && input > 0 && input <= numOfStartingLocations) {
					playerChoice = input;
					location[playerChoice].changePlayerOwner(i);
					playerArray[i].addSettlementLocation(playerChoice);
					location[input].setLocationSettlement(true);
					for (int b = 0; b <= 5; b++) {
						System.out.println();
					}
					//System.out.println("DEBUG: " + playerChoice + " " + i);
					break;
				} else 
					System.out.println("INVALID ENTRY. Enter a valid number.");
			}
		}
		//Players Choosing starting positions (Round 2 of picking)
		playerChoice = 0;
		for (int i = 1; i <= numOfPlayers; i++) { //player loop
			System.out.println("PICK STARTING LOCATION: ROUND 1");
			for (int l = 1; l <= numOfStartingLocations; l++) { //location loop
				if (location[l].getPlayerOwner() == 0) {
					String resource1 = location[l].getLocationResource(1);
					String resource2 = location[l].getLocationResource(2);
					String resource3 = location[l].getLocationResource(3);
					int chipNumber1 = location[l].getLocationChipNumber(1);
					int chipNumber2 = location[l].getLocationChipNumber(2);
					int chipNumber3 = location[l].getLocationChipNumber(3);
					System.out.println("----------------------------------------------------------------------");
					System.out.printf("Location %d: %s, %s, %s.\n", l, resource1, resource2, resource3);
				}
			}
			System.out.println();
			while (true) {
				System.out.printf("Player %d (%s) enter the number of your first starting location: ", i, playerArray[i].getPlayerName());
				input = keyboard.nextInt();
				if (location[input].getPlayerOwner() == 0 && input > 0 && input <= numOfStartingLocations) {
					playerChoice = input;
					location[playerChoice].changePlayerOwner(i);
					playerArray[i].addSettlementLocation(playerChoice);
					location[input].setLocationSettlement(true);
					for (int b = 0; b <= 5; b++) {
						System.out.println();
					}
					//System.out.println("DEBUG: " + playerChoice + " " + i);
					break;
				} else 
					System.out.println("INVALID ENTRY. Enter a valid number.");
			}
		}
		// Generate the rest of the locations
		for (int i = numOfStartingLocations + 1; i <= mapSize - 1; i++) {
			for (int r = 1; r <= 3; r++ ) { //create three resources
				int resourceCode = (int) (Math.random() * 6) + 1;
				loopResourceArray[r] = resourceCode;
			}
			for (int r = 1; r <= 3; r++) {
			location[i].setLocationResource(RESOURCE_CODE_TO_NAME[loopResourceArray[r]], r);
			}
			for (int c = 1; c <= 3; c++) {
				location[i].setLocationChipNumber(((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1), c);
			}
			location[i].changePlayerOwner(0);
		}
		
		// Before game rounds begin:
		boolean gameWon = false;
		
		int locationProduction[] = new int[mapSize];
		
		// Give out starting resources
		for (int l = 1; l <= numOfStartingLocations; l++) {
			if (location[l].getPlayerOwner() != 0) {
				int player = location[l].getPlayerOwner();
				String resource1 = location[l].getLocationResource(1);
				String resource2 = location[l].getLocationResource(2);
				String resource3 = location[l].getLocationResource(3);
				//resource1
				if (resource1.equals("Wheat")) {
					playerArray[player].setWheatAmount(1);
				} else if (resource1.equals("Sheep")) {
					playerArray[player].setSheepAmount(1);
				} else if (resource1.equals("Stone")) {
					playerArray[player].setStoneAmount(1);
				} else if (resource1.equals("Brick")) {
					playerArray[player].setBrickAmount(1);
				} else if (resource1.equals("Lumber")) {
					playerArray[player].setLumberAmount(1);
				} else if (resource1.equals("Merchant")) {
					playerArray[player].setMerchantAmount(1);
				}
				//resource 2
				if (resource2.equals("Wheat")) {
					playerArray[player].setWheatAmount(1);
				} else if (resource2.equals("Sheep")) {
					playerArray[player].setSheepAmount(1);
				} else if (resource2.equals("Stone")) {
					playerArray[player].setStoneAmount(1);
				} else if (resource2.equals("Brick")) {
					playerArray[player].setBrickAmount(1);
				} else if (resource2.equals("Lumber")) {
					playerArray[player].setLumberAmount(1);
				} else if (resource2.equals("Merchant")) {
					playerArray[player].setMerchantAmount(1);
				}
				//resource3
				if (resource3.equals("Wheat")) {
					playerArray[player].setWheatAmount(1);
				} else if (resource3.equals("Sheep")) {
					playerArray[player].setSheepAmount(1);
				} else if (resource3.equals("Stone")) {
					playerArray[player].setStoneAmount(1);
				} else if (resource3.equals("Brick")) {
					playerArray[player].setBrickAmount(1);
				} else if (resource3.equals("Lumber")) {
					playerArray[player].setLumberAmount(1);
				} else if (resource3.equals("Merchant")) {
					playerArray[player].setMerchantAmount(1);
				}
			}
		}
		
		// GAME ROUNDS BEGIN
		String stringInput = "";
	
		while (!gameWon) {
			for (int l = 1; l <= numOfStartingLocations; l++) { // Unlike the Board Game, All Owned Resources Are Given Out at the Beginning of the Turn
				if (location[l].getPlayerOwner() != 0) {
					int player = location[l].getPlayerOwner();
					String resource1 = location[l].getLocationResource(1);
					String resource2 = location[l].getLocationResource(2);
					String resource3 = location[l].getLocationResource(3);
					//resource1
					if (resource1.equals("Wheat")) {
						playerArray[player].setWheatAmount(1);
					} else if (resource1.equals("Sheep")) {
						playerArray[player].setSheepAmount(1);
					} else if (resource1.equals("Stone")) {
						playerArray[player].setStoneAmount(1);
					} else if (resource1.equals("Brick")) {
						playerArray[player].setBrickAmount(1);
					} else if (resource1.equals("Lumber")) {
						playerArray[player].setLumberAmount(1);
					} else if (resource1.equals("Merchant")) {
						playerArray[player].setMerchantAmount(1);
					}
					//resource 2
					if (resource2.equals("Wheat")) {
						playerArray[player].setWheatAmount(1);
					} else if (resource2.equals("Sheep")) {
						playerArray[player].setSheepAmount(1);
					} else if (resource2.equals("Stone")) {
						playerArray[player].setStoneAmount(1);
					} else if (resource2.equals("Brick")) {
						playerArray[player].setBrickAmount(1);
					} else if (resource2.equals("Lumber")) {
						playerArray[player].setLumberAmount(1);
					} else if (resource2.equals("Merchant")) {
						playerArray[player].setMerchantAmount(1);
					}
					//resource3
					if (resource3.equals("Wheat")) {
						playerArray[player].setWheatAmount(1);
					} else if (resource3.equals("Sheep")) {
						playerArray[player].setSheepAmount(1);
					} else if (resource3.equals("Stone")) {
						playerArray[player].setStoneAmount(1);
					} else if (resource3.equals("Brick")) {
						playerArray[player].setBrickAmount(1);
					} else if (resource3.equals("Lumber")) {
						playerArray[player].setLumberAmount(1);
					} else if (resource3.equals("Merchant")) {
						playerArray[player].setMerchantAmount(1);
					}
				}
			}
			for (int p = 1; p <= numOfPlayers; p++) {
				boolean turnEnded = false;
				while (!turnEnded) {
					char letterChoice = '_';
					letterChoice = menus.mainTurnMenu(playerArray[p], location, cards, playerArray); // Run Main Menu Method
					if (letterChoice == 'E') {
						turnEnded = true;
					}
				}
				playerArray[p].resetVPAmount();
				for (int l = 1; l <= location.length - 1; l++) {// At turn end add up victory points
					if (location[l].getPlayerOwner() == playerArray[p].getPlayerNumber() && location[l].getLocationSettlement() == true) {
						playerArray[p].setVPAmount(1);
					}
					if (location[l].getPlayerOwner() == playerArray[p].getPlayerNumber() && location[l].getLocationCity() == true) {
						playerArray[p].setVPAmount(2);
					}
				}
				for (int c = 1; c <= cards.length - 1; c++) {
					if (cards[c].getDevCardOwner() == playerArray[p].getPlayerNumber() && cards[c].getType() == 2) {
						playerArray[p].setVPAmount(1);
					}
				}
				for (int otherP = 1; otherP <= playerArray.length - 1; otherP++) { // Check for Longest Road and Largest Army
					if (playerArray[p].getArmySize() > playerArray[otherP].getArmySize() && playerArray[p].getArmySize() >= 3) { // Largest Army
						playerArray[p].setLargestArmy(true);
						playerArray[otherP].setLargestArmy(false);
					} else if (playerArray[p].getArmySize() < playerArray[otherP].getArmySize()) {
						playerArray[p].setLargestArmy(false);
					}
					if (playerArray[p].getNumOfRoads() > playerArray[otherP].getNumOfRoads() && playerArray[p].getNumOfRoads() >= 5) { // Longest Road
						playerArray[p].setLongestRoad(true);
						playerArray[otherP].setLongestRoad(false);
					} else if (playerArray[p].getNumOfRoads() < playerArray[otherP].getNumOfRoads()) {
						playerArray[p].setLongestRoad(false);
					}
				}
				if (playerArray[p].getLargestArmy() == true) {
					playerArray[p].setVPAmount(2);
				}
				if (playerArray[p].getLongestRoad() == true) {
					playerArray[p].setVPAmount(2);
				}
				gameWon = playerArray[p].checkVictoryCondition(totalVictoryPoints);
			}
		}
		if (gameWon) {
			menus.gameEndScreen(playerArray, totalVictoryPoints);
		}
		
		
	}
}
