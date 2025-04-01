package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class Main17298 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] newnum = new int[N];
		Deque<Integer> q = new ArrayDeque<>();		
		for (int i = N-1; i >=0; i--) {
//			System.out.println(Arrays.toString(newnum));
//			System.out.println(q);
			if(q.isEmpty()) {
				q.add(num[i]);
				newnum[i] = -1;
			}else {
				if(q.peekLast()>num[i]) {
					newnum[i] = q.peekLast();
					q.add(num[i]);
				}else {
					while(q.peekLast()<=num[i]) {
						q.pollLast();
						if(q.isEmpty()) break;
					}
					if(q.size()!=0) {
						newnum[i] = q.peekLast();
						q.add(num[i]);
					}else {
						newnum[i] = -1;
						q.add(num[i]);
					}
					
				}
			}
		}
//		System.out.println(q);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newnum.length; i++) {
			sb.append(newnum[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
