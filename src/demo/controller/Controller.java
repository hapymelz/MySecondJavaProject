package demo.controller;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Controller
{
	private Scanner input;
	
	public Controller()
	{
		this.input = new Scanner(System.in);
	}
	int rh1 = 1;
	int lh1 = 1;
	int rh2 = 1;
	int lh2 = 1;
	int p1 = 2;
	int p2 = 2;
	String yourHand = "";
	String theirHand = "";
	int p2move = ThreadLocalRandom.current().nextInt(1,3);
	int p2attack = ThreadLocalRandom.current().nextInt(1,3);
	
	public void start()
	{
		System.out.println("Commencing game...");
		System.out.println("Please only type in the letters the game prompts you to. Do not use a hand that you lost, else you waste a turn.");
		
		
		
		
		while (p1 > 0 || p2 > 0)
		{
			System.out.println("You: right hand = " + rh1 + " left hand = " + lh1);
			System.out.println("Computer: right hand = " + rh2 + " left hand = " + lh2);
			if (p1 > 0) 
			{
				Player1turn();
				
			} 
			else if (p2 > 0)
			{
				Player2Turn();
			}
			else
			{
				EndGame();
			}
		}
	}		
	
	public void Player1turn() 
	{
		System.out.println("Which hand would you like to use? L/R");
		String p1move = input.next();
		System.out.println("Which hand would you like to attack? L/R");
		String p1attack = input.next();

		if (p1move.equals("L"))
		{
			yourHand = "Left";
			if (p1attack.equals("L"))
			{
				lh2 = lh2 + lh1;
				if (lh2 > 5)
				{
					lh2 = lh2 - 5;
				}
				else if (lh2 == 5)
				{
					lh2 = 0;
					p2 = p2 - 1;
				}
			} 
			else if (p1attack.equals("R")) 
			{
				rh2 = rh2 + lh2;
				if (rh2 > 5)
				{
					rh2 = rh2 - 5;
				}
				else if (rh2 == 5)
				{
					rh2 = 0;
					p2 = p2 - 1;
				}
			} 
			else 
			{
				System.out.println("Please only type in 'L' or 'R'. Restart the game to continue playing");
			}
		} 
		
		
		
		
		
		else if (p1move.equals("R")) 
		{
			yourHand = "Right";
			if (p1attack.equals("L")) 
			{
				lh2 = lh2 + rh1;
				if (lh2 > 5)
				{
					lh2 = lh2 - 5;
				}
				else if (lh2 == 5)
				{
					lh2 = 0;
					p2 = p2 - 1;
				}
			}
			else if (p1attack.equals("R"))
			{
				rh2 = rh2 +rh1;
				if (rh2 > 5)
				{
					rh2 = rh2 - 5;
				}
				else if (rh2 == 5)
				{
					rh2 = 0;
					p2 = p2 - 1;
				}
			}
			else 
			{
				System.out.println("Please only type in 'L' or 'R'. Restart the game to continue playing");
			}
		}
		
		
		
		
		if (p1attack.equals("L"))
		{ 
			theirHand = "Left";
		}
		else 
		{
			theirHand = "Right";
		}
		System.out.println("You chose to attack Computer's " + theirHand + " hand with your " + yourHand + " hand.");
		
			
			
			
			
		if (lh2 == 0 || rh2 == 0) 
		{
			System.out.println("Computer lost a hand!");
			if (lh2 == 0 && rh2 == 0)
			{
				EndGame();
			}
			else
			{
				
			}
		}

		
	}
			
			
	public void Player2Turn() 
	{
		if (lh2 == 0)
		{
			p2move = 2;
		}
		if (rh2 == 0)
		{
			p2move = 1;
		}
		
		if (p2move == 1)
		{
			theirHand = "Left";
			if (p2attack == 1)
			{
				lh1 = lh1 + lh2;
				if (lh1 > 5)
				{
					lh1 = lh1 - 5;
				}
				else if (lh1 == 5)
				{
					lh1 = 0;
					p1 = p1 - 1;
				}
			} 
			else if (p2attack == 2)
			{
				rh1 = rh1 + lh2;
				if (rh1 > 5)
				{
					rh1 = rh1 - 5;
				}
				else if (rh1 == 5)
				{
					rh1 = 0;
					p1 = p1 - 1;
				}
			}
		}
		else 
		{
			theirHand = "Right";
			if (p2attack == 1)
			{
				lh1 = lh1 + rh2;
				if (lh1 > 5)
				{
					lh1 = lh1 - 5;
				}
				else if (lh1 == 5)
				{
					lh1 = 0;
					p1 = p1 - 1;
				}
			}
			else if (p2attack == 1)
			{
				rh1 = rh1 + rh2;
				if (rh1 > 5)
				{
					rh1 = rh1 - 5;
				}
				else if (rh1 == 5)
				{
					rh1 = 0;
					p1 = p1 - 1;
				}
			}
			
			if (p2attack == 1) 
			{ 
				yourHand = "Left";
			}
			else 
			{
				yourHand = "Right";
			}
			System.out.println("Computer chose to attack your " + yourHand + " hand with their " + theirHand + " hand.");
			if (lh1 == 0 || rh1 == 0)
			{
				System.out.println("You lost a hand!");
				if (lh1 == 0 && rh1 == 0)
				{
					EndGame();
				}
				else
				{
					
				}
			}
		}
	}
	
	
	public void EndGame()	
	{
		if (p1 == 0)
		{
			System.out.println("You lost!");
		}
		else
		{
			System.out.println("You won!");
		}
		
		System.out.println("Would you like to play again? Y/N");
		String playagain = input.next();
		if (playagain.equals("Y"))
		{
			start();
		}
		else
		{
		System.out.println("Okay. Thanks for playing!");
		}
	}
}
