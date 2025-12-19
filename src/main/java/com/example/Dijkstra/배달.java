package com.example.Dijkstra;

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 인접 리스트 구성
        for (int[] r : road) {
            int a = r[0], b = r[1], cost = r[2];
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        // 다익스트라 준비
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // 시작점: 마을 1, 거리 0

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], nowDist = cur[1];

            if (nowDist > dist[now]) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0], cost = next[1];
                if (dist[nextNode] > nowDist + cost) {
                    dist[nextNode] = nowDist + cost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // 배달 가능한 마을 수 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }
}
