package rii.practice.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sergeyr on 22.04.17.
 */
public class JourneyToMoon {

    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        UnionFind uf = new UnionFind(N);

        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            uf.union(a, b);
            // Store a and b in an appropriate data structure of your choice
        }



        long combinations = 0;
        for(int i = 0; i < uf.sz.length; i++ ){
            if(uf.sz[i] > 1){
                if(combinations == 0) combinations = 1;
                combinations *= uf.sz[i];
            }
        }

        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }

    static class UnionFind {
        int[] a;
        int[] sz;
        public UnionFind(int size) {
            a = new int[size + 1];
            sz = new int[size + 1];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
                sz[i] = 1;
            }

        }

        public void union(int i, int j) {
            int ip = find(i);
            int jp = find(j);
            if (sz[ip] < sz[jp]) {
                a[ip] = jp;
                sz[jp] += sz[ip];
            } else {
                sz[ip] += sz[jp];
                a[jp] = a[ip];
            }

        }

        private int find(int i) {
            while (a[i] != i) {
                a[i] = a[a[i]];
                i = a[i];

            }
            return i;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }


}
