import java.io.*;
import java.util.*;

public class C {
    public static void main(String args[]) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        br = new BufferedReader(new FileReader("qf.in"));
        pw = new PrintWriter("qf.out");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double[] v = new double[n + 1];
        v[0] = 1.0;
        for(int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            double p = Double.parseDouble(st.nextToken());
            for(int w = 0; w <= n - d; ++w) {
                if(v[w]*p > v[w + d]) {
                    v[w + d] = v[w]*p;
                }
            }
        }
        pw.println(new Formatter().format(Locale.US, "%.2f", v[n]));
        pw.close();
    }

    BufferedReader br;
    PrintWriter pw;
}
