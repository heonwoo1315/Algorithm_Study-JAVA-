package com.example.BFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class 미로탈출 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] grid = new char[n][m];
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        for (int i = 0; i < n; i++) {
            grid[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'S') {
                    sx = i; sy = j;
                } else if (grid[i][j] == 'L') {
                    lx = i; ly = j;
                } else if (grid[i][j] == 'E') {
                    ex = i; ey = j;
                }
            }
        }

        int toLever = bfs(sx, sy, 'L', grid);
        int toExit = bfs(lx, ly, 'E', grid);

        if (toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
    }

    private int bfs(int x, int y, char target, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            if (grid[cx][cy] == target) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        !visited[nx][ny] && grid[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offerLast(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}
