package main;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CardLabel extends JLabel
{
	/** The card assigned to the JLabel **/
	private Card myCard;
	
	/**
	 * Constructor for CardLabel
	 * 
	 * @param string	The text for the JLabel
	 */
	public CardLabel(String string) 
	{
		super(string);
	}
	
	/**
	 * Sets the card for the CardLabel
	 * 
	 * @param card
	 */
	public void setCard(Card card)
	{
		myCard = card;
		setText(card.toString());
	}
	
	/**
	 * Gets the card from the CardLabel
	 * 
	 * @return	Returns the card assigned to the CardLabel
	 */
	public Card getCard()
	{
		return myCard;
	}
	
	public void resetCard()
	{
		setText("");
		setIcon(null);	// Resets the picture for the CardLabel
		myCard = null;	// Removes the card assigned to the CardLabel
	}
}
