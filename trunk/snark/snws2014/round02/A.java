import java.io.*;
import java.util.*;

public class A {

    List<Integer>[] l;
    int[] d, c;

    int best;
    long cnt;

    void dfs(int i, int p) {
        for (int j : l[i]) {
            if (j != p) {
                dfs(j, i);
                if (d[j] > d[i]) {
                    d[i] = d[j];
                }
            }
        }

        int k = 0;
        for (int j : l[i]) {
            if (j != p && d[j] == d[i]) {
                c[i] += c[j];
                ++k;
            }
        }

        if (k > 1) {
            int v = 2 * d[i] + 1;
            if (v >= best) {
                long w = 0;
                for (int j : l[i]) {
                    if (j != p && d[j] == d[i]) {
                        w += (long) (c[i] - c[j]) * c[j];
                    }
                }
                if (v > best) cnt = 0;
                cnt += w / 2;
                best = v;
            }
        } else {
            int m = 0;
            for (int j : l[i]) {
                if (j != p && d[j] < d[i] && d[j] > m) {
                    m = d[j];
                }
            }

            int w = 0;
            for (int j : l[i]) {
                if (j != p && d[j] < d[i] && d[j] == m) {
                    w += c[j];
                }
            }
            if (w == 0) w = 1;

            int v = d[i] + m + 1;
            if (v >= best) {
                if (v > best) cnt = 0;
                cnt += (long) w * c[i];
                best = v;
            }
        }

        if (d[i] == 0) c[i] = 1;
        ++d[i];
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int n = in.readInt();
        l = new List[n];
        d = new int[n];
        c = new int[n];
        for (int i = 0; i < n; ++i) l[i] = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; ++i) {
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            l[a].add(b);
            l[b].add(a);
        }

        dfs(0, -1);

        out.println(best + " " + cnt);

        exit();
    }

    void exit() {
        //System.err.println((System.currentTimeMillis() - startTime) + " ms");
        out.close();
        System.exit(0);
    }

    InputReader in;
    OutputWriter out;

    //long startTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    class InputReader {

        private InputStream stream;

        private byte[] buffer = new byte[1024];
        private int pos, len;

        private int cur;

        private StringBuilder sb = new StringBuilder(32);

        InputReader(String name) throws IOException {
            if (name.equals("__std")) {
                stream = System.in;
            } else {
                stream = new FileInputStream(name);
            }
            cur = read();
        }

        private int read() throws IOException {
            if (len == -1) {
                throw new EOFException();
            }
            if (pos >= len) {
                pos = 0;
                len = stream.read(buffer);
                if (len == -1) return -1;
            }
            return buffer[pos++];
        }

        char readChar() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            char res = (char) cur;
            cur = read();
            return res;
        }

        int readInt() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            while (whitespace()) {
                cur = read();
            }
            if (cur == -1) {
                throw new EOFException();
            }
            int sign = 1;
            if (cur == '-') {
                sign = -1;
                cur = read();
            }
            int res = 0;
            while (!whitespace()) {
                if (cur < '0' || cur > '9') {
                    throw new NumberFormatException();
                }
                res *= 10;
                res += cur - '0';
                cur = read();
            }
            return res * sign;
        }

        long readLong() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            return Long.parseLong(readToken());
        }

        double readDouble() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            return Double.parseDouble(readToken());
        }

        String readLine() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            sb.setLength(0);
            while (cur != -1 && cur != '\r' && cur != '\n') {
                sb.append((char) cur);
                cur = read();
            }
            if (cur == '\r') {
                cur = read();
            }
            if (cur == '\n') {
                cur = read();
            }
            return sb.toString();
        }

        String readToken() throws IOException {
            if (cur == -1) {
                throw new EOFException();
            }
            while (whitespace()) {
                cur = read();
            }
            if (cur == -1) {
                throw new EOFException();
            }
            sb.setLength(0);
            while (!whitespace()) {
                sb.append((char) cur);
                cur = read();
            }
            return sb.toString();
        }

        boolean whitespace() {
            return cur == ' ' || cur == '\t' || cur == '\r' || cur == '\n' || cur == -1;
        }

        boolean eof() {
            return cur == -1;
        }
    }

    class OutputWriter {

        private PrintWriter writer;

        OutputWriter(String name) throws IOException {
            if (name.equals("__std")) {
                writer = new PrintWriter(System.out);
            } else {
                writer = new PrintWriter(name);
            }
        }

        void print(String format, Object ... args) {
            writer.print(new Formatter(Locale.US).format(format, args));
        }

        void println(String format, Object ... args) {
            writer.println(new Formatter(Locale.US).format(format, args));
        }

        void print(Object value) {
            writer.print(value);
        }

        void println(Object value) {
            writer.println(value);
        }

        void println() {
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}
