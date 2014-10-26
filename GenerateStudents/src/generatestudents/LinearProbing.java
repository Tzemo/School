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
    private int M = 128;
    private Key[] keys;
    private Value[] vals;

    public LinearProbing() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int i;
        
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
        
    }
    
    public Value get(Key key) {
        
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) { 
            
            if (keys[i].equals(key)) {
                return vals[i];
            }
            
        }
        return null;
        
    }

}
