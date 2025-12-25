package com.example.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class 공원 {
    public int solution(int[] mats, String[][] park){
        // Integer[]로 변환하고 내림차순 정렬
        Integer[] sortedMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedMats, Collections.reverseOrder());

        int rows = park.length;
        int cols = park[0].length;

        for (int size : sortedMats) {
            boolean found = false;

            for (int i = 0; i <= rows - size; i++) {
                for (int j = 0; j <= cols - size; j++) {
                    boolean check = true;

                    for (int dx = 0; dx < size; dx++) {
                        for (int dy = 0; dy < size; dy++) {
                            if (!park[i + dx][j + dy].equals("-1")) {
                                check = false;
                                break;
                            }
                        }
                        if (!check) break;
                    }

                    if (check) {
                        return size; // 정답을 바로 리턴
                    }
                }
            }
        }

        return -1; // 모든 크기에 실패한 경우
    }
}
