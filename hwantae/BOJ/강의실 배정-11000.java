package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class Main11000 {
	static class Room implements Comparable<Room>{
		int start;
		int end;
		Room(int s, int e){
			this.start = s;
			this.end = e;
		}
		
		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			if(this.start==o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
	static PriorityQueue<Room> q = new PriorityQueue<>();
	static PriorityQueue<Integer> rooms = new PriorityQueue<>();
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			q.add(new Room(start,end));
		}
		while(!q.isEmpty()) {
			Room cur = q.poll();
			
			if(rooms.isEmpty()) {
				rooms.add(cur.end);
			}else {
				if(rooms.peek()<=cur.start) {
					rooms.poll();
					rooms.add(cur.end);
				}else {
					rooms.add(cur.end);
				}
			}
		}
		
		
		
		System.out.println(rooms.size());
	}

}
