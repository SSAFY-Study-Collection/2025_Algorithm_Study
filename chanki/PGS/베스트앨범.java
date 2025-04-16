import java.io.*;
import java.util.*;

public class 베스트앨범 {

	/*
	 * 장르 별로 가장 많이 재생된 노래 2개 모아서 베스트 앨범 출시 노래는 고유 번호로 구분 1. 속한 노래가 많이 재생된 장르 먼저 수록
	 * 2. 장르 내 많이 재생된 노래 먼저 수록 3. 장르 내 재생 횟수가 같으면 고유 번호가 낮은 노래 먼저 수록 (고유번호는 idx)
	 */

	class Solution {

		class Music implements Comparable<Music> {
			String genre;
			int idx;
			int play;
			int genrePlay;

			Music(String genre, int idx, int play, int genrePlay) {
				this.genre = genre;
				this.idx = idx;
				this.play = play;
				this.genrePlay = genrePlay;
			}

			@Override
			public int compareTo(Music o) {
				if (this.genrePlay == o.genrePlay) {
					if (this.play == o.play) {
						return Integer.compare(this.idx, o.idx);
					}
					return Integer.compare(o.play, this.play);
				}

				return Integer.compare(o.genrePlay, this.genrePlay);
			}
		}

		public int[] solution(String[] genres, int[] plays) {
			int[] answer;

			Map<String, Integer> genreMap = new HashMap<>();
			for (int i = 0; i < genres.length; ++i) {
				genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
			}

			Queue<Music> pq = new PriorityQueue<>();
			for (int i = 0; i < genres.length; ++i) {
				pq.add(new Music(genres[i], i, plays[i], genreMap.get(genres[i])));
			}

			List<Integer> list = new ArrayList<>();
			Map<String, Integer> countMap = new HashMap<>();
			while (!pq.isEmpty()) {
				Music curr = pq.poll();
				int count = countMap.getOrDefault(curr.genre, 0);
				if (count >= 2) {
					continue;
				}

				countMap.put(curr.genre, count + 1);
				list.add(curr.idx);
			}

			answer = new int[list.size()];
			for (int i = 0; i < list.size(); ++i) {
				answer[i] = list.get(i);
			}

			return answer;
		}
	}
}
