package org.example;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 */
public class StringToInteger {
    public static void main(String[] args) {

        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi(" b11228552307"));

    }

    public int myAtoi(String s) {
        int val = 0;

        try {
            val = Integer.parseInt(s);
            if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE)
                val = 0;

            return val;

        } catch (Exception ex) {

        }
        char[] chars = s.toCharArray();
        String intVal = "";
        boolean positive = true;

        for (int i = 0; i < chars.length; i++) {



            if (!(Character.isDigit(chars[i]) || isSign(chars[i]) || String.valueOf(chars[i]).equals(" ")))
                break;
            if(isSign(chars[i]) && i+1 < chars.length && !Character.isDigit(chars[i]))
                break;


            while (i < chars.length && (Character.isDigit(chars[i]))) {






                    intVal = intVal + chars[i];


                i++;

            }


        }
        if (intVal.isBlank())
            return 0;
        else if (!positive)
            intVal = "-" + intVal;

        try {
            long value = Long.parseLong(intVal);
            if (value < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (value > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int) value;

        } catch (Exception ex) {
            if(intVal.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else
               return Integer.MAX_VALUE;
        }



    }
    private boolean isSign(char c) {
        return String.valueOf(c).equals("-") || String.valueOf(c).equals("+");
    }
}
