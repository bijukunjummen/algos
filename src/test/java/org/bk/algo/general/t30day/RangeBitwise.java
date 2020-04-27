package org.bk.algo.general.t30day;

class RangeBitwise {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = result & i;
        }
        return result;
    }
}