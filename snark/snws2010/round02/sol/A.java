import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("median.in"); out("median.out");

        int n = readInt();
        final int[] a = new int[n];
        Integer[] p = new Integer[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
            p[i] = i;
        }

        Arrays.sort(p, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return a[i] - a[j];
            }
        });

        int[] next = new int[n];
        int[] prev = new int[n];
        int[] l = new int[n];
        for (int i = 0; i < n; ++i) {
            l[p[i]] = i;
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        int m = (n - 1) >> 1;
        int[] r = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            r[i] = a[p[m]];

            int j = l[i];

            if (next[j] < n) {
                prev[next[j]] = prev[j];
            }
            if (prev[j] >= 0) {
                next[prev[j]] = next[j];
            }

            if (m < j) {
                if ((i & 1) == 0) m = prev[m];
            } else if (m > j) {
                if ((i & 1) != 0) m = next[m];
            } else {
                m = (i & 1) == 0 ? prev[m] : next[m];
            }
        }

        for (int i = 0; i < n ; ++i) {
            print(r[i] + " ");
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
            if (!in.ready()) return "";
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
        new A().solve();
    }
}
