import java.util.ArrayDeque;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

    class Solution {

        class Point {
            int r;
            int c;

            Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            boolean[][] visited = new boolean[m][n];
            for (int i=0; i<m; ++i) {
                for (int j=0; j<n; ++j) {
                    if (picture[i][j] != 0 && !visited[i][j]) {
                        ++numberOfArea;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, visited, i, j));
                    }
                }
            }



            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public int bfs(int[][] picture, boolean[][] visited, int r, int c) {
            int cnt = 0;
            int color = picture[r][c];
            visited[r][c] = true;

            Queue<Point> q = new ArrayDeque<>();
            q.add(new Point(r, c));

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            while (!q.isEmpty()) {
                Point curr = q.poll();
                ++cnt;

                for (int d=0; d<4; ++d) {
                    int nextR = curr.r + dr[d];
                    int nextC = curr.c + dc[d];

                    if (isValid(nextR, nextC, picture) && !visited[nextR][nextC]
                            && picture[nextR][nextC] == color) {

                        visited[nextR][nextC] = true;
                        q.add(new Point(nextR, nextC));
                    }
                }

            }


            return cnt;
        }

        public boolean isValid(int r, int c, int[][] picture) {
            return r >= 0 && r < picture.length && c >= 0 && c < picture[r].length;
        }
    }
}
