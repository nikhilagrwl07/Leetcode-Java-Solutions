/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set4;

public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        CompareVersionNumbers165 ob = new CompareVersionNumbers165();

//        String s1 = "0.1";
//        String s2 ="1.1";

//        String s1 = "1.0";
//        String s2 ="1";

        String s1 = "1";
        String s2 = "1.1";
        int compareVersion = ob.compareVersion(s1, s2);
        System.out.println(compareVersion);

    }

    public int compareVersion(String version1, String version2) {

        String[] splitV1 = version1.split("\\.");
        String[] splitV2 = version2.split("\\.");

        int min = Math.min(splitV1.length - 1, splitV2.length - 1);
        int index = 0;

        while (index <= min) {

            int i = Integer.parseInt(splitV1[index]);
            int j = Integer.parseInt(splitV2[index]);
            if (i < j) {
                return -1;
            } else if (i > j) {
                return 1;
            }
            index++;
        }

        if (splitV2.length - 1 < splitV1.length - 1) {

            while (index <= splitV1.length - 1) {
                int i = Integer.parseInt(splitV1[index]);
                if (i != 0) {
                    return 1;
                }
                index++;
            }
        } else if (splitV2.length - 1 > splitV1.length - 1) {
            while (index <= splitV2.length - 1) {
                int i = Integer.parseInt(splitV2[index]);
                if (i != 0) {
                    return -1;
                }
                index++;
            }
        }

        return 0;
    }
}
