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
    
    private int M = 15401;
    private int N = 0;
    private Node[] st = new Node[M];
    private Node oldNode = null;
    private int firstKey;
    private int sum;

    private int hash (Key key) {
        
        String ldap = key.toString();
        
        int hash = 13;
        
        for (int i = 0; i < ldap.length(); i++) {
            hash = 31 * hash + ldap.charAt(i);
        }

        return (hash & 0x7fffffff) % M;
 
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
        
        int counter = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("|Counter|\t|Key|\t\t|value|\n");
        
        Node x;
        for (x = st[i]; x != null; x = x.next) {
            System.out.println("    " + counter++ + "\t\t  " + x.key + "\t\t " + x.val);
        }
        
        x = st[i];
   
    }
    
    public void printCollisionsForKey(Key key) {  
        
        int i = hash(key);
        
        Node x = st[i];

        if (x != null) {

            sum += x.collisions;
            
        }
        
        System.out.println(sum);
        
    }
    
    public void put(Key key, Value val) {
        
        int i = hash(key);

        for (Node x = st[i]; x != null; x = x.next) {
            
            if (key.equals(x.key)) {
                x.val = val;
                
                // Stopt de methode vroegtijdig.
                return;
            } 

            x.collisions++;

        }
        
        st[i] = new Node(key, val, oldNode);
        oldNode = st[i];

        // Onthoudt de allereerste key.
        // Key's die opnieuw worden doorgegeven in de methode zullen NOOIT hierin belanden.
        firstKey = st[i].hashCode();
        N++;
    }
    
    public int firstKey() {
        return firstKey;
    }

    public int size() {
        return N;
    }
    
    public int printCol() {     
        return sum;
    }
    
    private static class Node {
    
        private Object val;
        private Object key;
        private Node next;
        private int collisions;
                   
        public Node (Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
        
    }
    
}
