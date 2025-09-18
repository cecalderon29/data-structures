import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        //Create a priority que of strings
        //A priority needs tp be composed of Comparable objects
        Queue<String> students = new PriorityQueue<>();
        students.add("Neel");
        students.add("Jonathan");
        students.add("Cam");
        students.add("Kaitlyn");
        students.add("Dylan");

        while (students.size() > 0)
            System.out.println(students.remove());


        //Create todo
        //The workourder class has priotrity and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();
        //Lower priority items are more important

        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(1, "Conquer World"));
        toDo.add(new WorkOrder(9, "Play Videogames"));
        toDo.add(new WorkOrder(1, "Study fpor the test"));

        //Objects not stored in priority order
        System.out.println(toDo);

        //But they are removed in priority order
        while (toDo.size() > 0)
            System.out.println(toDo.remove());
    }

}
