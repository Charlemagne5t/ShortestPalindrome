import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String shortestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }

        String rev = new StringBuilder(s).reverse().toString();
        String pattern = s + "#" + rev;
        KMP kmp = new KMP(pattern);

        StringBuilder sb = new StringBuilder(rev);
        int i = kmp.lps[pattern.length() - 1];
        while (i < s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
class KMP {
    int[] lps;
    String pattern;
    int m;

    public KMP(String pattern) {
        this.pattern = pattern;
        m = pattern.length();
        lps = new int[m];
        computeLPSArray();

    }

    public List<Integer> KMPSearch(String text) {
        List<Integer> matches = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        int j = 0;
        int i = 0;

        while (n - i >= m - j){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                matches.add(i - j);
                j = lps[j - 1];
            }
            else if(i < n &&  pattern.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i = i + 1;
                }
            }
        }

        return matches;

    }

    private void computeLPSArray() {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m){
            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }else {
                if(length != 0 ){
                    length  = lps[length - 1];
                }else {
                    lps[i] = length;
                    i++;
                }
            }
        }
    }
}
