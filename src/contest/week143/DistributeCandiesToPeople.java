/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package contest.week143;

import java.util.Arrays;

public class DistributeCandiesToPeople {
    public static void main(String[] args) {

//        int candies = 10, num_people = 3;
        int candies = 7, num_people = 4;
//        int candies = 7, num_people = 1;

        DistributeCandiesToPeople ob = new DistributeCandiesToPeople();
        int[] distributeCandies = ob.distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(distributeCandies));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];

        if (num_people <= 0 || candies <= 0)
            return people;



        int index = 0;
        int counter = 1;
        while (candies > 0 && index <= num_people - 1) {
            people[index] += counter;

            if (candies >= counter) {
                candies = candies - counter;
            } else {
                break;
            }

            counter++;
            index++;

            if (index == num_people) {
                index = 0;
            }

            if(candies < counter){
                break;
            }

        }

        if (candies > 0) {
            people[index] += candies;
        }

        return people;
    }
}
