package com.example.BruteForce;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i : prices) {
            q.add(i);
        }

        int index = 0;
        while (!q.isEmpty()) {
            int currentPrice = q.poll();
            // currentPrice의 다음 가격부터 반복문을 진행 = i = (prices.length - q.size()
            // q가 제거된 크기만큼 주식 가격 배열의 크기를 빼줘서 결국엔 모든 배열을 탐색하게 만든다 인덱스 1부터, 인덱스 2부터, 인덱스 3부터
            // poll한 횟수만큼 q의 크기가 줄어드므로 결과적으로 prices의 배열에서 주식가격의 첫번째부터 마지막까지 순차적으로 탐색이 가능하다.
            for (int i = (prices.length - q.size()); i < prices.length; i++) {
                // 가격이 떨어 졌을 경우
                if (currentPrice > prices[i]) {
                    answer[index]++;
                    break;
                }
                // 가격이 떨어지지 않았을 경우
                if (currentPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}
