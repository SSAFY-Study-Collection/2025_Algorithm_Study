
import java.util.*;

public class 보행자천국 {

	/*
	- 자동차는 오른쪽 또는 아래 방향으로 한 칸씩 이동
	- 0: 자유롭게 갈 수 있음
	- 1: 자동차 통행 금지
	- 2: 좌회전/우회전 금지 -> 직진만 가능 (dir 변경 불가)
	DFS + DP?
	*/

	class Solution {
	    int MOD = 20170805;

	    int[] dr = {0 ,1};
	    int[] dc = {1, 0};
	    
	    public int solution(int m, int n, int[][] cityMap) {
	        int answer = 0;
	        
	        int[][][] dp = new int[m][n][2];
	        for (int i=0; i<m; ++i) {
	            for (int j=0; j<n; ++j) {
	                for (int k=0; k<2; ++k) {
	                    dp[i][j][k] = -1;
	                }
	            }
	        }
	        
	        dfs(cityMap, 0, 0, 0, dp);
	        
	        answer = (dp[0][0][0] % MOD + dp[0][0][1] % MOD) % MOD;
	        
	        return answer;
	    }
	    
	    public int dfs(int[][] map, int r, int c, int dir, int[][][] dp) {

	        
	        if (r == map.length-1 && c == map[r].length-1) {
	            return 1;
	        }
	        
	        if (dp[r][c][0] != -1 && dp[r][c][1] != -1) {
	            if (map[r][c] == 2) {
	                return dp[r][c][dir];
	            }
	            else {
	                return dp[r][c][0] + dp[r][c][1];
	            }
	        }
	        
	        
	        for (int d=0; d<2; ++d) {
	            if (dp[r][c][d] == -1) {
	                if (map[r][c] == 2) {
	                    if (dir == d) {
	                        dp[r][c][dir] = 0;
	                    }
	                }
	                else {
	                    dp[r][c][d] = 0;
	                }
	            }  
	             
	            
	            int nextR = r + dr[d];
	            int nextC = c + dc[d];
	            if (isValid(map, nextR, nextC) && map[nextR][nextC] != 1) {
	                if (map[r][c] == 2) {
	                    if (dir == d) {
	                        dp[r][c][d] = (dp[r][c][d] % MOD + dfs(map, nextR, nextC, d, dp) % MOD) % MOD;
	                    }
	                }
	                else {
	                    dp[r][c][d] = (dp[r][c][d] % MOD + dfs(map, nextR, nextC, d, dp) % MOD) % MOD;
	                }
	            }
	        }
	        
	        if (map[r][c] == 2) {
	            return dp[r][c][dir];
	        }
	        
	        return dp[r][c][0] + dp[r][c][1] % MOD;
	    }
	    
	    public boolean isValid(int[][] map, int r, int c) {
	        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
	    }
	}
}
