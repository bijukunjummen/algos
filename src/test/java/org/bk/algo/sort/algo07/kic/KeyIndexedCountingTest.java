package org.bk.algo.sort.algo07.kic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KeyIndexedCountingTest {
    List<Item<String>> items;
    
    @Before
    public void setUp(){
        items = new ArrayList<Item<String>>();
        items.add(new Item<String>(2, "Anderson"));
        items.add(new Item<String>(3, "Brown"));
        items.add(new Item<String>(3, "Davis"));
        items.add(new Item<String>(4, "Garcia"));
        items.add(new Item<String>(1, "Harris"));
        items.add(new Item<String>(3, "Jackson"));
        items.add(new Item<String>(4, "Johnson"));
        items.add(new Item<String>(3, "Johns"));
        items.add(new Item<String>(1, "Martin"));
        items.add(new Item<String>(2, "Martinez"));
    }
    
    @Test
    public void testKeyIndexCountingSort(){
        @SuppressWarnings("unchecked")
        Item<String>[] itemsArr = (Item<String>[])items.toArray(new Item[0]);
        KeyIndexedCountingSort.sort(itemsArr,5);
        System.out.println(Arrays.toString(itemsArr));
        
    }
}


