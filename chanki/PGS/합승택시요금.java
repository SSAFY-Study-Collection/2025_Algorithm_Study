
import java.util.*;

public class 합승택시요금 {

	class Solution {
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = 0;
	        
	        int[][] dist = new int[n+1][n+1];
	        for (int i=0; i<=n; ++i) {
	            Arrays.fill(dist[i], 100000007);
	            dist[i][i] = 0;
	        }
	        
	        for (int i=0; i<fares.length; ++i) {
	            dist[fares[i][0]][fares[i][1]] = fares[i][2];
	            dist[fares[i][1]][fares[i][0]] = fares[i][2];
	        }
	        
	        for (int k=1; k<=n; ++k) {
	            for (int i=1; i<=n; ++i) {
	                for (int j=1; j<=n; ++j) {
	                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
	                }
	            }
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for (int i=1; i<=n; ++i) {
	            int val = dist[s][i] + dist[i][a] + dist[i][b];
	            min = Math.min(min, val);
	        }
	        
	        return min;
	    }
	}
}
