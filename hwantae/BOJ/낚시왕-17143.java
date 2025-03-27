package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class Main17143 {
	static int R, C, M;
	static class Shark implements Comparable<Shark>{
		int r;
		int c;
		int s;
		int d;
		int z;
		Shark(int r, int c, int s, int d, int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return this.z - o.z;
		}
	}
	
	static PriorityQueue<Shark> sharks = new PriorityQueue<>();
	static int[][] map;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,1,-1};
	static int sum = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharks.add(new Shark(r,c,s,d,z));
			map[r][c] = z;
		}
		for (int c = 1; c < C+1; c++) {
//			for (int r = 0; r < R+1; r++) {
//				for (int c1 = 0; c1 < C+1; c1++) {
//					System.out.print(map[r][c1] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			for (int r = 1; r < R+1; r++) {
				if(map[r][c]!=0) {
					sum += map[r][c];
					map[r][c] = 0;
					
					break;
				}
			}
			int qsize = sharks.size();
			Map<Integer,List<Shark>> sea = new HashMap<>();
			for (int i = 0; i < qsize; i++) {
				Shark cur = sharks.poll();
				
				if(map[cur.r][cur.c]==0) continue;
				
				map[cur.r][cur.c] = 0;
				int s;
				if(cur.d==1||cur.d==2) {
					s = cur.s%(2*R-2);
				}else {
					s = cur.s%(2*C-2);
				}
				
				for (int j = 0; j < s; j++) {
					cur.r += dr[cur.d];
					cur.c += dc[cur.d];
					if(cur.r<1||cur.c<1||cur.r>R||cur.c>C) {
						if(cur.d==1) {
							cur.d = 2;
						}else if(cur.d==2) {
							cur.d = 1;
						}else if(cur.d==3) {
							cur.d = 4;
						}else if(cur.d==4) {
							cur.d = 3;
						}
						cur.r += dr[cur.d];
						cur.c += dc[cur.d];
						cur.r += dr[cur.d];
						cur.c += dc[cur.d];
					}
					
				}
				
				
				
//				if((cur.s/R)%2!=0) {
//					if(cur.d<3) {
//						cur.d = 2 - cur.d + 1;
//					}else {
//						cur.d = 4 - cur.d + 3;
//					}
//				}
				
				
				int key = cur.r*C+cur.c;
				
				sea.put(key, new ArrayList<>());
				sea.get(key).add(cur);
				
			}
			for (List<Shark> t : sea.values()) {
				
				Collections.sort(t);
				int nr = t.get(t.size()-1).r;
				int nc = t.get(t.size()-1).c;
				int ns = t.get(t.size()-1).s;
				int nd = t.get(t.size()-1).d;
				int nz = t.get(t.size()-1).z;
				map[nr][nc] = nz;
				sharks.add(new Shark(nr,nc,ns,nd,nz));
			}
			
		}
		System.out.println(sum);
		
		
		
	}	

}
