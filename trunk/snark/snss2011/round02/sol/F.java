import java.io.*;
import java.util.*;

public class F {

    void solve() throws IOException {
        in("semicircle.in"); out("semicircle.out");

        int n = readInt();
        double[] a = new double[n];
        for (int i = 0; i < n; ++i) {
            a[i] = readDouble();
        }
        double l = readDouble();
        double s = 0;
        for (int i = 0; i < n; ++i) {
            s += a[i];
            if (s + 1e-8 > 90.0) {
                println("Out after " + (i + 1));
                break;
            }
            if (2.0 * Math.sin(0.5 * Math.PI * (90.0 - s) / 90.0) < l + 1e-8) {
                println("Reached after " + (i + 1));
                break;
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

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    void println(Object value) {
        out.println(value);
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new F().solve();
    }
}
