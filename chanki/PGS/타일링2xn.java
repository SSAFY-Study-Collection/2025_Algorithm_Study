
import java.util.*;

public class 타일링2xn {

	class Solution {

		int MOD = 1_000_000_007;

		public int solution(int n) {
			int answer = 0;

			int[] dp = new int[n + 1];

			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i <= n; ++i) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
			}

			return dp[n];
		}
	}
}
