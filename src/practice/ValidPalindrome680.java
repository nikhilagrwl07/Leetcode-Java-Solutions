//package practice;
//
//public class ValidPalindrome680 {
//    public static void main(String[] args) {
//
//    }
//
//    public boolean validPalindrome(String s) {
//
//        if (s == null || s.length() <= 1)
//            return true;
//
//        // even
//        int len = s.length();
//        if (len % 2 == 0) {
//
//            int l = 0, r = len - 1;
//
//            while (l < r) {
//
//                if (l == len / 2 - 1 && r == len / 2) {
//                    return true;
//                } else if (s.charAt(l) != s.charAt(r)){
//                    return false;
//                }
//                l++;
//                r--;
//            }
//        }
//        else{
//            int l = 0, r = len - 1;
//
//            while (l <= r) {
//
//                if(s.charAt(l) != s.charAt(r)){
//                    return false;
//                }
//                else if(l ==r)
//                l++;
//                r--;
//            }
//
//        }
//
//
//
//
//
//    }
//}
