package org.bk.algo.sort.algo07.kic;

public class Item<T> {
    private final int key;
    private final T entity;
    
    public Item(int key, T entity){
        this.key = key;
        this.entity = entity;
    }
    
    public int key(){
        return this.key;
    }
    
    public T getEnity(){
        return this.entity;
    }
    
    @Override
    public String toString(){
        return String.format("%s:%s",this.entity,this.key);
    }
}
