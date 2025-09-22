import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	sentence = sentence.replace(".", " . ");
        Scanner scanner = new Scanner(sentence);
    	Stack <String> reverser = new Stack<>();
        String rSentence = "";
        
        while (scanner.hasNext()){
            String word = scanner.next();
            reverser.push(word);
            
            if(word.equals("."))
            {
                int size = reverser.size();
                for (int i = 0; i < size; i++){
                    if (i == 0){
                       reverser.pop();
                    }
                    else if (i == 1){
                        String temp = reverser.pop();
                        rSentence += " "+ temp.substring(0,1).toUpperCase() + temp.substring(1);
                    }
                    else
                    {
                        rSentence += " "+reverser.pop();
                    }
                }
                rSentence += ".";
            }
            
        }
        return rSentence;

    }
}
