package rii.woc31;

import java.util.Scanner;

public class Woc_31_ZeroOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] sequence = new int[n];
            for(int sequence_i=0; sequence_i < n; sequence_i++){
                sequence[sequence_i] = in.nextInt();
            }
            System.out.println(winner(sequence));
            // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
        }
    }

    private static String winner(int[] sequence) {
        return getTurns(sequence) % 2  == 0 ? "Bob" : "Alice";
    }

    private static int getTurns(int[] sequence) {
        int turnsTaken = 0;
        if(sequence.length <= 2) return 0;
        int left_idx = 0;
        int prev_left_idx = -1;
        int i = 1;
        while (i < sequence.length-1){
            int left = sequence[left_idx];
            int right = sequence[i+1];
            int curr = sequence[i];
            // remove the cell
            if(left == 0 && right == 0) {
                turnsTaken++;
                i++;
                // do this trick to avoid repetition
                if((prev_left_idx >= 0)
                        && curr == 1
                        && sequence[prev_left_idx] == 0){
                    turnsTaken++;
                    left_idx = prev_left_idx;
                    prev_left_idx = -1;
                }
            }else {
                prev_left_idx = left_idx;
                left_idx = i;
                i++;
                continue;
            }
        }
        return turnsTaken;
    }
}
