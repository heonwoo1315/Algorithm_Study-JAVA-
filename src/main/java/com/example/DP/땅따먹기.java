package com.example.DP;

import java.util.Arrays;

public class 땅따먹기 {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) { // 0부터 시작해야 함
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(max, land[i - 1][k]); // 같은 열 제외
                }
                land[i][j] += max;
            }
        }
        return Arrays.stream(land[land.length - 1]).max().getAsInt(); // 마지막 행에서 최대값 반환
    }

    public static void main(String[] args) {
        땅따먹기 obj = new 땅따먹기();
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        int result = obj.solution(land);
        System.out.println("최댓값 점수: " + result); // 출력: 16
    }
}
