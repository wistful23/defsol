import java.io.*;
import java.util.*;

public class F {

    int area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        char[] name = new char[n];
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; ++i) {
            name[i] = readToken().charAt(0);
            x[i] = readInt();
            y[i] = readInt();
        }

        char[] ans = new char[3];
        int best = -1;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int s = area(x[i], y[i], x[j], y[j], x[k], y[k]);
                    if (s > best) {
                        boolean flag = true;
                        for (int t = 0; t < n && flag; ++t) {
                            if (t != i && t != j && t != k) {
                                int s2 =
                                    area(x[i], y[i], x[j], y[j], x[t], y[t]) +
                                    area(x[i], y[i], x[t], y[t], x[k], y[k]) +
                                    area(x[t], y[t], x[j], y[j], x[k], y[k]);
                                flag = s != s2;
                            }
                        }
                        if (flag) {
                            best = s;
                            ans[0] = name[i];
                            ans[1] = name[j];
                            ans[2] = name[k];
                        }
                    }
                }
            }
        }

        Arrays.sort(ans);
        for (int i = 0; i < 3; ++i) {
            print(ans[i]);
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
        new F().solve();
    }
}
