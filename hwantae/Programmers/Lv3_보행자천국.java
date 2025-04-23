import java.util.*;
import java.io.*;

class Solution {
    int MOD = 20170805;
    static int[] dr = {0,1};
    static int[] dc = {1,0};
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dist = new int[m][n];
        dist[0][0] = 1;
        for(int r = 0; r<m;r++){
            for(int c=0; c<n; c++){
                    for(int d = 0; d<2; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if(nr>=0&&nc>=0&&nr<m&&nc<n&&cityMap[nr][nc]!=1){
                        if(cityMap[nr][nc]==2){
                            while(cityMap[nr][nc]==2){
                                nr += dr[d];
                                nc += dc[d];
                                if(nr<0||nc<0||nr>=m||nc>=n) break;
                            }
                            if(nr<0||nc<0||nr>=m||nc>=n) continue;

                            if(cityMap[nr][nc]==0){
                                dist[nr][nc] = (dist[nr][nc] + dist[r][c] +MOD) % MOD;
                            }else{
                                 dist[nr][nc] += 0;
                            }
                        }else if(cityMap[nr][nc]==0){
                            dist[nr][nc] = (dist[nr][nc] + dist[r][c] ) % MOD;
                        }
                    }
                
                    
                }
            }
            
        } 
        
         // for(int r = 0; r<m;r++){
         //    for(int c=0; c<n; c++){
         //        System.out.print(dist[r][c] + " ");
         //    }
         //     System.out.println();
         // }
        
        return dist[m-1][n-1];
    
    
    }
}