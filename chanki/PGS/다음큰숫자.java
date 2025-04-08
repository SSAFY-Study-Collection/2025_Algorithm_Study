
import java.util.*;

public class 다음큰숫자 {

	/*
	 * 맨 뒤 1에 1을 더해주고 1 -> 0으로 변한 개수-1 만큼 뒤에서부터 1 추가
	 */

	class Solution {
		public int solution(int n) {
			int answer = 0;

			String s = Integer.toString(n, 2);
			int cnt = 0;

			for (int i = s.length() - 1; i >= 0; --i) {
				if (s.charAt(i) == '1') {
					break;
				}
				++cnt;
			}
			int firstOneCnt = 0;
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == '1') {
					++firstOneCnt;
				}
			}

			n += Math.pow(2, cnt);
			s = Integer.toString(n, 2);
			int secondOneCnt = 0;
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == '1') {
					++secondOneCnt;
				}
			}

			for (int i = 0; i < (firstOneCnt - secondOneCnt); ++i) {
				n += Math.pow(2, i);
			}

			answer = n;
			return answer;
		}
	}
}
