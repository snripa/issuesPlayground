package rii;

/**
 * Created by sergeyr on 18.05.17.
 */
public class Test {

    public static void main(String[] args) {
        int[] j = new int[20];
        j[0] = 3;
        int g = 2;
        int seed = 2;
        int p = 4;
        System.out.println(0  + "->" + j[0]);
        long start = System.currentTimeMillis();
        for (int i = 1; i < j.length; i++){
            j[i] = (j[i - 1] * g + seed) % p;
            System.out.println(i +  "->" + j[i]);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
