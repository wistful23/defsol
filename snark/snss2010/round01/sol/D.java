import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = -1;
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            int a = Integer.parseInt(st.nextToken());
            if (a < min) {
                min = a;
                j = i;
            }
        }
        if (j + m > n) {
            j = n - m;
        }
        out.println((j + 1) + " " + (j + m));

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
