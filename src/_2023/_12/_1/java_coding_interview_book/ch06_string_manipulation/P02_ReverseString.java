package _2023._12._1.java_coding_interview_book.ch06_string_manipulation;

// https://leetcode.com/problems/reverse-string/
public class P02_ReverseString {

    public static void main(String[] args) {
        solution1(new char[]{'h','e','l','l','o'});
    }

    public static void solution1(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
