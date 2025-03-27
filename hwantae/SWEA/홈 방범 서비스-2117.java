package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution2117 {
	static int N, M;
	static int[][] map;
	static class Home{
		int r;
		int c;
		Home(int r, int c){
			this.r = r ;
			this.c = c;
		}
	}
	static List<Home> homes;
	static int maxhome ;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			homes = new ArrayList<>();
			maxhome = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]==1) {
						homes.add(new Home(r,c));
					}
				}
			}
			
			for (int k = 1; k <= N*N; k++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						int count = 0;
						for (Home h : homes) {
							
							int Diff = Math.abs(r-h.r) + Math.abs(c-h.c);
							if(Diff<=k-1) {
								count++;
							}
						}
						int pay = (int) (Math.pow(k, 2) + Math.pow(k-1, 2));
						if(count*M-pay>=0) {
							maxhome = Math.max(maxhome, count);
						}
					}
				}
			}
			System.out.printf("#%d %d\n",i,maxhome);
		}
	}

}
