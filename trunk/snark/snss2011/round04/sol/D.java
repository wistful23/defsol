import java.io.*;
import java.util.*;

public class D {

    void solve() throws IOException {
        in("__std"); out("__std");

        int m = readInt();
        int n = readInt();
        int[] s = new int[n];
        int[] c = new int[n];
        User[] users = new User[m];
        for (int i = 0; i < m; ++i) {
            User u = new User();
            int k = readInt();
            while (k-- > 0) {
                int j = readInt();
                int r = readInt();
                if (r > u.max) u.max = r;
                if (r < u.min) u.min = r;
                u.apps.add(j);
                s[j] += r;
                ++c[j];
            }
            users[i] = u;
        }
        for (int i = 0; i < m; ++i) {
            User u = users[i];
            print(i + ":");
            for (int j = 0; j < n; ++j) {
                if (!u.apps.contains(j) && u.min * c[j] <= s[j] && u.max * c[j] >= s[j]) {
                    print(" " + j);
                }
            }
            println();
        }

        exit();
    }

    class User {
        Set<Integer> apps = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        int max = 0;
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
        new D().solve();
    }
}
