package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCache {
    private final Deque<Integer> queue;
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.queue = new ArrayDeque<>();
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = this.cache.get(key);
        if (result != null) {
            this.queue.remove(key);
            this.queue.add(key);
        }
        return result != null ? result.intValue() : -1;
    }

    public void put(int key, int value) {

        if (queue.contains(key)) {
            queue.remove(key);
        }
        queue.add(key);
        cache.put(key, value);

        if (queue.size() > capacity) {
            int keyToRemove = queue.remove();
            cache.remove(keyToRemove);
        }
    }

}


class LRUCacheTest {
    @Test
    void testLru() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        assertThat(lruCache.get(1)).isEqualTo(1);
        lruCache.put(3, 3);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(4, 4);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(3);
        assertThat(lruCache.get(4)).isEqualTo(4);
    }

    @Test
    void testLru2() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);

        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(2)).isEqualTo(3);
    }

}