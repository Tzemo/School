/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatestudents;

/**
 *
 * @author Sylvi-Fashion
 */
public class SequentialSearchST<Key, Value> {
 
    private int N;          
    private int M = 10501;
    private Node first;     

 
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    private int hash(Key key) {
        
        String ldap = key.toString();
        
        int hash = 13;
   
        for (int i = 0; i < ldap.length(); i++) {
            hash = (hash * 37 + ldap.charAt(i)) * hash ;
        }
        
        return (hash & 0x7fffffff) % M;

    } 
    
    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }
    
    public int put(Key key, Value val) {

        int cols = 0;
        for (Node x = first; x != null; x = x.next) {
           
            if (hash(key) == hash(x.key)) {
                cols++;
            } 

        }
        first = new Node(key, val, first);
        N++;
        return cols;
    }
 
}
