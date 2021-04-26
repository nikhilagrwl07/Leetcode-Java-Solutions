package practice;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {
    public static void main(String[] args) {
        ReservoirSampling ob = new ReservoirSampling();
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 1;
        int[] randomElement = ob.selectKRandom(stream, k);

        System.out.println(Arrays.toString(randomElement));
    }

    public int[] selectKRandom(int[] a, int k) {
        if (k == a.length)
            return a;

        int[] sample = new int[k];
        int i;
        for (i = 0; i < k; i++)
            sample[i] = a[i];

        Random r = new Random();
        for (; i < a.length; i++) {
            int index = r.nextInt(i + 1); // 0 to i

            if (index < k) {
                sample[index] = a[i];
            }
        }

        return sample;

    }
}
