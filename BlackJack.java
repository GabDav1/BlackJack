package blackjack;
import java.util.Scanner;

public class BlackJack {
	
	private Player human, computer;
	private Pack cards;
	private Scanner sc = new Scanner(System.in);
	
	public BlackJack(Player one, Player two){
		
		this.human = one;
		this.computer = two;
		
		cards = new Pack();
		
		boolean check = this.dealFirstTwo(human);
		boolean check2 = this.dealFirstTwo(computer);
		System.out.println("\nComputer has "+computer.getHand()[0]);
		int valueHuman = this.dealCards(human);
		int valueAI = this.dealCardsAI(computer);
		
		if(check){
			System.out.println("******* B L A C K J A C K *******\n\tYOU WIN");
		}else if(check2){
			System.out.println("\nComputer wins by blackjack.");
		} else{
			if(valueHuman==21){
				System.out.println("21 !!! You WIN");
			}else if(valueHuman>21){
				System.out.println("BUSTED("+valueHuman+")"+"! YOU LOSE");
			}else if(valueAI>21){
				System.out.println("OPPONENT BUSTED("+valueAI+")"+". YOU WIN!");
			}else if(valueAI>valueHuman){
				System.out.println("You lose, "+valueAI+" to "+valueHuman);
			}else if(valueHuman>valueAI){
				System.out.println("You win, "+valueHuman+" to "+valueAI);
			}else if(valueHuman==valueAI){
				System.out.println("DRAW at "+valueAI);
			}
		}
		
		
	}
	
	
	
	private boolean dealFirstTwo(Player player) {
		boolean check = false;
		Card first = cards.getCardFromPack();
		Card second = cards.getCardFromPack();
		
		check = checkBlackJack(first,second);
		player.receiveCardInHand(first);
		player.receiveCardInHand(second);
		return check;
	}



	private int dealCardsAI(Player AI) {
		int value=0;
		Card curent;
	
			while(true){
				if(AI.cardSum()==21 || AI.cardSum()>21){
					value=AI.cardSum();
					break;
				
				}else{
					if(AI.cardSum()>human.cardSum()){
						value=AI.cardSum();
						break;
					} else{
						curent=cards.getCardFromPack();
						if(curent.getNumar()==14 && AI.cardSum()>10){
							curent.changeAsValue(); //Ii schimba valoarea din 11 in 1.
								
						}
						AI.receiveCardInHand(curent);
					}
				}		
		}
		return value;
	}
	
	//Metoda care verifica primele 2 carti pentru BlackJack. Cartile cu numarul 14 sunt de tip AS, asa ca verificam 
	// daca una din carti are numarul 14 si ceealalta valoarea 10.
	
	private boolean checkBlackJack(Card first, Card second) {
		boolean check = false;
		if((first.getNumar()==14 && second.getValoare()==10) || (second.getNumar()==14 && first.getValoare()==10)){
			check = true;
		}
		return check;
	}

	public int dealCards(Player player){
		int value;
		int alegere=0;
		Card curent;
		
			player.showHand();
			while(true){
				if(player.cardSum()==21 || player.cardSum()>21){
					value=player.cardSum();
					break;
				
				}else{
					System.out.println("\n1-HIT ME === 2-HOLD");
					alegere=sc.nextInt();
					if(alegere==1){
						curent=cards.getCardFromPack();
						if(curent.getNumar()==14 && player.cardSum()>10){
							curent.changeAsValue(); //Ii schimba valoarea din 11 in 1.
								
						}
						player.receiveCardInHand(curent);
						player.showHand();
					} else if(alegere==2){
						value=player.cardSum();
						player.showHand();
						break;
					} else {
						System.out.println("Incorrect choice. Try again.");
					}
				}
				
			}
		return value;
	}

}
