package main;

import javax.swing.ImageIcon;

public class Card 
{
	/**Holds the suit of the card. 1 = spades, 2 = clubs, 3 = hearts, 4 = diamonds*/
    private int cardSuit;
    
    /**Holds the name of the card*/
    private String cardID;
    
    /**Holds the numerical value of the card*/
    private int cardValue;

    /**Holds the image of the card*/
    private ImageIcon myImage;
    
    /**
     * Constructor for objects of class Card
     */
    public Card(int suit, String type, int value, ImageIcon img)
    {
        cardSuit = suit;
        cardID = type;
        cardValue = value;
        myImage = Images.resize(img, 104, 160);
    }

    /**
     * Accesses the suit of the card
     * 
     * @return  Returns the suit of the card
     */
    public int getSuit()
    {
        return cardSuit;
    }
    
    /**
     * Accesses the ID of the card
     * 
     * @return Returns the ID of the card
     */
    public String getID()
    {
        return cardID;
    }
    
    /**
     * Accesses the value of the card
     * 
     * @return  Returns the value of the card
     */
    public int getValue()
    {
        return cardValue;
    }
    
    /**
     * Accesses the image of the card
     */
    public ImageIcon getImage()
    {
    	return myImage;
    }
    
    /**
     * Sets the value of the card's suit
     */
    public void setSuit(int suit)
    {
        cardSuit = suit;
    }
    
    /**
     * Sets the value of the card's ID
     */
    public void setID(String type)
    {
        cardID = type;
    }
    
    /**
     * Sets the value of the card's suit
     */
    public void setValue(int value)
    {
        cardValue = value;
    }
    
    /**
     * Sets the image of the card
     */
    public void setImage(ImageIcon img)
    {
        myImage = img;
    }
    
    /**
     * Checks if the cards are the same
     * 
     * @param   Card otherCard  The card to compare to
     * @return  Returns true if the cards are the same
     */
    public boolean matches(Card otherCard)
    {
        return suitMatches(otherCard) && idMatches(otherCard);
    }
    
    /**
     * Checks if the suit of the cards is the same
     * 
     * @param   Card otherCard  The card to compare to
     * @return  Returns true if the suit is the same
     */
    public boolean suitMatches(Card otherCard)
    {
        return cardSuit == otherCard.getSuit();
    }
    
    /**
     * Checks if the type of card is the same
     * 
     * @param   Card otherCard  The card to compare to
     * @return  Returns true if the type of card is the same
     */
    public boolean idMatches(Card otherCard)
    {
        return cardID.equals(otherCard.getID());
    }
    
    /**
     * Returns the information about the card
     */
    public String toString()
    {
        if (cardSuit == 1)      // If the card is a spade
        {
            return cardID + " of Spades worth " + cardValue + " points";
        }
        else if (cardSuit == 2) // If the card is a club
        {
            return cardID + " of Clubs worth " + cardValue + " points";
        }
        else if (cardSuit == 3) // If the card is a heart
        {
            return cardID + " of Hearts worth " + cardValue + " points";
        }
        else if (cardSuit == 4) // If the card is a diamond
        {
            return cardID + " of Diamonds worth " + cardValue + " points";
        }
        else
        {
            return "Invalid card";
        }
    }

}
