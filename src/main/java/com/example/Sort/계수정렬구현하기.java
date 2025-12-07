package com.example.Sort;

public class 계수정렬구현하기 {
    private static String solution(String s) {
        int[] counts = new int[26];

        // 문자열의 각 문제에 대한 빈도수를 count배열에 저장
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sortedStr = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char)(i + 'a'));
            }
        }
        return sortedStr.toString();
    }
}
