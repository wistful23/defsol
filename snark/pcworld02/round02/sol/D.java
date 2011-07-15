import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("fraction.in"));
        out = new PrintWriter("fraction.out");

        int n = Integer.parseInt(in.readLine());
        double s = Math.sqrt(n);
        int a = (int) s;
        if (a * a == n) {
            out.println("[" + a + "]");
        } else {
            out.print("[" + a + ";(");
            int u = a;
            int v = n - a * a;
            while (true) {
                int b = (int) ((s + u) / v);
                out.print(b);
                if (b == 2 * a) break;
                u = v * b - u;
                v = (n - u * u) / v;
                out.print(",");
            }
            out.println(")]");
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
