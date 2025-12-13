package com.example.DFS;

public class 네트워크 {
    static int[][] computer;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current){
        visited[current] = true;

        for (int i = 0; i < computer.length; i++){
            if (computer[current][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
