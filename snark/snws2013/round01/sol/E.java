import java.io.*;
import java.util.*;

public class E {

    void solve() throws IOException {
        in("__std"); out("__std");

        int n = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readInt();
        }
        int[] b = new int[n];
        int m = readInt();
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(0);
        while (m-- > 0) {
            int x = readInt();
            if (x == 0) {
                int i = q.poll();
                while (a[i] == b[i]) i = q.poll();
                ++b[i];
                q.add(a[i] == b[i] ? i + 1 : i);
                print((i + 1) + " ");
            } else {
                --x;
                --b[x];
                q.add(x);
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
