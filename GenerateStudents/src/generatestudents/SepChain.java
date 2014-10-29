/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestudents;

/**
 *
 * @author duytran
 */
public class SepChain<Key, Value> {

    private int M = 10501;
    private Node[] st = new Node[M];
    private int cols;

    private static class Node {

        Object key;
        Object val;
        Node next;

        Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int hash(Key key) {
        
        String ldap = key.toString();
        
        int hash = 13;
        
        for (int i = 0; i < ldap.length(); i++) {
            hash = 31 * hash + ldap.charAt(i);
        }
        
        return (hash & 0x7fffffff) % M;
        
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (hash(key) == hash((Key) x.key) ) {
                cols++;
            }
        }

        st[i] = new Node(key, val, st[i]);
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }
        return null;

    }
    
    public int getJeColjon() {
        return cols;
    }
    
}
