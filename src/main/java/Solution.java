public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        boolean even = false;
        if(n % 2 == 0){
            even = true;
        }
        long leftH = 0;
        long rightH = 0;
        if(even){
            leftH = hash(s, 0, n / 2 - 1);
            rightH = hash(s, n / 2, n - 1);
        }else{
            leftH = hash(s, 0, n / 2 - 1);
            rightH = hash(s, n / 2 + 1, n - 1);
        }

    }
    private long hash(String key, int start, int end) {
        long h = 0;
        for (int j = start; j <= end; j++){
            h = (26 * h + key.charAt(j)) % (long)(Math.pow(2,45) - 1);
        }
        return h;
    }
}
