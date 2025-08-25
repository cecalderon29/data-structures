import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {   
        /*The addLast method can be used to populate the list */
        LinkedList <String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Steve");
        
        System.out.println(staff);
        
        //The list is currently [Tony, Natasha, Peter, Steve]

        /*
         * The listIterator method creates a new ListIterator.
         * that is positioned at the head of the list.
         * The | is used to represent the iterator position.
         */
         ListIterator<String> iter = staff.listIterator();//    |Tony, Natasha, Peter, Steve

        /* The next method advances the iterator OVER the  next element in the list */
        iter.next(); //    Tony|Natasha, Peter, Steve

        /*The next method also returns the element that the iterator passes over */
        String avenger = iter.next(); //    TonyNatasha|Peter, Steve
        System.out.println(avenger);//    Natasha
        
    }
}
