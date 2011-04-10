import java.io.*;
import java.util.*;

public class B {

    final static int INF = Integer.MAX_VALUE;

    final int[][] m = new int[28][7];
    final int[][][][] d = new int[2][28][28][28];

    void solve() throws IOException {
        in("mrx.in"); out("mrx.out");

        for (int x = 0; x < 28; ++x) {
            Arrays.fill(m[x], -1);
        }
        int l = 0;
        int v = 0;
        for (int x = 0; x < 28; ++x) {
            m[x][6] = x;
            if (x > l + v) {
                ++v;
                l += v;
            }
            if (x > l) {
                m[x][0] = x - 1;
            }
            if (x < l + v) {
                m[x][1] = x + 1;
            }
            if (x < 21) {
                m[x][4] = x + v + 1;
                m[x][5] = x + v + 2;
                m[m[x][4]][3] = x;
                m[m[x][5]][2] = x;
            }
        }

        for (int x = 0; x < 28; ++x) {
            for (int y = 0; y < 28; ++y) {
                d[0][x][x][y] = 1;
                d[0][x][y][x] = 1;
            }
        }

        for (int t = 0; t < 28; ++t) {
            int k = t & 1;
            for (int x = 0; x < 28; ++x) {
                for (int y = 0; y < 28; ++y) {
                    for (int z = 0; z < 28; ++z) {
                        d[1 - k][x][y][z] = d[k][x][y][z];
                        if (d[k][x][y][z] == 0) {
                            int r = 0;
                            for (int i = 0; i < 7; ++i) {
                                int xx = m[x][i];
                                if (xx != -1) {
                                    r = Math.max(r, run(k, xx, y, z));
                                    int xxx = m[xx][i];
                                    if (xxx != -1) {
                                        r = Math.max(r, run(k, xxx, y, z));
                                    }
                                }
                            }
                            if (r < INF) {
                                d[1 - k][x][y][z] = r + 1;
                            }
                        }
                    }
                }
            }
        }

        while (!eof()) {
            int z = readInt() - 1;
            int y = readInt() - 1;
            int x = readInt() - 1;
            println("StAN wins in " + (d[0][x][y][z] - 1) + ".");
        }

        exit();
    }

    int run(int k, int x, int y, int z) {
        int r = INF;
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 7; ++j) {
                int yy = m[y][i];
                int zz = m[z][j];
                if (yy != -1 && zz != -1 && d[k][x][yy][zz] != 0) {
                    r = Math.min(r, d[k][x][yy][zz]);
                }
            }
        }
        return r;
    }

    void in(String name) throws IOException {
        if (name.equals("__std")) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(name));
        }
    }

    void out(String name) throws IOException {
        if (name.equals("__std")) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(name);
        }
    }

    void exit() {
        out.close();
        System.exit(0);
    }

    int readInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
    }

    String readLine() throws IOException {
        st = null;
        return in.readLine();
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void print(Object value) {
        out.print(value);
    }

    void println(Object value) {
        out.println(value);
    }

    void println() {
        out.println();
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new B().solve();
    }
}
