import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("hare.in"));
        out = new PrintWriter("hare.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            double u =  Double.parseDouble(st.nextToken());
            double v =  Double.parseDouble(st.nextToken());
            Point[] l = new Point[n];
            double[] ts = new double[n];
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(in.readLine());
                l[j] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                if (j == 0) {
                    ts[0] = Math.hypot(l[0].x, l[0].y) / u;
                } else {
                    ts[j] = ts[j - 1] + dist(l[j - 1], l[j]) / u;
                }
            }
            Point[] s = new Point[h];
            s[0] = new Point(0, 0);
            for (int i = 1; i < h; ++i) {
                st = new StringTokenizer(in.readLine());
                s[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }
            g = new boolean[h][n][n + 1];
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < n; ++j) {
                    double t = dist(s[i], l[j]) / v;
                    if (t <= ts[j]) {
                        g[i][j][n] = true;
                    }
                    for (int jj = 0; jj < j; ++jj) {
                        t = dist(l[jj], l[j]) / v;
                        if (t <= ts[j] - ts[jj]) {
                            g[i][j][jj] = true;
                        }
                    }
                }
            }
            p = new int[n];
            Arrays.fill(p, -1);
            best = 0;
            assign(0, 0);
            out.println("Data Set " + x + ":");
            out.println(best);
            out.println();
        }

        out.close();
    }

    int n, h;
    boolean[][][] g;
    int[] p;
    int best;

    void assign(int i, int c) {
        if (i == h) {
            if (c > 0) {
                go(0, c);
            }
        } else {
            assign(i + 1, c);
            for (int j = 0; j < n; ++j) {
                if (p[j] == -1 && g[i][j][n]) {
                    p[j] = i;
                    assign(i + 1, c + 1);
                    p[j] = -1;
                }
            }
        }
    }

    void go(int jj, int c) {
        if (jj == n) {
            if (c > best) best = c;
        } else {
            go(jj + 1, c);
            if (p[jj] != -1) {
                for (int j = jj + 1; j < n; ++j) {
                    int i = p[jj];
                    if (p[j] == -1 && g[i][j][jj]) {
                        p[j] = i;
                        go(jj + 1, c + 1);
                        p[j] = -1;
                    }
                }
            }
        }
    }

    double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    BufferedReader in;
    PrintWriter out;
}
