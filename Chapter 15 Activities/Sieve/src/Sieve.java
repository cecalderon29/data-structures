import java.util.Scanner;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        for (int i = 2; i <= n; i++)
        {
            boolean isPrime = true;
            if (i != 2 && i % 2 == 0)
            {
                isPrime = false;
            }
            else if (i % 3 == 0 && i != 3)
            {
                isPrime = false;
            }
            else if (i % 5 == 0 && i != 5)
            {
                isPrime = false;
            }
            else if (i % 7 == 0 && i != 7)
            {
                isPrime = false;
            }
            

            if (isPrime)
            {
                System.out.println(i);
            }
        }

    }
}
