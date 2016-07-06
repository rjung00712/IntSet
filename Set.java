/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richardjung_a1;

/**
 *
 * @author Richard
 */
public interface Set {
    void remove(int val);
    
    // add node with given value to Set. if already exists, do nothing
    void addElement(int val);
        
    /*
    public Node getHead() {
        return this.head;
    }
    
    public Node getTail() {
        return this.tail;
    }
    */
    
    // returns integer equal to number of distinct nodes in Set
    int size(); 
    
    // returns boolean value true if every element in givenSet is 
    // in current set false otherwise
    boolean subsetOf(IntSet givenSet);
    
    // returns true if both sets contain same elements where order in either
    // set does not count
    boolean isEqual(IntSet givenSet);
    
    /* if A, B, C are sets, has the form C=A.union(B). Union returns 
       a Set that contains all the elements in set A and B, but only list
       duplicates once. return a new IntSet for the result without modifying 
       existing or givenSet */
    IntSet union(IntSet givenSet);
    
    /* if A, B, C are sets, has form C= A.intersection(B) and returns a set 
       containing only elements that are common to both A and B, but no 
       duplicates. Should return a new IntSet for the result without modifying
       existing or givenSet */
    IntSet intersection(IntSet givenSet);
    
    /* if A, B, C are sets, has form C= A.complement(B) and returns a set 
       containing only elements that are in A but not in B. Should return a 
       new IntSet for the result without modifying
       existing or givenSet */
    IntSet complement(IntSet givenSet);
    // returns a string to represent the Set in the format of "[3, 4, 6, 8]"
    
    @Override
    String toString(); 
}
