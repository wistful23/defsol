import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        new E().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] g = new int[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(in.readLine());
            int i = n - Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken()) - 1;
            g[i][j] = 1;
        }

        boolean overflow = false;
        while (t-- > 0 && !overflow) {
            st = new StringTokenizer(in.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int f = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) / 90;
            int[][] c = s[f][a];
            int h = c.length;
            boolean flag = true;
            int ii = n - h;
            for (int i = 1 - h; i <= n - h && flag; ++i) {
                for (int ci = i < 0 ? -i : 0; ci < h && flag; ++ci) {
                    for (int cj = 0; cj < c[ci].length && flag; ++cj) {
                        if (c[ci][cj] == 1 && g[i + ci][p + cj] == 1) {
                            ii = i - 1;
                            flag = false;
                        }
                    }
                }
            }
            for (int ci = ii < 0 ? -ii : 0; ci < h; ++ci) {
                for (int cj = 0; cj < c[ci].length; ++cj) {
                    if (c[ci][cj] == 1) {
                        g[ii + ci][p + cj] = 1;
                    }
                }
            }
            overflow = ii < 0;
        }

        out.println(overflow ? "Overflow" : "Ok");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                out.print(g[i][j] == 1 ? '*' : '.');
            }
            out.println();
        }

        out.close();
    }

    final static int[][][][] s =
        {
            {
            {{1, 1, 1, 1}},
            {{1},
             {1},
             {1},
             {1}},
            {{1, 1, 1, 1}},
            {{1},
             {1},
             {1},
             {1}}
            },

            {
            {{1},
             {1, 1, 1}},
            {{0, 1},
             {0, 1},
             {1, 1}},
            {{1, 1, 1},
             {0, 0, 1}},
            {{1, 1},
             {1},
             {1}}
            },

            {
            {{0, 0, 1},
             {1, 1, 1}},
            {{1, 1},
             {0, 1},
             {0, 1}},
            {{1, 1, 1},
             {1}},
            {{1},
             {1},
             {1, 1}}
            },

            {
            {{1, 1},
             {1, 1}},
            {{1, 1},
             {1, 1}},
            {{1, 1},
             {1, 1}},
            {{1, 1},
             {1, 1}},
            },

            {
            {{0, 1, 1},
             {1, 1}},
            {{1},
             {1, 1},
             {0, 1}},
            {{0, 1, 1},
             {1, 1}},
            {{1},
             {1, 1},
             {0, 1}}
            },

            {
            {{0, 1},
             {1, 1, 1}},
            {{0, 1},
             {1, 1},
             {0, 1}},
            {{1, 1, 1},
             {0, 1}},
            {{1},
             {1, 1},
             {1}}
            },

            {
            {{1, 1},
             {0, 1, 1}},
            {{0, 1},
             {1, 1},
             {1}},
            {{1, 1},
             {0, 1, 1}},
            {{0, 1},
             {1, 1},
             {1}}
            },
        };

    BufferedReader in;
    PrintWriter out;
}
