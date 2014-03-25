/*
 * James Keller
 * ITCS 2215 - 02
 * Date:  2/8/2013
 */

import java.util.Scanner;

public class TowersMain {

   public static void main (String[] args)
   {   
       String status;
       
       //Loop based on the users input to continue
       do
       {
            int input;
  
            System.out.println("Welcome to the Towers of Hanoi Puzzle Program.");
            System.out.print("How many disks would you like to solve for? ");
            
            Scanner keyboard1 = new Scanner(System.in);
            input = keyboard1.nextInt();
            
            //Warns the user about exceptionally high inputs
            if (input >= 15)
            {
                System.out.println("\nThat's a lot of moves...this may take" + 
                                    " some time.");
                try
                {
                Thread.sleep(1500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
            System.out.println("\nHere are the steps to solve your puzzle:");
            System.out.println("_______________________________________________");
            
            //Instantiates a recursive towers object based on the users input
            try
            {
            RecursiveTowers puzzle = new RecursiveTowers ();
            puzzle.set(input);
            puzzle.initiate();
            System.out.println("\nIt took " + puzzle.getMoves() + " moves to " +
                               "solve your puzzle.");
            }
            catch (Exception e)
            {
                System.out.println("Oops...something broke. Please start again.");
            }
            
            System.out.print("\nWould you like to solve another puzzle? (Y/N): ");
            
            Scanner keyboard2 = new Scanner(System.in);
            status = keyboard2.nextLine();
            
            System.out.println("");
            
      } while (status.equalsIgnoreCase("Y") || status.equalsIgnoreCase("Yes"));
   }
}
