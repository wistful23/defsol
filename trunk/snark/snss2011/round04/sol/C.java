import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        int m = readInt();
        int n = readInt();
        int k = readInt();
        Cafe[] cafes = new Cafe[k];
        for (int i = 0; i < k; ++i) {
            Cafe c = new Cafe();
            c.y = readInt();
            c.x = readInt();
            c.r = readInt();
            c.b = readInt();
            cafes[i] = c;
        }
        int best = 0;
        int cnt = 0;
        List<State> l = new ArrayList<State>();
        for (int y = 1; y <= n; ++y) {
            l.clear();
            for (Cafe c : cafes) {
                int h = Math.abs(c.y - y);
                if (h <= c.r) {
                    int d = (int) (Math.sqrt(c.r * c.r - h * h));
                    int lb = c.x - d;
                    if (lb < 1) lb = 1;
                    int rb = c.x + d;
                    if (rb > m) rb = m;
                    l.add(new State(lb, c.b, 1));
                    l.add(new State(rb + 1, c.b, -1));
                }
            }
            Collections.sort(l);
            int sum = 0;
            for (int i = 0; i < l.size() - 1; ++i) {
                State s0 = l.get(i);
                State s1 = l.get(i + 1);
                sum += s0.order * s0.b;
                int d = s1.x - s0.x;
                if (sum > best) {
                    best = sum;
                    cnt = d;
                } else if (sum == best) {
                    cnt += d;
                }
            }
        }
        println(best);
        println(cnt);

        exit();
    }

    class State implements Comparable<State> {
        int x, b;
        int order;

        State(int x, int b, int order) {
            this.x = x;
            this.b = b;
            this.order = order;
        }

        public int compareTo(State o) {
            int d = x - o.x;
            if (d == 0) d = order - o.order;
            return d;
        }
    }

    class Cafe {
        int x, y, r, b;
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

    long readLong() throws IOException {
        return Long.parseLong(readToken());
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
        out.println(new Formatter(Locale.US).format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter(Locale.US).format(format, args));
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
        new C().solve();
    }
}
