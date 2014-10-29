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
    
    private int M = 10501;
    private int N = 0;
    private SequentialSearchST<Key, Value>[] st;
    private int cols;
   
    public SeparateChainingHashST() {

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
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
        int i = hash(key);
        return st[i].get(key);
    } 
    
    public void put(Key key, Value val) {

        int i = hash(key);
        this.cols += st[i].put(key, val);
        N++;
     
    } 

    public void printCol() {
        System.out.println("Separate Chaining Collisions: " + cols);
    }

}
