package leetcodeProblems.medium;

public class WaterAndJug365 {
    public static void main(String[] args) {
        WaterAndJug365 ob = new WaterAndJug365();
        int x = 3, y = 5, z = 4;
        int x2 = 3, y2 = 6, z2 = 5;
        int x3 = 4, y3 = 6, z3 = 8;
        int x4 = 34, y4 = 5, z4 = 6;
        int x5 = 0, y5 = 2, z5 = 1;
        int x6 = 0, y6 = 2, z6 = 0;
        int x7 = 11, y7 = 3, z7 = 13;
        int x8 = 2, y8 = 6, z8 = 5;
        System.out.println(ob.canMeasureWater(x, y, z));
        System.out.println(ob.canMeasureWater(x2, y2, z2));
        System.out.println(ob.canMeasureWater(x3, y3, z3));
        System.out.println(ob.canMeasureWater(x4, y4, z4));
        System.out.println(ob.canMeasureWater(x5, y5, z5));
        System.out.println(ob.canMeasureWater(x6, y6, z6));
        System.out.println(ob.canMeasureWater(x7, y7, z7));
        System.out.println(ob.canMeasureWater(x8, y8, z8));
    }

    public boolean canMeasureWater(int x, int y, int z) {

        if (x + y < z)
            return false;

        if (x > y)
            return canMeasureWaterUtil(y, x, z);

        else
            return canMeasureWaterUtil(x, y, z);
    }


    public boolean canMeasureWaterUtil(int x, int y, int z) {
        if (x > y)
            return canMeasureWaterUtil(y, x, z);

        if (z == x || z == y || x + y == z)
            return true;

        if ((x == 0 || y == 0) && z > 0)
            return false;


        if (y - x > 0) {
            return z % (y - x) == 0 || canMeasureWaterUtil(x, y - x, z)
                    || ((y - x < x) && canMeasureWaterUtil(y - x, y, z));
        } else {
            return canMeasureWaterUtil(x, y - x, z);
        }
    }

}
