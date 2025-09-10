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
        Set<Integer> primes = new Set<Integer>();
        // Your work goes here
        for (int i = 2; i <= n; i++)
        {
            primes.add(i);
        }   

        
        for (number : primes)
        {
            if (i != 2 && i % 2 == 0)
            {
                primes.remove(number);
            }
            else if (i % 3 == 0 && i != 3)
            {
                primes.remove(number);
            }
            else if (i % 5 == 0 && i != 5)
            {
                primes.remove(number);
            }
            else if (i % 7 == 0 && i != 7)
            {
                primes.remove(number);
            }
        }
        
        for (int prime : primes)
        {
            System.out.println(prime);
        }


    }
}
