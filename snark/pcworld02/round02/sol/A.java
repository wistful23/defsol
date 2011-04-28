import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("gears.in"));
        out = new PrintWriter("gears.out");

        int n = Integer.parseInt(in.readLine());

        int a[] = new int[n];
        int b[] = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; ++i) {
            b[i] = Integer.parseInt(st.nextToken());
            if(b[i] > b[j]) {
                j = i;
            }
        }

        int t = b[j];
        for(int i = 0; i < n; ++i) {
            b[i] = (t - b[i]) % a[i];
        }

        while(true) {
            boolean flag = true;
            for(int i = 0; i < n; ++i) {
                if(b[i] != 0) {
                    flag = false;
                }
            }
            if(flag) {
                break;
            }

            t += a[j];
            for(int i = 0; i < n; ++i) {
                b[i] = (b[i] + a[j]) % a[i];
            }
        }

        out.println(t);
        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
