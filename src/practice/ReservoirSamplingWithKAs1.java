package practice;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSamplingWithKAs1 {
    public static void main(String[] args) {
        ReservoirSamplingWithKAs1 ob = new ReservoirSamplingWithKAs1();
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 1;
        ob.selectKRandom(stream, k);
    }

    public void selectKRandom(int[] a, int k) {
        if (k == a.length)
            return;

        Random r = new Random();
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int index = r.nextInt(i + 1); // 0 to i

            if (index < k) {
                result = a[i];
            }
            System.out.println("stream last index = " + i + " : random number = " + result);
        }
    }
}
