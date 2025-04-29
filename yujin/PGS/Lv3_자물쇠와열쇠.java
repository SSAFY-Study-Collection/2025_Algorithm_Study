package yujin.PGS;

import java.util.*;

public class Lv3_자물쇠와열쇠 {
    static int m,n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;

        int[][] mylock = new int[2*m+n-2][2*m+n-2];
        int[][][] mykey = new int[4][m][m];
        int lockCnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(lock[i][j] == 0) lockCnt++;
            }
        }

        for(int i = 0; i < 2*m+n-2; i++){
            Arrays.fill(mylock[i], 2);
        }

        int start = m-1;
        for(int i = 0; i < n; i++) {
            System.arraycopy(lock[i], 0, mylock[start+i], start, n);
        }

        mykey[0] = key;
        mykey[1] = rotate90(mykey[0]);
        mykey[2] = rotate90(mykey[1]);
        mykey[3] = rotate90(mykey[2]);

        for(int i = 0; i < m+n-1; i++) {
            for(int j = 0; j < m+n-1; j++) {
                for(int k = 0; k < 4; k++) {
                    boolean tmp = true;
                    int cnt = 0;
                    end: for(int y = 0; y < m; y++) {
                        for(int x = 0; x < m; x++) {
                            if(mylock[i+y][j+x] - mykey[k][y][x] == 0) {
                                tmp = false;
                                break end;
                            } else if(mylock[i+y][j+x] == 0){
                                cnt++;
                            }
                        }
                    }
                    if(tmp && cnt == lockCnt) return true;
                }

            }
        }
        return false;
    }
    public static int[][] rotate90(int[][] arr){
        int[][] rotated = new int[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                rotated[i][j] = arr[m-j-1][i];
            }
        }
        return rotated;
    }
}
