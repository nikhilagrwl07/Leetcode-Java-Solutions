/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class BulbSwitcher319 {
    public static void main(String[] args) {
        BulbSwitcher319 ob = new BulbSwitcher319();
        int bulbOn = ob.bulbSwitch(10);
        System.out.println(bulbOn);
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);

    }
}
