package main;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Player 
{
	/**The amount of money the player has**/
	private int intMoney;
	/**What the value of the players cards is equal to**/
	private int cardTotal;
	/**The players hand of cards**/
	public ArrayList<CardLabel> hand;
	
	/**
	 * Constructor for the Player object
	 * 
	 * @param parent	The parent JFrame
	 * @param card1		The first card in the hand
	 * @param card2		The second card in the hand
	 * @param card3		The third card in the hand
	 * @param card4		The fourth card in the hand
	 * @param card5		The fifth card in the hand
	 */
	public Player(JFrame parent, CardLabel card1, CardLabel card2, CardLabel card3, CardLabel card4, CardLabel card5)
	{
		hand = new ArrayList<CardLabel>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
	}

	/**
	 * 
	 * @return	Returns the total amount of money the player has
	 */
	public int getIntMoney() 
	{
		return intMoney;
	}

	/**
	 * Sets the amount of money the player has
	 * 
	 * @param money
	 */
	public void setIntMoney(int money) 
	{
		intMoney = money;
	}
	
	/**
	 * Checks if the player has gone over a point value of 21
	 * 
	 * @return	Returns true if the card total is greater than 21, false if not
	 */
	public boolean isBusted()
	{
		int aceIndex = -1;
		for (int i = 0; i < hand.size(); i++)
		{
			// If there is an ace with a value of 11 save its index
			if (hand.get(i).getCard() != null && hand.get(i).getCard().getID().equals("Ace") && hand.get(i).getCard().getValue() == 11)
				aceIndex = i;
		}
		// If the card today is greater than 21 and there is an ace
		if (calcCardTotal() > 21 && aceIndex != -1)
		{
			hand.get(aceIndex).getCard().setValue(1);	// Sets the extra ace's value to 1 instead of 11
		}
		
		return (calcCardTotal() > 21);
	}
	
	/**
	 * Calculates the total value of cards in the players hand
	 * 
	 * @return	Returns the total value of the cards
	 */
	public int calcCardTotal()
	{
		cardTotal = 0;
		for (CardLabel c: hand)
		{
			if (c.getCard() != null)	// If the card exists
				cardTotal += c.getCard().getValue(); 
		}
		return cardTotal;
	}
	
	/**
	 * Removes all cards from the hand
	 */
	public void resetCards()
	{
		for (CardLabel c: hand)
		{
			c.resetCard();
		}
	}
}
