import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("monkeys.in"));
        out = new PrintWriter("monkeys.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            double s = Double.parseDouble(st.nextToken());

            double[] p = new double[256];
            for (int i = 0; i < m; ++i) {
                st = new StringTokenizer(in.readLine());
                char c = st.nextToken().charAt(0);
                p[c] = Double.parseDouble(st.nextToken());
            }

            double d = 0;

            for (int i = 0; i < n; ++i) {
                String w = in.readLine();

                double r = s;
                for (int j = 0; j < w.length(); ++j) {
                    r *= p[w.charAt(j)];
                }

                d += r;
            }

            out.println("Data Set " + x + ":");
            out.println(new Formatter().format(Locale.US, "%.4E", d));
            out.println();
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
