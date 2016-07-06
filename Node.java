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
public class Node {
    
    private int value;
    private Node next;
    
    // constructors
    public Node() {
        
    }
    
    public Node(int val) {
        this.value = val;
    }
    
    public Node(int val, Node next) {
        this.value = val;
        this.next = next;
    }
    
    // setters and getters
    public void setValue(int val) { this.value = val; }
    
    public int getValue() { return value; }
    
    public void setNext(Node next) { this.next = next; }
    
    public Node getNext() { return next; }
}
