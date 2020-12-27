package org.bk.algo.general;

class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;
        int len = A.length;
        boolean inc = true;
        if (A[len - 1] >= A[0]) {
            inc = true;
        } else {
            inc = false;
        }
        
        boolean isMonotonic = true;
        int curr = A[0];
        for (int i = 1; i < len; i++) {
            if (!((inc && A[i] >= curr) || (!inc && A[i] <= curr))) {
                return false;
            }
            curr = A[i];
        }
        return isMonotonic;
    }
}