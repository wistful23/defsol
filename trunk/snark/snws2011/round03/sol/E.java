import java.io.*;
import java.util.*;

public class E {

    static class Link {
        int i, c;

        Link(int i, int c) {
            this.i = i;
            this.c = c;
        }
    }

    int n;
    List<Link>[] l;

    int[] s;
    int best;

    int max;
    int x, y;

    int len(int i, int p) {
        int max = 0;
        int max2 = 0;
        int j = -1;
        for (Link e : l[i]) {
            if (e.i != p) {
                int t = len(e.i, i) + e.c;
                if (t > max) {
                    if (max > max2) {
                        max2 = max;
                        j = s[i];
                    }
                    max = t;
                    s[i] = e.i;
                } else if (t > max2) {
                    max2 = t;
                    j = e.i;
                }
            }
        }
        if (j != -1 && max + max2 > best) {
            best = max + max2;
            x = i;
            y = j;
        }
        return max;
    }

    void calc(int i, int p, boolean market, int d) {
        if (d > max) {
            max = d;
        }
        for (Link e : l[i]) {
            if (e.i != p) {
                if (e.i == y || (market && e.i == s[i])) {
                    calc(e.i, i, true, 0);
                } else {
                    calc(e.i, i, false, d + e.c);
                }
            }
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        l = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            l[i] = new ArrayList<Link>();
        }

        int[] w = new int[n];
        for (int k = 0; k < n - 1; ++k) {
            int i = readInt() - 1;
            int j = readInt() - 1;
            int c = readInt();
            l[i].add(new Link(j, c));
            l[j].add(new Link(i, c));
            ++w[i];
            ++w[j];
        }

        s = new int[n];
        Arrays.fill(s, -1);
        for (int i = 0; i < n; ++i) {
            if (w[i] > 1) {
                len(i, -1);
                calc(x, -1, true, 0);

                println(max);
                exit();
            }
        }

        println(0);
        exit();
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
        new E().solve();
    }
}