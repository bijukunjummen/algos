package org.bk.algo.sort.algo07.kic;

public class KeyIndexedCountingSort {

    public static void sort(Item<String>[] items, int radix) {
            int length = items.length;
            int[] count = new int[radix+1];
            @SuppressWarnings("unchecked")
            Item<String>[] aux = (Item<String>[])new Item[length]; 
            
            for (int i=0;i<length;i++){
                count[items[i].key()+1]++;
            }
            
            for (int r=0;r<radix;r++){
                count[r+1] += count[r];
            }
            
            for (int i=0;i<length;i++){
                aux[count[items[i].key()]++] = items[i]; 
            }
            
            for (int i=0;i<length;i++){
                items[i] = aux[i];
            }
    }

}
