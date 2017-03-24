package main;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CardLabel extends JLabel
{
	private Card myCard;
	
	public CardLabel(String string) 
	{
		super(string);
	}
	
	public void setCard(Card card)
	{
		myCard = card;
		setText(card.toString());
	}
	
	public Card getCard()
	{
		return myCard;
	}
	
	public void resetCard()
	{
		setText("");
		setIcon(null);
		myCard = null;
	}
}
