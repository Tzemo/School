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
public class SeparateChainingHashST<Key, Value> {
    
    private int M = 11701;
    private int N = 0;
    private SequentialSearchST<Key, Value>[] st;
    private int cols;
   
    public SeparateChainingHashST() {

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    private int hash(Key key) {
       int hash = 7;
        String strKey = key.toString();
        for (int i = 0; i < strKey.length(); i++) {
            hash = ((31 * hash) + strKey.charAt(i)) % M; 
        }

        return hash;

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
        int i = hash(key);
        return st[i].get(key);
    } 
    
    public void put(Key key, Value val) {

        int i = hash(key);
        if (!st[i].contains(key)) {
            N++;
        }
        int cols = st[i].put(key, val);
        
        this.cols += cols;
    } 

    public void printCol() {
        System.out.println("Separate Chaining Collisions: " + cols);
    }

}
