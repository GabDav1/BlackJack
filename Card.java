package blackjack;


public class Card {
	
	private int valoareBlackjack;
	private final int numar;
	private final Suit suita;
	
	// Modificarea valorii din 11 in 1. Metoda este aplicata dupa ce a fost realizata verificarea pentru AS in prealabil.
	public void changeAsValue() {
		this.valoareBlackjack=1;
	}	
	
	//doar getteri
	public int getNumar() {
		return numar;
	}
	public Suit getSuita() {
		return suita;
	}
	public int getValoare() {
		return valoareBlackjack;
	}
	
	//Constructorul transforma numerele neaplicabile unei carti in valoarea minima. 
	//Apoi aloca valorile (din blackjack) in functie de numerele cartilor.
	
	public Card(int numar,Suit suita){
		
		if((numar<2)||(numar>14)){
			this.numar = 2;
		} else{
			this.numar = numar;	
		}
		
		if((numar>1)&&(numar<11)){
			this.valoareBlackjack = numar;
		} else if(numar>10 && numar<14){
			this.valoareBlackjack=10;
		}else if(numar==14){
			this.valoareBlackjack=11; //Cartea 14(AS-ul) o initializam cu 11, valoarea asteptata la verificarea initiala pentru BlackJack.
		}								//Cand va trebui schimbata, se va apela metoda ChangeAsValue din clasa asta.
		
		this.suita = suita;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder ts = new StringBuilder("[");
		
		switch(this.numar){
		
		case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
			ts.append(this.numar).append(" de ")
			.append(this.suita);
			break;
		case 11: ts.append("valet").append(" de ")
					.append(this.suita);
		break;
		case 12: ts.append("regina").append(" de ")
				.append(this.suita);
				break;
		case 13: ts.append("rege").append(" de ")
				.append(this.suita);
				break;
		case 14: ts.append("AS").append(" de ").append(this.suita);	
		}
		ts.append("]");
		
		return ts.toString();
	}
		
}
