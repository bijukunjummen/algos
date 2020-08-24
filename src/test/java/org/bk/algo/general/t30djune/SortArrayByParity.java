package org.bk.algo.general.t30djune;


class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int numEvens = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                numEvens++;
            }
        }

        int[] res = new int[A.length];
        int evenStart = 0;
        int oddStart = numEvens;
        for (int i = 0; i < A.length; i++) {
            int elem = A[i];
            if (elem % 2 == 0) {
                res[evenStart++] = elem;
            } else {
                res[oddStart++] = elem;
            }
        }

        return res;
    }


}