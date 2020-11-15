package org.bk.algo.general;

import java.util.ArrayList;
import java.util.List;

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length;i++) {
            int[] v = intervals[i];
            list.add(new Interval(v[0], v[1], "start", i));
            list.add(new Interval(v[1], v[0], "end", i));
        }
        list.sort((i1, i2) -> {
            if (i1.t != i2.t) {
              return i1.t - i2.t;                
            } else {
                return i1.o - i2.o;
            }

        });
        
        int min = 0;
        int parallel = 0;
        for (Interval ival: list) {
            if (ival.s.equals("start")) {
                parallel++;
                if (parallel > min) {
                    min = parallel;
                }
            } else {
                parallel--;
            }
        }
        return min;
    }
    
    static class Interval {
        int t;
        int o;
        String s;
        int idx;
        
        Interval(int t, int o, String s, int idx) {
            this.t = t;
            this.o = o;
            this.s = s;
            this.idx = idx;
        }
    }
}