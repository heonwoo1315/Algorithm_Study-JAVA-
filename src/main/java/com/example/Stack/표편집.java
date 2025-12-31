package com.example.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> order = new Stack<Integer>(); // 삭제했던 행의 리스트 내 위치 인덱스를 저장
        Stack<Integer> index = new Stack<Integer>(); // 삭제된 행의 실제 번호를 저장 (이름 같은?)
        LinkedList<Integer> graph = new LinkedList<>(); // 현재 살아있는 행의 번호를 저장하는 리스트 (실제 행 번호 보존)
        for(int i=0; i<n; i++)
            graph.add(i);
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c=='D')
                k+=Integer.parseInt(cmd[i].substring(2));
            else if(c=='U')
                k-=Integer.parseInt(cmd[i].substring(2)); // cmd의 2번째 인덱스의 정수 스트링값을 정수로 변환한다음 그 수만큼 -
            else if(c=='C') {
                order.add(k);
                index.add(graph.get(k));
                graph.remove(k);
                if(k==graph.size())
                    k--;
            }
            else if(c=='Z') {
                graph.add(order.peek(), index.pop());
                if(order.pop()<=k) //order.peek()<=k도 되나 테스트
                    k++;  // 복구한 행이 선택된 행보다 작을(위에 있을 경우)경우 선택된 행이 바뀌지 않아야 하므로 k를 증가시켜서 선택된행을 내려야한다.
            }
            //System.out.println(k);
        }
        int temp_index=0;
        for(int i=0; i<n; i++)
        {
            if(i==graph.get(temp_index)) {
                answer+="O";
                temp_index++;
            }
            else
                answer+="X";
        }
        return answer;
    }
}
