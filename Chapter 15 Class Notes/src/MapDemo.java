import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*The map interface is generic
         * The first type given is the the key
         * The second type given is  the value
         */
        Map<String, Color> favColors = new HashMap<>();
        
        //Add elements to the map using the put method
        favColors.put("Sreeram", Color.GREEN);
        favColors.put("Cam", Color.BLUE);
        favColors.put("Nimai", Color.RED);

        //Two different elements can have the same value
        favColors.put("Kaitlyn", Color.GREEN);

        //The same key cannot have two different values
        favColors.put("Cam", Color.ORANGE); //This will overwrite the previous value

        //create a set of keys in a map
        Set<String> keys = favColors.keySet();
        for(String key : keys)
        {
            System.out.println(key + "(" +key.hashCode() +"): " + favColors.get(key));
        }
    }

}
