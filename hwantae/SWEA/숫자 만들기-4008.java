package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution2477 {
	static int N;
	static int[] op;
	static int[] num;
	static int max, min;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			op = new int[N-1];
			num = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int count = Integer.parseInt(st.nextToken());
				for (int j2 = 0; j2 < count; j2++) {
					op[idx] = j;
					idx++;
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			
			permutation(new int[N-1], 0, new boolean[N-1]);
			System.out.printf("#%d %d\n",i,max -  min);
		}
	}
	
	private static void permutation(int[] sel, int i, boolean[] v) {
		
		if(i==N-1) {
				int sum = num[0];
				for (int j = 0; j < N-1; j++) {
					if(sel[j]==0) {
						sum += num[j+1];
					}else if(sel[j]==1) {
						sum -= num[j+1];
					}else if(sel[j]==2) {
						sum *= num[j+1];
					}else if(sel[j]==3) {
						sum /= num[j+1];
					}
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);	
			return ;
		}
		
		
		for (int j = 0; j < v.length; j++) {
				if(v[j]) continue;
				if(j>0&&op[j-1]==op[j]&&!v[j-1]) continue;
				v[j] = true;
				sel[i] = op[j];
				permutation(sel,i+1,v);
				v[j] = false;
			
		}
	}

}
