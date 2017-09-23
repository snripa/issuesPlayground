package rii.practice.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO: not funished
 */
public class CeasarCypher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        System.out.println(encodeCeasar(s.toCharArray(), k));
    }

    private static String encodeCeasar(char[] s, int k) {
        char[] caps = new char[26];
        char[] small = new char[26];
        char cap = 'A', sm = 'a';
        for (int i = 0; i < 26; i++) {
            caps[i] = cap;
            small[i] = sm;
            cap++;
            sm++;
        }

        int shift = k % 26;
        char[] result = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            int currPos = 0;
            if ((ch >= 'A' && ch <= 'Z')) {
                currPos = ch - 'A' ;
                int index = shift > (25 - currPos) ? (shift - (25 - currPos) - 1) : (currPos + shift);
                result[i] = caps[index];
            } else if (ch >= 'a' && ch <= 'z') {
                currPos = ch - 'a' ;
                int index = shift > (25 - currPos) ? (shift - (25 - currPos) - 1) : (currPos + shift);
                result[i] = small[index];

            } else result[i] = s[i];


        }
        return new String(result);
    }


}
