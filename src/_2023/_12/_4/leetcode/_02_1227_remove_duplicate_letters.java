package _2023._12._4.leetcode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _02_1227_remove_duplicate_letters {
    public String removeDuplicateLetters(String s) {

        for (char ch : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(ch));
            if (toSortedSet(suffix).equals(toSortedSet(s))) {
                return ch + removeDuplicateLetters(suffix.replace(String.valueOf(ch), ""));
            }
        }
        return "";
    }

    public Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }


}
