package com.example.BFS;

import java.util.*;

public class 지게차와크레인 {
    int n, m;
    char[][] map;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n + 2][m + 2];

        // 창고 테두리 패딩
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '0');
        }
        for (int i = 0; i < n; i++) {
            String row = storage[i];
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = row.charAt(j);
            }
        }

        for (String request : requests) {
            if (request.length() == 1) {
                // 지게차 작업
                char target = request.charAt(0);
                List<int[]> toRemove = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target && isConnectedToOutside(i, j)) {
                            toRemove.add(new int[]{i, j});
                        }
                    }
                }
                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = '0';
                }
                updateOutside();
            } else {
                // 크레인 작업
                char target = request.charAt(0);
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '1';
                        }
                    }
                }
                updateOutside();
            }
        }

        // 남은 컨테이너 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '0' && map[i][j] != '1') {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 외부와 연결된 컨테이너인지 확인
    private boolean isConnectedToOutside(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (map[nx][ny] == '0') {
                return true;
            }
        }
        return false;
    }

    // 외부와 연결된 빈 공간 업데이트
    private void updateOutside() {
        visited = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n + 2 && ny < m + 2 && !visited[nx][ny]) {
                    if (map[nx][ny] == '0' || map[nx][ny] == '1') {
                        if (map[nx][ny] == '1') {
                            map[nx][ny] = '0';
                        }
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
