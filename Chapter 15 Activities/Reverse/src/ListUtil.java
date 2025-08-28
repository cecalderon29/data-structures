import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ArrayList <String> reversed = new ArrayList<>();
        ListIterator<String> iter = strings.listIterator();
        

        

        while(iter.hasNext())
        {   
            String value = iter.next();
            reversed.add(0, value);
            iter.remove();
        }
        
        strings.addAll(reversed);
    }
}