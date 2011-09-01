import java.io.*;
import java.util.*;

public class E {

    final static int LEN = 1000000;

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt() << 1;
        }
        Arrays.sort(a);
        int k = readInt();
        int l = 0;
        int r = LEN >> 1;
        while (l < r) {
            int d = (l + r) >> 1;
            boolean flag = false;
            for (int s = 0; s < n && !flag; ++s) {
                int p = a[s] + d;
                int c = k - 1;
                int i = 1;
                while (i < n && c >= 0) {
                    int j = s + i++;
                    int q;
                    if (j >= n) {
                        q = a[j - n] + (LEN << 1);
                    } else {
                        q = a[j];
                    }
                    if (Math.abs(q - p) > d) {
                        --c;
                        p = q + d;
                    }
                }
                flag = i == n && c >= 0;
            }
            if (flag) {
                r = d;
            } else {
                l = d + 1;
            }
        }
        println("%.1f", 0.5 * l);

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
        new E().solve();
    }
}
