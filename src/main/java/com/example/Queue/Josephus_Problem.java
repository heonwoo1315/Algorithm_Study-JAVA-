package com.example.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus_Problem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        int cnt = 0;
        int lastRemoved = -1; // 마지막으로 제거된 값을 저장
        while(!queue.isEmpty()) {
            int data = queue.poll();
            cnt++;
            if(cnt % k == 0){
                lastRemoved = data; // 제거된 값 업데이트
            } else {
                queue.add(data);
            }
        }

        System.out.println(lastRemoved); // 마지막 제거된 값 출력
    }
}
