package main;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Deck 
{
	/**
     * 
     */
    private ArrayList<Card> myCards;
    
    /**
     * 
     */
    private ArrayList<Card> myUsedCards;
    
    /**
     * 
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
     * 
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
     * 
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
     * 
     */
    public boolean isEmpty()
    {
        return myCards.isEmpty();
    }
    
    /**
     * 
     */
    public int size()
    {
        return myCards.size();
    }
    
    /**
     *
     */
    public void shuffle()
    {
        myCards = selectionShuffle(myUsedCards);
        for (Card c: myCards)
        {
        	if (c!= null && c.getID().equals("Ace") && c.getValue() == 1)
        		c.setValue(11);
        }
    }
    
    /**
     * 
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
     * 
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
