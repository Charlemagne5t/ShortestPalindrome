import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        String s = "aacecaaa";
        String expected = "aaacecaaa";
        String actual = new Solution().shortestPalindrome(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "abcd";
        String expected = "dcbabcd";
        String actual = new Solution().shortestPalindrome(s);

        Assert.assertEquals(expected, actual);
    }
}
