import java.util.Scanner;
. . .
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> gradebook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("Who would you like to add?");
                String name = in.next()
                
                

            } else if (input.equals("R"))
            {
                . . .
            } else if (input.equals("M"))
            {
                . . .
            } else if (input.equalsIgnoreCase("P"))
            {
                . . .
            } else
            {
                done = true;
            }
        }
    }
}
