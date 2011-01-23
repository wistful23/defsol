import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("bear.in"));
        out = new PrintWriter("bear.out");

        int k = Integer.parseInt(in.readLine());
        for (int x = 1; x <= k; ++x) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int b = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());

            double v = 0;
            for (int i = 0; i < b; ++i) {
                double r = Double.parseDouble(in.readLine());
                v += 4.0 / 3.0 * Math.PI * r * r * r;
            }

            out.println("Data Set " + x + ":");
            out.println(v / 1000 >= w ? "Yes" : "No");
            out.println();
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
