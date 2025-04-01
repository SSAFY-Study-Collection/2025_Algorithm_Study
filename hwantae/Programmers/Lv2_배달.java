import java.util.*;
import java.io.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N][N];
        for(int i = 0; i<N; i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
        }
        for(int i = 0; i< N; i++){
            graph[i][i] = 0;
        }
        
        
        for(int[] r : road){
            graph[r[0]-1][r[1]-1] = Math.min(graph[r[0]-1][r[1]-1],r[2]);
            graph[r[1]-1][r[0]-1] = Math.min(graph[r[1]-1][r[0]-1],r[2]);
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                   if(graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE){
                       graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                   }     
                }
            }
        }
        
         
        for(int j=0; j<N; j++){
                if(graph[0][j]<=K){
                    answer++;
                }
        }
        
        
        
        // for(int r = 0; r<N;r++){
        //     for(int c=0; c<N; c++){
        //         System.out.print(graph[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        

        return answer;
    }
}