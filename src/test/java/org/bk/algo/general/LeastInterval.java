//package org.bk.algo.general;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class LeastInterval {
//    public int leastInterval(char[] tasks, int n) {
//        Map<Character, Integer> freqMap = new HashMap<>();
//        for (int i = 0; i < tasks.length; i++) {
//            char c = tasks[i];
//            int count = freqMap.getOrDefault(c, 0);
//            freqMap.put(c, count + 1);
//        }
//
//        List<TaskAndFreq> list = new ArrayList<>();
//        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
//            Character c = entry.getKey();
//            Integer count = entry.getValue();
//            list.add(new TaskAndFreq(c, count));
//        }
//
//        list.sort((t1, t2) -> (t2.freq - t1.freq));
//
//
//    }
//
//    private static class TaskAndFreq {
//        Character c;
//        int freq;
//
//        TaskAndFreq(Character c, int freq) {
//            this.c = c;
//            this.freq = freq;
//
//        }
//    }
//}