// package org.bk.algo.general.t30sep;
//
// import org.jetbrains.annotations.NotNull;
//
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
//
// class MaxDistance {
//     public int maxDistance(List<List<Integer>> arrays) {
//         List<Pair> pairs = new ArrayList<>();
//         int idx = 0;
//         for (List<Integer> arr : arrays) {
//             pairs.add(new Pair(first(arr), idx));
//             pairs.add(new Pair(last(arr), idx));
//             idx++;
//         }
//
//         Collections.sort(pairs);
//         Pair min = first(pairs);
//         Pair max = last(pairs);
//         if (min.arr != max.arr) {
//             return max.num - min.num;
//         }
//         return Math.max(pairs.get(1).num - )
//     }
//
//
//     private <T> T first(List<T> arr) {
//         return arr.get(0);
//     }
//
//     private <T> T last(List<T> arr) {
//         return arr.get(arr.size() - 1);
//     }
//
//     static class Pair implements Comparable<Pair>{
//         int num;
//         int arr;
//
//         public Pair(int num, int arr) {
//             this.num = num;
//             this.arr = arr;
//         }
//
//         @Override
//         public int compareTo(@NotNull Pair o) {
//             return this.num - o.num;
//         }
//     }
// }