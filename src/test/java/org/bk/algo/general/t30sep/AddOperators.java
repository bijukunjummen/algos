// package org.bk.algo.general.t30sep;
//
// import java.util.ArrayList;
// import java.util.List;
//
// class AddOperators {
//     public List<String> addOperators(String num, int target) {
//         if (num.length() == 0) return List.of();
//         List<List<Character>> paths = traverseAndGeneratePaths(1, List.of(), num.toCharArray());
//         List<String> validPaths = new ArrayList<>();
//         for (List<Character> path: paths) {
//             if (calc(path) == target) {
//                 validPaths.add(convertToString(path));
//             }
//         }
//         Character.getNumericValue()
//         return validPaths;
//     }
//
//     private int calc(List<Character> path) {
//         List<Character> calcPath = new ArrayList<>(path);
//     }
//
//     private List<List<Character>> traverseAndGeneratePaths(int current, List<Character> currentPath, char[] cs) {
//         if (current == cs.length - 1) {
//             List<Character> nextPath = new ArrayList<>(currentPath);
//             nextPath.add(cs[current]);
//             return List.of(currentPath);
//         }
//
//         char currentDigit = cs[current];
//         char[] nextChars = {'+', '-', '*'};
//         List<List<Character>> nextResults = new ArrayList<>();
//         for (char nextChar: nextChars) {
//             List<Character> nextPath = new ArrayList<>(currentPath);
//             nextPath.add(currentDigit)
//             nextPath.add(nextChar);
//
//             nextResults.addAll(traverseAndGeneratePaths(current + 1, nextPath, cs));
//         }
//
//         return nextResults;
//
//     }
// }