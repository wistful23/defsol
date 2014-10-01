import java.io.*;
import java.util.*;

public class D {

    static long MOD = 1000000007;

    List<List<Integer>> t;
    int[] w;

    int calc1(int i) {
        if (t.get(i).isEmpty()) {
            return 1;
        }
        int r = 0;
        for (int j : t.get(i)) {
            int v = w[j] * calc1(j);
            r += v;
        }
        return r % 2;
    }

    long calc2(int i) {
        if (t.get(i).isEmpty()) {
            return 1;
        }
        long r = 0;
        for (int j : t.get(i)) {
            long v = w[j] * calc2(j) % MOD;
            r = (r + v) % MOD;
        }
        return r;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        t = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            t.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < n; ++i) {
            int p = readInt();
            t.get(p).add(i);
        }
        w = new int[n];
        for (int i = 1; i < n; ++i) {
            w[i] = readInt();
        }

        if (calc1(0) == 0) {
            println("Pass");
        } else {
            println(calc2(0));
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
        new D().solve();
    }
}
