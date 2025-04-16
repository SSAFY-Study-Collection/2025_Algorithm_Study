import java.util.*;

public class Lv3_보행자천국 {
    
    int MOD = 20170805;
    int[] dx = {1,0};
    int[] dy = {0,1};
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        long result = bfs(m, n, cityMap);
        answer = (int)(result % (long)MOD);
        return answer;
    }
    
    long bfs(int m, int n, int[][] cityMap){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        long[][] visited = new long[m][n];
        visited[0][0] = 1L;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int predir = cur[2];

			if(cityMap[cx][cy] == 1){
				continue;
			}

			for(int i=0; i<dx.length; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(cityMap[cx][cy] == 2){
					if(cx+dx[predir]!=nx 
						|| cy+dy[predir]!=ny){
						continue;
					}
				}
				if(nx>=0 && ny>=0 && nx<m && ny<n){
					queue.offer(new int[]{nx, ny, i});
					visited[nx][ny]++;
				}
			}
		}

		return visited[m-1][n-1];
        
    }

/*
class Solution {
    int MOD = 20170805;
    int[] dx = {1,0};
    int[] dy = {0,1};
    long result = 0;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        dfs(new int[]{0, 0}, 0, new int[]{0,0}, n, m, cityMap, new boolean[m][n]);
        answer = (int)(result % (long)20170805);
        return answer;
    }
    
    void dfs(int[] prefix, int predir, int[] current, int n, int m, int[][] cityMap, boolean[][] visited){
        
        int cx = current[0];
        int cy = current[1];
	
        if(cx==m-1 && cy==n-1){
            result++;
            return;
        }
        
        if(cityMap[cx][cy] == 1){
            return;
        }
        
        for(int i=0; i<dx.length; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
			if(cityMap[cx][cy] == 2){
				if(cx+dx[predir]!=nx 
					|| cy+dy[predir]!=ny){
					continue;
				}
			}
            if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny]){
                visited[cx][cy] = true;
                dfs(new int[]{cx, cy}, i, new int[]{nx, ny}, n, m, cityMap, visited);
                visited[cx][cy] = false;
            }
        }
    }
}

1은 자동차 통행 금지
2는 좌회전 우회전 금지(해당 차의 포지션의 직진만 가능)
사방탐색 dfs + 백트래킹? -> 시간초과
bfs + 누적 방문 횟수배열? 


0 0 0
0 0 0
0 0 0


0 2 0 0 0 2
0 0 2 0 1 0
1 0 0 2 2 0

*/
}
