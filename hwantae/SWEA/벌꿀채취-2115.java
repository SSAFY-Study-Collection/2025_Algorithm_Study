package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution2115 {
	static int N, M, C;
	static int[][] map;
	static class Honey implements Comparable<Honey>{
		int r;
		int c;
		int h;
		
		Honey(int r, int c, int h){
			this.r = r;
			this.c = c;
			this.h = h;
		}
		
		@Override
		public int compareTo(Honey o) {
			// TODO Auto-generated method stub
			return (this.h - o.h) * -1;
		}
	}
	static PriorityQueue<Honey> q;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			q = new PriorityQueue<>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N - M + 1; c++) {
					int honey = collect(r,c);
					q.add(new Honey(r,c,honey));
				}
			}
			Honey[] user = new Honey[2];
			user[0] = q.poll();
			while(user[1]==null) {
				boolean isValid = true;
				Honey cur = q.poll();
				for (int i = 0; i < M; i++) {
					int r0 = user[0].r ;
					int c0 = user[0].c + i;
					for (int j = 0; j < M; j++) {
						int r1 = cur.r ;
						int c1 = cur.c + j;
						if(r0==r1&&c0==c1) isValid = false; 
					}
				}
				if(isValid) {
					user[1] = cur;
				}
			}
//			System.out.println(user[0].r + " " + user[0].c);
//			System.out.println(user[1].r + " " + user[1].c);

			System.out.printf("#%d %d\n",t,user[0].h + user[1].h);
		}
	}
	static int maxhoney;
	private static int collect(int r, int c) {
		// TODO Auto-generated method stub
		int sum = 0;
		int honey = 0;
		int[] honeys = new int[M];
		for (int i = 0; i < M; i++) {
			sum += map[r][c+i];
			honeys[i] = map[r][c+i];
		}
		if(sum<=C) {
			for (int i = 0; i < M; i++) {
				honey += Math.pow(map[r][c+i], 2);
			}
			return honey;
		}else {
			maxhoney  = Integer.MIN_VALUE;
			permutation(new boolean[M], 0, honeys);
			return maxhoney;
		}
		
		
	}
	private static void permutation(boolean[] v, int i, int[] honeys) {
		// TODO Auto-generated method stub
		if(i==M) {
			int sum = 0;
			for (int j = 0; j < v.length; j++) {
				if(v[j]) sum += honeys[j];
			}
			int honey = 0;
			if(sum<=C) {
				for (int j = 0; j < honeys.length; j++) {
					if(v[j]) honey += Math.pow(honeys[j], 2);
				}
			}
			maxhoney = Math.max(honey,maxhoney);
			return ;
		}
		
		
		v[i] = true;
		permutation(v, i+1, honeys);
		v[i] = false;
		permutation(v, i+1, honeys);
	}

}
