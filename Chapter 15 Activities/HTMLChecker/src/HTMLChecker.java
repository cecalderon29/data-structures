import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {   Stack <String> tags = new Stack<>();
            // Your code goes here
            while (in.hasNext())
            {
                String tag = in.next();
                if (tag.charAt(0) == '<')
                {
                    if (tag.charAt(1) != '/')
                        tags.push(tag);
                
                    if (tag.charAt(1) == '/')
                    {
                        String openTag = tags.pop();
                        String openTag2 = openTag.replace("<", "").replace(">", "");
                        String closeTag = tag.replace("<", "").replace(">", "").substring(1);
                        if (!openTag2.equals(closeTag))
                        {
                            System.out.println("Error: " + openTag2 + " does not match " + closeTag);
                        }
                        if (openTag2.equals(closeTag))
                        {
                            System.out.println("Success: " + openTag + " matches " + tag);
                        }
                        if (tags.size() == 0)
                        {
                            System.out.println("All Tags Closed");
                        }
                    
                    }
            }
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
