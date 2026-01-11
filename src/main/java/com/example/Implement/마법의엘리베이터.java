package com.example.Implement;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;

            if (digit > 5 || (digit == 5 && storey % 10 >= 5)) {
                // 5 이상이거나 다음 자리도 5 이상이면 올림
                answer += (10 - digit);
                storey++; // 다음 자리 올림 처리
            } else {
                // 그냥 빼는 게 이득
                answer += digit;
            }
        }

        return answer;
    }
}
