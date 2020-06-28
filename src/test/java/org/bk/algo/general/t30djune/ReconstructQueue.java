package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Each person is described by a pair of integers (h, k),
// where h is the height of the person and k is the number of people in front of this person
// who have a height greater than or equal to h
class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            list.add(null);
        }

        Arrays.sort(people, Comparator.comparingInt(arr -> arr[0]));
        for (int i = people.length - 1; i >= 0; i--) {
            int[] person = people[i];
            int potentialIndex = findPotentialIndex(list, person);
            moveOthersAndSetPerson(potentialIndex, person, list);
        }
        return list.toArray(new int[0][0]);
    }

    private void moveOthersAndSetPerson(int potentialIndex, int[] person, List<int[]> list) {
        if (list.get(potentialIndex) == null) {
            list.set(potentialIndex, person);
            return;
        }
        int emptyIndex = potentialIndex;
        while (list.get(emptyIndex) != null) {
            emptyIndex++;
        }

        for (int i = emptyIndex - 1; i >= potentialIndex; i--) {
            list.set(i + 1, list.get(i));
        }
        list.set(potentialIndex, person);

    }

    private int findPotentialIndex(List<int[]> list, int[] person) {
        int potentialIndex = person[1];
        int[] personAtIndex = list.get(potentialIndex);
        while (personAtIndex != null) {
            if (personAtIndex[0] < person[0]) {
                potentialIndex++;
                personAtIndex = list.get(potentialIndex);
            } else {
                return potentialIndex;
            }
        }
        return potentialIndex;
    }

    void printList(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] person = list.get(i);
            if (person != null) {
                System.out.println(i + ":" + person[0] + "," + person[1]);
            } else {
                System.out.println(i + ": null");
            }
        }

    }

    @Test
    void testRecons1() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        for (int[] person : reconstructQueue(people)) {
            System.out.println(person[0] + "," + person[1]);
        }

    }
}