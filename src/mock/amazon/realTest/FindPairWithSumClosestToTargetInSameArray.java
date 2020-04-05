package mock.amazon.realTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindPairWithSumClosestToTargetInSameArray {
    public static void main(String[] args) {

        FindPairWithSumClosestToTargetInSameArray ob = new FindPairWithSumClosestToTargetInSameArray();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(10);
        l.add(25);
        l.add(35);
        l.add(60);
        ArrayList<Integer> integers = ob.IDsOfSongs(90, l);
        System.out.println(integers);

//        ArrayList<Integer> l = new ArrayList<>();
//        l.add(100);
//        l.add(180);
//        l.add(40);
//        l.add(120);
//        l.add(10);
//        ArrayList<Integer> integers = ob.IDsOfSongs(250, l);
//        System.out.println(integers);

    }

    // Approach - Sorting
    // Time Complexity - (N * logN) where N is size of songDurations
    // Space Complexity - O(N) where N is size of songDurations
    ArrayList<Integer> IDsOfSongs(int rideDuration,
                                  ArrayList<Integer> songDurations) {

        // Corner cases
        if (rideDuration - 30 <= 0 || songDurations == null || songDurations.size() < 2) {
            return new ArrayList<Integer>(0);
        }

        // for lookup of index by value after original songDurations list is sorted
        ArrayList<Integer> copiedList = new ArrayList<>(songDurations);

        // Sorting in ascending order
        songDurations.sort(Comparator.comparingInt(o -> o));

        // Corner case - if least duration song is greater than rideDuration - 30, then no such song pair exist
        if (songDurations.get(0) >= rideDuration - 30) {
            return new ArrayList<Integer>(0);
        }

        int res_l = 0, res_r = 0;  // To store indexes of result pair
        int target = rideDuration - 30;


        // Initialize left and right indexes and difference between
        // pair sum and x
        int l = 0, r = songDurations.size() - 1, diff = Integer.MAX_VALUE;

        // While there are elements between l and r
        while (r > l) {

            // Check if this pair is closer than the closest pair so far
            if (songDurations.get(l) + songDurations.get(r) <= target) {

                if ((target - (songDurations.get(l) + songDurations.get(r))) < diff) {
                    res_l = l;
                    res_r = r;
                    diff = target - (songDurations.get(l) + songDurations.get(r));
                    l++;

                }
                else if (target - (songDurations.get(l) + songDurations.get(r)) == diff) {
                    if (Math.max(songDurations.get(res_l), songDurations.get(res_r)) <
                            Math.max(songDurations.get(l), songDurations.get(r))) {
                        res_l = l;
                        res_r = r;
                    }
                    l++;
                    r--;
                }
            }
            else {
                r--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>(2);
        int v1 = songDurations.get(res_l);
        int v2 = songDurations.get(res_r);
        boolean isV1Found = false;
        boolean isV2Found = false;

        // looking up for index of given number from copiedList
        for (int i = 0; i < copiedList.size(); i++) {


            if (copiedList.get(i) == v1){
                ans.add(i);
                isV1Found = true;
            }

            if (copiedList.get(i) == v2) {
                ans.add(i);
                isV2Found = true;
            }

            if (isV1Found && isV2Found) {
                break;
            }
        }

        return ans;

    }


}
