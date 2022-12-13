import java.util.*;
import java.io.*;

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        if(s.substring(0, 1).equals("-")) return false;

        for(int i = 0; i < s.length() / 2; i++) {
            if(!(s.substring(i, i + 1).equals(s.substring(s.length() - i - 1, s.length() - i)))) return false;
        }

        return true;
    }
}