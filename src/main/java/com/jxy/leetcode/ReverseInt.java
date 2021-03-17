package com.jxy.leetcode;

class ReverseInt {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int popInt = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && popInt > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && popInt < -8)) {
                return 0;
            }
            result = result * 10 + popInt;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}