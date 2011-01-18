import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int p = readInt();
        int l = readInt();

        String[] a = new String[2];
        a[0] = readToken();
        a[1] = readToken();

        if (a[0].equals(a[1])) {
            println(0);
            exit();
        }

        int[][][] t = new int[2][p][n];
        for (int i = 0; i < p; ++i) {
            char[] c = readToken().toCharArray();
            for (int j = 0; j < n; ++j) {
                t[0][i][j] = c[j] - 'a';
                t[1][i][t[0][i][j]] = j;
            }
        }

        Map<String, Integer> w = new HashMap<String, Integer>();
        List<String>[] s = new ArrayList[2];
        for (int k = 0; k < 2; ++k) {
            s[k] = new ArrayList<String>();
        }

        char[] d = new char[n];

        for (int e = 0; e < 2; ++e) {
            int k = 0;
            s[k].clear();
            s[k].add(a[e]);
            int ll = l / 2;
            if (e == 0) {
                ll += l % 2;
                w.put(a[0], 0);
            }
            for (int step = 1; step <= ll; ++step) {
                s[1 - k].clear();
                for (String c : s[k]) {
                    for (int i = 0; i < p; ++i) {
                        for (int j = 0; j < n; ++j) {
                            d[j] = c.charAt(t[e][i][j]);
                        }
                        String r = String.valueOf(d);
                        if (e == 0 && r.equals(a[1])) {
                            println(step);
                            exit();
                        }
                        if (w.containsKey(r)) {
                            if (e == 0) continue;
                            println(w.get(r) + step);
                            exit();
                        }
                        if (e == 0) w.put(r, step);
                        if (step < ll) {
                            s[1 - k].add(r);
                        }
                    }
                }
                k = 1 - k;
            }
        }

        println(-1);

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
        new B().solve();
    }
}
