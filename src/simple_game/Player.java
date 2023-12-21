package simple_game;

import java.util.Scanner;

public class Player {

	private String name;
	private String gender;
	private int age;
	
	
	public Player(String name, String gender, int age) {
		super();
		name   = this.getName();
		gender = this.getGender();
		age    = this.getAge();
	}
	
	
	// Open the game -start-
	public Player playerDetails() {
		System.out.println("Please, we would like to know your name before the game start...");
		boolean hasName = false;
		String playerName = "";
		String playerGender = "";
		int playerAge = 0;
		
		while(hasName == false) {
			Scanner name = new Scanner(System.in);
			playerName = name.nextLine();
			
			if(!playerName.equals("")) {
				System.out.println("Please type in your gender...");
				Scanner gender = new Scanner(System.in);
				playerGender = gender.nextLine();
				
				if(!playerGender.equals("")) {
					System.out.println("Please give us your age as well...");
					Scanner age = new Scanner(System.in);
					playerAge = age.nextInt();
					
					if((playerAge != 0) && !(playerAge < 10)) {
						System.out.println("Your data is being proccesed please wait... (Your data is safe with us)...");
						hasName = true;
					}else {
						System.out.println("Please you have to provide your age and you have to be atleast (18) or above...");
						hasName = true;
					}
				}else {
					System.out.println("Your gender please...");
					hasName = true;
				}
			}else {
				System.out.println("Your name please...");
				hasName = true;
			}
		}
		hasName = true;
		
//		Player player = new Player(null, null, 0);  // Instantiating a player
		this.setName(playerName);
		this.setGender(playerGender);
		this.setAge(playerAge);
		
		return this;
			   
		
	} // Open the game -end-


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
