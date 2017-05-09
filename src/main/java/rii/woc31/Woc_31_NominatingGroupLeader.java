package rii.woc31;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Woc_31_NominatingGroupLeader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] v = new int[n];
            for (int v_i = 0; v_i < n; v_i++) {
                v[v_i] = in.nextInt();
            }
            int g = in.nextInt();
            for (int a1 = 0; a1 < g; a1++) {
                int l = in.nextInt();
                int r = in.nextInt();
                int x = in.nextInt();
                System.out.println(getLeader(v, l, r, x));
            }
        }
    }

    private static int getLeader(int[] v, int l, int r, int x) {
        Map<Integer, Integer> votesScored = new HashMap<>();
        int left = r - l + 1;
        int leaderScore = 0;

        for (int i = l; i <= r; i++) {
            if((x - leaderScore) > left) return -1;
            int curr_v = v[i];
            Integer currScored = votesScored.getOrDefault(curr_v, 0) + 1;
            if(leaderScore < currScored) leaderScore = currScored;
            votesScored.put(curr_v, currScored);
            left--;
        }
        int candidate = -1;
        for (Map.Entry<Integer, Integer> e : votesScored.entrySet()) {
            if (e.getValue() == x) {
                if (candidate == -1 || e.getKey() < candidate) candidate = e.getKey();
            }
        }

        return candidate;
    }
}
