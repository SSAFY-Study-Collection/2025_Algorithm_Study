package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution1953 {
	static int N, M;
	static int sr, sc;
	static int L;
	static int[][] map;
	static class Point{
		int r;
		int c;
		int time;
		Point(int r, int c, int time){
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] pipe = {{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
	static int[][] valid = {{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}};
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			boolean[][] v = new boolean[N][M];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Point> q = new ArrayDeque<>();
			q.add(new Point(sr,sc,1));
			v[sr][sc] = true;
			int cnt = 0;
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				if(cur.time==L+1) {
					
					break;
				}
				
				for (int dir : pipe[map[cur.r][cur.c]-1]) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];
					
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&!v[nr][nc]) {
						boolean isValid = false;
						for (int a : valid[dir]) {
							if(a==map[nr][nc]) {
								isValid = true;
								break;
							}
						}
						if(isValid) {
							v[nr][nc] = true;
							q.add(new Point(nr,nc,cur.time+1));
						}
					}
				}
				cnt++;
			}

			
			System.out.printf("#%d %d\n",t,cnt);
		}
		
		
	}

}
