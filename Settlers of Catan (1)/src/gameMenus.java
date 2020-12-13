import java.util.Scanner;

public class gameMenus {
	
	Scanner keyboard = new Scanner(System.in);

	public char mainTurnMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		String input = "";
		char letterChoice = '_';
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("-------------------------------------------");
		System.out.printf("	OPTIONS:						\n");
		System.out.printf("	a) %-1.30s %-10.10s						\n", "Trade Resources", "|");
		System.out.printf("	b) %-1.30s %-10.10s						\n", "Build", "|");
		System.out.printf("	c) %-1.30s %-10.10s						\n", "Play Development Card", "|");
		System.out.printf("	d) %-1.30s %-10.10s						\n", "Player Info", "|");
		System.out.printf("	e) %-1.30s %-10.10s						\n", "End Turn", "|");
		System.out.println("-------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-e): \n");
		
		input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
		case 'A': // TRADE OVERVIEW
			tradeOverviewMenu(player, location, cards, playerArray); break;
		case 'B': // BUILD OVERVIEW
			buildOverviewMenu(player, location, cards, playerArray); break;
		case 'C': // PLAY DEV CARD OVERVIEW
			playDevelopmentCardMenu(player, location, cards, playerArray); break;
		case 'D': // GENERAL PLAYER INFORMATION
			playerOverviewMenu(player, location, cards, playerArray); break;
		case 'E': // END TURN
			break;
		}
		return letterChoice;
	}
	
	public void tradeOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	TRADE MENU\n");
		System.out.printf("	OPTIONS: 							\n");
		System.out.printf("	a) Create Trade Offer \n");
		System.out.printf("	b) Create Trade Offer With Merchant\n");
		System.out.println();
		System.out.printf(" c) Exit to Main Menu \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-c): \n");
			
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
			case 'A': withoutMerchantOverviewMenu(player, location, cards, playerArray); break;
			case 'B': withMerchantOverviewMenu(player, location, cards, playerArray); break;
			case 'C': mainTurnMenu(player, location, cards, playerArray);
			default: mainTurnMenu(player, location, cards, playerArray);
		}
	}
	
	public void buildOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	BUILD MENU OPTIONS: \n");
		System.out.printf("	a) Build Road \n");
		System.out.printf("	b) Build Settlement \n");
		System.out.printf("	c) Upgrade Settlement \n");
		System.out.printf("	d) Build Development Card \n");
		System.out.println();
		System.out.printf("	e) Exit to Main Menu \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-d): \n");
			
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
			case 'A': if (player.getBrickAmount() >= 1 && player.getLumberAmount() >= 1) {// BUILD ROAD
				player.setBrickAmount(-1);
				player.setLumberAmount(-1);
				player.setNumOfRoads(1);
					}
				break;
			case 'B': buildSettlementMenu(player, location, cards, playerArray); mainTurnMenu(player, location, cards, playerArray); break;// BUILD SETTLEMENT
			case 'C': upgradeSettlementMenu(player, location, cards, playerArray); mainTurnMenu(player, location, cards, playerArray); break; // UPGRADE SETTLEMENT
			
			case 'D': if (player.getWheatAmount() >= 1 && player.getSheepAmount() >= 1
					&& player.getStoneAmount() >= 1) { // BUY DEVELOPMENT CARD
					player.setWheatAmount(-1);
					player.setSheepAmount(-1);
					player.setStoneAmount(-1);
					player.setNumOfDevCards(1);
					for (int c = 1; c <= cards.length - 1; c++) {
						if (cards[c].getDevCardOwner() == 0) {
							cards[c].setDevCardOwner(player.getPlayerNumber());
							break;
							}
					}
					playDevelopmentCardMenu(player, location, cards, playerArray);
				} break;
			case 'F': mainTurnMenu(player, location, cards, playerArray); break;
			default: mainTurnMenu(player, location, cards, playerArray);
		}
	}
	
	public void buildSettlementMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	BUILD SETTLEMENT MENU\n");
		System.out.printf("	AVAILABLE LOCATIONS(Build more roads to unlock more): 							\n");

		for (int i = 1; i <= player.getNumOfRoads() * 2; i++) {
			if (location[i].getPlayerOwner() == 0) {
				System.out.printf(" %d) Settlement (%s, %s, %s)\n", location[i].getLocationNumber(), location[i].getLocationResource(1), location[i].getLocationResource(2), location[i].getLocationResource(3));
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.printf(" 0) Exit to Main Menu \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (1-0): \n");
			
		numberChoice = Integer.parseInt(keyboard.next());
		if (location[numberChoice].getPlayerOwner() <= 0) {
			location[numberChoice].setPlayerOwner(player.getPlayerNumber());
			location[numberChoice].setLocationSettlement(true);
			player.setWheatAmount(-1);
			player.setBrickAmount(-1);
			player.setSheepAmount(-1);
			player.setLumberAmount(-1);
			mainTurnMenu(player, location, cards, playerArray);
		} else if (numberChoice == 0) {
			mainTurnMenu(player, location, cards, playerArray);
		} else {
			mainTurnMenu(player, location, cards, playerArray);
		}
	}
	
	public void upgradeSettlementMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	SETTLEMENT UPGRADE MENU\n");
		System.out.printf("	SETTLEMENTS: 							\n");

		for (int i = 1; i <= location.length - 1; i++) {
			if (location[i].getPlayerOwner() == player.getPlayerNumber() && location[i].getLocationCity() == false) {
				System.out.printf(" %d) Settlement (%s, %s, %s)\n", location[i].getLocationNumber(), location[i].getLocationResource(1), location[i].getLocationResource(2), location[i].getLocationResource(3));
			}
		}
		System.out.printf(" 0) Exit to Main Menu \n");
		System.out.println("");
		System.out.printf("Enter a choice from the options menu (1-0): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		numberChoice = Integer.parseInt(keyboard.next());
		if (location[numberChoice].getLocationSettlement() == true && location[numberChoice].getPlayerOwner() == player.getPlayerNumber() &&
				player.getWheatAmount() >= 3 && player.getStoneAmount() >= 2) {
				player.setWheatAmount(-3);
				player.setStoneAmount(-2);
				location[numberChoice].setLocationSettlement(false);
				location[numberChoice].setLocationCity(true);
				mainTurnMenu(player, location, cards, playerArray);
			} else if (numberChoice == 0) {
				mainTurnMenu(player, location, cards, playerArray);
			}
	}
	
	public void playDevelopmentCardMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("PLAY DEVELOPMENT CARD MENU\n");
		System.out.printf("DEVELOPMENT CARDS: 							\n");
		for (int i = 1; i <= cards.length - 1; i++) {
			if (cards[i].getDevCardOwner() == player.getPlayerNumber()) {
				System.out.printf(" %d) %S: %s \n", cards[i].getDevCardNumber(), cards[i].getDevCardTypeName(), cards[i].getDevCardDescription());
			}
		}
		System.out.printf(" 0) Exit to Main Menu \n");
		System.out.println("");
		System.out.printf("Enter a choice from the options menu (1-0): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		numberChoice = keyboard.nextInt();
		if (numberChoice > 0) {
			switch (cards[numberChoice].getType()) {
				case 1: playDevelopmentCardKnight(player, location, cards, playerArray); break;
				case 2: player.setVPAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
				case 3: player.setNumOfRoads(2); mainTurnMenu(player, location, cards, playerArray); break;
				case 4: playDevelopmentCardMonopoly(player, location, cards, playerArray); mainTurnMenu(player, location, cards, playerArray); break;
				case 5: playDevelopmentCardYearOfPlenty(player, location, cards, playerArray); mainTurnMenu(player, location, cards, playerArray);  break;
			}
		} else if (numberChoice == 0) {
			mainTurnMenu(player, location, cards, playerArray);
		}
	}
	
	public void playDevelopmentCardKnight(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("PLAY KNIGHT CARD\n");
		System.out.printf("OPPONENT LOCATIONS: 							\n");
		for (int l = 1; l <= location.length - 1; l++) {
			if (location[l].getPlayerOwner() > 0) {
				System.out.printf(" %d) Player %d (%s, %s, %s)\n", location[l].getLocationNumber(), location[l].getPlayerOwner(), location[l].getLocationResource(1), location[l].getLocationResource(2), location[l].getLocationResource(3));
			}
		}
		System.out.printf(" 0) Exit to Main Menu \n");
		System.out.println("");
		System.out.printf("Enter a choice from the options menu (1-0): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		numberChoice = keyboard.nextInt();
		if (numberChoice > 0) {
			location[numberChoice].setBlock(true);
			player.setArmySize(1);
			mainTurnMenu(player, location, cards, playerArray);
		} else if (numberChoice == 0) {
			mainTurnMenu(player, location, cards, playerArray);
		}
	}
	
	public void playDevelopmentCardMonopoly(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("PLAY MONOPOLY CARD\n");
		System.out.printf("RESOURCE CHOICES: 							\n");
		System.out.printf("	a) Take all Wheat\n");
		System.out.printf("	b) Take all Sheep\n");
		System.out.printf("	c) Take all Stone\n");
		System.out.printf("	d) Take all Brick\n");
		System.out.printf("	e) Take all Lumber\n");
		System.out.printf(" f) Exit to Main Menu \n");
		System.out.printf("Enter a choice from the options menu (a-f): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		letterChoice = keyboard.next().toUpperCase().charAt(0);
		int resourceTotal = 0;
		switch (letterChoice) {
		case 'A': for (int p = 1; p <= playerArray.length - 1; p++) {
			resourceTotal += playerArray[p].getWheatAmount();
			playerArray[p].setWheatAmount(-playerArray[p].getWheatAmount());
			}
			player.setWheatAmount(resourceTotal);
			mainTurnMenu(player, location, cards, playerArray);
			break;
		case 'B':  for (int p = 1; p <= playerArray.length - 1; p++) {
			resourceTotal += playerArray[p].getSheepAmount();
			playerArray[p].setSheepAmount(-playerArray[p].getSheepAmount());
			}
			player.setSheepAmount(resourceTotal); 
			mainTurnMenu(player, location, cards, playerArray);
			break;
		case 'C':  for (int p = 1; p <= playerArray.length - 1; p++) {
			resourceTotal += playerArray[p].getStoneAmount();
			playerArray[p].setStoneAmount(-playerArray[p].getStoneAmount());
			}
			player.setStoneAmount(resourceTotal);
			mainTurnMenu(player, location, cards, playerArray);
			break;
		case 'D':  for (int p = 1; p <= playerArray.length - 1; p++) {
			resourceTotal += playerArray[p].getBrickAmount();
			playerArray[p].setBrickAmount(-playerArray[p].getBrickAmount());
			}
			player.setBrickAmount(resourceTotal);
			mainTurnMenu(player, location, cards, playerArray);
			break;
		case 'E':  for (int p = 1; p <= playerArray.length - 1; p++) {
			resourceTotal += playerArray[p].getLumberAmount();
			playerArray[p].setLumberAmount(-playerArray[p].getLumberAmount());
			}
			player.setLumberAmount(resourceTotal);
			mainTurnMenu(player, location, cards, playerArray);
			break;
		case 'F':  mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void playDevelopmentCardYearOfPlenty(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("PLAY YEAR OF PLENTY CARD\n");
		System.out.printf("RESOURCE CHOICES: 							\n");
		System.out.printf("	a) Get 2 Wheat\n");
		System.out.printf("	b) Get 2 Sheep\n");
		System.out.printf("	c) Get 2 Stone\n");
		System.out.printf("	d) Get 2 Brick\n");
		System.out.printf("	e) Get 2 Lumber\n");
		System.out.printf(" f) Exit to Main Menu \n");
		System.out.printf("Enter a choice from the options menu (a-f): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		letterChoice = keyboard.next().toUpperCase().charAt(0);
		int resourceTotal = 0;
		switch (letterChoice) {
		case 'A': player.setWheatAmount(2); mainTurnMenu(player, location, cards, playerArray); break;
		case 'B': player.setSheepAmount(2); mainTurnMenu(player, location, cards, playerArray); break;
		case 'C': player.setStoneAmount(2); mainTurnMenu(player, location, cards, playerArray); break;
		case 'D': player.setBrickAmount(2); mainTurnMenu(player, location, cards, playerArray); break;
		case 'E': player.setLumberAmount(2); mainTurnMenu(player, location, cards, playerArray); break;
		case 'F':  mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void withoutMerchantOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	MERCHANT MENU\n");
		System.out.printf("	OPTIONS: 						 \n");
		System.out.printf("	a) Buy Wheat\n");
		System.out.printf("	b) Buy Sheep\n");
		System.out.printf("	c) Buy Stone\n");
		System.out.printf("	d) Buy Brick\n");
		System.out.printf("	e) Buy Lumber\n");
		System.out.printf(" f) Exit to Main Menu \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-f): \n");
			
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E': createTradeOfferMenu(player, location, cards, playerArray, letterChoice); break;
			case 'F': mainTurnMenu(player, location, cards, playerArray); break;
		}
	}

	public void createTradeOfferMenu(players player, locations location[], developmentCards cards[], players playerArray[], char prevLetterChoice) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		String resourceToTrade = "";
		int resourceCode = 0;
		char letterChoice = '_';
		switch (prevLetterChoice) {
		case 'A': resourceToTrade = "Wheat"; resourceCode = 1; break;
		case 'B': resourceToTrade = "Sheep"; resourceCode = 2; break;
		case 'C': resourceToTrade = "Stone"; resourceCode = 3; break;
		case 'D': resourceToTrade = "Brick"; resourceCode = 4; break;
		case 'E': resourceToTrade = "Lumber";resourceCode = 5; break;
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	TRADE OFFER MENU\n");
		System.out.printf("	OPTIONS: 							\n");
		System.out.printf("	a) Sell 4 Wheat for 1 %s\n", resourceToTrade);
		System.out.printf("	b) Sell 4 Sheep for 1 %s\n", resourceToTrade);
		System.out.printf("	c) Sell 4 Stone for 1 %s\n", resourceToTrade);
		System.out.printf("	d) Sell 4 Brick for 1 %s\n", resourceToTrade);
		System.out.printf("	e) Sell 4 Lumber for 1 %s\n", resourceToTrade);
		System.out.printf("	f) Exit to Main Menu\n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		boolean validTrade = false;
		switch (letterChoice) { // REMOVE RESOURCE BEING TRADED OUT
			case 'A': if (player.getWheatAmount() >= 4) {player.setWheatAmount(-4); validTrade = true;} break;
			case 'B': if (player.getSheepAmount() >= 4) {player.setSheepAmount(-4); validTrade = true;} break;
			case 'C': if (player.getStoneAmount() >= 4) {player.setStoneAmount(-4); validTrade = true;} break;
			case 'D': if (player.getBrickAmount() >= 4) {player.setBrickAmount(-4); validTrade = true;} break;
			case 'E': if (player.getLumberAmount() >= 4){ player.setLumberAmount(-4); validTrade = true;} break;
			case 'F': mainTurnMenu(player, location, cards, playerArray); break;
			}
			switch (prevLetterChoice) { // ADD RESOURCE BEING TRADED FOR
			case 'A': if (validTrade) player.setWheatAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'B': if (validTrade) player.setSheepAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'C': if (validTrade) player.setStoneAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'D': if (validTrade) player.setBrickAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'E': if (validTrade) player.setLumberAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void withMerchantOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		char letterChoice = '_';
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	MERCHANT MENU\n");
		System.out.printf("	OPTIONS: 				   \n");
		System.out.printf("	a) Buy Wheat With Merchant \n");
		System.out.printf("	b) Buy Sheep With Merchant \n");
		System.out.printf("	c) Buy Stone With Merchant \n");
		System.out.printf("	d) Buy Brick With Merchant \n");
		System.out.printf("	e) Buy Lumber With Merchant\n");
		System.out.printf(" f) Exit to Main Menu \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-g): \n");
			
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E': createOfferWithMerchantMenu(player, location, cards, playerArray, letterChoice); break;
			case 'F': mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void createOfferWithMerchantMenu(players player, locations location[], developmentCards cards[], players playerArray[], char prevLetterChoice) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		String resourceToTrade = "";
		char letterChoice = '_';
		switch (prevLetterChoice) {
		case 'A': resourceToTrade = "Wheat";  break;
		case 'B': resourceToTrade = "Sheep";  break;
		case 'C': resourceToTrade = "Stone";  break;
		case 'D': resourceToTrade = "Brick";  break;
		case 'E': resourceToTrade = "Lumber"; break;
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	TRADE OFFER WITH MERCHANT MENU\n");
		System.out.printf("	OPTIONS: 							\n");
		System.out.printf("	a) Sell 2 Wheat and 1 Merchant for 1 %s\n", resourceToTrade);
		System.out.printf("	b) Sell 2 Sheep and 1 Merchant for 1 %s\n", resourceToTrade);
		System.out.printf("	c) Sell 2 Stone and 1 Merchant for 1 %s\n", resourceToTrade);
		System.out.printf("	d) Sell 2 Brick and 1 Merchant for 1 %s\n", resourceToTrade);
		System.out.printf("	e) Sell 2 Lumber and 1 Merchant for 1 %s\n", resourceToTrade);
		System.out.printf("	f) Exit to Main Menu\n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-g): \n");
		String input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		boolean validTrade = false;
		switch (letterChoice) { // REMOVE RESOURCE BEING TRADED OUT
			case 'A': if (player.getWheatAmount() >= 2 && player.getMerchantAmount() >= 1) {player.setWheatAmount(-2); player.setMerchantAmount(-1); validTrade = true;} break;
			case 'B': if (player.getSheepAmount() >= 2 && player.getMerchantAmount() >= 1) {player.setSheepAmount(-2); player.setMerchantAmount(-1);validTrade = true; }break;
			case 'C': if (player.getStoneAmount() >= 2 && player.getMerchantAmount() >= 1) {player.setStoneAmount(-2); player.setMerchantAmount(-1);validTrade = true; }break;
			case 'D': if (player.getBrickAmount() >= 2 && player.getMerchantAmount() >= 1) {player.setBrickAmount(-2); player.setMerchantAmount(-1);validTrade = true; }break;
			case 'E': if (player.getLumberAmount() >= 2){ player.setLumberAmount(-2); validTrade = true;} break;
			case 'F': mainTurnMenu(player, location, cards, playerArray);
			}
			switch (prevLetterChoice) { // ADD RESOURCE BEING TRADED FOR
			case 'A': if (validTrade) player.setWheatAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'B': if (validTrade) player.setSheepAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'C': if (validTrade) player.setStoneAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'D': if (validTrade) player.setBrickAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
			case 'E': if (validTrade) player.setLumberAmount(1); mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void playerOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		String input = "";
		char letterChoice = '_';
		int numOfSettlements = 0, numOfCities = 0;
		for (int l = 1; l <= location.length - 1; l++) {
			if (location[l].getPlayerOwner() == player.getPlayerNumber() && location[l].getLocationSettlement() == true) {
				numOfSettlements++;
			}
			if (location[l].getPlayerOwner() == player.getPlayerNumber() && location[l].getLocationCity() == true) {
				numOfCities++;
			}
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("-------------------------------------------");
		System.out.printf("	PLAYER OVERVIEW:						\n");
		System.out.printf("	Victory Points: %d					\n", player.getVPAmount());
		System.out.printf("	Number of Roads: %d					\n", player.getNumOfRoads());
		System.out.printf("	Number of Settlements: %d					\n", numOfSettlements);
		System.out.printf("	Number of Cities: %d						\n", numOfCities);
		System.out.printf("	Army Size: %d						\n", player.getArmySize());
		System.out.println();
		System.out.println(" a) View List of Owned Locations");
		System.out.println(" b) View Info on All Players ");
		System.out.println(" c) Exit to Main Menu");
		System.out.println("-------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-c): \n");
		input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
		case 'A': playerOwnedLocationOverviewMenu(player, location, cards, playerArray); break;
		case 'B': allPlayerOverviewMenu(player, location, cards, playerArray); break;
		case 'C': mainTurnMenu(player, location, cards, playerArray); break;
		}	
	}
	
	public void playerOwnedLocationOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		int numberChoice = 0;
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	SETTLEMENT UPGRADE MENU\n");
		System.out.printf("	SETTLEMENTS: 							\n");

		for (int i = 1; i <= location.length - 1; i++) {
			if (location[i].getPlayerOwner() == player.getPlayerNumber() && location[i].getLocationSettlement() == true) {
				System.out.printf(" %d) Settlement (%s, %s, %s)\n", location[i].getLocationNumber(), location[i].getLocationResource(1), location[i].getLocationResource(2), location[i].getLocationResource(3));
			} else if (location[i].getPlayerOwner() == player.getPlayerNumber() && location[i].getLocationCity() == true) {
				System.out.printf(" %d) City (%s, %s, %s)\n", location[i].getLocationNumber(), location[i].getLocationResource(1), location[i].getLocationResource(2), location[i].getLocationResource(3));
			}
		}
		System.out.printf(" 0) Exit to Main Menu \n");
		System.out.println("");
		System.out.printf("Enter a choice from the options menu (1-0): \n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("|RESOURCES:	\n");
		System.out.printf("|WHEAT: %d	\n", player.getWheatAmount()); 
		System.out.printf("|SHEEP: %d	\n", player.getSheepAmount()); 
		System.out.printf("|STONE: %d	\n", player.getStoneAmount()); 
		System.out.printf("|BRICK: %d	\n", player.getBrickAmount());
		System.out.printf("|LUMBER: %d	\n", player.getLumberAmount());
		System.out.printf("|MERCHANT: %d	\n", player.getMerchantAmount());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		numberChoice = keyboard.nextInt();
		mainTurnMenu(player, location, cards, playerArray);
	}
	
	public void allPlayerOverviewMenu(players player, locations location[], developmentCards cards[], players playerArray[]) {
		for (int i = 1; i <= 30; i++) {
			System.out.println();
		}
		String input = "";
		char letterChoice = '_';
		int numOfSettlements[] = new int[6], numOfCities[] = new int[6];
		for (int p = 1; p <= numOfSettlements.length - 1; p++) {
			for (int l = 1; l <= location.length - 1; l++) {
				if (location[l].getPlayerOwner() == playerArray[p].getPlayerNumber() && location[l].getLocationSettlement() == true) {
					numOfSettlements[p]++;
				}
				if (location[l].getPlayerOwner() == playerArray[p].getPlayerNumber() && location[l].getLocationCity() == true) {
					numOfCities[p]++;
				}
			}
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("	PLAYER %d'S TURN (%s)\n", player.getPlayerNumber(), player.getPlayerName());
		System.out.println("-------------------------------------------");
		System.out.printf("	PLAYER 1 OVERVIEW:						\n");
		System.out.printf("	Number of Roads: %d					\n", playerArray[1].getNumOfRoads());
		System.out.printf("	Number of Settlements: %d					\n", numOfSettlements[1]);
		System.out.printf("	Number of Cities: %d						\n", numOfCities[1]);
		System.out.printf("	Your Army Size: %d					\n", playerArray[1].getArmySize());
		System.out.println("-------------------------------------------");
		System.out.printf("	PLAYER 2 OVERVIEW:						\n");
		System.out.printf("	Number of Roads: %d					\n", playerArray[2].getNumOfRoads());
		System.out.printf("	Number of Settlements: %d					\n", numOfSettlements[2]);
		System.out.printf("	Number of Cities: %d						\n", numOfCities[2]);
		System.out.printf("	Your Army Size: %d					\n", playerArray[2].getArmySize());
		if (numOfSettlements[3] != 0) {
			System.out.println("-------------------------------------------");
			System.out.printf("	PLAYER 3 OVERVIEW:						\n");
			System.out.printf("	Number of Roads: %d					\n", playerArray[3].getNumOfRoads());
			System.out.printf("	Number of Settlements: %d					\n", numOfSettlements[3]);
			System.out.printf("	Number of Cities: %d						\n", numOfCities[3]);
			System.out.printf("	Your Army Size: %d					\n", playerArray[3].getArmySize());
		}
		if (numOfSettlements[4] != 0) {
			System.out.println("-------------------------------------------");
			System.out.printf("	PLAYER 4 OVERVIEW:						\n");
			System.out.printf("	Number of Roads: %d					\n", playerArray[4].getNumOfRoads());
			System.out.printf("	Number of Settlements: %d					\n", numOfSettlements[4]);
			System.out.printf("	Number of Cities: %d						\n", numOfCities[4]);
			System.out.printf("	Your Army Size: %d					\n", playerArray[4].getArmySize());
		}
		if (numOfSettlements[5] != 0) {
			System.out.println("-------------------------------------------");
			System.out.printf("	PLAYER 5 OVERVIEW:						\n");
			System.out.printf("	Number of Roads: %d					\n", playerArray[5].getNumOfRoads());
			System.out.printf("	Number of Settlements: %d					\n", numOfSettlements[5]);
			System.out.printf("	Number of Cities: %d						\n", numOfCities[5]);
			System.out.printf("	Your Army Size: %d					\n", playerArray[5].getArmySize());
		}
		System.out.println();
		System.out.println(" a) View Info on Self");
		System.out.println(" b) Exit to Main Menu");
		System.out.println("-------------------------------------------");
		System.out.println("RECIPES: ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "ROADS", "SETTLEMENTS", "CITIES", "DEVELOPMENT CARDS");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Brick", "Brick", "Stone", "Stone");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", "Lumber", "Lumber", "Stone", "Sheep");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Sheep", "Wheat", "Wheat");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", "Wheat", "Wheat", " ");
		System.out.printf("%-20.30s %-20.30s %-20.30s %-20.30s \n", " ", " ", "Wheat", " ");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Enter a choice from the options menu (a-b): \n");
		input = keyboard.next().toUpperCase();
		letterChoice = input.charAt(0);
		switch (letterChoice) {
		case 'A': playerOverviewMenu(player, location, cards, playerArray); break;
		case 'B': mainTurnMenu(player, location, cards, playerArray); break;
		}
	}
	
	public void gameEndScreen(players playerArray[], int totalVictoryPoints) {
		System.out.printf("                                 ____                                         \r\n" + 
				"                              .-\"    `-.      ,                               \r\n" + 
				"                            .'          '.   /j\\                              \r\n" + 
				"                           /              \\,/:/#\\                /\\           \r\n" + 
				"                          ;              ,//' '/#\\              //#\\          \r\n" + 
				"                          |             /' :   '/#\\            /  /#\\         \r\n" + 
				"                          :         ,  /' /'    '/#\\__..--\"\"\"\"/    /#\\__      \r\n" + 
				"                           \\       /'\\'-._:__    '/#\\        ;      /#, \"\"\"---\r\n" + 
				"                            `-.   / ;#\\']\" ; \"\"\"--./#J       ':____...!       \r\n" + 
				"                               `-/   /#\\  J  [;[;[;Y]         |      ;        \r\n" + 
				"\"\"\"\"\"\"---....             __.--\"/    '/#\\ ;   \" \"  |     !    |   #! |        \r\n" + 
				"             \"\"--.. _.--\"\"     /      ,/#\\'-..____.;_,   |    |   '  |        \r\n" + 
				"                   \"-.        :_....___,/#} \"####\" | '_.-\",   | #['  |        \r\n" + 
				"                      '-._      |[;[;[;[;|         |.;'  /;\\  |      |        \r\n" + 
				"                      ,   `-.   |        :     _   .;'    /;\\ |   #\" |        \r\n" + 
				"                      !      `._:      _  ;   ##' .;'      /;\\|  _,  |        \r\n" + 
				"                     .#\\\"\"\"---..._    ';, |      .;{___     /;\\  ]#' |__....--\r\n" + 
				"          .--.      ;'/#\\         \\    ]! |       \"| , \"\"\"--./_J    /         \r\n" + 
				"         /  '%;    /  '/#\\         \\   !' :        |!# #! #! #|    :`.__      \r\n" + 
				"        i__..'%] _:_   ;##J         \\      :\"#...._!   '  \"  \"|__  |    `--.._\r\n" + 
				"         | .--\"\"\" !|\"\"\"\"  |\"\"\"----...J     | '##\"\" `-._       |  \"\"\"---.._    \r\n" + 
				"     ____: |      #|      |         #|     |          \"]      ;   ___...-\"T,  \r\n" + 
				"    /   :  :      !|      |   _______!_    |           |__..--;\"\"\"     ,;MM;  \r\n" + 
				"   :____| :    .-.#|      |  /\\      /#\\   |          /'               ''MM;  \r\n" + 
				"    |\"\"\": |   /   \\|   .----+  ;      /#\\  :___..--\"\";                  ,'MM; \r\n" + 
				"   _Y--:  |  ;     ;.-'      ;  \\______/#: /         ;                  ''MM; \r\n" + 
				"  /    |  | ;_______;     ____!  |\"##\"\"\"MM!         ;                    ,'MM;\r\n" + 
				" !_____|  |  |\"#\"#\"|____.'\"\"##\"  |       :         ;                     ''MM  \r\n" + 
				"  | \"\"\"\"--!._|     |##\"\"         !       !         :____.....-------\"\"\"\"\"\" |'\r\n" + 
				"  |          :     |______                        ___!_ \"#\"\"#\"\"#\"\"\"#\"\"\"#\"\"\"|  \r\n" + 
				"__|          ;     |MM\"MM\"\"\"\"\"---..._______...--\"\"MM\"MM]                   |   \r\n" + 
				"  \"\\-.      :      |#                                  :                   |  \r\n" + 
				"    /#'.    |      /##,                                !                   |  \r\n" + 
				"   .',/'\\   |       #:#,                                ;       .==.       |  \r\n" + 
				"  /\"\\'#\"\\',.|       ##;#,                               !     ,'||||',     |  \r\n" + 
				"        /;/`:       ######,          ____             _ :     M||||||M     |  \r\n" + 
				"       ###          /;\"\\.__\"-._   \"\"\"                   |===..M!!!!!!M_____|  \r\n" + 
				"                           `--..`--.._____             _!_                    \r\n" + 
				"                                          `--...____,=\"_.'`-.____        fsc");
		System.out.println("GAME ENDED!");
		System.out.printf("CONGRATULATIONS TO PLAYER %d (%s)");
		System.out.printf("You Were the First to Make it to %d Victory Points!", totalVictoryPoints);
	}
	
}
