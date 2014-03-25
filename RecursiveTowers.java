/*
 * James Keller
 * ITCS 2215 - 02
 * Date:  2/8/2013
 */

public class RecursiveTowers
{
    private int inputDisks;
    int moveCount = 0;
    String s = "SourcePeg";
    String t = "TargetPeg";
    String sp = "SparePeg";

    //Constructor
    public RecursiveTowers ()
    {
        inputDisks = 0;
    }

    //Setter for the number of disks
    public void set(int disks)
    {
        inputDisks = disks;
    }
    
    //Returns the total number of moves needed to solve the puzzle
    public int getMoves()
    {
        return moveCount;
    }
    
    //Initiates the recursive call
    public void initiate ()
    {
        moveTower (inputDisks, s, t, sp);
    }

    //Moves the defined number of disks from 1 tower to another
    //Moves subsets of disks (n-1). A disk is moved, then the subset is
    //moved back.
    private void moveTower (int numDisks, String s, String t, String sp)
    {
        //Base case of 1
        if (numDisks == 1)
        {
            moveOneDisk (s, t, numDisks);
        }
        else
        {
            moveTower (numDisks-1, s, sp, t);
            moveOneDisk (s, t, numDisks);
            moveTower (numDisks-1, sp, t, s);
        }
    }

    //Prints to console the disk and its relative move from one peg
    //to another.
    private void moveOneDisk (String source, String target, int n)
    {
        moveCount++;
        System.out.println ("Move disk " + n + " from the " + source + 
                            " to the " + target);
    }
}

