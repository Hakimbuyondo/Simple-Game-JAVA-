package simple_game;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game(null); // Instantiating the game
		String anotation = ("Game");
		
		 	 String [] games = new String[10];
		 	 games[0] = ("Mind"+" "+anotation);
		 	 games[2] = ("Word Guessing"+" "+anotation);
		 	 
		 	 game.setGameNames(games);
		 	 
		 	 Player player = new Player(null, null, 0); // Instantiating a player
		
		System.out.println("You are about to enter the Game, please press (Y) to continue or (N) to abort...\n");
		
		String startGame = "";
		boolean setGame = false;
		
		while(setGame == false) {
			Scanner scanner = new Scanner(System.in);
			String start = scanner.nextLine();
			if(start.equalsIgnoreCase("Y") || start.equalsIgnoreCase("N")) {
				setGame = true;
				startGame = start;
			}
		}
		
		if(startGame.equalsIgnoreCase("Y")) {
			System.out.println("Yes you are about to enter the game: bellow is the list of Games. Wish you success...");
			for(String data : games) {
				if(data != null) {
					System.out.println(data);
				}
			}
			System.out.println("--------------------------");
			
			Player details = player.playerDetails(); // Invoking the openTheGame
			boolean playerQualification = game.checkPlayerQualification(player);
			
		}else if(startGame.equalsIgnoreCase("N")) {
			System.out.println("You have aborted the game loading proccess: stay safe...");
			setGame = false;
		}	 
		
		
	}


}
