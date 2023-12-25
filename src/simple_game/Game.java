package simple_game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	private static String[] gameNames;
	static Player player;

	// Constructor
	public Game(String[] gameNames) {
		super();
		gameNames = this.getGameNames();
	}
	
	public boolean checkPlayerQualification(Player player) {
		String[] gameCategories = {"Science", "Math", "Social Studies", "History", "Biology", "Word Puzzle"};
		System.out.println(player.getName()+": Nice to meet you, bellow is the list of available categories (Please choose a category by typing its name from the list)...");
		for(String data : gameCategories) {
			System.out.println(" ___________________\n "+data);
		}
		
		Scanner chooseCategory = new Scanner(System.in);
		String category = chooseCategory.nextLine();
		
		if(player.getAge() < 10) {
			if(category.equalsIgnoreCase(gameCategories[0])) {
				youngersScience();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[1])) {
				youngersMath();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[2])) {
				youngersSST();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[3])) {
				youngersHistory();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[4])) {
				youngersBiology();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[5])) {
				wordPuzzleYoung();
				return true;
			}else {
				System.out.println("Note: the loaded game is default because the we did not recognise what you typed in...\n");
				gamesForYoungers();
				return true;
			}
		}else if(player.getAge() >= 18){
			if(category.equalsIgnoreCase(gameCategories[0])) {
				adultScience();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[1])) {
				adultMath();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[2])) {
				adultSST();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[3])) {
				adultHistory();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[4])) {
				adultBiology();
				return true;
			}else if(category.equalsIgnoreCase(gameCategories[5])) {
				wordPuzzleAdult();
				return true;
			}else {
				System.out.println("Note: the loaded game is default because the we did not recognise what you typed in...\n");
				gamesForOlders();
				return true;
			}

		}else {
			return false;
		}
	}
	
	
	private void gamesForOlders() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome \n".toUpperCase());
		String mindGameQuestion1 = "What is so fragile that even saying it\'s name brakes it ?"; // Silence
		String mindGameQuestion2 = "I\'m tall when am young, and I\'m short when am old, what am i ?"; // A Candle
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
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome \n".toUpperCase());
		String mindGameQuestion1 = "Which number comes after 17 ?"; // 18
		String mindGameQuestion2 = "What is the answer of adding for ( 10 + 15 ) ?"; // 25
		String mindGameQuestion3 = "If human has 2 legs and 2 hands, how many legs does a dog have ?"; // 4
		String mindGameQuestion4 = "How many days do we have in a week ?"; // 7
		String mindGameQuestion5 = "How many months do we have in a year ?"; // 12
		String mindGameQuestion6 = "How many days are there in a year ?"; // 365
		String mindGameQuestion7 = "What are your ears for ?"; // Listening / Hearing
		String mindGameQuestion8 = "We use our eyes to ?"; // See
		String mindGameQuestion9 = "How many letters are there in English alphabet ?"; // 26
		String mindGameQuestion10 = "We use our ______ to smell."; // Nose
		String mindGameQuestion11 = "The baby of a dog is called ?"; // Puppy
		String mindGameQuestion12 = "What is the next number in the following sequence- ( 7, 14, 21, 28 ) ?"; // 35
		
		
		PlayGame [] myGame = {
				new PlayGame(mindGameQuestion1, "18"),
				new PlayGame(mindGameQuestion2, "25"),
				new PlayGame(mindGameQuestion3, "4"),
				new PlayGame(mindGameQuestion4, "7"),
				new PlayGame(mindGameQuestion5, "12"),
				new PlayGame(mindGameQuestion6, "365"),
				new PlayGame(mindGameQuestion7, "Hearing"),
				new PlayGame(mindGameQuestion8, "See"),
				new PlayGame(mindGameQuestion9, "26"),
				new PlayGame(mindGameQuestion10, "Nose"),
				new PlayGame(mindGameQuestion11, "Puppy"),
				new PlayGame(mindGameQuestion12, "35"),
		};
		runGame(myGame);
	}
	
	//Science for kids
	public static void youngersScience() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Science Questions \n".toUpperCase());
		String science1 = "Which anilmal lays ages (Dog, Cat, Duck, Sheep) ?"; // Duck
		String science2 = "A male cow is called ( Goat, Sheep, Ok, Monkey ) ?"; // Ox
		String science3 = "All animals neens food, air and ______ to survive ( House, Water, Choclate, Fruits )."; // Water
		String science4 = "Which one is a fur-bearing animal ( Hen, Crocodile, Tortoise, Cat ) ?"; // Cat
		String science5 = "The tree has a branch filled with green ________ ( Hair, Root, Leaves, Trunk ) ?"; // Leaves
		String science6 = "Legs have feet and arms have ( Ankles, Pelvis, Hands, Skull ) ?"; // Hands
		String science7 = "Which organ covers the entire body and protects it ( Liver, Skin, Heart, Brain ) ?"; // Skin
		String science8 = "Which shape is a round ( Rectangle, Circle, Square, Triangle ) ?"; // Circle
		
		PlayGame [] science = {
				new PlayGame(science1, "Duck"),
				new PlayGame(science2, "Ox"),
				new PlayGame(science3, "Water"),
				new PlayGame(science4, "Cat"),
				new PlayGame(science5, "Leaves"),
				new PlayGame(science6, "Hands"),
				new PlayGame(science7, "Skin"),
				new PlayGame(science8, "Circle"),
		};
		runGame(science);
	}
	// Math for kids
	public static void youngersMath() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Math Questions \n".toUpperCase());
		String math1 = "What is the answer of (7 + 9) ?"; // 16
		String math2 = "What is the next number in the following sequence- ( 10, 30, 50, 70 ) ?"; // 90
		String math3 = "What is the answer of ( 15 - 7 ) ?"; // 8
		String math4 = "What is the answer of adding ( 15 + 7 - 10) ?"; // 12
		String math5 = "What is the answer comes out of ( 8 - 4 * 5 ) ?"; // 20
		String math6 = "Which number comes after 13 ?"; // 14
		String math7 = "Add a number to 17 and make 25 ?"; // 8
		String math8 = "If a dog has 4 legs, how many legs does 3 dogs have ?"; // 12
		
		PlayGame [] math = {
				new PlayGame(math1, "16"),
				new PlayGame(math2, "90"),
				new PlayGame(math3, "8"),
				new PlayGame(math4, "12"),
				new PlayGame(math5, "20"),
				new PlayGame(math6, "14"),
				new PlayGame(math7, "8"),
				new PlayGame(math8, "12"),
		};
		runGame(math);
	}
	// SST for kids
	public static void youngersSST() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to S.S.T Questions \n".toUpperCase());
		String sst1 = "Which is the largest country in the word ( Colombia, Canada, Russia, America ) ?"; // Russia
		String sst2 = "Which country has the largest population in the world ( Ghana, Canada, China, Russia ) ?"; // China
		String sst3 = "Which is the largest waterfall in the world ( Victoria falls, Nile River, Atlantic )."; // Victoria falls
		String sst4 = "Which is the biggest desert in the world ?"; // Sahara Desert
		String sst5 = "What is the capital city of China ( Tianjin, Beijing, Hon Kong ) ?"; // Beijing
		
		PlayGame [] sst = {
				new PlayGame(sst1, "Russia"),
				new PlayGame(sst2, "China"),
				new PlayGame(sst3, "Victoria falls"),
				new PlayGame(sst4, "Sahara Desert"),
				new PlayGame(sst5, "Beijing"),
		};
		runGame(sst);
	}
	// History for kids
	public static void youngersHistory() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to History Questions \n".toUpperCase());
		String history1 = "Who was the prime minister of the UK for most of the Second World War ?"; // Winston Churchill
		String history2 = "Which people travelled in longships and raided Britain from Scandinavia in early medieval times ?"; // Vikings
		String history3 = "What is the London home of the prime minister ?"; // 10 Downing Street
		String history4 = "What title was given to the rulers of Ancient Egypt ?"; // Pharaoh
		String history5 = "What overall term is given to the people who fought each other and animals as entertainment in Ancient Rome ?"; // Gladiators
		String history6 = "What notable event affected London in September 1666 ?"; // The Great Fire
		
		PlayGame [] history = {
				new PlayGame(history1, "Winston Churchill"),
				new PlayGame(history2, "Vikings"),
				new PlayGame(history3, "10 Downing Street"),
				new PlayGame(history4, "Pharaoh"),
				new PlayGame(history5, "Gladiators"),
				new PlayGame(history6, "The Great Fire"),
		};
		runGame(history);
	}
	//Biology for kids
	public static void youngersBiology() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Biology Questions \n".toUpperCase());
		String biology1 = "Can frogs live in salt water ( Yes, No) ?"; // No
		String biology2 = "A group of dog offspring is known as a ?"; // Litter
		String biology3 = "( True or False )? A salamander is a warm blooded animal ?"; // False
		String biology4 = "Botany is the study of ?"; // Plants
		String biology5 = "Bacterial infections in humans can be treated with what ?"; // Antibiotics
		
		PlayGame [] biology = {
				new PlayGame(biology1, "No"),
				new PlayGame(biology2, "Litter"),
				new PlayGame(biology3, "False"),
				new PlayGame(biology4, "Plants"),
				new PlayGame(biology5, "Antibiotics"),
		};
		runGame(biology);
	}
	// Chemistry for kids
	public static void wordPuzzleYoung() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Word Puzzle \n".toUpperCase());
		String chemistry1 = "Please arrange following word ( S,G,D,O ) ?"; // Dogs
		String chemistry2 = "Please arrange following word ( F,L,A,M,I,Y ) ?"; // Family
		String chemistry3 = "Please arrange following word ( P,E,L,E,S ) ?"; // Sleep
		String chemistry4 = "Please arrange following word ( S,S,A,R,G ) ?"; // Grass
		String chemistry5 = "Please arrange following word ( M,I,S,E,L ) ?"; // Smile
		String chemistry6 = "Please arrange following word ( T,R,K,U,C ) ?"; // Truck 
		String chemistry7 = "Please arrange following word ( O,P,N,S,O ) ?"; // Spoon 
		String chemistry8 = "Please arrange following word ( E,H,T,R,A ) ?"; // Earth 
		String chemistry9 = "Please arrange following word ( A,P,E,L,N ) ?"; // Plane 
		String chemistry10 = "Please arrange following word ( R,V,Y,E,E ) ?"; // Every 
		
		PlayGame [] chemistry = {
				new PlayGame(chemistry1, "Dogs"),
				new PlayGame(chemistry2, "Family"),
				new PlayGame(chemistry3, "Sleep"),
				new PlayGame(chemistry4, "Grass"),
				new PlayGame(chemistry5, "Smile"),
				new PlayGame(chemistry6, "Truck"),
				new PlayGame(chemistry7, "Spoon"),
				new PlayGame(chemistry8, "Earth"),
				new PlayGame(chemistry9, "Plane"),
				new PlayGame(chemistry10, "Every"),
		};
		runGame(chemistry);
	}
	
	// -----------ADULTS
	//Science for adults
	public static void adultScience() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome Science Questions \n".toUpperCase());
		String science1 = "Optics is the study of what ?"; // Light
		String science2 = "What does DNA stand for ?"; // Deoxyribonucleic Acid
		String science3 = "Which Apollo moon mission was the first to carry a lunar rover ?"; // Apollo 15 mission
		String science4 = "What was the name of the first man-made satellite launched by the Soviet Union in 1957 ?"; // Sputnik 1
		String science5 = "What is the rarest blood type ?"; // AB Negative
		String science6 = "The earth has three layers that are different due to varying temperatures. What are its three layers (seperate with ,) ?"; // Crust,mantle,core
		String science7 = "Frogs belong to which animal group ?"; // Amphibians
		String science8 = "How many bones do sharks have in their bodies ?"; // Zero
		String science9 = "The smallest bones in the body are located where ?"; // Ear
		String science10 = "How many hearts does an octopus have ?"; // 3
		String science11 = "What colour catches the eye first ?"; // Yellow
		String science12 = "What is the only bone in the human body that isn’t attached to another bone ?"; // Hyoid bone
		String science13 = "Animals that are active during dawn and dusk are called what type of animals ?"; // Crepuscular
		String science14 = "At what temperature are Celsius and Fahrenheit equal ?"; // -40
		String science15 = "What are the four primary precious metals ?"; // Gold,Silver,Platinum,Apalladium
		String science16 = "This part of the brain deals with hearing and language ?"; // Temporal lobe
		String science17 = "This jungle animal, when in groups, is referred to as an ambush. What kind of animal is this ?"; // Tigers
		
		PlayGame [] science = {
				new PlayGame(science1, "Light"),
				new PlayGame(science2, "Deoxyribonucleic Acid"),
				new PlayGame(science3, "Apollo 15 mission"),
				new PlayGame(science4, "Sputnik 1"),
				new PlayGame(science5, "AB Negative"),
				new PlayGame(science6, "Crust,Mantle,Core"),
				new PlayGame(science7, "Amphibians"),
				new PlayGame(science8, "Zero"),
				new PlayGame(science9, "Ear"),
				new PlayGame(science10, "3"),
				new PlayGame(science11, "Yellow"),
				new PlayGame(science12, "Hyoid bone"),
				new PlayGame(science13, "Crepuscular"),
				new PlayGame(science14, "-40"),
				new PlayGame(science15, "Gold,Silver,Platinum,Apalladium"),
				new PlayGame(science16, "Temporal lobe"),
				new PlayGame(science17, "Tigers"),
		};
		runGame(science);
	}
	// Math for adults
	public static void adultMath() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome Math Questions \n".toUpperCase());
		String math1 = "If ( 1=3, 2=3, 3=5, 4=4, 5=4, then 6= ) ?"; // 3 | the answer is three because 6 has 3 letters
		String math2 = "What is the missing number ( 16, 06, 68, 88, __, 98 ) ?"; // 87
		String math3 = "I am an odd number. Take away one letter and I become even. What number am i ?"; // Seven
		String math4 = "Using only an addition, how do you add eight 8’s and get the number 1000 ( please avoid spaces ) ?"; // 888+88+8+8+8=1000
		String math5 = "Sally is 54 years old and her mother is 80, how many years ago was Sally’s mother times her age ?"; // 41 | 41 years ago, when Sally was 13 and her mother was 39.
		String math6 = "There is a three-digit number. The second digit is four times as big as the third digit, while the first digit is three less than the second digit. What is the number ?"; // 141
		String math7 = "Two girls were born to the same mother, at the same time, on the same day, in the same month and the same year and yet somehow they’re not twins. Why not ?"; // Triplets | Because there was a third girl, which makes them triplets!
		String math8 = "The day before yesterday I was 25. The next year I will be 28. This is true only one day in a year. What day is my Birthday (Month and date) ?"; // December 31
		String math9 = "How to get a number 100 by using four sevens (7’s) and a one (1) ( please avoid spaces ) ?"; // 177–77=100
		String math10 = "How many feet are in a mile ?"; // 5280
		String math11 = "Solve  - 15+ (-5x) =0 ?"; // -3
		
		PlayGame [] math = {
				new PlayGame(math1, "3"),
				new PlayGame(math2, "87"),
				new PlayGame(math3, "Seven"),
				new PlayGame(math4, "888+88+8+8+8=1000"),
				new PlayGame(math5, "41"),
				new PlayGame(math6, "141"),
				new PlayGame(math7, "Triplets"),
				new PlayGame(math8, "December 31"),
				new PlayGame(math9, "177–77=100"),
				new PlayGame(math10, "5280"),
				new PlayGame(math11, "-3"),
		};
		runGame(math);
	}
	// SST for adults
	public static void adultSST() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome Social Studies Questions \n".toUpperCase());
		String sst1 = "A person who studies biology is known as a ?"; // Biologist
		String sst2 = "Botany is the study of ?"; // Plants
		String sst3 = "True or false? The common cold is caused by a virus ?"; // True
		String sst4 = "Animals which eat both plants and other animals are known as what ?"; // Omnivores
		String sst5 = "Bacterial infections in humans can be treated with what ?"; // Antibiotics
		String sst6 = "A single piece of coiled DNA is known as a ?"; // Chromosome
		String sst7 = "The area of biology devoted to the study of fungi is known as ?"; // Mycology
		String sst8 = "What is the name of the process used by plants to convert sunlight into food ?"; // Photosynthesis
		String sst9 = "The death of every member of a particular species is known as what ?"; // Extinction
		String sst10 = "True or false? A salamander is a warm blooded animal ?"; // False
		String sst11 = "A change of the DNA in an organism that results in a new trait is known as a ?"; // Mutation
		
		PlayGame [] sst = {
				new PlayGame(sst1, "Biologist"),
				new PlayGame(sst2, "Plants"),
				new PlayGame(sst3, "True"),
				new PlayGame(sst4, "Omnivores"),
				new PlayGame(sst5, "Antibiotics"),
				new PlayGame(sst6, "Chromosome"),
				new PlayGame(sst7, "Mycology"),
				new PlayGame(sst8, "Photosynthesis"),
				new PlayGame(sst9, "Extinction"),
				new PlayGame(sst10, "False"),
				new PlayGame(sst11, "Mutation"),
		};
		runGame(sst);
	}
	// History for adults
	public static void adultHistory() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome History Questions \n".toUpperCase());
		String history1 = "How many wives did Henry VIII have ?"; // 6
		String history2 = "Francisco Franco ruled which European country from 1939 to 1975 ?"; // Spain
		String history3 = "What type of boats did the Vikings use when exploring and raiding ?"; // Longships
		String history4 = "In what year was the Concorde’s first flight ?"; // 1969
		String history5 = "Which country did Germany invade to kickstart World War II ?"; // Poland
		String history6 = "What language was spoken in Ancient Rome ?"; // Latin
		String history7 = "Who discovered penicillin ?"; // Alexander Fleming
		String history8 = "In what year did Pakistan gain independence from the UK ?"; // 1947
		String history9 = "In Ancient Rome, what was a thermae ?"; // Public baths
		String history10 = "Who is said to be so beautiful that her face launched a thousand ships ?"; // Helen of Troy
		String history11 = "Which US state was an independent country from 1777 to 1791 ?"; // Vermont
		String history12 = "Who is known as the ‘Father of Medicine’ ?"; // Hippocrates
		String history13 = "In what year did the Berlin Wall fall ?"; // 1989
		String history14 = "The First Opium War was fought between Great Britain and which other country ?"; // China
		
		PlayGame [] history = {
				new PlayGame(history1, "6"),
				new PlayGame(history2, "Spain"),
				new PlayGame(history3, "Longships"),
				new PlayGame(history4, "1969"),
				new PlayGame(history5, "Poland"),
				new PlayGame(history6, "Latin"),
				new PlayGame(history7, "Alexander Fleming"),
				new PlayGame(history8, "1947"),
				new PlayGame(history9, "Public baths"),
				new PlayGame(history10, "Helen of Troy"),
				new PlayGame(history11, "Vermont"),
				new PlayGame(history12, "Hippocrates"),
				new PlayGame(history13, "1989"),
				new PlayGame(history14, "China"),
		};
		runGame(history);
	}
	//Biology for adults
	public static void adultBiology() {
		System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Biology Questions \n".toUpperCase());
		String biology1 = "Can frogs live in salt water ( Yes, No) ?"; // No
		String biology2 = "A group of dog offspring is known as a ?"; // Litter
		String biology3 = "( True or False )? A salamander is a warm blooded animal ?"; // False
		String biology4 = "Botany is the study of ?"; // Plants
		String biology5 = "Bacterial infections in humans can be treated with what ?"; // Antibiotics
		
		PlayGame [] biology = {
				new PlayGame(biology1, "No"),
				new PlayGame(biology2, "Litter"),
				new PlayGame(biology3, "False"),
				new PlayGame(biology4, "Plants"),
				new PlayGame(biology5, "Antibiotics"),
		};
		runGame(biology);
	}
	// Chemistry for adults
	public static void wordPuzzleAdult() {				
				System.out.println("HELLO \""+player.getName().toUpperCase()+"\" you are welcome to Word Puzzle \n".toUpperCase());
				String chemistry1 = "Please arrange following word ( S,G,D,O ) ?"; // Dogs
				String chemistry2 = "Please arrange following word ( B,U,T,A,O ) ?"; // About
				String chemistry3 = "Please arrange following word ( E,H,S,O,U ) ?"; // House
				String chemistry4 = "Please arrange following word ( L,W,E,O,B ) ?"; // Below
				String chemistry5 = "Please arrange following word ( P,E,L,E,S ) ?"; // Sleep
				String chemistry6 = "Please arrange following word ( N,G,E,R,E ) ?"; // Green
				String chemistry7 = "Please arrange following word ( E,R,T,O,H ) ?"; // Other
				String chemistry8 = "Please arrange following word ( T,R,K,U,C ) ?"; // Truck 
				String chemistry9 = "Please arrange following word ( E,S,C,I,N ) ?"; // Since 
				String chemistry10 = "Please arrange following word ( E,H,T,R,A ) ?"; // Earth 
				String chemistry11 = "Please arrange following word ( A,P,E,L,N ) ?"; // Plane 
				String chemistry12 = "Please arrange following word ( R,V,Y,E,E ) ?"; // Every
				String chemistry13 = "Please arrange following word ( E,S,T,R,A ) ?"; // Tears
				String chemistry14 = "Please arrange following word ( R,L,Y,O,G ) ?"; // Glory
				String chemistry15 = "Please arrange following word ( K,R,C,E,O ) ?"; // Ocker
				String chemistry16 = "Please arrange following word ( Y,F,R,E,R ) ?"; // Ferry
				String chemistry17 = "Please arrange following word ( S,A,E,T,W ) ?"; // Sweat
				String chemistry18 = "Please arrange following word ( B,G,I,N,O ) ?"; // Bingo
				String chemistry19 = "Please arrange following word ( C,F,T,A,R ) ?"; // Craft
				String chemistry20 = "Please arrange following word ( Y,U,D,S,T ) ?"; // Dusty
				String chemistry21 = "Please arrange following word ( T,W,A,E,H ) ?"; // Wheat
				
				PlayGame [] chemistry = {
						new PlayGame(chemistry1, "Dogs"),
						new PlayGame(chemistry2, "About"),
						new PlayGame(chemistry3, "House"),
						new PlayGame(chemistry4, "Below"),
						new PlayGame(chemistry5, "Sleep"),
						new PlayGame(chemistry6, "Green"),
						new PlayGame(chemistry7, "Other"),
						new PlayGame(chemistry8, "Truck"),
						new PlayGame(chemistry9, "Since"),
						new PlayGame(chemistry10, "Earth"),
						new PlayGame(chemistry11, "Plane"),
						new PlayGame(chemistry12, "Every"),
						new PlayGame(chemistry13, "Tears"),
						new PlayGame(chemistry14, "Glory"),
						new PlayGame(chemistry15, "Ocker"),
						new PlayGame(chemistry16, "Ferry"),
						new PlayGame(chemistry17, "Sweat"),
						new PlayGame(chemistry18, "Bingo"),
						new PlayGame(chemistry19, "Craft"),
						new PlayGame(chemistry20, "Dusty"),
						new PlayGame(chemistry21, "Wheat"),
		};
		runGame(chemistry);
	}
	
	public static void runGame(PlayGame [] myGame) {
		int score = 0;
		int addScore = 3;
		Scanner getAnswerFromUser = new Scanner(System.in);
		
		ArrayList<String> rightQuestions = new ArrayList<String>();
		
		for(int i = 0; i < myGame.length; i++) {
			System.out.println(myGame[i].question);
			String answer = getAnswerFromUser.nextLine();
			if(answer.equalsIgnoreCase(myGame[i].answer)) {
				score = score + addScore;
				rightQuestions.add("\n| Question: "+myGame[i].question
						+".\n| Answer: "+myGame[i].answer);
			}
		}
		System.out.println("You have scored "+score+"/"+myGame.length * addScore);
		System.out.println("\n----------------------------------");
		scoreWritter(player, score, myGame.length, addScore, rightQuestions);
	}
	
	public static void scoreWritter(Player ply, int score, int length, int addScore,  List<String> rightQuestions) {
		// Write content to a file
		String filePath = "gameData.txt";
		
		try {
			
			System.out.println(ply.getName() + ": You have completed the game with ("+score+" / "+length * addScore+") ...");
			
			String playerData = (
				"\n| Player Name: "+ply.getName().toUpperCase()
				+".\n| Player Gender: "+ply.getGender()
				+".\n| Player Age: "+ply.getAge()
				+".\n| Points Scored: "+score
				+".\n| Out Of: "+length * addScore
				+".\n|_____________________\" ANSWERED QUESTIONS \"__________________________________________________________________________________________________________________________________________\n|"
			);
			Files.write(Paths.get(filePath), playerData.getBytes(), StandardOpenOption.APPEND);
			
			for(String data : rightQuestions) {
				Files.write(Paths.get(filePath), data.getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(Paths.get(filePath), "\n|_____________________________________________________________________________________________________________________________________________________________________________________".getBytes(), StandardOpenOption.APPEND);
		
		}catch(IOException e){
			System.out.println("File not found (we did not find where to save your data)...");
		}
	}

	//
	public String[] getGameNames() {
		return gameNames;
	}

	public void setGameNames(String[] gameNames) {
		this.gameNames = gameNames;
	}
	
	
}
