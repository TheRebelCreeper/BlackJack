package main;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Player 
{
	private int intMoney;
	private int cardTotal;
	public ArrayList<CardLabel> hand;
	
	public Player(JFrame parent, CardLabel card1, CardLabel card2, CardLabel card3, CardLabel card4, CardLabel card5)
	{
		hand = new ArrayList<CardLabel>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
	}

	public int getIntMoney() 
	{
		return intMoney;
	}

	public void setIntMoney(int money) 
	{
		intMoney = money;
	}
	
	public boolean isBusted()
	{
		int aceIndex = -1;
		for (int i = 0; i < hand.size(); i++)
		{
			// If there is an ace with a value of 11
			if (hand.get(i).getCard() != null && hand.get(i).getCard().getID().equals("Ace") && hand.get(i).getCard().getValue() == 11)
				aceIndex = i;
		}
		if (calcCardTotal() > 21 && aceIndex != -1)
		{
			hand.get(aceIndex).getCard().setValue(1);
		}
		
		return (calcCardTotal() > 21);
	}
	
	public int calcCardTotal()
	{
		cardTotal = 0;
		for (CardLabel c: hand)
		{
			if (c.getCard() != null)
				cardTotal += c.getCard().getValue(); 
		}
		return cardTotal;
	}
	
	public void resetCards()
	{
		for (CardLabel c: hand)
		{
			c.resetCard();
		}
	}
}
