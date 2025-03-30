import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class 자물쇠와열쇠 {
/*
- 자물쇠는 N*N 크기의 정사각 격자 형태
- 열쇠는 M*M 크기의 정사각 격자 형태

- 열쇠의 돌기 부분이 자물쇠의 모든 홈을 채우면 열린다.
- 열쇠의 돌기 부분과 자물쇠의 돌기 부분은 만날 수 없다.
- ** 열쇠는 회전과 이동이 가능하다.

- 이동하고 도는 것과 돌고 이동하는 것이 똑같다. -> 4개의 key로 체크

0 = 홈
1 = 돌기
*/


    class Solution {

        class Point {
            int r;
            int c;
            Point(int r, int  c) {
                this.r = r;
                this.c = c;
            }

            public boolean equals(Object obj) {
                if (obj == null) return false;
                if (this == obj) return true;
                if (getClass() != obj.getClass()) return false;

                Point o = (Point) obj;
                return this.r == o.r && this.c == o.c;
            }

            public int hashCode() {
                return Objects.hash(r, c);
            }
        }

        int N;

        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;

            N = lock.length;

            List<Point> blanks =  new ArrayList<>();

            for (int i=0; i<lock.length; ++i) {
                for (int j=0; j<lock[i].length; ++j) {
                    if (lock[i][j] == 0) {
                        blanks.add(new Point(i, j));
                    }
                }
            }

            if (blanks.size() == 0) {
                return true;
            }

            for (int i=0; i<4; ++i) {
                answer = play(key, blanks, i, lock);
                if (answer) {
                    break;
                }
            }

            return answer;
        }

        public boolean play(int[][] key, List<Point> blanks, int idx,
                            int[][] lock) {

            List<Point> keys = new ArrayList<>();

            if (idx == 0) { // 원본
                for (int i=0; i<key.length; ++i) {
                    for (int j=0; j<key[i].length; ++j) {
                        if (key[i][j] == 1) {
                            keys.add(new Point(i, j));
                        }
                    }
                }
            }
            else if (idx == 1) { // 90도 회전
                for (int i=0; i<key.length; ++i) {
                    for (int j=key[i].length-1; j>=0; --j) {
                        if (key[j][i] == 1) {
                            keys.add(new Point(i, key[i].length-j-1));
                        }
                    }
                }
            }
            else if (idx == 2) { // 180도 회전
                for (int i=key.length-1; i>=0; --i) {
                    for (int j=key[i].length-1; j>=0; --j) {
                        if (key[i][j] == 1) {
                            keys.add(new Point(key.length-i-1,
                                    key[i].length-j-1));
                        }
                    }
                }
            }
            else if (idx == 3) { // 270도 회전
                for (int i=key.length-1; i>=0; --i) {
                    for (int j=0; j<key[i].length; ++j) {
                        if (key[j][i] == 1) {
                            keys.add(new Point(key.length-i-1, j));
                        }
                    }
                }
            }

            return chk(blanks, keys, lock);
        }

        public boolean chk(List<Point> blanks, List<Point> keys,
                           int[][] lock) {
            int cnt;

            for (int i=0; i<blanks.size(); ++i) {
                Point currB = blanks.get(i);
                for (int j=0; j<keys.size(); ++j) {
                    int rGap = currB.r - keys.get(j).r;
                    int cGap = currB.c - keys.get(j).c;
                    cnt = 0;
                    L : for (int k=0; k<keys.size(); ++k) {
                        Point currK = keys.get(k);
                        int nextR = currK.r + rGap;
                        int nextC = currK.c + cGap;
                        if (!isValid(nextR, nextC)) continue;
                        if (lock[nextR][nextC] == 1) break L;
                        if (lock[nextR][nextC] == 0) {
                            ++cnt;
                        }
                    }
                    if (cnt == blanks.size()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isValid(int r, int c) {
            return r >= 0 && r < N && c >= 0 && c < N;
        }
    }
}
