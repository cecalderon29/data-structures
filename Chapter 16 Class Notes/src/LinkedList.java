import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    //first refers tro the first node in the list
    //if the list is empty, first is null
    private Node first;
    

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if (first == null) throw new NoSuchElementException();
        return this.first.element;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if (first == null) throw new NoSuchElementException();


        Object element = first.element;
        first = first.next;
        return element;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = first;
        first = newNode;
    }
    /**
     * Checks size of linked list
     * @return size
     */
    /* Not recursive
    public int size(){
        int size = 0;
        Node current = first;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    */
    /**
     * Checks size of linked list
     * @param current
     * @return size
     */
    //Recursize 
    public int size(Node current){
        int size = 0;
        if (current == null)
            return size;
        return 1 + size(current.next);
    }
    /**
     * Checks whether linked list contains an objects
     * @return object obj
     */
    /* Not recursive
    public boolean contains(Object obj){
        boolean contains = false;
        Node current = first;
        while (current != null){
            if (current.element == obj){
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }
    */
    /**
     * Checks whether linked list contains an objects
     * @param current
     * @param obj
     * @return
     */
    //Recursive
    public boolean contains(Node current, Object obj){
        if (current == null){
            return false;
        }
        if (current.element == obj){
            return true;
        }
        return contains(current.next, obj);
        
    }
    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator();

    }

    public String toString(){
        ListIterator listIterator = listIterator();

        String allElements = "[";
        while (listIterator.hasNext()){
            allElements += listIterator.next() + ", ";
        }

        return allElements + "]";

    }


    //Class Node
    //Node is static because it does not access any thimg in the LinkedList class
    //will store information not interact
    private static class Node
    {
        public Node next;
        public Object element;

    }

    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            previous = position;

            if (position == null){
                position = first;
            }
            else 
            {
                position = position.next;

            }
            isAfterNext= true;

            return position.element;
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            //check if list is empty
            if ( position == null) {
                return first!= null;
            }
            //the iterator has moved so check next node
            return position.next != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element){
            //check if iterator is at beginning of list
            if (position == null){
                addFirst(element);
                position = first;
            }
            else {
                Node newNode = new Node();
                newNode.element = element;
                newNode.next = position.next;
                
                //set next element of the CURENT postion to point to the new node
                position.next = newNode;
                position = newNode;

            }
            isAfterNext = false;
        }





        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(){
            if (!isAfterNext){
                throw new IllegalStateException();
            }
            //Check if iterator is at begginning 
            if (position == first){
                removeFirst();
                position = null;
            }
            else {
                previous.next = position.next;
                position = previous;
            }
            isAfterNext = false;
        }






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set (Object element){
            if (!isAfterNext){
                throw new IllegalStateException();
            }
            position.element = element;
            //We dont have to reset isAfterNExt because the structure of the list has not changed

        }



    }//LinkedListIterator
}//LinkedList
