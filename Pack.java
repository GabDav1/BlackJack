package blackjack;


public class Pack {
	private Card[] packOfCards = new Card[52];
	
	public Pack(){
		int m = 0;
		for(int g=0;g<4;g++){
			for(int i=2;i<15;i++){
				switch(g){
				case 0: packOfCards[m]=new Card(i, Suit.NEAGRA);
				m++; 
				continue;
				case 1: packOfCards[m]=new Card(i, Suit.ROMB);
				m++;
				continue;
				case 2: packOfCards[m]=new Card(i, Suit.ROSU);
				m++;
				continue;
				case 3: packOfCards[m]=new Card(i, Suit.TREFLA);
				m++;
				continue;
				}	
			}
		}
		this.shuffle();
	}

	private void shuffle() {
		double dRandom;
		int intRandom;
		for (int i = 0; i < packOfCards.length; i++) {
			dRandom = Math.random()*(packOfCards.length);
			intRandom=(int)dRandom;
			Card temp = packOfCards[i];
			packOfCards[i] = packOfCards[intRandom];
			packOfCards[intRandom] = temp;
			
		}
		
	}

	public Card getCardFromPack(){
		Card carteDeReturnat = packOfCards[packOfCards.length-1];
		Card[] cartiDeInlocuit = new Card[packOfCards.length-1];
		for (int i = 0; i < cartiDeInlocuit.length; i++) {
			cartiDeInlocuit[i]=packOfCards[i];
		}
		packOfCards=cartiDeInlocuit;
		return carteDeReturnat;
	}
	
	public String toString() {
		StringBuilder builder = new  StringBuilder();
		for (int i = 0; i < this.packOfCards.length; i++) {
			builder.append(this.packOfCards[i]+"\n");
		}
	return builder.toString();
	}
	
	
	public Card[] getPackOfCards() {
		return packOfCards;
	}


	public void setPackOfCards(Card[] packOfCards) {
		this.packOfCards = packOfCards;
	}

	
	
}
