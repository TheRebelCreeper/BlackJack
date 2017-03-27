package main;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Deck 
{
	/** Contains the cards in play **/
    private ArrayList<Card> myCards;
 
    /** Contains the used cards **/
    private ArrayList<Card> myUsedCards;
    
    /**
     * Default constructor for the deck. Creates a deck with 104 cards 
     */
    public Deck()
    {
        myCards = new ArrayList<Card>();
        myUsedCards= new ArrayList<Card>();
        
        String[] type = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        int[] suit = {1, 2, 3, 4};
        int[] value = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        String images[][] = new String[4][];
        images[0] = Images.spades;
        images[1] = Images.clubs;
        images[2] = Images.hearts;
        images[3] = Images.diamonds;
        
        for (int i = 0; i < suit.length; i++)
        {
            for(int j = 0; j < type.length; j++)
            {
                myUsedCards.add(new Card(suit[i], type[j], value[j], new ImageIcon(Board.class.getResource("/images/" + images[i][j] + ".png"))));
                myUsedCards.add(new Card(suit[i], type[j], value[j], new ImageIcon(Board.class.getResource("/images/" + images[i][j] + ".png"))));
            }
        }
        
        shuffle();
    }
    
    /**
     * Constructor for deck
     * 
     * @param type	The type of card
     * @param suit	An integer value representing the suit of the card
     * @param value	The numerical value of the card
     */
    public Deck(String[] type, int[] suit, int[] value)
    {
        myCards = new ArrayList<Card>();
        myUsedCards= new ArrayList<Card>();
        
        for (int i = 0; i < suit.length; i++)
        {
            for(int j = 0; j < type.length; j++)
            {
                myCards.add(new Card(suit[i], type[j], value[j], null));
            }
        }
        
        shuffle();
    }
    
    /**
     * Deals a card out of the deck
     * 
     * @return Returns the card at the top of the deck
     */
    public Card deal()
    {
        if (!isEmpty())
        {
            myUsedCards.add(myCards.get(myCards.size() - 1));
            myCards.remove(myCards.size() - 1);
            return myUsedCards.get(myUsedCards.size() - 1);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Checks if the deck is empty
     * 
     * @return Returns true if the deck is empty
     */
    public boolean isEmpty()
    {
        return myCards.isEmpty();
    }
    
    /**
     * Gets the size of the deck
     * 
     * @return Returns the size of the deck
     */
    public int size()
    {
        return myCards.size();
    }
    
    /**
     * Shuffles the deck of cards
     */
    public void shuffle()
    {
        myCards = selectionShuffle(myUsedCards);
        
        // Resets the value of aces to 11
        for (Card c: myCards)
        {
        	if (c!= null && c.getID().equals("Ace") && c.getValue() == 1)
        		c.setValue(11);
        }
    }
    
    /**
     * Shuffles the deck randomly
     * 
     * @param usedCards	an ArrayList of the used cards
     */
    private ArrayList<Card> selectionShuffle(ArrayList<Card> usedCards)
    {
        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while(!usedCards.isEmpty())
        {
            int r = rand.nextInt(usedCards.size());
            shuffled.add(usedCards.get(r));
            usedCards.remove(r);
        }
        usedCards.clear();
        return shuffled;
    }
    
    /**
     * Prints out the cards in the deck
     * 
     * @return Returns a string
     */
    public String toString()
    {
        String rtnStr = "";
        for(Card i: myCards)
        {
            rtnStr += i.toString() + "\n";
        }
        return rtnStr;
    }
}
