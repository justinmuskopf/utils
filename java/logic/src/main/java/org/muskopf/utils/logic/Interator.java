package org.muskopf.utils.logic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * A class that provides an iterable integer similar to Python's <code>for i in range(5)</code>
 * Example Usage:
 *  <code>
 *      for (Integer i : Interator.get(5) {
 *
 *
 *      }
 *  </code>
 */
public class Interator implements Iterable<Integer> {
    private Integer limit;
​
    Interator(int limit) {
        this.limit = limit;
    }
​
    public static Interator get(int max) {
        return new Interator(max);
    }
​
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            final int max = limit;
            private int current = 0;
​
            @Override
            public boolean hasNext() {
                return current < max;
            }
​
            @Override
            public Integer next() {
                if (hasNext()) {
                    return current++;
                } else {
                    throw new NoSuchElementException();
                }
            }
​
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Can't remove values from a Range");
            }
        };
    }
}