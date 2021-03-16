package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Set<Character> temp = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c > 47 && c < 58) {
                temp.add(c);
            }
        }
        return temp.size();
    }

}
