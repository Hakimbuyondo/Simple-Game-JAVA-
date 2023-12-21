package simple_game;

import java.util.Scanner;

public class Game {

	private static String[] gameNames;

	// Constructor
	public Game(String[] gameNames) {
		super();
		gameNames = this.getGameNames();
	}
	
	public boolean checkPlayerQualification(Player player) {
		if(player.getAge() < 18) {
			gamesForYoungers();
			return true;
		}else if(player.getAge() >= 18){
			gamesForOlders();
			return true;
		}else {
			return false;
		}
	}
	
	
	private void gamesForOlders() {
		String mindGameQuestion1 = "What is so fragile that even saying it\'s name brakes it ?"; // Silence
		String mindGameQuestion2 = "I\'m tall when am yourng, and I\'m short when am old, what am i ?"; // A Candle
		String mindGameQuestion3 = "What is as big as you are and yet does not weigh anything ?"; // Your Shadow
		String mindGameQuestion4 = "What can travel around the world while staying in a corner ?"; // A Postage stamp
		String mindGameQuestion5 = "Do you know what you can hold without ever touching it ?"; // Your breath
		
		PlayGame [] myGame = {
				new PlayGame(mindGameQuestion1, "Silence"),
				new PlayGame(mindGameQuestion2, "A Candle"),
				new PlayGame(mindGameQuestion3, "Your Shadow"),
				new PlayGame(mindGameQuestion4, "A Postage stamp"),
				new PlayGame(mindGameQuestion5, "Your breath"),
		};
		runGame(myGame);
	}

	private static void gamesForYoungers() {
		
	}
	
	public static void runGame(PlayGame [] myGame) {
		int score = 0;
		Scanner getAnswerFromUser = new Scanner(System.in);
		
		for(int i = 0; i < myGame.length; i++) {
			System.out.println(myGame[i].question);
			String answer = getAnswerFromUser.nextLine();
			if(answer.equalsIgnoreCase(myGame[i].answer)) {
				score++;
			}
		}
		System.out.println("You have scored "+score+"/"+myGame.length);
	}

	//
	public String[] getGameNames() {
		return gameNames;
	}

	public void setGameNames(String[] gameNames) {
		this.gameNames = gameNames;
	}
	
	
}
