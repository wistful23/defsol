import java.io.*;
import java.util.*;

public class C {

    class Link {
        int v, w;

        Link(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int n = in.readInt();
        int m = in.readInt();
        int s = in.readInt();
        List<Link>[] g = new ArrayList[n];
        final long[] d = new long[n];
        boolean[] mask = new boolean[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Link>();
            d[i] = -1;
            mask[i] = true;
        }
        while (m-- > 0) {
            int u = in.readInt() - 1;
            int v = in.readInt() - 1;
            int w = in.readInt();
            g[u].add(new Link(v, w));
            g[v].add(new Link(u, w));
        }
        int[] p = new int[s + 1];
        for (int i = 0; i < s + 1; ++i) {
            p[i] = in.readInt() - 1;
        }
        Queue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return d[i] < d[j] ? -1 : 1;
            }
        });
        int u = 0;
        d[u] = 0;
        while (u != -1) {
            mask[u] = false;
            for (Link lk : g[u]) {
                if (mask[lk.v] && (d[lk.v] == -1 || d[u] + lk.w < d[lk.v])) {
                    if (d[lk.v] != -1) {
                        q.remove(lk.v);
                    }
                    d[lk.v] = d[u] + lk.w;
                    q.add(lk.v);
                }
            }
            u = -1;
            while (!q.isEmpty() && !mask[u = q.poll()]) {
            }
        }
        boolean flag = true;
        for (int i = 0; i < s && flag; ++i) {
            if (d[p[i]] != -1) {
                flag = d[p[i]] > d[p[s]];
            }
        }
        out.println(flag ? d[p[s]] : -1);

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
        new C().solve();
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
