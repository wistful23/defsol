import java.io.*;
import java.util.*;

public class B {
    public static void main(String args[]) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("penalty.in"));
        pw = new PrintWriter("penalty.out");

        n = Integer.parseInt(br.readLine());
        w = new int[n][2];
        h = new int[n][2];
        int s = 0;
        for(int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w[i][0] = Integer.parseInt(st.nextToken());
            h[i][0] = Integer.parseInt(st.nextToken());
            s += w[i][0] * h[i][0];
            w[i][1] = h[i][0];
            h[i][1] = w[i][0];
        }

        l = (int)Math.round(Math.sqrt(s));
        if(l * l == s) {
            mask = new boolean[n];
            f = new boolean[l][l];
            go(0, 0);
        }

        pw.println("NO");

        pw.close();
    }

    int n, l;
    int[][] w;
    int[][] h;
    boolean mask[];
    boolean f[][];
    boolean flag;

    void go(int i, int j) {
        if(j == l) {
            j = 0;
            ++i;
        }
        if(i == l) {
            pw.println("YES");
            pw.close();
            System.exit(0);
            return;
        }
        if(!f[i][j]) {
            for(int k = 0; k < n; ++k) {
                if(mask[k]) continue;
                for(int c = 0; c < 2; ++c) {
                    int ei = i + h[k][c];
                    int ej = j + w[k][c];

                    if(ei > l || ej > l) continue;
                    boolean check = true;
                    for(int ii = i; ii < ei; ++ii) {
                        for(int jj = j; jj < ej; ++jj) {
                            check = !f[ii][jj];
                            if(!check) break;
                        }
                        if(!check) break;
                    }
                    if(check) {
                        for(int ii = i; ii < ei; ++ii) {
                            for(int jj = j; jj < ej; ++jj) {
                                f[ii][jj] = true;
                            }
                        }
                        mask[k] = true;
                        go(i, ej);
                        for(int ii = i; ii < ei; ++ii) {
                            for(int jj = j; jj < ej; ++jj) {
                                f[ii][jj] = false;
                            }
                        }
                        mask[k] = false;
                    }
                }
            }
        } else go(i, j + 1);
    }

    BufferedReader br;
    PrintWriter pw;
}
