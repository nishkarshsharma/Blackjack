import java.util.*;

public class Deck {

	private List<Card> cards;
	
	public class Card
	{
		private Suit suit;
		private Rank rank;
		
		public Card(Suit suit, Rank rank)
		{
			this.rank = rank;
			this.suit = suit;
		}
		
		public Suit getSuit()
		{
			return suit;
		}
		
		public Rank getRank()
		{
			return rank;
		}
		
		public String getCards()
		{
			return this.rank + "of" + this.suit;
		}
	}
	
	public void Shuffle()
	{
		Collections.shuffle(cards);
	}
	
	public enum Suit
	{
		CLUBS, HEARTS, DIAMONDS, SPADES;
	}
	
	public enum Rank
	{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	public Deck()
	{
		this.cards = new ArrayList<>();
		for(Suit suit : Suit.values())
		{
			for(Rank rank : Rank.values())
			{
				Card card = new Card(suit, rank);
				this.cards.add(card);
			}
		}
	}
	public int noOfCards()
	{
		return cards.size();
	}
	
	public Card dealCards()
	{
		if(!cards.isEmpty())
		{
			return cards.remove(0); //returns the top card
		}
		return null;
	}
}
