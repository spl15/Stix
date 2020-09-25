
 /** @Author: Stephen Lamalie
 * @Class: COP3022
 * @Date: 08/30/19
 * @ Version: 1.2
 */

import java.util.*;

public class Stix 
{	
	static int total = 0;
	static int myChoice = 0;
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		String choice;
		
		System.out.println("Hi, lets get started with a game of stix");
		System.out.println("How many stixs would you like to start with? (must be 						between [5-30])");
		
		//error checking to verify that the initial number is a number
		while(!kb.hasNextInt())
		{
			System.out.println("this is not a number, please try again");
			kb.next();
		}			
		total = kb.nextInt();
		//verify that the total is between 5-30
		while(total>30 || total<5)
		{
			System.out.println("Must be between[5-30], please try again");
			while(!kb.hasNextInt())
			{
				System.out.println("Not a numer, please try again");
				kb.next();
			}
			total= kb.nextInt();
		}
		
		System.out.println("Would you like to go first? enter y for yes and any other "
				+ "charcter or string to allow the computer to go first");
		choice = kb.next();
		
		// if choice is y or Y the player goes first, otherwise the computer does 
		while(total>0)
		{
			if(choice.equalsIgnoreCase("y"))
			{
				playerMove();
				if(total != 0)
				{
					computerMove();
				}
			}
			else
			{
				computerMove();
				if(total != 0)
				{
					playerMove();
				}
			}
		}
	}
	
	
	public static void playerMove()
	{
		
		System.out.println("how many stix would you like to take? must be between [1-3]");
		//verify that it is a number
		while(!kb.hasNextInt())
		{
			System.out.println("Not a numer, please try again");
			kb.hasNext();
		}
		myChoice = kb.nextInt();
		
		//verify that the person player can only take a valid move of 1, 2, or 3 stix
		while(myChoice < 1 || myChoice >3)
		{
			//verify player choice is a number
			System.out.println("number must be between[1-3], please try again");
			while(!kb.hasNextInt())
			{
				System.out.println("Not a numer, please try again");
				kb.next();
			}
			myChoice = kb.nextInt();
		}
		
		//prevents the player from taking more stix than are available  
		while((total-myChoice) < 0)
		{
			System.out.println("there are only " + total + " stixs to take, please try again");
			
			while(!kb.hasNextInt())
			{
				System.out.println("Not a numer, please try again");
				kb.next();
			}
			myChoice = kb.nextInt();
			
			//player can't take 0 or any negative number 
			while(myChoice < 1)
			{
					System.out.println("You must take at least one stix, please try again.");
					//verify that the input is a number
					while(!kb.hasNextInt())
					{
						System.out.println("Not a numer, please try again");
						kb.next();
					}
					myChoice = kb.nextInt();
			}
			
		}
		
		total = total - myChoice;
		System.out.println("You took "+ myChoice + " stixs");
		System.out.print("stix on the table: ");
		for(int i = 0;i < total;i++)
		{
			System.out.print("|");
			if(i==(total-1))
			{
				System.out.print("\n");
			}
		}
		// if the player takes the last stix, then he loses
		if(total==0)
		{
			System.out.println("You have drawn the last stix, sorry you lose");
		}
	}
	
	//the computer move, it takes one if it has to but will try to invoke the strategy to move in pairs of 4(the player and it) once a desired location is reached
	public static void computerMove()
	{	
		if(total == 1)
		{
			System.out.println("The computer takes 1 stix");
			--total;
			System.out.println("The computer has drawn the last stix, YOU WIN!!!");
		}
		else if((total % 4) == 2)
		{
			System.out.println("The computer takes 1 stix");
			--total;
		}
		else if((total % 4) == 3)
		{
			System.out.println("The computer takes 2 stix");
			total -= 2;
		}
		else if((total % 4) == 0)
		{
			System.out.println("The computer takes 3 stix");
			total -= 3;
		}
		else
		{
			System.out.println("The computer takes 1 stix");
			--total;
		}
		
		
		System.out.print("stix on the table: ");
		for(int i = 0;i < total;i++)
		{
			System.out.print("|");
			if(i==(total-1))
			{
				System.out.print("\n");
			}
		}
	}
	

}
