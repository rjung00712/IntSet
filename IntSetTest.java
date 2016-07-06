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
public class IntSetTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IntSet A = new IntSet();
        
        A.addElement(1);
        A.addElement(3);
        A.addElement(5);
        A.addElement(7);
        
        System.out.println("Set A: " + A);
        
        A.remove(1);
        System.out.println("Set A: " + A);
        
        IntSet B = new IntSet();
        
        B.addElement(1);
        B.addElement(3);
        B.addElement(5);
        B.addElement(7);
        
        System.out.println("Set B: " + B);
        
        IntSet C = A.complement(B);
//        System.out.println("first set complement second set: " + C);
        
//        IntSet C = A.intersection(B);
//        System.out.println("C: " + C);
        
//        IntSet D = new IntSet();
        
//        System.out.println(A.intersection(B).subsetOf(A));
        
//        System.out.println(C);
        
//        System.out.println("intersection of these two sets: " + A.intersection(B));
//        System.out.println("union of these two sets: " + A.union(B));
        
//        System.out.println(A.isEqual(B));
        
//        System.out.println(B.subsetOf(A));
//        System.out.println(A.getHead().getValue());
//        System.out.println(A.getTail().getValue());
        
//        System.out.println(A.contain(30));
//        System.out.println(A.size());
    }    
}
