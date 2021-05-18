package com.java.programs;

public class StringLogicalPrograms {
    public static void main(String args[]) {

        String abc ="acbmmbcd";
        int mid = abc.length()/2;
        StringBuilder first = new StringBuilder(abc.substring(0, mid));
        StringBuilder second = new StringBuilder(abc.substring(mid));
        int count = 0;
        while (first.charAt(first.length() - 1) == second.charAt(0) && first.length()>0 && second.length()>0) {
            first.deleteCharAt(first.length() - 1);
            second.deleteCharAt(0);
            count++;
        }
        System.out.println(count);
    }
}
