import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) throws IOException {
        new A().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new FileReader("divide.in"));
        out = new PrintWriter("divide.out");

        n = Integer.parseInt(in.readLine());
        s = n * (n + 1) / 2;

        if(s % 3 == 0) {
            s /= 3;

            mask = new int[n + 1];
            Arrays.fill(mask, 0);

            p = new int[s + 1];

            if(go(1) && go(2)) {
                out.println("POSSIBLE");
                print(1);
                print(2);
                print(0);
            } else {
                out.println("IMPOSSIBLE");
            }
        } else {
            out.println("IMPOSSIBLE");
        }

        out.close();
    }

    boolean go(int k) {
        Arrays.fill(p, -1);
        p[0] = 0;
        for(int i = n; i >= 1; --i) {
            if(mask[i] == 0) {
                for(int t = s - i; t >= 0; t--) {
                    if(p[t] != -1 && p[t + i] == -1) {
                        p[t + i] = i;
                    }
                }
            }
        }
        if(p[s] != -1) {
            int t = s;
            while(p[t] != 0) {
                mask[p[t]] = k;
                t = t - p[t];
            }
            return true;
        }
        return false;
    }

    void print(int k) {
        int c = 0;
        for(int i = 1; i <= n; ++i) {
            if(mask[i] == k) {
                ++c;
            }
        }
        out.print(c);
        for(int i = 1; i <= n; ++i) {
            if(mask[i] == k) {
                out.print(" " + i);
            }
        }
        out.println();
    }

    int n, s;

    int mask[];
    int p[];

    BufferedReader in;
    PrintWriter out;
}
