package com.example.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speed = {1, 1, 1, 1, 1, 1};

        int[] answer = solution(progresses, speed);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int data = 100 - progresses[i];
            if(data % speeds[i] == 0) {
                queue.add(data/speeds[i]);
            } else {
                queue.add((data / speeds[i])+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            int data2 = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && data2 >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }

        //리스트를 배열로 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
