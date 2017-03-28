package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Board implements ActionListener
{
	private JFrame frmBlackjack;
	private Deck myDeck = new Deck();
	
	// Player cards
	private CardLabel card1;
	private CardLabel card2;
	private CardLabel card3;
	private CardLabel card4;
	private CardLabel card5;
	private JLabel playerTotal;
	
	// Dealer cards
	private CardLabel card6;
	private CardLabel card7;
	private CardLabel card8;
	private CardLabel card9;
	private CardLabel card10;
	private JLabel dealerTotal;
	
	private JButton hit;
	private JButton stay;
	private Player dealer;
	private Player player;

	/**
	 * Create the application.
	 */
	public Board() 
	{
		initialize();
		player = new Player(frmBlackjack, card1, card2, card3, card4, card5);
		dealer = new Player(frmBlackjack, card6, card7, card8, card9, card10);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmBlackjack = new JFrame();
		frmBlackjack.setTitle("Blackjack");
		frmBlackjack.setBounds(100, 100, 600, 600);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.getContentPane().setLayout(null);
		
		card1 = new CardLabel("");
		card1.setBounds(10, 306, 104, 160);
		frmBlackjack.getContentPane().add(card1);
		
		card2 = new CardLabel("");
		card2.setBounds(124, 306, 104, 160);
		frmBlackjack.getContentPane().add(card2);
		
		card3 = new CardLabel("");
		card3.setBounds(238, 306, 104, 160);
		frmBlackjack.getContentPane().add(card3);
		
		card4 = new CardLabel("");
		card4.setBounds(352, 306, 104, 160);
		frmBlackjack.getContentPane().add(card4);
		
		card5 = new CardLabel("");
		card5.setBounds(471, 306, 104, 160);
		frmBlackjack.getContentPane().add(card5);
		
		playerTotal = new JLabel("");
		playerTotal.setLocation(10, 477);
		playerTotal.setSize(100, 30);
		frmBlackjack.getContentPane().add(playerTotal);
		
		card6 = new CardLabel("");
		card6.setBounds(10, 11, 104, 160);
		frmBlackjack.getContentPane().add(card6);
		
		card7 = new CardLabel("");
		card7.setBounds(124, 11, 104, 160);
		frmBlackjack.getContentPane().add(card7);
		
		card8 = new CardLabel("");
		card8.setBounds(238, 11, 104, 160);
		frmBlackjack.getContentPane().add(card8);
		
		card9 = new CardLabel("");
		card9.setBounds(352, 11, 104, 160);
		frmBlackjack.getContentPane().add(card9);
		
		card10 = new CardLabel("");
		card10.setBounds(471, 11, 104, 160);
		frmBlackjack.getContentPane().add(card10);
		
		dealerTotal = new JLabel("");
		dealerTotal.setLocation(14, 182);
		dealerTotal.setSize(100, 30);
		frmBlackjack.getContentPane().add(dealerTotal);
		
		hit = new JButton("Hit");
		hit.setBounds(10, 528, 89, 23);
		frmBlackjack.getContentPane().add(hit);
		hit.addActionListener(this);
		
		stay = new JButton("Stay");
		stay.setBounds(102, 528, 89, 23);
		frmBlackjack.getContentPane().add(stay);
		stay.addActionListener(this);
		
		frmBlackjack.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getSource() == hit)
		{
			if (hit(player))
			{
				JOptionPane.showMessageDialog(null, "You have busted!", "Busted", JOptionPane.ERROR_MESSAGE);
				dealCards();
			}
			playerTotal.setText("" + player.calcCardTotal());
		}
		
		if (event.getSource() == stay)
		{
			for (int i = 0; i < dealer.hand.size(); i++)
			{
				if (dealer.hand.get(i).getCard() != null)
					dealer.hand.get(i).setIcon(dealer.hand.get(i).getCard().getImage());
				dealerTotal.setText("" + dealer.calcCardTotal());
			}
			
			while (dealer.calcCardTotal() < 16)
			{
				if (hit(dealer))
				{
					JOptionPane.showMessageDialog(null, "Dealer has busted!", "Busted", JOptionPane.ERROR_MESSAGE);
				}
				dealerTotal.setText("" + dealer.calcCardTotal());
			}
			
			if (dealer.isBusted())
			{
				JOptionPane.showMessageDialog(null, "You won!", "Winner", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.isBusted())
			{
				JOptionPane.showMessageDialog(null, "You lost!", "Loser", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.calcCardTotal() > dealer.calcCardTotal())
			{
				JOptionPane.showMessageDialog(null, "You won!", "Winner", JOptionPane.ERROR_MESSAGE);
			}
			else if (player.calcCardTotal() < dealer.calcCardTotal())
			{
				JOptionPane.showMessageDialog(null, "You lost!", "Loser", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You tied", "Tie", JOptionPane.ERROR_MESSAGE);
			}
			dealCards();
		}
	}
	
	/**
	 * Deals cards to the player at the start of a hand. 
	 */
	public void dealCards()
	{
		// If there are not enough cards for a hand then shuffle
		if (myDeck.size() <=4)
		{
			// Makes sure there are no cards left in the deck
			while (!myDeck.isEmpty())
			{
				myDeck.deal();
			}
			myDeck.shuffle();
			JOptionPane.showMessageDialog(null, "Shuffling", "Shuffle", JOptionPane.DEFAULT_OPTION);
		}
		
		dealer.resetCards();
		player.resetCards();
		
		for (int i = 0; i < 2; i++)
		{
			dealer.hand.get(i).setCard(myDeck.deal());
			dealer.hand.get(i).setIcon(dealer.hand.get(i).getCard().getImage());
		}
		dealer.hand.get(0).setIcon(Images.resize(Images.defaultCard, 104, 160));
		
		for (int i = 0; i < 2; i++)
		{
			player.hand.get(i).setCard(myDeck.deal());
			player.hand.get(i).setIcon(player.hand.get(i).getCard().getImage());
		}
		
		player.isBusted();
		playerTotal.setText("" + player.calcCardTotal());
		dealerTotal.setText("" + dealer.hand.get(1).getCard().getValue());
		
		if (player.calcCardTotal() == 21)
		{
			JOptionPane.showMessageDialog(null, "Blackjack! You won!", "Winner", JOptionPane.ERROR_MESSAGE);
			dealCards();
		}
	}
	
	/**
	 * Deals a card to a player and calculates whether they have gone over 21
	 * 
	 * @param 	player	Which player is taking a card
	 * @return	Returns true if the player has gone over 21
	 */
	public boolean hit(Player player)
	{
		if (player.hand.get(0).getCard() != null && player.hand.get(1).getCard() != null)
		{
			if (player.hand.get(2).getCard() == null)
			{
				player.hand.get(2).setCard(myDeck.deal());
				player.hand.get(2).setIcon(player.hand.get(2).getCard().getImage());
			}
			else if (player.hand.get(3).getCard() == null)
			{
				player.hand.get(3).setCard(myDeck.deal());
				player.hand.get(3).setIcon(player.hand.get(3).getCard().getImage());
			}
			else if (player.hand.get(4).getCard() == null)
			{
				player.hand.get(4).setCard(myDeck.deal());
				player.hand.get(4).setIcon(player.hand.get(4).getCard().getImage());
			}
		}
		return player.isBusted();
	}
}