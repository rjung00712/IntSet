/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richardjung_a1;

import richardjung_a1.Node;

public class IntSet implements Set {
    // data members
    private Node head;  // first node in linkedlist
    private Node tail;  // last node in linkedlist
    private int count;  // keeps track of size of linkedlist
    
    public IntSet() {}
    
    // returns true if value is in set, false otherwise
    public boolean contain(int val) { 
        Node cursor = head; // start at the head node
        while(cursor != null) { // iterate through the list to find the value
            if(val == cursor.getValue()) 
                return true;
      
            cursor = cursor.getNext();
        }
        return false; 
    }
    
    // removes node containing the value from set, if not contained, do nothing

    /**
     *
     * @param val
     */
    @Override
    public void remove(int val) {
        Node cursor = head;
        
        if(cursor == null)
            ;
        else if(cursor.getValue() == val) {
            head = head.getNext();
            count--;
        }
        else {
            while(cursor.getNext().getNext() != null) {
                if(cursor.getNext().getValue() == val) {
                    cursor.setNext(cursor.getNext().getNext()); 
                    count--;
                    break;
                }
                    cursor = cursor.getNext();
            }   
            if(cursor.getNext().getValue() == val) {
                cursor.setNext(cursor.getNext().getNext());
                tail = cursor;
                count--;
            }
        }   
    }
    
    // add node with given value to Set. if already exists, do nothing
    @Override
    public void addElement(int val) {
        Node cursor = head;
        
        if(cursor == null) {    // if empty set, create a node
            head = tail = new Node(val);
            count++;
        } else {    // add to end and also check if value already exists
            while((cursor.getValue() != val) && (cursor.getNext() != null)) {
                cursor = cursor.getNext();      
            }
            if(cursor.getValue() != val) {
                cursor.setNext(new Node(val));
                tail = cursor.getNext();
                count++;
            }   
        }   
    }
    /*
    public Node getHead() {
        return this.head;
    }
    
    public Node getTail() {
        return this.tail;
    }
    */
    
    // returns integer equal to number of distinct nodes in Set
    public int size() { return count; }
    
    // returns boolean value true if every element in givenSet is 
    // in current set false otherwise
    public boolean subsetOf(IntSet givenSet) {
        Node cursor = head; // head of this linked list object
        
        if(cursor == null)  // if givenSet is empty set
            return true;
        // if current set is bigger than givenSet, it can't be subset
        else if(this.size() > givenSet.size()) 
            return false;
        else {
            while(cursor != null) {
                if(!givenSet.contain(cursor.getValue())) {
                    return false;
                }
                cursor = cursor.getNext();
            }
            // check last node of given set if it contains the last element
//            if(givenSet.contain(cursor.getValue())) 
//                return true;
        }   
            return true;
    }
    
    // returns true if both sets contain same elements where order in either
    // set does not count
    public boolean isEqual(IntSet givenSet) {
        Node cursor = head;
        boolean equals;

        if(this.size() != givenSet.size())  // if not same size, can't be equal
            return false;
        else 
            equals = this.subsetOf(givenSet);
            
        return equals;
    }
    
    /* if A, B, C are sets, has the form C=A.union(B). Union returns 
       a Set that contains all the elements in set A and B, but only list
       duplicates once. return a new IntSet for the result without modifying 
       existing or givenSet */
    public IntSet union(IntSet givenSet) {
        IntSet newSet = new IntSet();
        Node cursor = head;
        
        // if both sets are empty return empty set
        if(cursor == null && givenSet.head == null)     
            return newSet;
        else if(cursor == null) {   // if set A is empty
            cursor = givenSet.head;
        
            while(cursor != null) {
                newSet.addElement(cursor.getValue());
                cursor = cursor.getNext();
            }
//            newSet.addElement(cursor.getValue());
            return newSet;
        }
        else {
            while(cursor != null) {   // fill newSet with set A
                newSet.addElement(cursor.getValue());
                cursor = cursor.getNext();
            }
//            newSet.addElement(cursor.getValue());
            
            cursor = givenSet.head; // cursor at set B head
            if(cursor == null)   // if set B is empty return newSet with set A
                return newSet;
            else {
                while(cursor != null) {
                    // if there is a duplicate only write it once
                    if(this.contain(cursor.getValue()))
                        cursor = cursor.getNext();
                    else {
                        newSet.addElement(cursor.getValue());
                        cursor = cursor.getNext();
                    }
                }
//                if(this.contain(cursor.getValue()))
//                    return newSet;
//                else
//                    newSet.addElement(cursor.getValue());
            }
        }   
        return newSet;
    }
    
    /* if A, B, C are sets, has form C= A.intersection(B) and returns a set 
       containing only elements that are common to both A and B, but no 
       duplicates. Should return a new IntSet for the result without modifying
       existing or givenSet */
    public IntSet intersection(IntSet givenSet) {
        Node cursor = head;
        IntSet newSet = new IntSet();
         
        if(cursor == null || givenSet.head == null) 
            return newSet;
        else {
            while(cursor != null) {
                if(givenSet.contain(cursor.getValue()))
                    newSet.addElement(cursor.getValue());
                
                cursor = cursor.getNext();
            }
//            if(givenSet.contain(cursor.getValue()))
//                newSet.addElement(cursor.getValue());
        }
        return newSet;
    }
    
    /* if A, B, C are sets, has form C= A.complement(B) and returns a set 
       containing only elements that are in A but not in B. Should return a 
       new IntSet for the result without modifying
       existing or givenSet */
    public IntSet complement(IntSet givenSet) {
        Node cursor = head;
        IntSet newSet = new IntSet();
        
        if(cursor == null)
            return newSet;
        else {
            while(cursor != null) {
                if(givenSet.contain(cursor.getValue())) {
                    cursor = cursor.getNext();
                    count--;
                } else {
                    newSet.addElement(cursor.getValue());
                    cursor = cursor.getNext();
                }
            }
        }  
        return newSet;
    }
    
    // returns a string to represent the Set in the format of "[3, 4, 6, 8]"
    @Override
    public String toString() {
        String res = "[";
        Node cursor = head;
        if(head == null) {
            res += "]";
            return res;
        }
        while(cursor.getNext() != null) {
            res += cursor.getValue() + ", ";
            cursor = cursor.getNext();
        }
        res += cursor.getValue();
        res += "]";
        
        return res;
    }
}
