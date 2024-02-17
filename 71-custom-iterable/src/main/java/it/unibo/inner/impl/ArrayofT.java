package it.unibo.inner.impl;
import java.util.Iterator;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class ArrayofT<T> implements IterableWithPolicy<T>{
    private T[] array;

    public ArrayofT(T[] array){
        this.array = array;
    }
    @Override
    public Iterator<T> iterator() {
        return new InnerArrayofT();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
    };

    private class InnerArrayofT implements Iterator<T>{
        private int i = 0;
        private T currentVal;

        @Override
        public boolean hasNext() {
            if(i <= array.length - 1){
                return true;
            }
            return false;
        }

        @Override
        public T next(){
            currentVal = array[i];
            i++;
            return currentVal;
        }
        
    }
    
}
