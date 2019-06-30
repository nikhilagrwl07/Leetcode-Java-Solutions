/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class InsertGetRandomInConstantTime380 {
    public static void main(String[] args) {

        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(3));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.remove(1));


    }
}


class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (map.get(val) != null)
            return false;

        int size = list.size();

        // add in list
        list.add(size, val);

        // add in map
        map.put(val, size);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

        if (map.get(val) == null)
            return false;

        int location = map.get(val);

        // update list
        int lastElement = list.get(list.size() - 1);

        list.set(location, lastElement);
        list.remove(list.size() - 1);


        // update map
        map.put(lastElement, location);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random r = new Random();
        int low = 0;        // inclusive
        int high = list.size();  // exclusive
        int randomNumber = r.nextInt(high - low) + low;
        return list.get(randomNumber);
    }
}
