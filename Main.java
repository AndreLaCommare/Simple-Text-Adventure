import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args){

		Scanner kb = new Scanner(System.in);
		Random rand = new Random();

		//Game Variables
		String[] enemies = {"Draugr","Barbarian","Thief"};
		String[] weapons = {"Axe", "Sword", "Flail", "Dagger", "Club"};
		int maxEnemyHealth = 10;
		int enemyMaxAttack = 3;

		//Player Variables
		int playerHealth = 15;
		int playerMaxAttack = 4;
		int estusFlasks = 3;
		int estusHealPoints = 2;
		int estusRefillOnKill = 25; //This is a percentage chance to refill healing item.

		boolean running = true;

		System.out.println("This is a bad place. How long will you last?");

        GAME:
		while (running){
			System.out.println("-----------------------------------------");
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			String weapon = weapons[rand.nextInt(weapons.length)];
			System.out.println("\t# A " + enemy + " has approached you. Brandishing a " + weapon + "! #\n");


			while(enemyHealth > 0){
				System.out.println("\tYour HP: " + playerHealth);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t 1.) Strike");
				System.out.println("\t 2.) Estus Flask");
				System.out.println("\t 3.) Dodge");
				System.out.println("\t 4.) Run");

				String userInput = kb.nextLine();

				if (userInput.equals("1")){
					int playerDamage = rand.nextInt(playerMaxAttack);
					int enemyDamage = rand.nextInt(enemyMaxAttack);
					playerHealth -= enemyDamage;
					enemyHealth -= playerDamage;

					if (playerDamage == 0){
						System.out.println("\t> You missed!");
					}
					else{

					System.out.println("\t> You strike the " + enemy + " for " + playerDamage + " damage.");
					}
					if (enemyDamage == 0){
						System.out.println("\t> The " + enemy + " missed!");
					}
					else {
					System.out.println("\t> The " + enemy + " strikes you with its  " + weapon + " for " + enemyDamage + " damage.");
				    }

					if (playerHealth < 1){
						System.out.println("\t> You have taken too much damage.");
						break;
					}

				}
				else if (userInput.equals("2")){
					if (estusFlasks > 0){
						playerHealth += estusHealPoints;
						estusFlasks --;
						System.out.println("\t> You consume one Estus Flask, to restore " + estusHealPoints + " HP."
						 					+"\n\t> You now have " + playerHealth + " HP."
						 					+"\n\t> You now have " + estusFlasks + " Estus Flasks remaining.");
					}
					else {
						System.out.println("\t> No Estus Flasks Reamining! Defeat enemies for a chance to restore one.");
					}

				}
				else if (userInput.equals("3")){
					System.out.println("\t> The " + enemy + " makes a mighty sweeping blow with its " + weapon + " cleaving nothing but air, as you deftly evade the blow.");



				}
				else if (userInput.equals("4")){
					System.out.println("\t> You flee the " + enemy + "!");
					continue GAME;

				}
				else {
					System.out.println("\t> Invalid input. Please select again.");
				}

			}
			if (playerHealth < 1){
				System.out.println("You were unable to conquer the terrors of the bad place, joining the countless others who fell before thee.");
				break;
			}

				System.out.println("-----------------------------------------");
				System.out.println(" # " + enemy + " was defeated! # ");
				System.out.println(" # You have " + playerHealth + " HP left. # ");
				if (rand.nextInt(100) < estusRefillOnKill){
					estusFlasks++;
					System.out.println(" # One Estus Flask refilled with the " + enemy +"'s death. # ");
					System.out.println(" # You now have " + estusFlasks + " Estus Flasks. # ");
				}

				System.out.println("-----------------------------------------");
				System.out.println("What would you like to do?");
				System.out.println("1.) Venture Further");
				System.out.println("2.) Attempt Escape");

				String userInput2 = kb.nextLine();

				while(!(userInput2.equals("1")) && !(userInput2.equals("2"))){
					System.out.println("Invalid option. Please select again.");
					userInput2 = kb.nextLine();
				}

				if (userInput2.equals("1")){
					System.out.println("Unphased by your battle, you push further into the dark.");
				}
				else if (userInput2.equals("2")){
					System.out.println("Scrambling back, fumbling through the dark, you eventually stumble across a pale stream of light."
					 +"\nFollowing it leads you outside, to a world bathed in blood red luminescence.");
					break;
				}



		}

		System.out.println("#######################");
		System.out.println("# Thanks for Playing! #");
		System.out.println("#######################");



	}

}