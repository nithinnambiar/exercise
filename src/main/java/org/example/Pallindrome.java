package org.example;

public class Pallindrome {

    public boolean isPallindrome(String str) {

        int len = str.length();
        int j = len -1;
        char[] chArr = str.toCharArray();
        for(int i=0; i < len && i < j ; i++) {
            if(chArr[i]!=chArr[j])
                return false;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String val ="nithin";
        Pallindrome pallindrome = new Pallindrome();
        System.out.println(pallindrome.isPallindrome(val));
    }
}
