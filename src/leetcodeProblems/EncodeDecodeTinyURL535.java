/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeTinyURL535 {
    public static void main(String[] args) {

    }

}


class Codec {

    private String encodingBase = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<String, String> shortToLongUrl = new HashMap<>();
    Random r = new Random();

    public String getShortUrl() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count <= 61) {
            sb.append(encodingBase.charAt(r.nextInt(62)));
            count++;
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String shortUrl = getShortUrl();

        if(shortToLongUrl.containsKey(shortUrl)){
            shortUrl = getShortUrl();
        }

        shortToLongUrl.put(shortUrl, longUrl);
        return "http://tinyurl.com/" + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongUrl.getOrDefault(shortUrl.replace("http://tinyurl.com/", ""), "");
    }
}
