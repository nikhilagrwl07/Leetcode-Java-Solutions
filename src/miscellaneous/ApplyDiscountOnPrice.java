package miscellaneous;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ApplyDiscountOnPrice {
    public static void main(String[] args) {
        ApplyDiscountOnPrice ob = new ApplyDiscountOnPrice();

        String str = "The price of Nike Air Jordans in $100.99 ";
        String discountedString = ob.applyDiscount(str, new BigDecimal(15));
        System.out.println(discountedString);
    }


    public String applyDiscount(String input, BigDecimal discountPercent) {
        if (input == null || input.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder(input);

        // assuming last value from $ from end is givenPrice
        int index = sb.lastIndexOf("$");

        if (index == -1) {
            return "";
        }

        BigDecimal discountFactor = new BigDecimal(1).subtract(discountPercent.divide(new BigDecimal(100)));

        BigDecimal givenPrice = new BigDecimal(sb.substring(index + 1, sb.length() - 1));

        BigDecimal newPrice = givenPrice.multiply(discountFactor).setScale(2, RoundingMode.CEILING);
        sb.replace(index + 1, sb.length() - 1, String.valueOf(newPrice));
        return sb.toString();
    }
}
