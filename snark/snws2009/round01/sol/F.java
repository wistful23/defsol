import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        new F().solve();
    }

    void solve() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new FileReader("zebras.in"));
        out = new PrintWriter("zebras.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int z = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double best = 1e23d;
            int l = 1 << z;
            int[] n = new int[l];
            for (int v = 0; v < l; ++v) {
                n[v] = num(v);
            }
            double d[][] = new double[t][l];
            double s[][] = new double[z][z];
            for (int u = 0; u < t; ++u) {
                st = new StringTokenizer(in.readLine());
                Point[] p = new Point[z];
                for (int i = 0; i < z; ++i) {
                    p[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                }
                for (int i = 0; i < z; ++i) {
                    for (int j = i + 1; j < z; ++j) {
                        s[i][j] = dist(p[i], p[j]);
                    }
                }
                for (int v = 0; v < l; ++v) {
                    for (int i = 0; i < z; ++i) {
                        for (int j = i + 1; j < z; ++j) {
                            if (val(v, i) == val(v, j)) {
                                d[u][v] += a * s[i][j];
                            } else {
                                d[u][v] -= b * s[i][j];
                            }
                        }
                    }
                    if (u > 0) {
                        double r = 1e23d;
                        for (int w = 0; w < l; ++w) {
                            double e = d[u - 1][w] + c * n[w ^ v];
                            if (e < r) r = e;
                        }
                        d[u][v] += r;
                    }
                    if (u == t - 1) {
                        if (d[u][v] < best) best = d[u][v];
                    }
                }
            }
            out.println("Data Set " + x + ":");
            out.printf("%.2f\n", best);
            out.println();
        }

        out.close();
    }

    int val(int v, int i) {
        return (v & (1 << i)) == 0 ? 0 : 1;
    }

    int num(int v) {
        int c = 0;
        while (v > 0) {
            if ((v & 1) == 1) ++c;
            v >>>= 1;
        }
        return c;
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
