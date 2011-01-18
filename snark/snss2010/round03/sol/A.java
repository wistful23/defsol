import java.io.*;
import java.util.*;

public class A {

    String f(int c) {
        if (c < 0) return "S" + (-c);
        if (c == 0) return "B";
        return "" + c;
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int p = readInt();

        int[] s = new int[50];
        int k = 0;
        s[k] = -1;
        k += 2;

        while (p-- > 0) {
            s[k++] = -k;
        }
        if ((k & 1) == 1) ++k;

        int i = 1;
        while (n-- > 0) {
            p = readInt();
            while (p-- > 0) {
                s[k++] = i++;
            }
            if ((k & 1) == 1) {
                ++k;
                ++i;
            }
        }

        if (k % 4 != 0) k += 2;
        int l = 0;
        int r = k - 1;
        for (int j = 0; j < k / 4; ++j) {
            print(f(s[r--]) + "/" + f(s[l++]) + "," + f(s[l++]) + "/" + f(s[r--]) + " ");
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
        new A().solve();
    }
}
