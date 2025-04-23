package com.ssafy.prog;

import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int R, C;
    static int count;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        v = new boolean[m][n];
        R = m;
        C = n;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(picture[r][c]!=0&&!v[r][c]){
                    count = 0;
                    dfs(r,c, picture[r][c], picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                }
            }
        }
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static private void dfs(int r, int c, int val, int[][] map){
        v[r][c] = true;
        count++;
        for(int i = 0; i < dr.length; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr>=0&&nc>=0&&nr<R&&nc<C&&!v[nr][nc]&&map[nr][nc]==val){
                dfs(nr,nc,val,map);
            }
        }
        
    }
}