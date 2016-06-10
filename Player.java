package blackjack;


public class Player {

	private String name;
	
	private Card[] hand = new Card[0];
	
	public void receiveCardInHand(Card cardReceived){
		Card[] newHand = new Card[hand.length+1];
		for(int i=0;i<hand.length;i++){
			newHand[i]=hand[i]; 
		}
		newHand[newHand.length-1]=cardReceived;
		hand=newHand;
	}
	
	public void showHand(){
		System.out.println("Your hand:\n");
		for(int i=0;i<hand.length;i++){
			System.out.println(hand[i]+" ");
		}
	}
	
	public int cardSum(){
		int sum=0;
		for(int i=0;i<hand.length;i++){
			sum+=hand[i].getValoare();
		}
		return sum;
	}
	
	public Player(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public Card[] getHand() {
		return hand;
	}
	
	
}
