package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfDigits {
    public int solution(int[] A) {
        // Collect the sum of the digits to the numbers as a map
        // The values of the map is a Priority queue to bubble up the largest numbers
        Map<Integer, PriorityQueue<Integer>> sumToNumbers = new HashMap<>();

        // Looping through the entire array once
        for (int n : A) {
            int sum = sumOfDigits(n);
            // Creating a Priority Queue to hold the largest numbers
            // Priority queue only needs to hold the largest 2..
            sumToNumbers.computeIfAbsent(sum, (k) -> new PriorityQueue<>(2));
            PriorityQueue<Integer> pq = sumToNumbers.get(sum);
            if (pq.size() < 2) {
                pq.add(n);
            } else if (n > pq.peek()) {
                pq.poll();
                pq.add(n);
            }
        }

        int max = -1;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : sumToNumbers.entrySet()) {
            int maxForSum = maxForSum(entry.getValue());
            if (maxForSum > max) {
                max = maxForSum;
            }
        }
        return max;
    }

    private int maxForSum(PriorityQueue<Integer> maxPq) {
        if (maxPq.size() < 2) {
            return -1;
        }

        return maxPq.poll() + maxPq.poll();
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }

    @Test
    void testSumDigits() {
//        Assertions.assertThat(sumOfDigits(15)).isEqualTo(6);
        assertThat(solution(new int[]{51, 71, 17, 42})).isEqualTo(93);
//        Assertions.assertThat(solution(new int[]{42, 33, 60})).isEqualTo(102);
//        Assertions.assertThat(solution(new int[]{51, 32, 43})).isEqualTo(-1);
//        Assertions.assertThat(solution(new int[]{765, 675, 567})).isEqualTo(solution(new int[]{675, 567, 765}));
    }
}

class SimpleMachine {
    public int solution(String S) {
        String[] tokens = S.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else if (isPop(token)) {
                if (stack.peek() == null) {
                    return -1;
                }
                stack.pop();
            } else if (isDup(token)) {
                if (stack.peek() == null) {
                    return -1;
                }
                Integer n = stack.pop();
                stack.push(n);
                stack.push(n);
            } else if (isPlus(token)) {
                if (stack.peek() == null) {
                    return -1;
                }
                Integer n1 = stack.pop();
                if (stack.peek() == null) {
                    return -1;
                }
                Integer n2 = stack.pop();
                stack.push(n1 + n2);
            } else if (isMinus(token)) {
                if (stack.peek() == null) {
                    return -1;
                }
                Integer n1 = stack.pop();
                if (stack.peek() == null) {
                    return -1;
                }
                Integer n2 = stack.pop();
                stack.push(n1 - n2);
            } else {
                return -1;
            }
        }

        if (stack.size() == 0) {
            return -1;
        }
        return (Integer) stack.pop();
    }

    private boolean isPlus(String token) {
        return token.equals("+");
    }

    private boolean isMinus(String token) {
        return token.equals("-");
    }

    private boolean isDup(String token) {
        return token.equals("DUP");
    }

    private boolean isPop(String token) {
        return token.equals("POP");
    }

    private boolean isNumber(String token) {
        char[] arr = token.toCharArray();
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    interface Expression {
        boolean isOperand();
    }

    class NumberExpression implements Expression {
        int n;

        NumberExpression(int n) {
            this.n = n;
        }

        @Override
        public boolean isOperand() {
            return true;
        }
    }


    @Test
    void testExpression() {
        assertThat(solution("13 DUP 4 POP 5 DUP + DUP + -")).isEqualTo(7);
        assertThat(solution("13 - -")).isEqualTo(-1);
        assertThat(solution("13 5 +")).isEqualTo(18);
    }
}

