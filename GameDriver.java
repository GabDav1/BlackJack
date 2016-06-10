package blackjack;

import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insert player name: ");
		String human = sc.nextLine();
		System.out.println("Welcome, "+human+". Have a seat at the table");
		
		new BlackJack(new Player(human), new Player("AI"));
		System.out.println("\nPlay again, "+human+"? Y/N");

		String answer = sc.next();
		while(answer.equalsIgnoreCase("y")){
			new BlackJack(new Player(human), new Player("AI"));
			System.out.println("\nPlay again, "+human+"? Y/N");
			answer=sc.next();
		}
		sc.close();
	}

}
