import java.io.*;
import java.util.*;

public class D {

    class Link {
        int b, l;

        Link(int b, int l) {
            this.b = b;
            this.l = l;
        }
    }

    void solve() throws IOException {
        in = new InputReader("__std");
        out = new OutputWriter("__std");

        int n = in.readInt();
        int m = in.readInt();
        int s = in.readInt() - 1;
        int d = in.readInt() - 1;
        int[] c = new int[n];
        for (int i = 0; i < n; ++i) {
            c[i] = in.readInt();
        }

        List<Link>[] g = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Link>();
        }
        while (m-- > 0) {
            int a = in.readInt() - 1;
            int b = in.readInt() - 1;
            int l = in.readInt();
            g[a].add(new Link(b, l));
            g[b].add(new Link(a, l));
        }

        boolean[] mask = new boolean[n];
        final long[] w = new long[n];
        Queue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return w[i] < w[j] ? -1 : 1;
            }
        });

        int left = 0;
        int right = 1000000001;
        while (left < right) {
            int mid = (left + right) >> 1;
            Arrays.fill(mask, true);
            Arrays.fill(w, -1);
            w[s] = c[s] + mid;
            int a = s;
            while (a != -1) {
                mask[a] = false;
                for (Link lk : g[a]) {
                    if (mask[lk.b] && w[a] <= lk.l) {
                        if (w[lk.b] == -1 || w[a] + c[lk.b] < w[lk.b])
                        //if (w[lk.b] != -1) {
                        //    q.remove(lk.b);
                        //}
                        w[lk.b] = w[a] + c[lk.b];
                        q.add(lk.b);
                    }
                }
                a = -1;
                while (!q.isEmpty() && !mask[a = q.poll()]) {
                }
            }
            if (w[d] == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        out.println(left - 1);

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
        new D().solve();
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
