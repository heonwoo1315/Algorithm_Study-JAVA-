package com.example.Implement;

public class TakingOutBox {
    public int solution(int n, int w, int num) {
        int floor = (num - 1) / w; // num의 행 위치 정하기
        int location;
        if (floor % 2 == 0) { // num의 열 위치 정하기
            location = (num - 1) % w;
        } else {
            location = (w - 1) - ((num - 1) % w);
        }
        // 총 몇층까지 있는지 계산
        int totalfloor = (n - 1) / w;
        int answer = 0;

        for (int i = floor; i <= totalfloor; i++) {
            int currentBoxNum;
            if (i % 2 == 0) {
                currentBoxNum = (i * w) + (location + 1);
            } else {
                currentBoxNum = (i * w) + (w - location);
            }

            if (currentBoxNum <= n){
                answer++;
            }
        }
        return answer;
    }
}
