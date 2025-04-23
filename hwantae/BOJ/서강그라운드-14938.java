package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class Main14938 {
	static int N, M, R;
	static int[] items;
	static int[][] graph;
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		items = new int[N];
		graph = new int[N][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < N; i++) {
			graph[i][i] = 0;
		}
		
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			graph[from][to] = Math.min(graph[from][to], w);
			graph[to][from] = Math.min(graph[to][from], w);
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE) {
						graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if(graph[i][j]<=M) {
					sum += items[j];
				}
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
		
	}

}
