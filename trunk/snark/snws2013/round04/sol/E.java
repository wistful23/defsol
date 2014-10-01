import java.io.*;
import java.util.*;

public class E {

    ArrayList<Integer>[] m = new ArrayList[4];

    boolean[] mask = new boolean[4];
    int[] p = new int[4];

    double best = -Double.MAX_VALUE;
    int[] bp = new int[4];

    void go(int i, double v) {
        if (i == 4) {
            if (v > best) {
                best = v;
                System.arraycopy(p, 0, bp, 0, 4);
            }
            return;
        }
        for (int j = 0; j < 4; ++j) {
            if (!mask[j]) {
                p[i] = j;
                double nv = v;
                for (Integer a : m[j]) {
                    switch (j) {
                        case 0: nv /= a; break;
                        case 1: nv += a; break;
                        case 2: nv *= a; break;
                        case 3: nv -= a;
                    }
                }
                mask[j] = true;
                go(i + 1, nv);
                mask[j] = false;
            }
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        for (int i = 0; i < 4; ++i) m[i] = new ArrayList<Integer>();
        String s = "/+*-";
        int n = readInt();
        while (n-- > 0) {
            int i = s.indexOf(readToken().charAt(0));
            m[i].add(readInt());
        }
        go(0, 1);
        for (int i = 0; i < 4; ++i) {
            for (Integer v : m[bp[i]]) {
                println(s.charAt(bp[i]) + " " + v);
            }
        }

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

    char readChar() throws IOException {
        return (char) in.read();
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
        out.print(new Formatter(Locale.US).format(format, args));
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
        new E().solve();
    }
}
