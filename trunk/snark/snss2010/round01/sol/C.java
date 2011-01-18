import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[][] h = new int[n][n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                h[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int i0 = 0;
        int j0 = 0;
        int d = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (h[i][j] >= h[i0][j0]) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < 4; ++k) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        if (ii >= 0 && ii < n && jj >= 0 && jj < n && h[ii][jj] < min) {
                            min = h[ii][jj];
                        }
                    }
                    int c = 0;
                    int dd = 0;
                    for (int k = 0; k < 4; ++k) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        if (ii >= 0 && ii < n && jj >= 0 && jj < n && h[ii][jj] == min) {
                            ++c;
                            dd = k;
                        }
                    }
                    if (c == 1) {
                        i0 = i;
                        j0 = j;
                        d = dd;
                    }
                }
            }
        }

        boolean flag = true;
        while (i0 > 0 && i0 < n - 1 && j0 > 0 && j0 < n - 1 && flag) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 4; ++k) {
                int ii = i0 + di[k];
                int jj = j0 + dj[k];
                if (h[ii][jj] < h[i0][j0] && h[ii][jj] < min) {
                    min = h[ii][jj];
                }
            }
            flag = min < Integer.MAX_VALUE;
            if (flag) {
                int l = 23;
                int i = 0;
                int j = 0;
                int dd = 0;
                for (int k = 0; k < 4; ++k) {
                    int ii = i0 + di[k];
                    int jj = j0 + dj[k];
                    if (h[ii][jj] == min) {
                        int v = 3; // backward
                        if (d == k) { // forward
                            v = 0;
                        } else if ((d + 3) % 4 == k) { // left
                            v = 1;
                        } else if ((d + 1) % 4 == k) { // right
                            v = 2;
                        }
                        if (v < l) {
                            l = v;
                            i = ii;
                            j = jj;
                            dd = k;
                        }
                    }
                }
                i0 = i;
                j0 = j;
                d = dd;
            }
        }

        if (flag) {
            out.println(dn[d]);
        } else {
            out.println("Trapped");
        }

        out.close();
    }

    final static int[] di = {-1, 0, 1, 0};
    final static int[] dj = {0, 1, 0, -1};
    final static String[] dn = {"North", "East", "South", "West"};

    BufferedReader in;
    PrintWriter out;
}
