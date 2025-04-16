import java.util.*;

public class Lv3_합승택시요금 {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 200_000_000;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            
            dp[u][v] = cost;
            dp[v][u] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int min = INF;
        for (int k = 1; k <= n; k++) {
            int total = dp[s][k] + dp[k][a] + dp[k][b];
            min = Math.min(min, total);
        }

        return min;
    }

}
