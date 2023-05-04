import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game extends Deck
{
	
	Deck deck = new Deck();
//	private Deck deck;
	private List<Card> playerCards;
	private List<Card> dealerCards;
	private boolean isPlay = true;
	private int blackJackEndValue = 21;
	private int dealerMinValue = 17;
	
	
	public Game()
	{
		this.deck = new Deck();
		this.playerCards = new ArrayList<>();
		this.dealerCards = new ArrayList<>();
	}
	
	public void StartGame()
	{			
		System.out.println("Welcome to Kala-Julam");
		deck.Shuffle();
		System.out.println("Dealing cards");
		playerCards.add(deck.dealCards());
		playerCards.add(deck.dealCards());
		dealerCards.add(deck.dealCards());
		dealerCards.add(deck.dealCards());
		
		System.out.println("Player's Cards" + playerCards);
		System.out.println("Dealer's Card " + dealerCards.get(0));
		System.out.println("");
		
		//player cards dealing 
		while(isPlay)
		{
			int playerHandValue = getHandValue(playerCards);
			if(playerHandValue == blackJackEndValue)
			{
				System.out.println("Its is Kala-Julam"); 
				isPlay = false;
				break;
			}
			
			else if(playerHandValue > blackJackEndValue)
			{
				System.out.println("Busted");
				isPlay = false;
				break;
			}
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Hit or Stand!?");
			String hitStandInput = scanner.nextLine();
			System.out.println("You chose" + hitStandInput);
			scanner.close();
			
			if(hitStandInput.toLowerCase().equals("hit"))
			{
				playerCards.add(deck.dealCards());
				System.out.println("You now have: " + playerCards);
			}
			
			else if(hitStandInput.toLowerCase().equals("stand"))
			{
				break;
			}
			
			else
			{
				System.out.println("Invalid Input");
			}
		}
		
		//dealer cards dealing 
		while(getHandValue(dealerCards) < dealerMinValue)
		{
			dealerCards.add(deck.dealCards());
		}
		//Win or Lose logic
		int playerTotal = getHandValue(playerCards);
		int dealerTotal = getHandValue(dealerCards);
		if(playerTotal > blackJackEndValue || playerTotal < dealerTotal)
		{
			System.out.println("Game Lost");
		}
		else if(dealerTotal > blackJackEndValue || playerTotal > dealerTotal)
		{
			System.out.println("Congratulations! You Won");
		}
		else
		{
			System.out.println("Draw"); 
		}
		
		System.out.println("Thanks for playing, Goodbye!");
	}
	
	//Getting hand value of the card 
	private int getHandValue(List<Card> hand)
	{
		int value = 0;
		for (Card card : hand)
		{
			Rank rank = card.getRank();
			if(rank == Rank.ACE)
			{
				value += 11;
			}
			else if(rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING)
			{
				value += 10;
			}
			else
			{
				if(rank == Rank.TWO)
					value += 2;
				else if(rank == Rank.THREE)
					value += 3;
				else if(rank == Rank.FOUR)
					value += 4;
				else if(rank == Rank.FIVE) 
					value += 5;
				else if(rank == Rank.SIX) 
					value += 6;
				else if(rank == Rank.SEVEN)
					value += 7;
				else if(rank == Rank.EIGHT)
					value += 8;
				else if(rank == Rank.NINE)
					value += 9;
				else if(rank == Rank.TEN)
					value += 10;
			}
		}
		
		return value;
	}
	
	public static void main(String[] args)
	{
//		Game();
		Game game = new Game();
		game.StartGame();
	}
}
