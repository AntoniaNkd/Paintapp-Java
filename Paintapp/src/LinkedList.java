
/**
 *
 *  * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199

 */
import java.util.ArrayList;

//κλαση για την κατανομη δεδομενων σε μια απλα συνδεδεμενη λιστα
public class LinkedList<T> {
    private int numberOfNodes = 0; 
    private ListNode<T> front = null;
    
   //μεθοδος για ελεγχο αν ειναι αδεια η λιστα
    public boolean isEmpty() {
        return (front == null);
    }
    
    //μεθοδος για αδειασμα λιστας
    public void makeEmpty() {
        front = null;
        numberOfNodes = 0;
    }
    
    //μεθοδος για επιστροφη του μεγεθους της λιστας
    public int size() {
        return numberOfNodes;
    }
    
   //μεθοδος για προσθηκη κομβου μπροστα
    public void addFront( T element ) {
        front = new ListNode<T>( element, front );
        numberOfNodes++;
    }
    
    //μεθοδος για να κανει return τα daa του πρωτου κομβου
    public T peek() {
        if (isEmpty()) 
            return null;
        
        return front.getData();
    }
    
     //μεθοδος για αφαίρεση κομβου απο μπροστα
    @SuppressWarnings("unchecked")
    public T removeFront() {
        T tempData;
        
        if (isEmpty()) 
            return null;
        
        tempData = front.getData();
        front = front.getNext();
        numberOfNodes--;
        return tempData;
    }
    //μεθοδος για αφαίρεση κομβου απο το τελος
    @SuppressWarnings("unchecked")
    public void removeEnd(T element) {
        ListNode<T> node=front;
        while(node.getNext() != null)
        {
            node = node.getNext();
        }
        node.setNext(new ListNode<T>((T)element, null));
    }
    
    // μεθοδος  για να επιστραφει ολη η λιστα 
    @SuppressWarnings("unchecked")
    public ArrayList<T> getArray() {
        
        ArrayList<T> shapeArray=new ArrayList<T>();
        
        ListNode<T> node=front;
        while (node!=null)
        {
            shapeArray.add(node.getData());
            node = node.getNext();
        }
        
        return shapeArray;
    }
}

   
