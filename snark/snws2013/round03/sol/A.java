import java.io.*;
import java.util.*;

public class A {

    void solve() throws IOException {
        in("__std"); out("__std");

        StringBuilder s = new StringBuilder();
        char ch = readChar();
        while (ch != '#') {
            if ("><+-[].".indexOf(ch) != -1) {
                s.append(ch);
            }
            ch = readChar();
        }
        char[] c = s.toString().toCharArray();
        int[] l = new int[c.length];
        Stack<Integer> ps = new Stack<Integer>();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '[') {
                ps.push(i);
            } else if (c[i] == ']') {
                int j = ps.pop();
                l[i] = j - 1;
                l[j] = i;
            }
        }
        int[] a = new int[30000];
        int p = 0;
        int i = 0;
        while (i < c.length) {
            switch (c[i]) {
                case '>':
                    ++p;
                    break;
                case '<':
                    --p;
                    break;
                case '+':
                    ++a[p];
                    if (a[p] > 255) a[p] = 0;
                    break;
                case '-':
                    --a[p];
                    if (a[p] < 0) a[p] = 255;
                    break;
                case '[':
                    if (a[p] == 0) i = l[i];
                    break;
                case ']':
                    if (a[p] != 0) i = l[i];
                    break;
                case '.':
                    print((char) a[p]);
            }
            ++i;
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
        new A().solve();
    }
}
