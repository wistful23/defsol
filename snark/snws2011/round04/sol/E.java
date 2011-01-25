import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("__std"); out("__std");

        int m = readInt();
        int n = readInt();
        char[][] map = new char[n][m];
        boolean[][][] mask = new boolean[n][m][4];
        Queue<State> q = new LinkedList<State>();
        for (int i = 0; i < n; ++i) {
            map[i] = readLine().toCharArray();
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 'S') {
                    map[i][j] = '.';
                    mask[i][j][3] = true;
                    q.add(new State(i, j, 3));
                    break;
                }
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            State s = q.poll();
            for (int t = 0; t < 4; ++t) {
                int i = s.i + di[t];
                int j = s.j + dj[t];
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    int k = s.k;
                    if (map[i][j] == 'D') --k;
                    if (map[i][j] == 'R') k = 3;
                    if (k >= 0 && !mask[i][j][k]) {
                        if (map[i][j] == 'G') {
                            ++cnt;
                            map[i][j] = '.';
                        }
                        mask[i][j][k] = true;
                        q.add(new State(i, j, k));
                    }
                }
            }
        }
        println(cnt);

        exit();
    }

    class State {
        int i, j, k;

        State(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    final static int[] di = {-1, 0, 1, 0};
    final static int[] dj = {0, -1, 0, 1};

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
        new E().solve();
    }
}
