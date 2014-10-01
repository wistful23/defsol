import java.io.*;
import java.util.*;

public class C {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        final int[] h = new int[n];
        final int[] v = new int[n];
        final Integer[] id = new Integer[n];
        for (int i = 0; i < n; ++i) {
            h[i] = readInt();
            v[i] = readInt();
            id[i] = i;
        }
        Arrays.sort(id, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return v[i] == v[j] ? h[i] - h[j] : v[i] - v[j];
            }
        });
        int l = 0;
        int r = 1000000001;
        while (l < r) {
            int t = (l + r) / 2;
            boolean flag = true;
            long p = -1;
            for (int i = 0; i < n && flag; ++i) {
                long c = (long) t * v[id[i]] + h[id[i]];
                flag = c > p;
                p = c;
            }
            if (flag) {
                r = t;
            } else {
                l = t + 1;
            }
        }
        println(l);

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
        new C().solve();
    }
}
