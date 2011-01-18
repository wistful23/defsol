import java.io.*;
import java.util.*;

public class B {

    void solve() throws IOException {
        in("__std"); out("__std");

        Map<String, Integer> items = new HashMap<String, Integer>();
        StringTokenizer st = new StringTokenizer(readLine(), ",");
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
            items.put(st2.nextToken(), Integer.parseInt(st2.nextToken()));
        }
        
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(readLine(), "|");
        while (st.hasMoreTokens()) {
            int max = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "&");
            while (st2.hasMoreTokens()) {
                int v = items.get(st2.nextToken());
                if (v > max) max = v;
            }
            if (max < min) min = max;
        }

        println(min);

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
