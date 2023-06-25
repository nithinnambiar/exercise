package org.example;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 */
public class IntegerReverse {

    public int reverse(int x) {

        if(x <= Integer.MIN_VALUE || x >= (Integer.MAX_VALUE))
            return 0;

        int num = Math.abs(x);
        if(num < 10)
            return (x < 0) ? -num : num;
        int i =0;
        long rev=0;
        while(num > 0)
        {
            int rem =  num % 10;
            num = num/10;
            rev = rev * 10 + rem;
            if(rev <= Integer.MIN_VALUE || rev >= (Integer.MAX_VALUE))
                return 0;
        }


        if(x < 0)
            rev= (int)-rev;
        if(rev <= Integer.MIN_VALUE || rev >= (Integer.MAX_VALUE))
            return 0;


        return (int)rev;

    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse(-1));
    }

}
