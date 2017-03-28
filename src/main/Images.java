package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images 
{
	public static ImageIcon defaultCard = new ImageIcon(Board.class.getResource("/images/Back of card.png"));
	
	public static String spades[] = {"Spades/Ace_Of_Spades", "Spades/2_Of_Spades", "Spades/3_Of_Spades", "Spades/4_Of_Spades",
									"Spades/5_Of_Spades", "Spades/6_Of_Spades", "Spades/7_Of_Spades", "Spades/8_Of_Spades",
									"Spades/9_Of_Spades", "Spades/10_Of_Spades", "Spades/Jack_Of_Spades",
									"Spades/Queen_Of_Spades", "Spades/King_Of_Spades"};
	
	public static String clubs[] = {"Clubs/Ace_Of_Clubs", "Clubs/2_Of_Clubs", "Clubs/3_Of_Clubs", "Clubs/4_Of_Clubs",
									"Clubs/5_Of_Clubs", "Clubs/6_Of_Clubs", "Clubs/7_Of_Clubs", "Clubs/8_Of_Clubs",
									"Clubs/9_Of_Clubs", "Clubs/10_Of_Clubs", "Clubs/Jack_Of_Clubs",
									"Clubs/Queen_Of_Clubs", "Clubs/King_Of_Clubs"};
	
	public static String hearts[] = {"Hearts/Ace_Of_Hearts", "Hearts/2_Of_Hearts", "Hearts/3_Of_Hearts", "Hearts/4_Of_Hearts",
									"Hearts/5_Of_Hearts", "Hearts/6_Of_Hearts", "Hearts/7_Of_Hearts", "Hearts/8_Of_Hearts",
									"Hearts/9_Of_Hearts", "Hearts/10_Of_Hearts", "Hearts/Jack_Of_Hearts",
									"Hearts/Queen_Of_Hearts", "Hearts/King_Of_Hearts"};
	
	public static String diamonds[] = {"Diamonds/Ace_Of_Diamonds", "Diamonds/2_Of_Diamonds", "Diamonds/3_Of_Diamonds", "Diamonds/4_Of_Diamonds",
										"Diamonds/5_Of_Diamonds", "Diamonds/6_Of_Diamonds", "Diamonds/7_Of_Diamonds", "Diamonds/8_Of_Diamonds",
										"Diamonds/9_Of_Diamonds", "Diamonds/10_Of_Diamonds", "Diamonds/Jack_Of_Diamonds",
										"Diamonds/Queen_Of_Diamonds", "Diamonds/King_Of_Diamonds"};
	
	public static ImageIcon resize(ImageIcon img, int w, int h)
	{
		return new ImageIcon(img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
	}

}
