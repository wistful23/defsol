import java.util.Scanner;
import java.io.*;

public class F {
    public static void main(String args[]) throws IOException {
        new F().solve();
    }

    public void solve() throws IOException {
        Scanner s = new Scanner(System.in/*new File("f.in")*/);
        PrintWriter pw = new PrintWriter(System.out/*"f.out"*/);
        m = s.nextInt();
        n = s.nextInt();
        f = new int[m][n];
        go(0, 0, 1);
        pw.println(ans);
        s.close();
        pw.close();
    }

    void go(int i, int j, int v) {
        if(j == n) {
            j = 0;
            ++i;
        }
        if(i == m) {
            int cnt = 0;
            for(int ii = 0; ii < m; ++ii) {
                for(int jj = 0; jj < n; ++jj) {
                    if(ii < m - 1 && f[ii][jj] != f[ii + 1][jj]) ++cnt;
                    if(jj < n - 1 && f[ii][jj] != f[ii][jj + 1]) ++cnt;
                }
            }
            if(cnt < ans) ans = cnt;
            return;
        }
        if(f[i][j] == 0) {
            for(int k = 0; k < 3; ++k) {
                int ei = i + h[k];
                int ej = j + w[k];
                if(ei > m || ej > n) continue;
                boolean flag = true;
                for(int ii = i; ii < ei; ++ii) {
                    for(int jj = j; jj < ej; ++jj) {
                        flag = f[ii][jj] == 0;
                        if(!flag) break;
                    }
                    if(!flag) break;
                }
                if(flag) {
                    for(int ii = i; ii < ei; ++ii) {
                        for(int jj = j; jj < ej; ++jj) {
                            f[ii][jj] = v;
                        }
                    }
                    go(i, ej, v + 1);
                    for(int ii = i; ii < ei; ++ii) {
                        for(int jj = j; jj < ej; ++jj) {
                            f[ii][jj] = 0;
                        }
                    }
                }
            }
        } else go(i, j + 1, v);
    }

    int ans = 1000000000;
    int n, m;
    int[][] f;

    final int[] w = {4, 6, 3};
    final int[] h = {4, 3, 6};
}
