package rii.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sergeyr on 9/1/17.
 */
public class TwoChars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        System.out.println(calc(s.toCharArray()));
    }

    private static int calc(char[] chars) {
        if(chars.length <=1 ) return 0;
        int max = 0;

        for (char a = 'a'; a < 'z'; a++){
            for(char b = 'a'; b < 'z'; b++){
                if (a == b) continue;

                int len = 0;
                boolean needFirst = true;
                for(int i = 0; i < chars.length; i++){
                    char curr = chars[i];
                    if(needFirst && curr == b) {len = 0; break;}
                    if(!needFirst && curr == a) {len=0; break;}
                    if(needFirst && curr == a){
                        len++;
                        needFirst= false;
                    } else if(!needFirst && curr == b){
                        len++;
                        needFirst = true;
                    }
                }
                if (len > max) max = len;
            }
        }
        return max;
    }
}
