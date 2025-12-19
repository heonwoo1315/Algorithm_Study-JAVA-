package com.example.Hash;

import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 메일을 받은 횟수
        HashMap<String, Integer> idMap = new HashMap<>(); // 유저 순서저장
        HashMap<String, HashSet<String>> map = new HashMap<>(); // 각 유저별 자신을 신고한 유저 set
        // ket값이 신고받은 사람, value값이 신고한 사람

        // init
        for(int i=0; i<id_list.length;i++){
            idMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }

        // 자신을 신고한 유저이름 저장
        for(String r : report){
            String[] str = r.split(" ");
            map.get(str[1]).add(str[0]);
        }

        // 여기서부터 chatgpt도움
        // 유저별 신고당한 횟수가 k보다 많으면 메일보냄
        for(int i=0; i<id_list.length;i++){
            HashSet<String> set = map.get(id_list[i]); // 해당 유저를 신고한 유저 set
            if(set.size() >= k){ // 신고받은 횟수가 k보다 크거나 같을경우
                for(String userId : set){
                    answer[idMap.get(userId)]++;
                }
            }
        }

        return answer;
    }
}
