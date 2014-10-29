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
public class LinearProbing<Key, Value> {

    private int N;
    private int M = 11701;
    private Key[] keys;
    private Value[] vals;
    private int cols = 0;

    public LinearProbing() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];

    }

    private int hash(Key key) {

         int hash = 7;
        String strKey = key.toString();
        for (int i = 0; i < strKey.length(); i++) {
            hash = ((31 * hash) + strKey.charAt(i)) % M; 
        }

        return hash;

    }

   public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (hash(key) == (hash(keys[i]))) {
                cols++;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {

            if (keys[i].equals(key)) {
                return vals[i];
            }

        }
        return null;

    }

    public void printCol() {
        System.out.println("Linear Probing Collisions: " + cols);
    }

}
