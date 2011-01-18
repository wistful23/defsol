import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    int b;

    int a;
    int[][] l;
    boolean[] mask;

    int n;
    int[][] g, g2;
    int[][] c;

    int min = Integer.MAX_VALUE;

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        g = new int[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(in.readLine());
            int i = -1;
            while (st.hasMoreTokens()) {
                int j = Integer.parseInt(st.nextToken()) - 1;
                if (i != -1) g[i][j] = g[j][i] = 1;
                i = j;
            }
        }

        l = new int[a][];
        for (int k = 0; k < a; ++k) {
            st = new StringTokenizer(in.readLine());
            l[k] = new int[st.countTokens()];
            for (int i = 0; i < l[k].length; ++i) {
                l[k][i] = Integer.parseInt(st.nextToken());
                if (i > 0) --l[k][i];
            }
        }

        c = new int[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                c[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mask = new boolean[a];
        go(0, 0);

        copy();
        out.println(calc() - min);

        out.close();
    }

    void copy() {
        g2 = new int[n][n];
        for (int i = 0; i < n; ++i) {
            System.arraycopy(g[i], 0, g2[i], 0, n);
        }
    }

    void go(int p, int v) {
        if (v > b) return;
        if (a == p) {
            copy();
            for (int k = 0; k < a; ++k) {
                if (mask[k]) {
                    for (int i = 2; i < l[k].length; ++i) {
                        g2[l[k][i]][l[k][i - 1]] = g2[l[k][i - 1]][l[k][i]] = 1;
                    }
                }
            }
            int r = calc();
            if (r < min) min = r;
            return;
        }
        mask[p] = false;
        go(p + 1, v);
        mask[p] = true;
        go(p + 1, v + l[p][0]);
    }

    int calc() {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (g2[i][k] != 0 && g2[k][j] != 0) {
                        if (g2[i][j] == 0 | g2[i][k] + g2[k][j] < g2[i][j]) {
                            g2[i][j] = g2[i][k] + g2[k][j];
                        }
                    }
                }
            }
        }
        int r = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                r += c[i][j] * g2[i][j];
            }
        }
        return r;
    }

    BufferedReader in;
    PrintWriter out;
}
