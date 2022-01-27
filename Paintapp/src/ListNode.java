/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * * @author Antonia Nikolaidou icsd17134 -- Christina Tsamoglou icsd17199

 */

//κλαση για τους κομβους της λιστας
public class ListNode<T> {
  private T data;
  private ListNode next;

  // Constructor
  public ListNode( T nodeData ) {
      this( nodeData, null);
  }
   
  // Constructor
  public ListNode( T nodeData, ListNode nodeNext ) {
      data = nodeData;
      next = nodeNext;
  }
   
  //μεθοδος για να παιρνει τα δεδομενα του καθε αντικειμενου
  public T getData() {
      return data;
  }
   
  // μεθοδο για να επιστρεφεται το επομενο αντικειμενο
  public ListNode getNext() {
      return next;
  }
   
  // μεθοδος για εισαγωγη δεδομενων
  public void setData( T newData ) {
      data = newData;
  }
   
   
  
  public void setNext( ListNode newNext ) {
      next = newNext;
  }
}
