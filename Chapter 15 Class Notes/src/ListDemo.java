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
         ListIterator<String> iter = staff.listIterator();//    |TNPS
        /* The next method advances the iterator OVER the  next element in the list */
        iter.next(); //    T|NPS

        /*The next method also returns the element that the iterator passes over */
        String avenger = iter.next(); //    TN|PS
        System.out.println(avenger);//    Natasha
        
        /* the add method inserts an element at the iterator position 
         * The iterator is the positioned AFTER the element that was added
         */
        iter.add("Clint"); //    TNC|PS
        iter.add("Bruce");//    TNCB|PS
        System.out.println(staff);
        
        /*The remove method can only be called after calling next or previous */
        //iter.remove(); This line would cause an illegal state exception
        //thr remove method removes the element returned  after calling next or previous
        iter.next();// TNCBP|S
        iter.remove(); //Peter removed -> Tony, Natasha, Steve, Clint, Bruce
        System.out.println(staff);


        /* The set method updates the element returned by 
         * the last call to next or previous 
         */
        iter.previous(); // TNC|BS
        iter.set("Thor");//Bruce is replaced by Thor ->TNC|TS
        System.out.println(staff);

        /*The hasNext methos is used to determine if there is a next node
         * after the iterator. The hasNext method is often used in the conditon
         * of a while loop.
         */
        iter = staff.listIterator();
        while(iter.hasNext())
        {
            String n = iter.next();
            if (n.equals("Natasha")) 
                iter.remove();
        }

        /*Enhanced for loops work with Linked Lists */
        for (String n : staff)
        {
            System.out.print(n+" ");
        }

        System.out.println();

        iter = staff.listIterator();
        while (iter.hasNext())
        {
            String n = iter.next();
            if (n.equals("Tony"))
                //staff.remove("Tony"); Must use iterator if youre going to remove in list
                {}
        }
        for (String n : staff)//for loop creates an iterator in the background
        {
           if (n.equals("Tony"))
                //staff.add("T'Challa");cant modify lsit while useing iterator
                {}
        }
        System.out.println(staff);
    }
}

