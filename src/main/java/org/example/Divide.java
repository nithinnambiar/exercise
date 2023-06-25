package org.example;

import java.math.BigDecimal;

public class Divide {
    public static  int divide(int dividend, int divisor) {

        if (dividend > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }



        return new BigDecimal(dividend).divide(new BigDecimal(divisor), BigDecimal.ROUND_DOWN).intValue();

    }

    public static int divideBitWise(long dividend, long divisor) {
        int quotient=0;
        boolean isNegative = dividend <0 || divisor <0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        for(long i=31; i >=0; i--) {
            if((divisor << i) <= dividend){
                dividend = dividend - (divisor << i);
                quotient = quotient + (1 << i);

            }
        }
        return isNegative? -quotient:quotient;
    }

    public static void main(String[] args) {
        System.out.println(Divide.divide(7, -3));
        System.out.println(Divide.divideBitWise(7, -3));
    }

}
