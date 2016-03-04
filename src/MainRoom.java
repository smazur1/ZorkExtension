

import java.util.Random;
import java.util.Scanner;

public class MainRoom {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static boolean secretFound = false;
	static boolean[] rooms = new boolean[8];
	static double totalMoney = 0;
	static boolean[] moneyFound = new boolean[8];
	static String itemsSeen = "";



	private static void roomDescribe(String where, String[] stuff, double totalMoney, String directions) {
		System.out.println("You are in " + where);
		for (String thing : stuff) {
			System.out.println("You see " + thing);
		}
		System.out.printf("You have $%.2f.%n" , totalMoney );


		System.out.println("You can go " + directions);
	}

	public static void exitTheHouse() {
		String place = "You have left the house";
		String[] things = new String[1];
		int counter = 0;

		for (boolean count : rooms) {
			if (count == true)
				counter++;	
		}

		int chance;
		chance = rnd.nextInt(4);
		if (chance == 3) {
			things[0] = "You are being followed.  Good Luck";
		} else {
			things[0] = "You are safe now.";
		}

		String direct = "Goodbye";

		System.out.println(place);
		for (String thing : things) {
			System.out.println(thing);
		}
		System.out.println("You visited " + counter + " rooms.");
		System.out.printf("You have $%.2f.%n" , totalMoney );
		System.out.println("You have seen: \n" + itemsSeen);
		System.out.println(direct);


		//	roomDescribe(place, things, direct);

		System.exit(0);

	}	

	public static void room1() {
		String place = "the Foyer";
		String[] things = new String[1];
		things[0] = "a dead scorpion";

		if (rooms[0] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}

		String direct = " to the north (n) or the south (s)";
		rooms[0] = true;
		double money = 0;

		if (moneyFound[0] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[0] = true;
		}

		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room2();
			}
			else if (choice.equals("s")) {
				exitTheHouse();
			}
		} while (1 == 1);
	}

	public static void room2() {
		String place = "the Front Room";
		String[] things = new String[1];
		things[0] = "a phone";
		if (rooms[1] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		String direct = " to the east (e), the south (s) or the west (w)";
		rooms[1] = true;
		double money = 0;

		if (moneyFound[1] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[1] = true;
		}


		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room3();
			} else if (choice.equals("s")) {
				room1();
			} else if (choice.equals("e")) {
				room4();
			}
		} while (1 == 1);
	}

	public static void room3() {
		String place = "the Library";
		String[] things = new String[1];
		things[0] = "Spiders";
		if (rooms[2] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		String direct = " to the north (n) or the east (e)";
		rooms[2] = true;
		double money = 0;

		if (moneyFound[2] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[2] = true;
		}


		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room5();
			} else if (choice.equals("e")) {
				room2();
			}
		} while (1 == 1);
	}

	public static void room4() {
		String place = "the Kitchen";
		String[] things = new String[1];
		things[0] = "Bats";
		if (rooms[3] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		String direct = " to the north (n) or the west (w)";
		rooms[3] = true;
		double money = 0;

		if (moneyFound[3] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[3] = true;
		}


		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room7();
			} else if (choice.equals("w")) {
				room2();
			}
		} while (1 == 1);
	}

	public static void room5() {
		String place = "the Dining Room";
		String[] things = new String[2];
		things[0] = "Dust";
		things[1] = "Empty Box";
		if (rooms[4] == false){
			itemsSeen = itemsSeen + things[0] + "\n" + things[1] + "\n";
		}
		String direct = " to the south (s)";
		rooms[4] = true;
		double money = 0;

		if (moneyFound[4] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[4] = true;
		}


		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("s")) {
				room3();
			}
		} while (1 == 1);
	}

	public static void room6() {

		int chance;
		double money = 0;

		if (moneyFound[5] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[5] = true;
		}

		if (secretFound == false) {

			chance = rnd.nextInt(4);
			if (chance == 2) {
				secretFound = true;
			}
		}

		String place = "the Vault";
		String[] things = new String[1];
		things[0] = "3 Walking Skeletons";
		if (rooms[5] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		rooms[5] = true;

		String direct;
		if (secretFound == true) {
			direct = " to the east (e) or the secret room (s)";
		}
		else {
			direct = " to the east (e)";
		}

		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("e")) {
				room7();
			}
			else if ((choice.equals("s")) && (secretFound))
			{
				room8();
			}
		} while (1 == 1);
	}

	public static void room7() {
		String place = "the Parlor";
		String[] things = new String[1];
		things[0] = "Treasure Chest";
		if (rooms[6] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		String direct = " to the west (w) or the south (s)";
		rooms[6] = true;
		double money = 0;

		if (moneyFound[6] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[6] = true;
		}

		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room6();
			} else if (choice.equals("s")) {
				room4();
			}
		} while (1 == 1);
	}

	public static void room8() {
		String place = "the Secret Room";
		String[] things = new String[1];
		things[0] = "Piles of Gold";
		if (rooms[7] == false){
			itemsSeen = itemsSeen + things[0] + "\n";
		}
		String direct = " to the west (w)";
		rooms[7] = true;
		double money = 0;

		if (moneyFound[7] == false) {
			money = (rnd.nextDouble() * 1000.0 );
			totalMoney = totalMoney + money;
			moneyFound[7] = true;
		}

		do {
			roomDescribe(place, things, totalMoney, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room6();
			} 
		} while (1 == 1);
	}	

	public static void main(String[] args) {
		room1();
	}

}

