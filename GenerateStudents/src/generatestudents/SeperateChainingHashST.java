/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generatestudents;

/**
 *
 * @author duytran
 * @param <key>
 * @param <value>
 */
public class SeperateChainingHashST<Key, Value> {
    
    private int M = 97;
    private Node[] st = new Node[M];
    
    private int hash (Key key) {
        
        return (key.hashCode() & 0x7fffffff) % M;
        
    }
    
    public Value get(Key key) {
        
        int i = hash(key);
        
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }
    
    public void getAll(Key key) {
        
        int i = hash(key);
        
        int counter = 0;
        for (Node x = st[i]; x != null; x = x.next) {
            System.out.println(++counter);
            System.out.println("The value for key " + i + " is " + x.val);
            
        }
        
    }
    
    public void put(Key key, Value val) {
        
        int i = hash(key);
        
        
        
        for (Node current = st[i]; current != null; current = current.next) {
            if (current.next == null ){ 
                if (key.equals(current.key)) {
                    
                   Node node = new Node(key, val, null);
                   current.next = node;
                   return;
                } 

            }
            
        }
        st[i] = new Node(key, val, null);
        
    }
    
    private static class Node {
    
        private Object val;
        private Object key;
        private Node next;
               
        public Node(){
            
        }
        
        
        
        public Node (Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
        
    }
    
}
